package bo.gob.aduana.vipas.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.aduana.vipas.exception.UnauthorizedException;
import bo.gob.aduana.vipas.model.Comision;
import bo.gob.aduana.vipas.model.CriteriosBusqueda;
import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.repository.entity.VipComisionResumen;
import bo.gob.aduana.vipas.service.AuthorizationService;
import bo.gob.aduana.vipas.service.ComisionResumenService;
import bo.gob.aduana.vipas.service.ComisionService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ComisionController {
	@Autowired
	private ComisionService comisionService;
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private ComisionResumenService comisionResumenService;

	@GetMapping(value = "/obtenerComision/{nroCom:.+}")
	@ApiOperation("Metodo para obtener comision registrada")
	public ResponseEntity<?> obtenerComision(@RequestHeader HttpHeaders header, @PathVariable String nroCom) {
		SimpleResponse simpleResponse;
		try {
			authorizationService.validToken(header);
			Comision com = comisionService.obtenerComision(nroCom);
			if (com != null)
				simpleResponse = new SimpleResponse("SUCCESS", com, "200");
			else
				simpleResponse = new SimpleResponse("ERROR", "No exite el número de comisión memorizada.", "200");
		} catch (Exception e) {
			simpleResponse = new SimpleResponse("ERROR", e.getMessage().toString(), "200");
		}
		return new ResponseEntity<>(simpleResponse, simpleResponse.getStatus());
	}

	@GetMapping(value = "/obtenerComisiones/{gerencia:.+}")
	@ApiOperation("Metodo para obtener comisiones registrada")
	public ResponseEntity<?> obtenerComisiones(@RequestHeader HttpHeaders header, @PathVariable String gerencia) {
		SimpleResponse simpleResponse;
		try {
			authorizationService.validToken(header);
			List<Comision> com = comisionService.obtenerComisiones(gerencia);
			if (com != null)
				simpleResponse = new SimpleResponse("SUCCESS", com, "200");
			else
				simpleResponse = new SimpleResponse("ERROR", "No existe registros para mostrar.", "200");
		} catch (Exception e) {
			simpleResponse = new SimpleResponse("ERROR", e.getMessage().toString(), "200");
		}
		return new ResponseEntity<>(simpleResponse, simpleResponse.getStatus());
	}

	@GetMapping(value = "/obtenerComisionesResumen")
	@ApiOperation("Metodo para obtener resumen de comisiones por criterios")
	public ResponseEntity<?> findAllByCriterios(@RequestHeader HttpHeaders header, 
			@RequestParam(value = "codigoGerencia", required = true, defaultValue = "") String codigoGerencia,
			@RequestParam(value = "numeroMemo", required = false, defaultValue = "") String numeroMemo,
			@RequestParam(value = "numeroDocumento", required = false, defaultValue = "") String numeroDocumento,
			@RequestParam(value = "fechaInicio", required = false) String fechaInicio,
			@RequestParam(value = "fechaFin", required = false) String fechaFin) throws UnauthorizedException, ParseException {
		CriteriosBusqueda criterios = new CriteriosBusqueda();
		authorizationService.validToken(header);
		criterios.setNumeroMemo(numeroMemo);
		criterios.setFechaInicio(fechaInicio);
		criterios.setFechaFin(fechaFin);
		criterios.setNumeroDocumento(numeroDocumento);
		criterios.setCodigoGerencia(codigoGerencia);
		List<VipComisionResumen>  lista = comisionResumenService.findAllByCriterios(criterios, null, false);
		SimpleResponse simpleResponse = new SimpleResponse("SUCCESS", lista, "200");
		return new ResponseEntity<>(simpleResponse, simpleResponse.getStatus());
	}

}

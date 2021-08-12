package bo.gob.aduana.vipas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import bo.gob.aduana.vipas.model.ItinerarioMemo;
import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.repository.entity.KeyVipItinerario;
import bo.gob.aduana.vipas.service.AuthorizationService;
import bo.gob.aduana.vipas.service.ItinerarioMemoService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ItinerarioMemoController {
	@Autowired
	private ItinerarioMemoService itinerarioMemoService;
	@Autowired
	private AuthorizationService authorizationService;
	
	@PostMapping("guardarItinerarioMemo")
	@ApiOperation("Metodo para guardar itinerario de las comisiones memorizadas")
	public ResponseEntity<?> guardaItinerarioMemo(@RequestHeader HttpHeaders header,@RequestBody ItinerarioMemo itinerarioMemo) {
        SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			simpleResponse = itinerarioMemoService.guardarItinerarioMemo(itinerarioMemo);
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
	
	@PostMapping("eliminarItinerarioMemo")
	@ApiOperation("Metodo para guardar itinerario de las comisiones memorizadas")
	public ResponseEntity<?> eliminarItinerarioMemo(@RequestHeader HttpHeaders header,@RequestBody ItinerarioMemo itinerarioMemo) {			
		SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			KeyVipItinerario id = new KeyVipItinerario();
			id.setComNrocom(itinerarioMemo.getNroCom());
			id.setItiNroiti(itinerarioMemo.getNroIti());
			String com = itinerarioMemoService.eliminarItinerarioMemo(id);
			if (com != null)
				simpleResponse = new SimpleResponse("SUCCESS",com ,"200");
			else
				simpleResponse = new SimpleResponse("ERROR","No se eliminó la información" ,"200");
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
	@GetMapping("obtenerItinerariosMemo/{nroCom:.+}")
	@ApiOperation("Metodo para obtener itinerarios memorizadas")
	public ResponseEntity<?> obtenerItinerariosMemo(@RequestHeader HttpHeaders header,@PathVariable String nroCom) {			
		SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			List<ItinerarioMemo> itinerarios = itinerarioMemoService.obtenerItinerariosMemo(nroCom);
			if (itinerarios != null)
				if (!itinerarios.isEmpty())
					simpleResponse = new SimpleResponse("SUCCESS",itinerarios ,"200");
				else
					simpleResponse = new SimpleResponse("ERROR","No existe información registrada" ,"200");
			else
				simpleResponse = new SimpleResponse("ERROR","No existe información" ,"200");
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
}

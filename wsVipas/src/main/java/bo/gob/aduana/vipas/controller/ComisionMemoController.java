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
import bo.gob.aduana.vipas.model.ComisionMemo;
import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.service.AuthorizationService;
import bo.gob.aduana.vipas.service.ComisionMemoService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ComisionMemoController {
	@Autowired
	private ComisionMemoService comisionMemoService;
	@Autowired
	private AuthorizationService authorizationService;
	
	
	@PostMapping("guardarComisionMemo")
	@ApiOperation("Metodo para guardar comisiones memorizadas")
	public ResponseEntity<?> guardaComisionMemo(@RequestHeader HttpHeaders header,@RequestBody ComisionMemo comisionMemo) {			
		SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			simpleResponse = comisionMemoService.guardarComisionMemo(comisionMemo);
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());		
    }
	
	@GetMapping(value="/obtenerComisionMemo/{nroCom:.+}")
	@ApiOperation("Metodo para obtener comision memorizada")
	public ResponseEntity<?> obtenerComisionMemo(@RequestHeader HttpHeaders header,@PathVariable String nroCom) {			
		SimpleResponse simpleResponse;		
		try {	 
			authorizationService.validToken(header);
			ComisionMemo com = comisionMemoService.obtenerComisionMemo(nroCom);
			if (com != null)
				simpleResponse = new SimpleResponse("SUCCESS", com ,"200");
			else
				simpleResponse = new SimpleResponse("ERROR","No exite el número de comisión memorizada." ,"200");
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
	
	@PostMapping("eliminarComisionMemo")
	@ApiOperation("Metodo para eliminar comisiones memorizadas")
	public ResponseEntity<?> eliminarComisionMemo(@RequestHeader HttpHeaders header,@RequestBody ComisionMemo comisionMemo) {			
		SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			String com = comisionMemoService.eliminarComisionMemo(comisionMemo.getNrocom());
			if (com != null)
				simpleResponse = new SimpleResponse("SUCCESS",com ,"200");
			else
				simpleResponse = new SimpleResponse("ERROR","No se guardo la información." ,"200");
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
	
	@PostMapping("registrarComisionMemo")
	@ApiOperation("Metodo para registrar comision memorizada")
	public ResponseEntity<?> registrarComisionMemo(@RequestHeader HttpHeaders header,@RequestBody ComisionMemo comisionMemo) {			
		SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			simpleResponse = comisionMemoService.registrarComision(comisionMemo);
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());	
    }
	
	@GetMapping(value="/obtenerComisionesMemo/{gerencia:.+}")
	@ApiOperation("Metodo para obtener comisiones memorizada")
	public ResponseEntity<?> obtenerComisionesMemo(@RequestHeader HttpHeaders header, @PathVariable String gerencia) {			
		SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			List<ComisionMemo> com = comisionMemoService.obtenerComisionesMemo(gerencia);
			if (com != null)
				simpleResponse = new SimpleResponse("SUCCESS", com ,"200");
			else
				simpleResponse = new SimpleResponse("ERROR","No existe registros para mostrar." ,"200");
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
	@PostMapping("verificarMemorandum")
	@ApiOperation("Metodo para verificar un memorandum en rrhh")
	public ResponseEntity<?> verificarMemorandum(@RequestHeader HttpHeaders header, @RequestBody String nroMemo) {			
		SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			simpleResponse = comisionMemoService.verificarMemorandum(nroMemo);
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
}

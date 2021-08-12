package bo.gob.aduana.vipas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.service.AuthorizationService;
import bo.gob.aduana.vipas.service.PaisService;
import io.swagger.annotations.ApiOperation;

@RestController
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	@Autowired
	private AuthorizationService authorizationService;
	
	@GetMapping("dummy")
	public SimpleResponse dummy() {
		SimpleResponse simpleResponse = new SimpleResponse("SUCCESS", "Servicio funcionando correctamente","200");		
		return simpleResponse;
	}
	
	@GetMapping("obtenerPaises")
	@ApiOperation("Metodo para obtener listado de paises")
	public ResponseEntity<?> obtienePaises(@RequestHeader HttpHeaders header) {			
		SimpleResponse simpleResponse;		
		try {	     	     
			authorizationService.validToken(header);
	     simpleResponse = new SimpleResponse("SUCCESS",paisService.getPaises() ,"200");
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
}

package bo.gob.aduana.vipas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.service.AuthorizationService;
import bo.gob.aduana.vipas.service.ParametricaService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ParametricaController {
	@Autowired
	private	ParametricaService parametricaService;
	@Autowired
	private AuthorizationService authorizationService;
	
	@GetMapping("getParametricas")
	@ApiOperation("Metodo para obtener listado de parametricas")
	public ResponseEntity<?> obtieneParametricas(@RequestHeader HttpHeaders header) {			
		SimpleResponse simpleResponse;		
		try {	 
			authorizationService.validToken(header);
	     simpleResponse = new SimpleResponse("SUCCESS",parametricaService.getParametricas() ,"200");
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
}

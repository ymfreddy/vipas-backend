package bo.gob.aduana.vipas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.aduana.vipas.model.Itinerario;
import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.service.AuthorizationService;
import bo.gob.aduana.vipas.service.ItinerarioService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ItinerarioController {
	@Autowired
	private ItinerarioService itinerarioService;
	@Autowired
	private AuthorizationService authorizationService;
	
	
	@GetMapping("obtenerItinerarios/{nroCom:.+}")
	@ApiOperation("Metodo para obtener itinerarios memorizadas")
	public ResponseEntity<?> obtenerItinerariosMemo(@RequestHeader HttpHeaders header,@PathVariable String nroCom) {			
		SimpleResponse simpleResponse;		
		try {	   
			authorizationService.validToken(header);
			List<Itinerario> itinerarios = itinerarioService.obtenerItinerarios(nroCom);
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

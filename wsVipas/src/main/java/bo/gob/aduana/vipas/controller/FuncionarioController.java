package bo.gob.aduana.vipas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.aduana.vipas.model.Funcionario;
import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.service.AuthorizationService;
import bo.gob.aduana.vipas.service.FuncionarioService;
import io.swagger.annotations.ApiOperation;

@RestController
public class FuncionarioController {
	@Autowired
	private	FuncionarioService funcionarioService;
	@Autowired
	private AuthorizationService authorizationService;
	
	
	@GetMapping("obtenerFuncionario/{nroDoc:.+}")
	@ApiOperation("Metodo para obtener informacion personal de un determinado funcionario")
	public ResponseEntity<?> obtenerFuncionario(@RequestHeader HttpHeaders header,@PathVariable String nroDoc) {			
		SimpleResponse simpleResponse;		
		try {	 
			authorizationService.validToken(header);
			Funcionario fun= funcionarioService.obtenerFuncionario(nroDoc);
			if (fun != null)
				simpleResponse = new SimpleResponse("SUCCESS",fun ,"200");
			else
				simpleResponse = new SimpleResponse("ERROR","No exite información con el nro de Documento "+nroDoc+"." ,"200");      
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return new ResponseEntity<> (simpleResponse, simpleResponse.getStatus());
    }
}

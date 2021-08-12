package bo.gob.aduana.vipas.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
//import org.springframework.security.jwt.crypto.sign.InvalidSignatureException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import bo.gob.aduana.vipas.model.SimpleResponse;

@RestControllerAdvice
public class ExceptionGlobalResponse {
	SimpleResponse res;
	@ExceptionHandler(RuntimeException.class)		
	public ResponseEntity<Object> runtimeException(RuntimeException e) {
		//res=new Respuesta("","422","El header Pais-Origen debe ser enviado. ","005");
		//new SimpleResponse("Error","La solicitud no existe" ,"200");
		e.printStackTrace();
		res = new SimpleResponse("ERROR", "Se ha producido un error en el servicio, runtimeException: "+e.getMessage(), "404");			
		return new ResponseEntity<> (res, res.getStatus());
	}				
		
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ResponseEntity<Object> httpMediaType(HttpMediaTypeNotAcceptableException e) {
		e.printStackTrace();
		res = new SimpleResponse("ERROR", "El recurso solicitado no se pudo encontrar. HttpMediaTypeNotAcceptableException: "+e.getMessage(), "404");
		return new ResponseEntity<> (res, res.getStatus());	
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> httpMediaType(IOException e) {
		e.printStackTrace();
		res = new SimpleResponse("ERROR", "Se ha producido un error en el servicio, IOException: "+e.getMessage(), "500");
		return new ResponseEntity<> (res, res.getStatus());	
	}
	
	@RequestMapping("*")
    public ResponseEntity<Object> fallbackHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		res = new SimpleResponse("ERROR", "Se ha producido un error en el servicio, fallbackHandler, ResponseEntity ", "500");
		return new ResponseEntity<> (res, res.getStatus());	
    }
	
	/*@ExceptionHandler(InvalidSignatureException.class)	
	public ResponseEntity<Object> InvalidSignatureException(InvalidSignatureException e) {
		res = new SimpleResponse("ERROR", "Se ha producido un error en el servicio, por lo que no se pudo completar la solicitud: "+e.getMessage(), "500");
		return new ResponseEntity<> (res, res.getStatus());		
	}*/
	
	@ExceptionHandler(Exception.class)		
	public ResponseEntity<Object> exception(Exception e) {
		e.printStackTrace();
		res = new SimpleResponse("ERROR", "Exception: "+e.getMessage(), "500");
		return new ResponseEntity<> (res, res.getStatus());	
	}
}

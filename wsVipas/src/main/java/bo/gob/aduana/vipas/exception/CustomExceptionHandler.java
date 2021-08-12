package bo.gob.aduana.vipas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import bo.gob.aduana.vipas.model.SimpleResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UnauthorizedException.class)
	public final ResponseEntity<SimpleResponse> handleUnauthorizedException (UnauthorizedException e) {
		SimpleResponse error = new SimpleResponse("ERROR", "Unauthorized: "+e.getMessage(), "401");
		return new ResponseEntity<> (error, error.getStatus());
	}
}

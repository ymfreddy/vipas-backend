package bo.gob.aduana.vipas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import bo.gob.aduana.vipas.model.SimpleResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class RestDefaultExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handleException(Exception ex) {
		log.error("ERROR", ex);
		SimpleResponse error = new SimpleResponse("ERROR", (ex != null ? ex.getMessage() : "Objeto Nulo"), "401");
		return new ResponseEntity<>(error, error.getStatus());
	}
}
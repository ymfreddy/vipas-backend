package bo.gob.aduana.vipas.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import bo.gob.aduana.vipas.model.SimpleResponse;

public class FileExceptionAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException exc) {
	    
		List<String> details = new ArrayList<String>();
        details.add(exc.getMessage());
        
        SimpleResponse err = new SimpleResponse("ERROR", "File Not Found"+LocalDateTime.now() ,"401");
	
        return new ResponseEntity<> (err, err.getStatus());
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    
		List<String> details = new ArrayList<String>();
        details.add(exc.getMessage());
		
        SimpleResponse err = new SimpleResponse("ERROR", "File Size Exceeded"+LocalDateTime.now() ,"401");
	
        return new ResponseEntity<> (err, err.getStatus());
	}

}
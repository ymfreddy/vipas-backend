package bo.gob.aduana.vipas.exception;

public class FileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public FileNotFoundException(String message)
	{
		this.message = message;	
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



}
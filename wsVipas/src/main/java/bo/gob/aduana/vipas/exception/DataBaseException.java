package bo.gob.aduana.vipas.exception;

public class DataBaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataBaseException (String message) {
		super (message);
	}
	
	public DataBaseException (String message, Throwable cause) {
		super (message, cause);
	}
}
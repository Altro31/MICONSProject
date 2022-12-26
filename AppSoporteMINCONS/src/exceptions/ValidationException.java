package exceptions;

public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7705170608745225174L;
	
	public static final String EMPTY 					= "string empty";
	public static final String OUT_OF_RANGE 		= "string overlimit";
	public static final String NULL 					= "object null";
	public static final String EXIST					= "exist";
	public static final String DATE_WRONG				= "date wrong";
	public static final String DATE_ERROR				= "date error";

	
	public ValidationException(String message) {
		super(message);
	}

}

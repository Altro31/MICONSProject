package exceptions;

public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7705170608745225174L;

	public static final String EMPTY = "string empty";
	public static final String OUT_OF_RANGE = "string overlimit";
	public static final String NULL = "object null";
	public static final String EXIST = "exist";
	public static final String DATE_WRONG = "date wrong";
	public static final String DATE_ERROR = "date error";
	public static final String MONTH_WRONG = "month wrong";
	public static final String DAY_WRONG = "day wrong";
	public static final String AGE_WRONG = "age wrong";

	// Info
	public static final String ABOVE_RANGE = "above range";
	public static final String BELOW_RANGE = "below range";

	private final String info;

	public ValidationException(String message) {
		super(message);
		this.info = "";
	}

	public ValidationException(String message, String info) {
		super(message);
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

}

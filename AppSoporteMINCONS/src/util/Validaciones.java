package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import classes.Sistema;
import classifications.TipoEvento;
import exceptions.ValidationException;

public final class Validaciones {

	private static final Sistema sistema = Sistema.getInstance();

	private Validaciones() {
	}

	/**
	 * @Messages OUT_OF_RANGE
	 * 
	 * @param val
	 * @throws ValidationException
	 */
	public static void nonNegative(float val) throws ValidationException {
		if (val < 0) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

	/**
	 * @Messages OUT_OF_RANGE
	 * 
	 * @param val
	 * @throws ValidationException
	 */
	public static void nonZero(float val) throws ValidationException {
		if (val <= 0) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

	/**
	 * @messages: NULL
	 * 
	 * @param o
	 * @throws ValidationException
	 */
	public static void nullValidation(Object o) throws ValidationException {
		if (o == null)
			throw new ValidationException(ValidationException.NULL);
	}

	/**
	 * @messages: NULL, EMPTY
	 * 
	 * @param string
	 * @throws ValidationException
	 */
	public static void stringValidation(String string) throws ValidationException {
		nullValidation(string);
		if (string.isEmpty())
			throw new ValidationException(ValidationException.EMPTY);
	}

	/**
	 * 
	 * @Messages: NULL, EMPTY, EXIST, OUT_OF_RANGE
	 * @param name
	 * @throws ValidationException
	 */
	public static void nombreEvento(String name) throws ValidationException {
		stringValidation(name);
		if (name.length() > Limites.nombreEvento())
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		if (sistema.getEvento(name) != null) {
			throw new ValidationException(ValidationException.EXIST);
		}
	}

	/**
	 * 
	 * @Messages: NULL, EXIST
	 * @param evento
	 * @throws ValidationException
	 */
	public static void tipoEvento(TipoEvento evento) throws ValidationException {
		nullValidation(evento);
		if (!TipoEvento.contains(evento.getName())) {
			throw new ValidationException(ValidationException.EXIST);
		}
	}

	/**
	 * null, date is after today
	 * 
	 * @Messages NULL, DATE_WRONG
	 * @param date
	 * @throws ValidationException
	 */
	public static void fecha(Calendar date) throws ValidationException {
		nullValidation(date);
		GregorianCalendar today = new GregorianCalendar();
		if (today.before(date)) {
			throw new ValidationException(ValidationException.DATE_WRONG);
		}
	}

	/**
	 * null, date is after today
	 * 
	 * @Messages NULL, DATE_WRONG
	 * @param date
	 * @throws ValidationException
	 */
	public static void fechaInicio(Calendar date) throws ValidationException {
		fecha(date);
	}

	/**
	 * null, fechaFin are before than today, fechaInicio is before than fechaFin
	 * 
	 * @Messages NULL, DATE_WRONG, DATE_ERROR
	 * @param fechaInicio
	 * @param fechaFin
	 * @throws ValidationException
	 */
	public static void fechaFin(Calendar fechaInicio, Calendar fechaFin) throws ValidationException {
		fecha(fechaFin);
		if (fechaInicio != null && fechaInicio.after(fechaFin)) {
			throw new ValidationException(ValidationException.DATE_ERROR);
		}
	}

	/**
	 * direccion can only have 250 characters or lower
	 * 
	 * @Messages NULL, EMPTY, OUT_OF_RANGE
	 * 
	 * @param direccion
	 * @throws ValidationException
	 */
	public static void direccion(String direccion) throws ValidationException {
		stringValidation(direccion);
		if (direccion.length() > Limites.direccion()) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

	/**
	 * @Messages OUT_OF_RANGE
	 * 
	 * @param val
	 * @throws ValidationException
	 */
	public static void dimensions(float val) throws ValidationException {
		nonZero(val);
		if (val < Limites.dimensions()) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

	/**
	 * @Messages OUT_OF_RANGE
	 * 
	 * @param val
	 * @throws ValidationException
	 */
	public static void infantes(int val) throws ValidationException {
		nonNegative(val);
		if (val > Limites.infantes()) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

	/**
	 * @Messages OUT_OF_RANGE
	 * 
	 * @param val
	 * @param min
	 * @throws ValidationException
	 */
	public static void totalPresonas(int val, int min) throws ValidationException {
		nonNegative(val);
		if (val < min || val > Limites.totalPersonal()) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

//	public static void ciValidation(String cI) {
//		
//		if (cI==null) {
//			throw new IllegalArgumentException("cI cannot be null");
//		}
//		if (cI.length()!=11) {
//			throw new IllegalArgumentException("cI must to have 11 caracteres");
//		}
//		
//		
//		String date = cI.substring
//				(4, 6);
//		String month = cI.substring(2, 4);
//		String century = cI.substring(7, 8);
//		String year = cI.substring(0, 2);
//		
//		if (Integer.parseInt(month)<1 || Integer.parseInt(month)>12)
//			throw new IllegalArgumentException("cI must be a value betwen 1 and 12");
//		
//		if(century)
//		
//		
//		
//		
//		;
//		
//		
//	}
}

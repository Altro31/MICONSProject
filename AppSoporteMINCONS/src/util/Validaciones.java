package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

import classes.Sistema;
import classifications.TipoEvento;
import exceptions.ValidationException;
import settings.Limites;

public final class Validaciones {

	private static final Sistema sistema = Sistema.getInstance();

	private Validaciones() {
	}

	/**
	 * nonNegative
	 * 
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
	 * nonNegative, nonZero
	 * 
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
	 * noNull
	 * 
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
	 * noNull, noEmpty
	 * 
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
		if (Limites.nombreEvento() != null && name.length() > Limites.nombreEvento())
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
		if (Limites.direccion() != null && direccion.length() > Limites.direccion()) {
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
		if (Limites.dimensions() != null && val < Limites.dimensions()) {
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
		if (Limites.infantes() != null && val > Limites.infantes()) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

	/**
	 * @Messages OUT_OF_RANGE
	 * 
	 * @param val
	 * @throws ValidationException
	 */
	public static void ancianos(int val) throws ValidationException {
		nonNegative(val);
		if (Limites.ancianos() != null && val > Limites.ancianos()) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

	/**
	 * @Messages OUT_OF_RANGE
	 * 
	 * @param val
	 * @throws ValidationException
	 */
	public static void embarazadas(int val) throws ValidationException {
		nonNegative(val);
		if (Limites.embarazadas() != null && val > Limites.embarazadas()) {
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
		if (Limites.totalPersonal() != null && (val < min || val > Limites.totalPersonal())) {
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
		}
	}

	/**
	 * @Messages NULL,EMPTY,OUT_OF_RANGE,DATE_ERROR,AGE_WRONG
	 * @param ci
	 * @throws ValidationException
	 */
	public static void ci(String ci) throws ValidationException {

		stringValidation(ci);

		ValidationException ex = new ValidationException(ValidationException.OUT_OF_RANGE);
		if (ci.length() != 11) {
			if (ci.length() > 11)
				ex = new ValidationException(ValidationException.OUT_OF_RANGE, ValidationException.ABOVE_RANGE);
			throw ex;
		}

		int date = Integer.parseInt(ci.substring(4, 6));
		int month = Integer.parseInt(ci.substring(2, 4));
		String year = ci.substring(0, 2);
		int century = Integer.parseInt(ci.substring(6, 7));

		if (century == 9)
			year = "18" + year;
		else if (century > 5 && century < 9) {
			year = "20" + year;

		} else
			year = "19" + year;

		SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yy");
		dayFormat.setLenient(false);

		try {
			dayFormat.parse(date + "/" + month + "/" + year);
		} catch (ParseException e) {
			throw new ValidationException(ValidationException.DATE_ERROR);
		}

		Period age = Period.between(LocalDate.of(Integer.parseInt(year), month, date),
				LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1,
						Calendar.getInstance().get(Calendar.DATE)));

		if (age.getYears() < 18)
			throw new ValidationException(ValidationException.AGE_WRONG);

	}

	public static void nombreMaterial(String nombre) throws ValidationException {

		stringValidation(nombre);

		if (Limites.nombreMaterial() != null && nombre.length() > Limites.nombreMaterial())
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
	}

	public static void idMaterial(String id) throws ValidationException {

		stringValidation(id);

		if (id.length() != 8)
			throw new ValidationException(ValidationException.OUT_OF_RANGE);
	}
}

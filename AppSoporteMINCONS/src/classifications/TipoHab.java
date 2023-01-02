package classifications;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

import exceptions.ValidationException;
import util.Validaciones;

public final class TipoHab implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476927669869380994L;

	// Container
	private static final ArrayList<String> values = getValues();

	private String name;

	private TipoHab(String name) {
		setName(name);
	}

	/**
	 * 
	 * @return The name of all events as an ArrayList
	 */
	public static ArrayList<String> getValues() {

		ArrayList<String> values = new ArrayList<String>();

		if (TipoHab.values == null) {
			values.add("Casa");
			values.add("Bi-Planta");
			values.add("Duplex");
			values.add("Apartamento");
			values.add("Habitación en edificio");
			values.add("Bohío");
			values.add("Improvisado");

		} else {
			values = TipoHab.values;
		}

		return values;
	}

	/**
	 * Add an element to the list
	 * 
	 * @param typo The name of the element to add
	 * @return true if any elements were added
	 * @throws IllegalArgumentException If event is null or is empty
	 */
	public static boolean add(String typo) throws IllegalArgumentException {

		if (typo == null) {
			throw new IllegalArgumentException("typo no puede ser null");
		}
		if (typo.isEmpty()) {
			throw new IllegalArgumentException("typo no puede estar vacío");
		}

		boolean check = true;
		for (String string : values) {
			if (string.equalsIgnoreCase(typo)) {
				check = false;
			}
		}

		if (check) {
			values.add(typo);
		}

		return check;
	}

	/**
	 * Remove all the elements of the list that have the same name like typo
	 * 
	 * @param typo Name of the element to remove
	 * @return true if any element were removed
	 * @throws IllegalArgumentException If event is null or is empty
	 */
	public static boolean remove(final String typo) throws ValidationException {

		Validaciones.stringValidation(typo);

		return values.removeIf(new Predicate<String>() {

			@Override
			public boolean test(String name) {
				boolean check = false;
				if (name.equalsIgnoreCase(typo))
					check = true;
				return check;
			}
		});
	}

	/**
	 * Search for an element that its name equal to name ignoring the case
	 * 
	 * @param name The name to search
	 * @return a TipoEvento with that name as name
	 */
	public static boolean contains(String name) {

		Validaciones.nullValidation(name);
		boolean check = false;
		for (String string : values) {
			if (string.equalsIgnoreCase(name)) {
				check = true;
			}
		}
		return check;
	}

	public static TipoHab getTipoHab(String name) {

		TipoHab typo = null;

		try {
			typo = new TipoHab(name);
		} catch (ValidationException e) {
			typo = null;
		}

		return typo;
	}

	/**
	 * Setter
	 * 
	 * @param name
	 * @throws IllegalArgumentException If name not exist in the list of events, is
	 *                                  null or is empty
	 */
	private void setName(String name) throws IllegalArgumentException, ValidationException {
		Validaciones.stringValidation(name);
		if (!contains(name)) {
			throw new IllegalArgumentException(name + " no es un evento válido");
		}

		this.name = name;
	}

	/**
	 * Getter
	 * 
	 * @return A copy of name
	 */
	public String getName() {
		return name.intern();
	}
}

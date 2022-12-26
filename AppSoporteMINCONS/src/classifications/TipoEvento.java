package classifications;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

import exceptions.ValidationException;
import util.Validaciones;

public final class TipoEvento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476927669869380994L;

	// Container
	private static final ArrayList<String> values = getValues();

	private String name;

	private TipoEvento(String name) {
		setName(name);
	}

	/**
	 * 
	 * @return The name of all events as an ArrayList
	 */
	public static ArrayList<String> getValues() {

		ArrayList<String> values = new ArrayList<String>();

		if (TipoEvento.values == null) {
			values.add("Huracán");
			values.add("Tornado");
			values.add("Terremoto");
			values.add("Tsunami");
			values.add("Inundación");
			values.add("Incendio");
			values.add("Lluvia Torrencial");
		} else {
			values = TipoEvento.values;
		}

		return values;
	}

	/**
	 * Add an element to the list
	 * 
	 * @param evento The name of the element to add
	 * @return true if any elements were added
	 * @throws IllegalArgumentException If event is null or is empty
	 */
	public static boolean add(String evento) throws IllegalArgumentException {

		if (evento == null) {
			throw new IllegalArgumentException("evento no puede ser null");
		}
		if (evento.isEmpty()) {
			throw new IllegalArgumentException("evento no puede estar vacío");
		}

		boolean check = true;
		for (String string : values) {
			if (string.equalsIgnoreCase(evento)) {
				check = false;
			}
		}

		if (check) {
			values.add(evento);
		}

		return check;
	}

	/**
	 * Remove all the elements of the list that have the same name like event
	 * 
	 * @param event Name of the element to remove
	 * @return true if any element were removed
	 * @throws IllegalArgumentException If event is null or is empty
	 */
	public static boolean remove(final String event) throws IllegalArgumentException {

		if (event == null) {
			throw new IllegalArgumentException("evento no puede ser null");
		}
		if (event.isEmpty()) {
			throw new IllegalArgumentException("evento no puede estar vacío");
		}

		return values.removeIf(new Predicate<String>() {

			@Override
			public boolean test(String name) {
				boolean check = false;
				if (name.equalsIgnoreCase(event))
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
	
	public static TipoEvento getTipoEvento(String name) {
		
		TipoEvento evento = null;
		
		try {
			evento = new TipoEvento(name);
		} catch (ValidationException e) {
			evento = null;
		}
		
		return evento;
	}

	/**
	 * Setter
	 * @param name
	 * @throws IllegalArgumentException If name not exist in the list of events, is null or is empty
	 */
	private void setName(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("name no puede ser null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name no puede estar vacío");
		}
		if (!contains(name)) {
			throw new IllegalArgumentException(name + " no es un evento válido");
		}

		this.name = name;
	}

	/**
	 * Getter
	 * @return A copy of name
	 */
	public String getName() {
		return name.intern();
	}
}

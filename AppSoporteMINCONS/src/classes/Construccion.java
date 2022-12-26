package classes;

import java.io.Serializable;

import util.Auxiliary;

public class Construccion extends Material implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1499762410174505030L;
	String unidadMedida;

	public Construccion(String nombre, float precioUnitario, int cantidad, String unidadMedida) {
		super(Auxiliary.random(8), nombre, precioUnitario, cantidad);
		this.unidadMedida = unidadMedida;

	}

	public Construccion(String id, String nombre, float precioUnitario, int cantidad, String unidadMedida) {
		super(id, nombre, precioUnitario, cantidad);
		this.unidadMedida = unidadMedida;

	}

	public String getUnidadMedida() {
		return unidadMedida.intern();
	}

	public void setUnidadMedida(String unidadMedida) {
		if (unidadMedida == null || unidadMedida.isEmpty())
			throw new IllegalArgumentException("La unidad de medida debe tener al menos un caracter");
		if (unidadMedida.length() > 30)
			throw new IllegalArgumentException("Nombre no debe sobrepasar los 30 caracteres");

		this.unidadMedida = unidadMedida;
	}

	@Override
	public Construccion clones() {
		return new Construccion(id, nombre, precioUnitario, cantidad, unidadMedida);
	}
}

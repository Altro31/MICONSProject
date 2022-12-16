package clases;

import util.Auxiliary;

public class Construccion extends Material {

	String unidadMedida;

	public Construccion() {
		super(Auxiliary.random(8), "desconocido", 0, 0);
		unidadMedida = "metros";

	}

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
}

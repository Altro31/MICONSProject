package clases;

public class Construccion extends Material {

	String unidadMedida;

	public Construccion(String nombre) {
		super(nombre);

	}

	public Construccion(String nombre, String unidadMedida, float precioUnitario) {
		super(nombre, precioUnitario);
		this.setUnidadMedida(unidadMedida);

	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		if (unidadMedida == null || unidadMedida.isEmpty())
			throw new IllegalArgumentException("La unidad de medida debe tener al menos un caracter");
		if (unidadMedida.length() > 30)
			throw new IllegalArgumentException("Nombre no debe sobrepasar los 30 caracteres");

		this.unidadMedida = unidadMedida;
	}
}

package clases;

public class Construccion extends Material {

	String unidadMedida;

	public Construccion(String nombre) {
		super(nombre,"00000000000");

	}

	public Construccion(String nombre, int cantidad, float precioUnitario) {
		super(nombre, precioUnitario);
		this.cantidad = cantidad;

	}
	public Construccion() {
		super("", 0);
		unidadMedida= ""; 
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

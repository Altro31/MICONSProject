package clases;

public class Material {

	protected String nombre;
	protected float precioUnitario;

	public Material(String nombre) {
		this.setNombre(nombre);
	}

	public Material(String nombre, float precioUnitario) {
		this.setNombre(nombre);
		this.setPrecioUnitario(precioUnitario);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("Nombre debe tener al menos un caracter");
		if (nombre.length() > 40)
			throw new IllegalArgumentException("Nombre no debe sobrepasar los 40 caracteres");

		this.nombre = nombre;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		if (precioUnitario <= 0)
			throw new IllegalArgumentException("El precio debe ser mayor que cero");
		if (precioUnitario > 1000)
			throw new IllegalArgumentException("El precio unitario no puede ser mayor que 1000 "); // no debe sobrepasar
																									// los mil

		this.precioUnitario = precioUnitario;
	}

}

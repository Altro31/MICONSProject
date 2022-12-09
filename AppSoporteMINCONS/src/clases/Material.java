
package clases;

import interfaces.Identificador;

public class Material implements Identificador{
	
	private String id;
	protected String nombre;
	protected float precioUnitario;
	
	public Material() {
		id = "";
		nombre = "";
		precioUnitario = 0;
	}

	public Material(String nombre, String id) {
		this.setNombre(nombre);
		this.setIdentificador(id);
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
			throw new IllegalArgumentException("El precio unitario no puede ser mayor que 1000 ");

		this.precioUnitario = precioUnitario;
	}
	
	public String getIdentificador() {
		return id;
	}

	@Override
	public void setIdentificador(String id) {
		if (id.length() != 11 || !id.matches("\\d")) {
			throw new IllegalArgumentException("Se debe introducir once numeros"); 
		}
		else{
			this.id = id;
		}
		
	}

}

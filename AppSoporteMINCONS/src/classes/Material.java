
package classes;

import java.io.Serializable;

import interfaces.Identificador;

public abstract class Material implements Identificador, Serializable {

	private static final long serialVersionUID = 1540851799326861293L;
	protected String id;
	protected String nombre;
	protected float precioUnitario;
	protected int cantidad;

	// Constructor con todos los campos
	protected Material(String id, String nombre, float precioUnitario, int cant) {
		setId(id);
		setNombre(nombre);
		setPrecioUnitario(precioUnitario);
		setCantidad(cant);
	}

	// Métodos
	
	public float calcularPrecioFinal() {
		return precioUnitario*cantidad;
	}
	
	public abstract Object clones() ;
	
	// Setters y Getters

	public String getNombre() {
		return nombre.intern();
	}

	public void setNombre(String nombre) throws IllegalArgumentException {
		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("Nombre debe tener al menos un caracter");
		if (nombre.length() > 40)
			throw new IllegalArgumentException("Nombre no debe sobrepasar los 40 caracteres");

		this.nombre = nombre;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) throws IllegalArgumentException {
		if (precioUnitario <= 0)
			throw new IllegalArgumentException("El precio debe ser mayor que cero");

		this.precioUnitario = precioUnitario;
	}

	public String getID() {
		return id.intern();
	}

	private void setId(String id) throws IllegalArgumentException {
		if (id.length() != 8)
			throw new IllegalArgumentException("Identificador debe terner tamaño 8");
		if (!id.matches("[0-9]*"))
			throw new IllegalArgumentException("Identificador sólo puede contener numeros");
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) throws IllegalArgumentException {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("Cantidad debe ser mayor que 0");
		}
		this.cantidad = cantidad;
	}

}

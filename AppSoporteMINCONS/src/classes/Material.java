
package classes;

import java.io.Serializable;

import interfaces.Identificador;
import util.Validaciones;
import visual.settings.PanelMateriales;

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
		return precioUnitario * cantidad;
	}

	public abstract Object clones();

	/**
	 * Devuelve una instancia Material del tipo deseado
	 * 
	 * @tipos Inmueble, Construcción
	 * @param tipo
	 * @return
	 */
	public Material getMaterial(String tipo) {
		Material mat = null;
		if (tipo.equals(PanelMateriales.INMUEBLE)) {
			mat = new Inmueble("desconocido", 5, 1);
		} else if (tipo.equals(PanelMateriales.CONSTRUCCION)) {
			mat = new Construccion("desconocido", 5, 1, "desconocida");
		}
		return mat;
	}
	// Setters y Getters

	public String getNombre() {
		return nombre.intern();
	}

	public void setNombre(String nombre) throws IllegalArgumentException {

		Validaciones.nombreMaterial(nombre);
		this.nombre = nombre;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) throws IllegalArgumentException {

		Validaciones.nonZero(precioUnitario);

		this.precioUnitario = precioUnitario;
	}

	public String getID() {
		return id.intern();
	}

	private void setId(String id) throws IllegalArgumentException {
		Validaciones.idMaterial(id);
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) throws IllegalArgumentException {
		Validaciones.nonZero(cantidad);
		this.cantidad = cantidad;
	}

}

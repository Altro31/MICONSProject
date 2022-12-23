package clases;

import util.Auxiliary;

public class Inmueble extends Material {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3690386753353063211L;
	
	public Inmueble(String nombre, float precioUnitario, int cantidad) {
		super(Auxiliary.random(8), nombre, precioUnitario, cantidad);
	}
	
	public Inmueble(String id, String nombre, float precioUnitario, int cantidad) {
		super(id, nombre, precioUnitario, cantidad);
	}
}

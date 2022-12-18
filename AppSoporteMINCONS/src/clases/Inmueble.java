package clases;

import util.Auxiliary;

public class Inmueble extends Material {

	public Inmueble() {
		super(Auxiliary.random(8), "desconocido", 1, 1);

	}

	public Inmueble(String nombre, float precioUnitario, int cantidad) {
		super(Auxiliary.random(8), nombre, precioUnitario, cantidad);

	}
	public Inmueble(String id, String nombre, float precioUnitario, int cantidad) {
		super(id, nombre, precioUnitario, cantidad);
	}

}

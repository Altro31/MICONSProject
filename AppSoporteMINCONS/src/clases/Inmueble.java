package clases;

public class Inmueble extends Material {

	public Inmueble(String nombre) {
		super(nombre, "00000000000");
	}


	public Inmueble(String nombre, String id, int cantidad) {
		super(nombre, id);
		this.cantidad = cantidad;
		this.precioUnitario = 0;
	}
	
	public Inmueble(String nombre, String id, int cantidad, float precioUnitario) {
		super(nombre, id);
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

}

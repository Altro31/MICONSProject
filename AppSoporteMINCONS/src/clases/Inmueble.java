package clases;

public class Inmueble extends Material {

	private int cantidad;

	public Inmueble(String id, String nombre, float precioUnitario) {
		super(nombre, precioUnitario);
	}

	public Inmueble(String nombre, String id, int cantidad) {
		super(nombre, id);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Inmueble() {
		super("", 0);
		cantidad = 0;
	}

}

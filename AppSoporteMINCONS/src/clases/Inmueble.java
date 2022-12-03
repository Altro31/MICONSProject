package clases;

public class Inmueble extends Material{
	
	private String id;
	private int cantidad;
	
	public Inmueble(String id, String nombre, float precioUnitario) {
		super(nombre, precioUnitario);
		setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}

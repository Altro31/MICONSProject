package clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Cubicacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2620032420950104908L;
	
	private ArrayList<Material> materialesVenta;

	public Cubicacion() {
		materialesVenta = new ArrayList<Material>();
	}

	public ArrayList<Material> getListaMateriales() {
		return materialesVenta;
	}
	
	public float calcularPrecioTotalReparacion() {
		float total = 0;
		for (Material material : materialesVenta) {
			total+=material.calcularPrecioFinal();
		}
		return total;
	}

}

package clases;

import java.util.ArrayList;

public class Cubicacion {
	
	ArrayList<Material> materialesVenta;
	
	public Cubicacion() {
		materialesVenta = new ArrayList<Material>();
	}
	
	public ArrayList<Material> getListaMateriales() {
		return new ArrayList<Material>(materialesVenta);
	}
	public void addMaterial(Material material) {
		if(material==null)
			throw new IllegalArgumentException("Material tiene valor null");
		materialesVenta.add(material);
	}
	public void eliminarMaterial(int pos) {
		if(pos<0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		materialesVenta.remove(pos);
	}
	
	public void setMaterial(int pos, Material material) throws IndexOutOfBoundsException, IllegalArgumentException{
		if(pos<0)
			throw new IllegalArgumentException("Pos no debe tener valor negativo");
		materialesVenta.set(pos, material);
	}
	
}

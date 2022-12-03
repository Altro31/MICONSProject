package clases;

import java.util.ArrayList;

public class Elemento {
	
	private ArrayList<Inmueble> listaInmuebles;
	
	public ArrayList<Inmueble> getListaInmuebles() {
		return listaInmuebles;
	}
	
	public void addInmueble(Inmueble v) {
		if(v==null)
			throw new IllegalArgumentException("El objeto Inmueble no se ha inicializado");
		listaInmuebles.add(v);
	}
	
	public void eliminarInmueble(int pos) {
		if(listaInmuebles.isEmpty())
			throw new IllegalArgumentException("La lista de Inmueble está vacía");
		if(pos<=0 || pos>listaInmuebles.size()-1)
			throw new IllegalArgumentException("La posición está fuera del rango de la lista");
		listaInmuebles.remove(pos);
	}
	
}

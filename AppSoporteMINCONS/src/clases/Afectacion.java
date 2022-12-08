package clases;

import java.util.ArrayList;

public class Afectacion {
	// Attributes
	private ArrayList<Inmueble> listaInmuebles;
	private ArrayList<Pared> listaParedes;
	private ArrayList<Techo> listaTechos;
	
	//Constructores
	//Constructor por defecto
	public Afectacion() {
		listaInmuebles = new ArrayList<Inmueble>();
		listaInmuebles.add(new Inmueble("Lavadora", "123", 1));
		listaInmuebles.add(new Inmueble("Lavamanos", "456", 2));
		listaInmuebles.add(new Inmueble("Refrigerador", "789", 4));
		
		listaParedes=new ArrayList<Pared>();
	}
	
	//Getters and Setters
	
	public ArrayList<Inmueble> getListaInmuebles() {
		return new ArrayList<Inmueble>(listaInmuebles);
	}
	public void addInmueble(Inmueble inmueble) {
		if(inmueble==null)
			throw new IllegalArgumentException("Inmueble tiene valor null");
		listaInmuebles.add(inmueble);
	}
	public void eliminarInmueble(int pos) {
		if(pos<0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaInmuebles.remove(pos);
	}
	
	public ArrayList<Pared> getListaParedes() {
		return new ArrayList<Pared>(listaParedes);
	}
	public void addPared(Pared pared) {
		if(pared==null)
			throw new IllegalArgumentException("Pared tiene valor null");
		listaParedes.add(pared);
	}
	public void eliminarPared(int pos) {
		if(pos<0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaParedes.remove(pos);
	}
	
	public ArrayList<Techo> getListaTechos() {
		return new ArrayList<Techo>(listaTechos);
	}
	public void addTecho(Techo techo) {
		if(techo==null)
			throw new IllegalArgumentException("Techo tiene valor null");
		listaTechos.add(techo);
	}
	public void eliminarTecho(int pos) {
		if(pos<0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaTechos.remove(pos);
	}
}
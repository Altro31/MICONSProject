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
		listaInmuebles.add(new Inmueble("Lavadora", 50 ,1));
		listaInmuebles.add(new Inmueble("Lavamanos", 23, 2));
		listaInmuebles.add(new Inmueble("Refrigerador", 38, 4));
		
		listaParedes=new ArrayList<Pared>();
		
		listaTechos = new ArrayList<Techo>();
	}
	
	//Getters and Setters
	public ArrayList<Inmueble> getListaInmuebles() {
		return listaInmuebles;
	}
	
	public void setInmueble(int pos, Inmueble inmueble) throws IndexOutOfBoundsException, IllegalArgumentException{
		if(pos<0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaInmuebles.set(pos, inmueble);
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
			throw new IllegalArgumentException("Pos no debe tener valor negativo");
		listaParedes.remove(pos);
	}
	
	public void setPared(int pos, Pared pared) throws IndexOutOfBoundsException, IllegalArgumentException{
		if(pos<0)
			throw new IllegalArgumentException("Pos no debe tener valor negativo");
		listaParedes.set(pos, pared);
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
	
	public void setTecho(int pos, Techo techo) throws IndexOutOfBoundsException, IllegalArgumentException{
		if(pos<0)
			throw new IllegalArgumentException("Pos no debe tener valor negativo");
		listaTechos.set(pos, techo);
	}
}
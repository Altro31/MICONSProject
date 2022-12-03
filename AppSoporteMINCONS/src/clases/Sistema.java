package clases;

import java.util.ArrayList;

public class Sistema {
	
	private ArrayList<Evento> listaEventos;
	private ArrayList<Material> listaMateriales;
	
	private static Sistema sistema;
	
	private Sistema(){
		listaEventos = new ArrayList<Evento>();
		listaEventos.add(new Evento("Al", null, null, enums.Evento.TERREMOTO));
		listaMateriales= new ArrayList<Material>();
	}
	
	public static Sistema getSistema() {
		if(sistema==null)
			sistema=new Sistema();
		return sistema;
	}
	public ArrayList<Evento> getListaEventos() {
		return listaEventos;
	}
	public void addEventos(Evento evento) {
		if(evento==null)
			throw new IllegalArgumentException("Evento tiene valor null");
		listaEventos.add(evento);
	}
	public void eliminarEvento(int pos) {
		if(pos<0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaEventos.remove(pos);
	}
	
	public ArrayList<Material> getListaMateriales() {
		return new ArrayList<Material>(listaMateriales);
	}
	public void addMaterial(Material material) {
		if(material==null)
			throw new IllegalArgumentException("Material tiene valor null");
		listaMateriales.add(material);
	}
	public void eliminarMaterial(int pos) {
		if(pos<0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaMateriales.remove(pos);
	}
}

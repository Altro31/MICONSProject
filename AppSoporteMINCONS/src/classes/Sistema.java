package classes;

import java.io.Serializable;
import java.util.ArrayList;

import util.Manager;

public class Sistema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4250032788535040218L;
	private final ArrayList<Evento> listaEventos;
	private final ArrayList<Material> listaMateriales;

	private static Sistema sistema;

	private Sistema() {

		listaEventos = new ArrayList<Evento>();
		listaMateriales = new ArrayList<Material>();

		 listaMateriales.add(new Construccion("Cemento", 2000F, 1, "sacos"));
		 listaMateriales.add(new Construccion("Ladrillo", 25F, 1,
		 "unidades"));
		 listaMateriales.add(new Construccion("Bloque", 40F, 1, "unidades"));
		 listaMateriales.add(new Construccion("Gravilla", 180F, 1, "sacos"));
		 listaMateriales.add(new Construccion("Arena", 180F, 1, "sacos"));
		 listaMateriales.add(new Construccion("Tejas", 4500F, 1, "unidades"));
		 listaMateriales.add(new Construccion("Yeso", 3000F, 1, "sacos"));
		 listaMateriales.add(new Construccion("Cavilla", 250F, 1, "metros"));
		 listaMateriales.add(new Inmueble("Lavadora", 1, 11));
		 listaMateriales.add(new Inmueble("Lavamanos", 2, 12));
		 listaMateriales.add(new Inmueble("Refrigerador", 4, 13));
		 listaMateriales.add(new Inmueble("Fregadero", 4, 13));
		 listaMateriales.add(new Inmueble("Inodoro", 4, 13));
		 listaMateriales.add(new Inmueble("Televisor", 4, 13));
		 listaMateriales.add(new Inmueble("Mueble", 4, 13));

	}

	/**
	 * Devuelve una única instancia de Sistema (Singleton)
	 */
	public static Sistema getInstance() {
		if (sistema == null) {
			sistema = Manager.cargarDatos();
			if (sistema == null) {
				sistema = new Sistema();
			}
		}
		return sistema;
	}

	/**
	 * Busca un material por su nombre o ID
	 */
	public Material getMaterial(String nombreOrID) {
		Material material = null;
		for (Material mat : listaMateriales) {
			if (mat.getNombre().equalsIgnoreCase(nombreOrID) || mat.getID().equalsIgnoreCase(nombreOrID)) {
				material = mat;
			}
		}
		return material;
	}

	/**
	 * Busca un evento por su nombre
	 */
	public Evento getEvento(String nombre) {
		Evento evento = null;
		for (Evento ev : listaEventos) {
			if (ev.getNombre().equalsIgnoreCase(nombre)) {
				evento = ev;
			}
		}
		return evento;
	}

	public ArrayList<Evento> getListaEventos() {
		return listaEventos;
	}

	public ArrayList<Material> getListaMateriales() {
		return listaMateriales;
	}

	public void addEvento(Evento evento) {
		Evento evento1 = getEvento(evento.getNombre());
		if (evento1 != null) {
			listaEventos.set(listaEventos.indexOf(evento1), evento);
		} else {
			listaEventos.add(evento);
		}
	}

}

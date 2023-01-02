package classes;

import java.io.Serializable;
import java.util.ArrayList;

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

	}

	/**
	 * Devuelve una única instancia de Sistema (Singleton)
	 */
	public static Sistema getInstance() {
		if (sistema == null) {
			sistema = new Sistema();
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

	public void addEvento(Evento evento) {
		Evento evento1 = getEvento(evento.getNombre());
		if (evento1 != null) {
			listaEventos.set(listaEventos.indexOf(evento1), evento);
		} else {
			listaEventos.add(evento);
		}
	}

	public ArrayList<Material> getListaMateriales() {
		return listaMateriales;
	}

	public ArrayList<Inmueble> getListaInmuebles() {

		ArrayList<Inmueble> lista = new ArrayList<Inmueble>();

		for (Material material : listaMateriales) {
			if (material instanceof Inmueble) {
				lista.add((Inmueble) material);
			}
		}

		return lista;
	}

	public ArrayList<Construccion> getListaConstruccion() {

		ArrayList<Construccion> lista = new ArrayList<Construccion>();

		for (Material material : listaMateriales) {
			if (material instanceof Construccion) {
				lista.add((Construccion) material);
			}
		}

		return lista;
	}

	public void addMaterial(Material material) {

		Material other = getMaterial(material.getNombre());

		if (other != null) {
			listaMateriales.set(listaMateriales.indexOf(material), material);
		} else {
			listaMateriales.add(material);
		}

	}

}

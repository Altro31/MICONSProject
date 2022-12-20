package clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Afectacion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3292275485564873362L;
	// Attributes
	private ArrayList<Inmueble> listaInmuebles;
	private ArrayList<Pared> listaParedes;
	private ArrayList<Techo> listaTechos;

	// Constructores
	// Constructor por defecto
	public Afectacion() {

		listaInmuebles = new ArrayList<Inmueble>();

		listaParedes = new ArrayList<Pared>();

		listaTechos = new ArrayList<Techo>();
	}

	// Getters and Setters
	public ArrayList<Inmueble> getListaInmuebles() {
		return listaInmuebles;
	}

	public ArrayList<Pared> getListaParedes() {
		return listaParedes;
	}

	public ArrayList<Techo> getListaTechos() {
		return listaTechos;
	}
}
package clases;

import java.util.ArrayList;

public class Sistema {

	private static ArrayList<Evento> listaEventos = new ArrayList<Evento>();
	private static ArrayList<Material> listaMateriales = new ArrayList<Material>();
	private static Sistema sistema;

	private Sistema() {
		
		listaMateriales.add(new Construccion("Cemento", 3F, 6, "metros"));
		listaMateriales.add(new Construccion("Gravilla", 2F, 2, "metros"));
		listaMateriales.add(new Construccion("Arena", 4F, 6, "metros"));
		listaMateriales.add(new Construccion("Tejas", 7F, 9, "metros"));
		listaMateriales.add(new Inmueble("12345678", "Lavadora", 1, 11));
		listaMateriales.add(new Inmueble("45645679", "Lavamanos", 2, 12));
		listaMateriales.add(new Inmueble("78945671", "Refrigerador", 4, 13));
		
	}

	public static void getInstance() {
		if (sistema == null)
			sistema = new Sistema();
	}
	// Métodos

	// Busca un material por su nombre o ID
	public static Material getMaterial(String nombreOrID) {
		getInstance();
		Material material = null;
		for (Material mat : listaMateriales) {
			if (mat.getNombre().equalsIgnoreCase(nombreOrID) || mat.getID().equalsIgnoreCase(nombreOrID)) {
				material = mat;
			}
		}
		return material;
	}
	//Devuelve una única instancia de Sistema (Singleton)
	public static ArrayList<Evento> getListaEventos() {
		getInstance();
		return new ArrayList<Evento>(listaEventos);
	}

	// Getters y Setters
	public static void addEventos(Evento evento) {
		getInstance();
		if (evento == null)
			throw new IllegalArgumentException("TipoEvento tiene valor null");
		listaEventos.add(evento);
	}

	public static void eliminarEvento(int pos) {
		getInstance();
		if (pos < 0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaEventos.remove(pos);
	}

	public static ArrayList<Material> getListaMateriales() {
		getInstance();
		return new ArrayList<Material>(listaMateriales);
	}

	public static void addMaterial(Material material) {
		getInstance();
		if (material == null)
			throw new IllegalArgumentException("Material tiene valor null");
		listaMateriales.add(material);
	}

	public static void eliminarMaterial(int pos) {
		getInstance();
		if (pos < 0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaMateriales.remove(pos);
	}
}

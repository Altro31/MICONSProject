package clases;

import java.util.ArrayList;

public class Sistema {

	private static ArrayList<Evento> listaEventos;
	private static ArrayList<Material> listaMateriales;
	private static Sistema sistema;

	private Sistema() {

		listaEventos = new ArrayList<Evento>();

		listaMateriales = new ArrayList<Material>();
		listaMateriales.add(new Construccion("Cemento"));
		listaMateriales.add(new Construccion("Gravilla"));
		listaMateriales.add(new Construccion("Arena"));
		listaMateriales.add(new Construccion("Tejas"));
		listaMateriales.add(new Inmueble("Lavadora", "123", 1));
		listaMateriales.add(new Inmueble("Lavamanos", "456", 2));
		listaMateriales.add(new Inmueble("Refrigerador", "789", 4));
	}

	public static void getInstance() {
		if (sistema == null)
			sistema = new Sistema();
	}

	public static ArrayList<Evento> getListaEventos() {
		getInstance();
		return new ArrayList<Evento>(listaEventos);
	}

	public static void addEventos(Evento evento) {
		getInstance();
		if (evento == null)
			throw new IllegalArgumentException("Evento tiene valor null");
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

	public static Material getMaterial(String nombre) {
		getInstance();
		Material material = null;
		for (Material mat : listaMateriales) {
			if (mat.getNombre().equalsIgnoreCase(nombre)) {
				material = mat;
			}
		}
		return material;
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

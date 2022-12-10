package clases;

import java.util.ArrayList;

public class Sistema {

	private static ArrayList<Evento> listaEventos;
	private static ArrayList<Material> listaMateriales;
	private static Sistema sistema;

	private Sistema() {

		listaEventos = new ArrayList<Evento>();

		listaMateriales = new ArrayList<Material>();
		listaMateriales.add(new Construccion("Cemento",3,6));
		listaMateriales.add(new Construccion("Gravilla",2,2));
		listaMateriales.add(new Construccion("Arena",4,6));
		listaMateriales.add(new Construccion("Tejas",7,9));
		listaMateriales.add(new Inmueble("Lavadora", "12345678919", 1, 11));
		listaMateriales.add(new Inmueble("Lavamanos", "45645678919", 2, 12));
		listaMateriales.add(new Inmueble("Refrigerador", "78945678919", 4, 13));
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

package util;

import java.util.ArrayList;

public class Ruta {

	private static Ruta instace;
	private static ArrayList<Object[]> ruta;

	private Ruta() {
		ruta = new ArrayList<Object[]>();
	}

	public static void getInstace() {
		if (instace == null) {
			instace = new Ruta();
		}
	}

	public static void addRuta(Object visual, Object data) throws IllegalArgumentException {
		getInstace();
		if (visual == null) {
			throw new IllegalArgumentException("Visual no puede ser null");
		}
		ruta.add(new Object[] {visual, data});
	}

	public static Object[] getPosicionActual() {
		getInstace();
		return ruta.get(ruta.size()-1);
	}

	public static void removerRuta(Object o) throws IllegalArgumentException {
		getInstace();
		if (o == null) {
			throw new IllegalArgumentException("El objeto no puede ser null");
		}
		boolean borrar = false;
		for (Object[] objects : ruta) {
			if (objects[0].equals(o) || objects[1].equals(o)) {
				borrar = true;
			}
			if (borrar) {
				ruta.remove(objects);
			}
		}

	}
}

package util;

public final class Limites {

	private static int nombreEvento = 40;
	private static int direccion = 250;
	private static float dimensions = 5F;
	private static int infantes = 15;
	private static int totalPersonal = 20;

	private Limites() {
	}

	public static int nombreEvento() {
		return nombreEvento;
	}

	public static void setNombreEvento(int nombreEvento) {
		Limites.nombreEvento = nombreEvento;
	}

	public static int direccion() {
		return direccion;
	}

	public static void setDireccion(int direccion) {
		Limites.direccion = direccion;
	}

	public static float dimensions() {
		return dimensions;
	}

	public static void setDimensions(float dimensions) {
		Limites.dimensions = dimensions;
	}

	public static int infantes() {
		return infantes;
	}

	public static void setInfantes(int infantes) {
		Limites.infantes = infantes;
	}

	public static int totalPersonal() {
		return totalPersonal;
	}

	public static void setTotalPersonal(int totalPersonal) {
		Limites.totalPersonal = totalPersonal;
	}

}

package util;

public final class Limites {

	private static int nombreEvento = 40;
	private static int direccion = 250;
	private static float dimensions = 5F;
	private static Integer infantes = 10;
	private static Integer totalPersonal = 20;
	private static Integer embarazadas = null;
	private static Integer ancianos = null;

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

	public static Integer infantes() {
		return infantes;
	}

	public static void setInfantes(Integer infantes) {
		Limites.infantes = infantes;
	}

	public static Integer totalPersonal() {
		return totalPersonal;
	}

	public static void setTotalPersonal(Integer totalPersonal) {
		Limites.totalPersonal = totalPersonal;
	}

	public static Integer embarazadas() {
		return embarazadas;
	}

	public static void setEmbarazadas(Integer embarazadas) {
		Limites.embarazadas = embarazadas;
	}

	public static Integer ancianos() {
		return ancianos;
	}

	public static void setAncianos(Integer ancianos) {
		Limites.ancianos = ancianos;
	}

	

}

package enums;

public enum Evento {
	URACAN,
	TORNADO,
	TERREMOTO,
	OTRO;
	
	public static Evento getValue(String string) {
		Evento tipo;
		switch (string.toUpperCase()) {
		case "URACAN":
			tipo = Evento.URACAN;
			break;
		case "TORNADO":
			tipo = Evento.TORNADO;
			break;
		case "TERREMOTO":
			tipo = Evento.TERREMOTO;
			break;
		default:
			tipo = Evento.OTRO;
			break;
		}
		return tipo;
	}
}

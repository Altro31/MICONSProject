package enums;

public enum TipoEvento {
	URACAN,
	TORNADO,
	TERREMOTO,
	OTRO;
	
	public static TipoEvento getValue(String string) {
		TipoEvento tipo;
		switch (string.toUpperCase()) {
		case "URACAN":
			tipo = TipoEvento.URACAN;
			break;
		case "TORNADO":
			tipo = TipoEvento.TORNADO;
			break;
		case "TERREMOTO":
			tipo = TipoEvento.TERREMOTO;
			break;
		default:
			tipo = TipoEvento.OTRO;
			break;
		}
		return tipo;
	}
}

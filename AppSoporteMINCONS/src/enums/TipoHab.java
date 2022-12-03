package enums;

public enum TipoHab {
	CASA("C", "Casa"),
	APARTAMENTO("A", "Apartamento"),
	BOHIO("B", "Bohío"),
	OTRO("O", "Otro");

	String abrev;
	String string;
	
	private TipoHab(String abrev, String name) {
		this.abrev=abrev;
		this.string=name;
	}
	
	public String getAbrev() {
		return abrev;
	}
	
	public String getName() {
		return string;
	}
	
	public static TipoHab getValue(String string) {
		TipoHab tipo;
		switch (string.toUpperCase()) {
		case "Casa":
			tipo = TipoHab.CASA;
			break;
		case "Apartamento":
			tipo = TipoHab.APARTAMENTO;
			break;
		case "Bohío":
			tipo = TipoHab.BOHIO;
			break;
		default:
			tipo = TipoHab.OTRO;
			break;
		}
		return tipo;
	}
}

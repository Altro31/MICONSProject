package enums;

public enum Doc {
	
	PROPIEDAD("PP", "Propiedad"),
	USUFRUCTO("US", "Usufructo"),
	VIV_VINCULADA("VV", "Viviendas Vinculada"),
	ARRENDAMIENTO("AR", "Arrendamiento"),
	PROVIDENCIA("PR", "Providencia"),
	INDOCUMENTADO("IN", "Indocumentado");
	
	String abrev;
	String string;
	
	private Doc(String abrev, String name) {
		this.abrev=abrev;
		this.string=name;
	}
	
	public String getAbrev() {
		return abrev;
	}
	
	public String getName() {
		return string;
	}
	
	public static Doc getValue(String string) {
		Doc tipo;
		switch (string.toUpperCase()) {
		case "Propiedad":
			tipo = Doc.PROPIEDAD;
			break;
		case "Usufructo":
			tipo = Doc.USUFRUCTO;
			break;
		case "Viviendas Vinculada":
			tipo = Doc.VIV_VINCULADA;
			break;
		case "Arrendamiento":
			tipo = Doc.ARRENDAMIENTO;
			break;
		case "Providencia":
			tipo = Doc.PROVIDENCIA;
			break;
		default:
			tipo = Doc.INDOCUMENTADO;
			break;
		}
		return tipo;
	}
}

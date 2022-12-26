package classifications;

public enum Doc {

	PROPIEDAD( "Propiedad"), USUFRUCTO( "Usufructo"), VIV_VINCULADA( "Viviendas Vinculada"),
	ARRENDAMIENTO( "Arrendamiento"), PROVIDENCIA( "Providencia"), INDOCUMENTADO( "Indocumentado");

	private String name;

	private Doc(String name) {
		this.name = name;
	}

	public String getName() {
		return name+"";
	}
	
	public static Doc value(String string) {
		Doc tipo = null;
		for(Doc doc : values()) {
			if(doc.name.equalsIgnoreCase(string)) {
				tipo = doc;
			}
		}
		return tipo;
	}
}
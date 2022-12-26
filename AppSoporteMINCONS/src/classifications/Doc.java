package classifications;

public enum Doc {

	PROPIEDAD( "Propiedad"), USUFRUCTO( "Usufructo"), VIV_VINCULADA( "Vivienda Vinculada"),
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
	
	public static String[] names() {
		Doc[] values = values();
		String[] names = new String[values.length];
		for(int i=0; i<values.length; i++) {
			names[i] = values[i].name;
		}
		return names;
	}
}
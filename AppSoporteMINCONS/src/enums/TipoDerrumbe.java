package enums;

public enum TipoDerrumbe {
	PARCIAL,
	TOTAL;
	
	String string;
	
	TipoDerrumbe() {
		string=this.name();
	}
	
	public static String[] names() {
		return new String[] {
				"Parcial",
				"Total"
		};
	}
	
	public static TipoDerrumbe getValue(String string) {
		TipoDerrumbe tipo;
		if(string.equalsIgnoreCase("PARCIAL"))
			tipo=TipoDerrumbe.PARCIAL;
		else
			tipo=TipoDerrumbe.TOTAL;
		return tipo;
	}
	
}

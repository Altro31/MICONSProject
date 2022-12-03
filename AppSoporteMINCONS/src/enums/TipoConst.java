package enums;

public enum TipoConst {
	
	I("1"),
	II("2"),
	III("3"),
	IV("4"),
	V("5");
	
	String abrev;
	
	private TipoConst(String abrev) {
		this.abrev=abrev;
	}
	
	public String getAbrev() {
		return abrev;
	}
	
	public static TipoConst getValue(String string) {
		TipoConst tipo;
		switch (string.toUpperCase()) {
		case "1":
			tipo = TipoConst.I;
			break;
		case "2":
			tipo = TipoConst.II;
			break;
		case "3 Vinculada":
			tipo = TipoConst.III;
			break;
		case "4":
			tipo = TipoConst.IV;
			break;
		default:
			tipo = TipoConst.V;
			break;
		}
		return tipo;
	}
}

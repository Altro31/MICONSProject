package clases;

import enums.TipoDerrumbe;

public class Pared extends Fachada{
	
	private boolean esParedCarga;

	public Pared(String identidicador, Construccion materialPredominante, TipoDerrumbe tipoDerrumbe, boolean esParedCarga) {
		super(identidicador, materialPredominante, tipoDerrumbe);
		this.setEsParedCarga(esParedCarga);
	}

	public boolean isEsParedCarga() {
		return esParedCarga;
	}

	public void setEsParedCarga(boolean esParedCarga) {
		this.esParedCarga = esParedCarga;
	}
	

}

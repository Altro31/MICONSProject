package clases;

import enums.TipoDerrumbe;

public class Fachada extends Afectacion{
	
	protected String identificador;
	protected Construccion materialPredominante;
	protected TipoDerrumbe tipoDerrumbe;
	
	public Fachada(String identidicador, Construccion materialPredominante, TipoDerrumbe tipoDerrumbe) {
		this.setIdentificador(identidicador);
		this.setMaterialPredominante(materialPredominante);
		this.setTipoDerrumbe(tipoDerrumbe);
		this.setTipoDerrumbe(tipoDerrumbe);
	
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Construccion getMaterialPredominante() {
		return materialPredominante;
	}

	public void setMaterialPredominante(Construccion materialPredominante) {
		if (materialPredominante == null)
			throw new IllegalArgumentException(" El material no debe tomar valor null");

			
		this.materialPredominante = materialPredominante;
	}


	public void setTipoDerrumbe(TipoDerrumbe tipoDerrumbe) {
		this.tipoDerrumbe = tipoDerrumbe;
	}
	
	public TipoDerrumbe getTipoDerrumbe() {
		return tipoDerrumbe;

		
	}
}

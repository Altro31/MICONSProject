package classes;

import classifications.TipoDerrumbe;

public class Techo extends Fachada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8528196489430907386L;

	public Techo(String identidicador, Construccion materialPredominante, TipoDerrumbe tipoDerrumbe) {
		super(identidicador, materialPredominante, tipoDerrumbe);
	}
}

package clases;

import enums.TipoDerrumbe;
import util.Auxiliary;

public class Techo extends Fachada{

	public Techo(String identidicador, Construccion materialPredominante, TipoDerrumbe tipoDerrumbe) {
		super(Auxiliary.random(8), identidicador, materialPredominante, tipoDerrumbe);
	}
	
	public Techo(String id, String identidicador, Construccion materialPredominante, TipoDerrumbe tipoDerrumbe) {
		super(id, identidicador, materialPredominante, tipoDerrumbe);
	}
	
}

package classes;

import java.io.Serializable;

import interfaces.Identificador;
import util.Auxiliary;

public class FichaTecnica implements Serializable, Identificador {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7260472950220116082L;
	private String id;
	private Vivienda vivienda;
	private Afectacion afect;
	private Cubicacion cubicacion;

	public FichaTecnica() {
		id = Auxiliary.random(8);
		vivienda = new Vivienda();
		afect = new Afectacion();
		cubicacion = new Cubicacion();
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		if (vivienda == null)
			throw new IllegalArgumentException(" La vivenda no puede tomar valor null");

		this.vivienda = vivienda;
	}

	public Afectacion getAfect() {
		return afect;
	}

	public void setAfect(Afectacion afect) {
		if (afect == null)
			throw new IllegalArgumentException(" La afectacion no puede tomar valor null");

		this.afect = afect;
	}

	public Cubicacion getCubicacion() {
		return cubicacion;
	}

	public void setCubicacion(Cubicacion cubicacion) {
		if (cubicacion == null)
			throw new IllegalArgumentException("La cubicacion no puede ser null");
		this.cubicacion = cubicacion;
	}

	@Override
	public String getID() {
		return id.intern();
	}

}

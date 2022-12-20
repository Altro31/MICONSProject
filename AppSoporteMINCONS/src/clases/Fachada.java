package clases;

import java.io.Serializable;

import enums.TipoDerrumbe;

public class Fachada extends Afectacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6296330157150703523L;
	protected String nombre;
	protected Construccion materialPredominante;
	protected TipoDerrumbe tipoDerrumbe;

	public Fachada(String nombre, Construccion materialPredominante, TipoDerrumbe tipoDerrumbe) {
		setNombre(nombre);
		setMaterialPredominante(materialPredominante);
		setTipoDerrumbe(tipoDerrumbe);

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
		if (tipoDerrumbe == null)
			throw new IllegalArgumentException(" El tipo de derrumbe no debe tomar valor null");

		this.tipoDerrumbe = tipoDerrumbe;
	}

	public TipoDerrumbe getTipoDerrumbe() {
		return tipoDerrumbe;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException("nombre es null");
		if (nombre.isEmpty())
			throw new IllegalArgumentException("nombre de contener almenos 1 caracter");
		this.nombre = nombre;
	}
}

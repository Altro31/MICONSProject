package clases;

import enums.TipoDerrumbe;
import interfaces.Identificador;

public class Fachada extends Afectacion implements Identificador{
	
	protected String id;
	protected String nombre;
	protected Construccion materialPredominante;
	protected TipoDerrumbe tipoDerrumbe;
	
	public Fachada(String id, String nombre, Construccion materialPredominante, TipoDerrumbe tipoDerrumbe) {
		setId(id);
		setNombre(nombre);
		setMaterialPredominante(materialPredominante);
		setTipoDerrumbe(tipoDerrumbe);
	
	}

	private void setId(String id) {
		if (id.length() != 8)
			throw new IllegalArgumentException("Identificador debe terner tamaño 8");
		if (!id.matches("[0-9]*"))
			throw new IllegalArgumentException("Identificador sólo puede contener numeros");
		else{
			this.id = id;
		}
		
	
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
	@Override
	public String getID() {
		return id.intern();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

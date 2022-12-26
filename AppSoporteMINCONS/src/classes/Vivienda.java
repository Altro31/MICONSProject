package classes;

import java.io.Serializable;

import classifications.Doc;
import classifications.TipoConst;
import classifications.TipoHab;
import exceptions.ValidationException;
import util.Limites;
import util.Validaciones;

public class Vivienda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 404915085198327960L;
	private String direccion;
	private String ciJefe;
	private Doc docLegal;
	private TipoHab tipoHabitacional;
	private TipoConst tipoConstructiva;
	private float largo;
	private float ancho;
	private int totalPersonas;
	private int totalInfantes;
	private int totalAncianos;
	private int totalEmbarazadas;

	public Vivienda() {
		direccion = "desconocida";
		ciJefe = "01010100000";
		docLegal = Doc.PROPIEDAD;
		tipoHabitacional = TipoHab.getTipoHab("Apartamento");
		tipoConstructiva = TipoConst.I;
		largo = Limites.dimensions();
		ancho = Limites.dimensions();
		totalPersonas = 0;
		totalInfantes = 0;
		totalAncianos = 0;
		totalEmbarazadas = 0;
	}
	
	public String getDireccion() {

		return direccion;
	}

	public void setDireccion(String direccion) throws ValidationException {
		Validaciones.direccion(direccion);
		this.direccion = direccion;
	}

	public String getCiJefe() {
		return ciJefe;
	}

	public void setCiJefe(String ciJefe) {
		Validaciones.ci(ciJefe);
		this.ciJefe = ciJefe;
	}

	public Doc getDocLegal() {
		return docLegal;
	}

	public void setDocLegal(Doc docLegal) {
		Validaciones.nullValidation(docLegal);
		this.docLegal = docLegal;
	}

	public TipoHab getTipoHabitacional() {
		return tipoHabitacional;
	}

	public void setTipoHabitacional(TipoHab tipoHabitacional) {
		Validaciones.nullValidation(tipoHabitacional);
		this.tipoHabitacional = tipoHabitacional;
	}

	public TipoConst getTipoConstructiva() {
		return tipoConstructiva;
	}

	public void setTipoConstructiva(TipoConst tipoConstructiva) {
		Validaciones.nullValidation(tipoConstructiva);
		this.tipoConstructiva = tipoConstructiva;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		Validaciones.dimensions(largo);
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		Validaciones.dimensions(largo);
		this.ancho = ancho;
	}

	public float calcularArea() {
		return largo * ancho;
	}

	public int getTotalPersonas() {
		return totalPersonas;
	}

	public void setTotalPersonas(int totalPersonas) {
		Validaciones.totalPresonas(totalPersonas, totalInfantes + totalAncianos + totalEmbarazadas);
		this.totalPersonas = totalPersonas;
	}

	public int getTotalInfantes() {
		return totalInfantes;
	}

	public void setTotalInfantes(int totalInfantes) {
		Validaciones.infantes(totalInfantes);
		this.totalInfantes = totalInfantes;
	}

	public int getTotalAncianos() {
		return totalAncianos;
	}

	public void setTotalAncianos(int totalAncianos) {
		Validaciones.ancianos(totalAncianos);
		this.totalAncianos = totalAncianos;
	}

	public int getTotalEmbarazadas() {
		return totalEmbarazadas;
	}

	public void setTotalEmbarazadas(int totalEmbarazadas) {
		Validaciones.embarazadas(totalEmbarazadas);
		this.totalEmbarazadas = totalEmbarazadas;
	}
}

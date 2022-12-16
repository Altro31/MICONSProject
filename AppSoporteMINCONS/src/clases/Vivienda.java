package clases;

import enums.*;

public class Vivienda {
	private String direccion;
	private String ciJefe;
	private Doc docLegal;
	private TipoHab tipoHabitacional;
	private TipoConst tipoConstructiva;
	private double largo;
	private double ancho;
	private double area;
	private int totalPersonas;
	private int totalInfantes;
	private int totalAncianos;
	private int totalEmbarazadas;
	
	public Vivienda() {
		direccion = "";
		ciJefe = "";
		docLegal = null;
		tipoHabitacional = null;
		tipoConstructiva = null;
		largo = 0;
		ancho = 0;
		area = 0;
		totalPersonas = 0;
		totalAncianos = 0;
		totalInfantes = 0;
		totalEmbarazadas = 0;
	}
	
	public Vivienda(String direccion, String ciJefe, Doc docLegal, TipoHab tipoHabitacional, TipoConst tipoConstructiva,
			double largo, double ancho, double area, int totalPersonas, int totalInfantes, int totalAncianos,
			int totalEmbarazadas) {
		
		this.setDireccion(direccion);
		this.setCiJefe(ciJefe);
		this.setDocLegal(docLegal);
		this.setTipoHabitacional(tipoHabitacional);
		this.setTipoConstructiva(tipoConstructiva);
		this.setLargo(largo);
		this.setAncho(ancho);
		this.setArea(area);
		this.setTotalPersonas(totalPersonas);
		this.setTotalAncianos(totalAncianos);
		this.setTotalInfantes(totalInfantes);
		this.setTotalEmbarazadas(totalEmbarazadas);
	}

	public String getDireccion() {
		
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion == null || direccion.isEmpty())
			throw new IllegalArgumentException("La direccion debe tener al menos un caracter");
		if (direccion.length() > 250)
			throw new IllegalArgumentException("La direccion  no debe sobrepasar los 250 caracteres");
		
		this.direccion = direccion;
	}

	public String getCiJefe() { 
		return ciJefe;
	}

	public void setCiJefe(String ciJefe) { //FALTA ESTE TARECO ---> MIRA A VER SI TE GUSTA ASI :).dashiell
		if (ciJefe.length() != 11 || ciJefe.trim().length() == 0 || !ciJefe.matches("[0-9]*")) {
			throw new IllegalArgumentException("Se deben introducir once numeros");  
		}
		else{
			this.ciJefe = ciJefe;
		}
		
	}

	public Doc getDocLegal() {
		return docLegal;
	}

	public void setDocLegal(Doc docLegal) {
		if (docLegal== null )
			throw new IllegalArgumentException("El documento legal debe ser de los tipos ya definidos");

		this.docLegal = docLegal;
	}

	public TipoHab getTipoHabitacional() {
		return tipoHabitacional;
	}

	public void setTipoHabitacional(TipoHab tipoHabitacional) {
		if (tipoHabitacional == null )
			throw new IllegalArgumentException("El tipo habitacional debe ser de los tipos ya definidos");

		this.tipoHabitacional = tipoHabitacional;
	}

	public TipoConst getTipoConstructiva() {
		return tipoConstructiva;
	}

	public void setTipoConstructiva(TipoConst tipoConstructiva) {
		if (tipoConstructiva == null )
			throw new IllegalArgumentException("El tipo constructivo debe ser de los tipos ya definidos");


		this.tipoConstructiva = tipoConstructiva;
	}

	public double getLargo() {
			
		return largo;
	}

	public void setLargo(double largo) {
		if(largo <= 0)
			throw new IllegalArgumentException(" El largo debe estar en el intervalo positivo"); 
		
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		if(ancho <= 0)
			throw new IllegalArgumentException(" El ancho debe estar en el intervalo positivo"); 
		
		this.ancho = ancho;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		if(area <= 0)
			throw new IllegalArgumentException(" El area debe estar en el intervalo de 0 a 2000"); 
		
		this.area = area;
	}

	public int getTotalPersonas() {
		return totalPersonas;
	}

	public void setTotalPersonas(int totalPersonas) {
		if(totalPersonas < 0)
			throw new IllegalArgumentException(" El total de personas por vivienda debe ser mayor que 0"); 
		
		this.totalPersonas = totalPersonas;
	}

	public int getTotalInfantes() {
		if(largo < 0 || largo > 200)
			throw new IllegalArgumentException(" El largo debe estar en el intervalo de 0 a 200"); 
	
		return totalInfantes;
	}

	public void setTotalInfantes(int totalInfantes) {
		if(totalInfantes < 0)
			throw new IllegalArgumentException(" El total de infantes debe mayor o igual a cero"); 
		this.totalInfantes = totalInfantes;
	}

	public int getTotalAncianos() {
		return totalAncianos;
	}

	public void setTotalAncianos(int totalAncianos) {
		if(totalAncianos < 0 || totalAncianos > getTotalPersonas())
			throw new IllegalArgumentException("El total de ancianos debe estar entre cero y el numero de personas residentes en la vivieda"); 
		
		this.totalAncianos = totalAncianos;
	}

	public int getTotalEmbarazadas() {
		return totalEmbarazadas;
	}

	public void setTotalEmbarazadas(int totalEmbarazadas) {
		if(totalEmbarazadas < 0 || totalEmbarazadas > getTotalPersonas())
			throw new IllegalArgumentException(" El total de embarazadas debe estar en el intervalo de 0 y la cantidad de personas que residen en la vivienda"); 
		
		this.totalEmbarazadas = totalEmbarazadas;
	}
}

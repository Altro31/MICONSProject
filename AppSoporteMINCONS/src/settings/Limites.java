package settings;

import java.io.Serializable;

import exceptions.ValidationException;
import util.Validaciones;

public final class Limites implements Serializable, Cloneable {

	// Serial Version UID
	private static final long serialVersionUID = 4182346057142343860L;

	// Evento
	private Integer nombreEvento;

	// Vivienda
	private Integer direccion;
	private Float dimensiones;
	private Integer infantes;
	private Integer totalPersonal;
	private Integer embarazadas;
	private Integer ancianos;

	// Material
	private Integer nombreMaterial;

	private static Limites instance = getInstance();

	private Limites() {

		nombreEvento = 40;
		direccion = 250;
		dimensiones = 5F;
		infantes = 10;
		totalPersonal = 20;
		embarazadas = null;
		ancianos = null;
		nombreMaterial = 20;

	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public static Limites getInstance() {
		if (instance == null)
			instance = new Limites();
		return instance;
	}

	public static void update(Limites instance) throws ValidationException {

		Validaciones.nullValidation(instance);

		Limites.instance = instance;
	}

	public static void restoreDefaultValues() {
		instance = new Limites();
	}

	public static Integer nombreEvento() {
		return instance.nombreEvento;
	}

	public void setNombreEvento(int nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public static Integer direccion() {
		return instance.direccion;
	}

	public void setDireccion(int direccion) {
		instance.direccion = direccion;
	}

	public static Float dimensions() {
		return instance.dimensiones;
	}

	public void setDimensiones(float dimensions) {
		instance.dimensiones = dimensions;
	}

	public static Integer infantes() {
		return instance.infantes;
	}

	public void setInfantes(Integer infantes) {
		this.infantes = infantes;
	}

	public static Integer totalPersonal() {
		return instance.totalPersonal;
	}

	public void setTotalPersonas(Integer totalPersonal) {
		this.totalPersonal = totalPersonal;
	}

	public static Integer embarazadas() {
		return instance.embarazadas;
	}

	public void setEmbarazadas(Integer embarazadas) {
		this.embarazadas = embarazadas;
	}

	public static Integer ancianos() {
		return instance.ancianos;
	}

	public void setAncianos(Integer ancianos) {
		this.ancianos = ancianos;
	}

	public static Integer nombreMaterial() {
		return instance.nombreMaterial;
	}

	public void setNombreMaterial(Integer nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public Integer getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(Integer nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public Integer getDireccion() {
		return direccion;
	}

	public void setDireccion(Integer direccion) {
		this.direccion = direccion;
	}

	public Float getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(Float dimensiones) {
		this.dimensiones = dimensiones;
	}

	public Integer getInfantes() {
		return infantes;
	}

	public Integer getTotalPersonal() {
		return totalPersonal;
	}

	public Integer getEmbarazadas() {
		return embarazadas;
	}

	public Integer getAncianos() {
		return ancianos;
	}

	public Integer getNombreMaterial() {
		return nombreMaterial;
	}

}

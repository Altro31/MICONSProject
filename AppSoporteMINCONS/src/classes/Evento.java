package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import classifications.TipoEvento;
import util.Validaciones;

public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3567095338747536417L;
	private ArrayList<FichaTecnica> listaFichasTecnicas;
	private String nombre;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private TipoEvento tipoEvento;

	public Evento() {
		listaFichasTecnicas = new ArrayList<FichaTecnica>();
	}

	public Evento(String nombre, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, TipoEvento tipoEvento) {
		this();

		setFechaFin(fechaFin);
		setFechaInicio(fechaInicio);
		setNombre(nombre);
		setTipoEvento(tipoEvento);
	}

	public void addFichaTecnica(FichaTecnica ficha) {
		FichaTecnica fichaTecnica = getFicha(ficha.getID());
		if (fichaTecnica != null) {
			listaFichasTecnicas.set(listaFichasTecnicas.indexOf(fichaTecnica), ficha);
		} else {
			listaFichasTecnicas.add(ficha);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) { // validacion
		Validaciones.nombreEvento(nombre);
		this.nombre = nombre;

	}

	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		Validaciones.tipoEvento(tipoEvento);
		this.tipoEvento = tipoEvento;
	}

	public ArrayList<FichaTecnica> getListaFichasTecnicas() {
		return listaFichasTecnicas;
	}

	public void eliminarFichaTecnica(int pos) {
		if (pos < 0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaFichasTecnicas.remove(pos);
	}

	public FichaTecnica getFicha(String id) {
		FichaTecnica ficha = null;
		for (FichaTecnica fichaTecnica : listaFichasTecnicas) {
			if (fichaTecnica.getID().equals(id)) {
				ficha = fichaTecnica;
			}
		}

		return ficha;
	}

}

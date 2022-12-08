package clases;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Evento {
	
	private ArrayList<FichaTecnica> listaFichasTecnicas;
	private String nombre;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private enums.Evento tipoEvento;
	
	public Evento() {
		listaFichasTecnicas = new ArrayList<FichaTecnica>();
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
		listaFichasTecnicas.add(new FichaTecnica());
	}
	
	public Evento(String nombre, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, enums.Evento tipoEvento) {
		this();
		
		setFechaFin(fechaFin);
		setFechaInicio(fechaInicio);
		setNombre(nombre);
		setTipoEvento(tipoEvento);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
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
	public enums.Evento getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(enums.Evento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	
	public ArrayList<FichaTecnica> getListaFichasTecnicas() {
		return listaFichasTecnicas;
	}
	public void addFichaTecnica(FichaTecnica ficha) {
		if(ficha==null)
			throw new IllegalArgumentException("La ficha tiene valor null");
		listaFichasTecnicas.add(ficha);
	}
	public void eliminarFichaTecnica(int pos) {
		if(pos<0)
			throw new IllegalArgumentException("Pos debe tener valor negativo");
		listaFichasTecnicas.remove(pos);
	}
	
}

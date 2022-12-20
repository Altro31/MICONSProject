package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.table.DefaultTableModel;

import clases.Evento;
import clases.FichaTecnica;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class FichaTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515650816743836254L;

	private Class[] columnTypes = new Class[] { String.class, String.class, String.class };

	public FichaTableModel() {
		super(new Object[][] {}, new String[] { "#", "Direcci\u00F3n", "Fecha del Levantamiento" });
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	boolean[] columnEditables = new boolean[] { false, false, false };

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public void actualizar() {
		actualizar(((Evento) Frame.getPosicionActual()[1]).getListaFichasTecnicas());
	}

	public void actualizar(ArrayList<?> lista) {

		int index = 1;
		GregorianCalendar fecha = new GregorianCalendar();

		limpiar();

		for (Object ficha : lista) {
			addRow(new Object[] { index + "", ((FichaTecnica) ficha).getVivienda().getDireccion(),
					fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR) });
			index++;
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<FichaTecnica> lista = ((Evento) Frame.getPosicionActual()[1]).getListaFichasTecnicas();
		actualizar();
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

}

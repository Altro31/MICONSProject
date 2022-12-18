package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Evento;
import clases.FichaTecnica;
import interfaces.Actualizable;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class FichaTableModel extends DefaultTableModel implements Actualizable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515650816743836254L;

	private Class[] columnTypes = new Class[] { Boolean.class, String.class, String.class, String.class };

	public FichaTableModel() {
		super(new Object[][] {}, new String[] { "", "#", "Direcci\u00F3n", "Fecha del Levantamiento" });
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	boolean[] columnEditables = new boolean[] { true, false, false, false };

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	@Override
	public <T> void actualizar(ArrayList<T> lista) {
		int index = 1;
		limpiar();
		for (T ficha : lista) {
			addRow(new Object[] { null, index + "", ((FichaTecnica)ficha).getVivienda().getDireccion(), "" });
			index++;
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<FichaTecnica> lista = ((Evento) Frame.getPosicionActual()[1]).getListaFichasTecnicas();
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

}

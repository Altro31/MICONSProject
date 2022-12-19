package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Afectacion;
import clases.Techo;
import interfaces.Actualizable;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TechoTableModel extends DefaultTableModel implements Actualizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515650816743836254L;

	Class[] columnTypes = new Class[] { String.class, String.class, String.class };
	boolean[] columnEditables = new boolean[] { false, false, false };

	public TechoTableModel() {
		super(new Object[][] {}, new String[] { "#", "Identificador", "Tipo de Derrumbe" });
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	@Override
	public <T> void actualizar(ArrayList<T> lista) {
		int index = 1;
		limpiar();
		for (T techo : lista) {
			addRow(new Object[] { index + "", ((Techo) techo).getID(), ((Techo) techo).getTipoDerrumbe().name() });
			index++;
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<Techo> lista = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaTechos();
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

}

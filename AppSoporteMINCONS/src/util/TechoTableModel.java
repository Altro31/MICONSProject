package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import classes.FichaTecnica;
import classes.Techo;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TechoTableModel extends DefaultTableModel {

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

	public void actualizar() {
		actualizar(((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaTechos());
	}

	public void actualizar(ArrayList<?> lista) {
		int index = 1;
		limpiar();
		for (Object techo : lista) {
			addRow(new Object[] { index + "", ((Techo) techo).getNombre(), ((Techo) techo).getTipoDerrumbe().name() });
			index++;
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<Techo> lista = ((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaTechos();
		actualizar();
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

}

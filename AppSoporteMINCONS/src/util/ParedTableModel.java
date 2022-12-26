package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import classes.FichaTecnica;
import classes.Pared;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ParedTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515650816743836254L;

	private Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };
	boolean[] columnEditables = new boolean[] { false, false, false, false };

	public ParedTableModel() {
		super(new Object[][] {}, new String[] { "#", "Identificador", "Tipo de Derrumbe", "Pared de Carga" });
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
		actualizar(((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaParedes());
	}

	public void actualizar(ArrayList<?> lista) {
		int index = 1;
		limpiar();
		for (Object pared : lista) {
			addRow(new Object[] { index + "", ((Pared) pared).getNombre(), ((Pared) pared).getTipoDerrumbe().toString(),
					((Pared) pared).isEsParedCarga() ? "Si" : "No" });
			index++;
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<Pared> lista = ((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaParedes();
		actualizar();
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

}

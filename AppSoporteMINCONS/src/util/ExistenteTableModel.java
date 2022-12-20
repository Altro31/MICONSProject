package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Construccion;
import clases.Material;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ExistenteTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788875947825565334L;
	boolean[] columnEditables = new boolean[] { false, false };
	Class[] columnTypes = new Class[] { String.class, Float.class };

	public ExistenteTableModel() {
		super(new Object[][] {}, new String[] { "Nombre", "Precio Unitario" });
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public void actualizar(ArrayList<Construccion> lista) {
		limpiar();
		for (Material material : lista) {
			addRow(new Object[] { material.getNombre(), material.getPrecioUnitario() });
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

}

package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import classes.Material;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AsignarTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6826581361263243490L;
	Class[] columnTypes = new Class[] { String.class, Float.class, Integer.class };
	boolean[] columnEditables = new boolean[] { false, false, false };

	public AsignarTableModel() {
		super(new Object[][] {}, new String[] { "Nombre", "Precio Unitario", "Cantidad" });
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public void actualizar(ArrayList<Material> lista) {
		limpiar();
		for (Material material : lista) {
			addRow(new Object[] { material.getNombre(), material.getPrecioUnitario(), material.getCantidad() });
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

}

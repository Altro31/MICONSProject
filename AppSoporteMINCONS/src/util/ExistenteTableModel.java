package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Material;

public class ExistenteTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788875947825565334L;

	public ExistenteTableModel() {
		super(new Object[][] {}, new String[] { "Nombre", "Precio Unitario" });
	}

	Class[] columnTypes = new Class[] { String.class, Float.class };

	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public void actualizar(ArrayList<Material> lista) {
		limpiar();
		for (Material material : lista) {
			addRow(new Object[] { material.getNombre(), material.getPrecioUnitario() });
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

}

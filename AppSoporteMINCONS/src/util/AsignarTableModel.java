package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Material;

public class AsignarTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6826581361263243490L;
	
	public AsignarTableModel() {
		super(new Object[][] {}, new String[] { "Nombre", "Precio Unitario", "Cantidad" });
	}

	Class[] columnTypes = new Class[] { String.class, Float.class, Integer.class };

	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public void actualizar(ArrayList<Material> lista) {
		limpiar();
		for (Material material : lista) {
			addRow(new Object[] { material.getNombre(), material.getPrecioUnitario(), material.getCantidad()});
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

}

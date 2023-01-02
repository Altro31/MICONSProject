package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import classes.Construccion;
import classes.FichaTecnica;
import classes.Material;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MatSettingTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853621716070275671L;
	Class[] columnTypes = new Class[] { String.class, String.class, Float.class, String.class };
	boolean[] columnEditables = new boolean[] { false, false, false, false };

	public MatSettingTableModel() {
		super(new Object[][] {}, new String[] { "ID", "Nombre", "Precio Unitario", "Unidad de Medida" });
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<Material> lista = new ArrayList<Material>(
				((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaInmuebles());
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

	public void actualizar(ArrayList<Material> lista) {
		limpiar();
		for (Material material : lista) {
			addRow(new Object[] { material.getID(), material.getNombre(), material.getPrecioUnitario(),
					material instanceof Construccion ? ((Construccion) material).getUnidadMedida() : "" });
		}

	}

}

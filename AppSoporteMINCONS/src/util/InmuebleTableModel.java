package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import classes.FichaTecnica;
import classes.Inmueble;
import classes.Material;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class InmuebleTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853621716070275671L;
	Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };
	boolean[] columnEditables = new boolean[] { false, false, false, false };

	public InmuebleTableModel() {
		super(new Object[][] {}, new String[] { "#", "ID", "Nombre", "Cantidad" });
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
		ArrayList<Inmueble> lista = ((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaInmuebles();
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

	public void actualizar() {
		actualizar(((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaInmuebles());
	}

	public void actualizar(ArrayList<?> lista) {
		int index = 1;
		limpiar();
		for (Object inmueble : lista) {
			addRow(new Object[] { "" + index++, ((Material) inmueble).getID(), ((Material) inmueble).getNombre(),
					((Material) inmueble).getCantidad() });
		}

	}

}

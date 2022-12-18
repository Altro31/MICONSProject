package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Afectacion;
import clases.Inmueble;
import interfaces.Actualizable;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class InmuebleTableModel extends DefaultTableModel implements Actualizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853621716070275671L;
	Class[] columnTypes = new Class[] { Boolean.class, String.class, String.class, String.class, String.class };
	boolean[] columnEditables = new boolean[] { true, false, false, false, false };

	public InmuebleTableModel() {
		super(new Object[][] {}, new String[] { "", "#", "ID", "Nombre", "Cantidad" });
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
		ArrayList<Inmueble> lista = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaInmuebles();
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

	@Override
	public <T> void actualizar(ArrayList<T> lista) {
		int index = 1;
		limpiar();
		for (T inmueble : lista) {
			addRow(new Object[] { false, "" + index++, ((Inmueble)inmueble).getID(), ((Inmueble)inmueble).getNombre(),
					((Inmueble)inmueble).getCantidad() });
		}
		
	}

}

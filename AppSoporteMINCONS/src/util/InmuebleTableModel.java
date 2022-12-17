package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Afectacion;
import clases.Inmueble;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class InmuebleTableModel extends DefaultTableModel {

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

	public void actualizar(ArrayList<Inmueble> lista) {
		int index = 1;
		limpiar();
		for (Inmueble inmueble : lista) {
			addRow(new Object[] { false, "" + index++, inmueble.getID(), inmueble.getNombre(),
					inmueble.getCantidad() });
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<Inmueble> lista = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaInmuebles();
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

	public void borrarSeleccion() {
		Afectacion afectacion = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]);
		ArrayList<Inmueble> lista = new ArrayList<Inmueble>(afectacion.getListaInmuebles());
		Auxiliary.borrarSeleccion(this, lista, 0, 1);
		int i = 0;
		int size = afectacion.getListaInmuebles().size();
		while (i < size) {
			Inmueble inmueble = afectacion.getListaInmuebles().get(i);
			if (!lista.contains(inmueble)) {
				afectacion.eliminarInmueble(i);
				size--;
			} else {
				i++;
			}
		}
		actualizar(lista);
	}
}

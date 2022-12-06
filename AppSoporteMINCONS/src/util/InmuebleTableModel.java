package util;

import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Afectacion;
import clases.Inmueble;

public class InmuebleTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853621716070275671L;
	Class[] columnTypes = new Class[] { Boolean.class, Object.class, Object.class, Object.class, Object.class };
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
			addRow(new Object[] {false, ""+index++, inmueble.getIdentificador(), inmueble.getNombre(), inmueble.getCantidad()});
		}
	}
	
	public void limpiar() {
		Auxiliary.limpiar(this);
	}
	
	public void filtrar(JTextField txtField, int column) {
		ArrayList<Inmueble> lista = ((Afectacion)Ruta.getPosicionActual()[1]).getListaInmuebles();
		actualizar(lista);
		Auxiliary.filtro(txtField, this, column, lista.size());
		
	}
	
	public void borrarSeleccion() {
		Afectacion afectacion = ((Afectacion)Ruta.getPosicionActual()[1]);
		ArrayList<Inmueble> lista = new ArrayList<Inmueble>(afectacion.getListaInmuebles());
		Auxiliary.borrarSeleccion(this, lista, 0, 1);
		for (int i=0, size=afectacion.getListaInmuebles().size(); i<size; i++) {
			Inmueble ficha = afectacion.getListaInmuebles().get(i);
			if (!lista.contains(ficha)) {
				afectacion.eliminarInmueble(i);
				size--;
			}
		}
		actualizar(lista);
	}
}

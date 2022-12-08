package util;

import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Afectacion;
import clases.Inmueble;
import clases.Pared;
import enums.TipoDerrumbe;

public class ParedTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515650816743836254L;

	private Class[] columnTypes = new Class[] { Boolean.class, Object.class, Object.class, Object.class, Object.class};
	boolean[] columnEditables = new boolean[] { true, false, false, false, false };

	public ParedTableModel() {
		super(new Object[][] {}, new String[] { "", "#", "Identificador", "Tipo de Derrumbe", "Pared de Carga"});
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public void actualizar(ArrayList<Pared> lista) {
		int index = 1;
		limpiar();
		for (Pared pared : lista) {
			addRow(new Object[] {null, index+"", pared.getIdentificador(), pared.getTipoDerrumbe().toString(), pared.isEsParedCarga()? "Si" : "No"});
			index++;
		}
	}
	
	public void limpiar() {
		Auxiliary.limpiar(this);
	}
	
	public void filtrar(JTextField txtField, int column) {
		ArrayList<Pared> lista = ((Afectacion)Ruta.getPosicionActual()[1]).getListaParedes();
		actualizar(lista);
		Auxiliary.filtro(txtField, this, column, lista.size());
		
	}
	
	public void borrarSeleccion() {
		Afectacion afectacion = ((Afectacion)Ruta.getPosicionActual()[1]);
		ArrayList<Pared> lista = new ArrayList<Pared>(afectacion.getListaParedes());
		Auxiliary.borrarSeleccion(this, lista, 0, 1);
		for (int i=0, size=afectacion.getListaParedes().size(); i<size; i++) {
			Pared ficha = afectacion.getListaParedes().get(i);
			if (!lista.contains(ficha)) {
				afectacion.eliminarPared(i);
				size--;
			}
		}
		actualizar(lista);
	}

}

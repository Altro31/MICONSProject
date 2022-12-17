package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Afectacion;
import clases.Pared;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ParedTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515650816743836254L;

	private Class[] columnTypes = new Class[] { Boolean.class, String.class, String.class, String.class, String.class };
	boolean[] columnEditables = new boolean[] { true, false, false, false, false };

	public ParedTableModel() {
		super(new Object[][] {}, new String[] { "", "#", "Identificador", "Tipo de Derrumbe", "Pared de Carga" });
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
			addRow(new Object[] { null, index + "", pared.getID(), pared.getTipoDerrumbe().toString(),
					pared.isEsParedCarga() ? "Si" : "No" });
			index++;
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<Pared> lista = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaParedes();
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

	public void borrarSeleccion() {
		Afectacion afectacion = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]);
		ArrayList<Pared> lista = new ArrayList<Pared>(afectacion.getListaParedes());
		Auxiliary.borrarSeleccion(this, lista, 0, 1);
		int i = 0;
		int size = afectacion.getListaParedes().size();
		while (i < size) {
			Pared pared = afectacion.getListaParedes().get(i);
			if (!lista.contains(pared)) {
				afectacion.eliminarPared(i);
				size--;
			} else {
				i++;
			}
		}
		actualizar(lista);
	}

}

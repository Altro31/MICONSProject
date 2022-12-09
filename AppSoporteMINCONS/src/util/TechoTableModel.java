package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Afectacion;
import clases.Techo;
import enums.TipoDerrumbe;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TechoTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515650816743836254L;

	@SuppressWarnings("rawtypes")
	Class[] columnTypes = new Class[] { Boolean.class, Integer.class, String.class, String.class };
	boolean[] columnEditables = new boolean[] { true, false, false, false };

	public TechoTableModel() {
		super(new Object[][] {}, new String[] { "", "#", "Identificador", "Tipo de Derrumbe" });
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public void actualizar(ArrayList<Techo> lista) {
		int index = 1;
		limpiar();
		for (Techo techo : lista) {
			addRow(new Object[] { false, index + "", techo.getIdentificador(), techo.getTipoDerrumbe().name()});
			index++;
		}
	}

	public void limpiar() {
		Auxiliary.limpiar(this);
	}

	public void filtrar(String textFilter, int column) {
		ArrayList<Techo> lista = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaTechos();
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

	public void borrarSeleccion() {
		Afectacion afectacion = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]);
		ArrayList<Techo> lista = new ArrayList<Techo>(afectacion.getListaTechos());
		Auxiliary.borrarSeleccion(this, lista, 0, 1);
		for (int i = 0, size = afectacion.getListaTechos().size(); i < size; i++) {
			Techo techo = afectacion.getListaTechos().get(i);
			if (!lista.contains(techo)) {
				afectacion.eliminarPared(i);
				size--;
			}
		}
		actualizar(lista);
	}

}
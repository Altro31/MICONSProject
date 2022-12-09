package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clases.Evento;
import clases.FichaTecnica;
import visual.Frame;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class FichaTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515650816743836254L;

	private Class[] columnTypes = new Class[] { Boolean.class, Object.class, Object.class, Object.class };

	public FichaTableModel() {
		super(new Object[][] {}, new String[] { "", "#", "Direcci\u00F3n", "Fecha del Levantamiento" });
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	boolean[] columnEditables = new boolean[] { true, false, false, false };

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public void actualizar(ArrayList<FichaTecnica> lista) {
		int index = 1;
		limpiar();
		for (FichaTecnica ficha : lista) {
			addRow(new Object[] {null, index+"", "", ""});
			index++;
		}
	}
	
	public void limpiar() {
		Auxiliary.limpiar(this);
	}
	
	public void filtrar(String textFilter, int column) {
		ArrayList<FichaTecnica> lista = ((Evento)Frame.getPosicionActual()[1]).getListaFichasTecnicas();
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());
		
	}
	
	public void borrarSeleccion() {
		
		Evento evento = ((Evento)Frame.getPosicionActual()[1]);
		ArrayList<FichaTecnica> lista = new ArrayList<FichaTecnica>(evento.getListaFichasTecnicas());
		Auxiliary.borrarSeleccion(this, lista, 0, 1);
		for (int i=0, size=evento.getListaFichasTecnicas().size(); i<size; i++) {
			FichaTecnica ficha = evento.getListaFichasTecnicas().get(i);
			if (!lista.contains(ficha)) {
				evento.eliminarFichaTecnica(i);
				size--;
			}
		}
		actualizar(lista);
	}

}

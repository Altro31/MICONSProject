package util;

import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.FichaTecnica;

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
		for (FichaTecnica fichaTecnica : lista) {
			addRow(new Object[] {null, index+"", fichaTecnica.getCubicacion()+"", ""});
			index++;
		}
	}
	
	public void limpiar() {
		Auxiliary.limpiar(this);
	}
	
	public void filtrar(JTextField txtField, int column, ArrayList<FichaTecnica> listaFicha) {
		actualizar(listaFicha);
		Auxiliary.filtro(txtField, this, column, listaFicha.size());
		
	}
	
	public void borrarSeleccion(ArrayList<FichaTecnica> lista) {
		Auxiliary.borrarSeleccion(this, lista, 0, 1);
		actualizar(lista);
	}

}

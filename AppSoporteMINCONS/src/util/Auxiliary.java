package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

//Modificador final para que no se pueda heredar de esta clase
@SuppressWarnings({"rawtypes", "unchecked"})
public final class Auxiliary {

	// Constructor privado para que no se pueda instanciar la Clase
	private Auxiliary() {
	}

	/**
	 * Limpia los datos de una tabla
	 * 
	 * @param tableModel TableModel de la tabla
	 */
	public static void limpiar(DefaultTableModel tableModel) {
		int count = tableModel.getRowCount();
		for (int i = 0; i < count; i++) {
			tableModel.removeRow(0);
		}
	}
	
	//Calcular Area
	public static float calcularArea(float largo, float ancho) {
		if (largo<=0) {
			throw new IllegalArgumentException("largo debe ser mayor que 0");
		}
		if (largo<=0) {
			throw new IllegalArgumentException("ancho debe ser mayor que 0");
		}
		return largo*ancho;
	}

	/**
	 * Filtra los datos de una Tabla
	 * 
	 * Actualizar la tabla antes cada vez que se valla a usar éste método
	 * 
	 * @param txtField   De donde se extrae el texto a Filtrar
	 * @param tableModel TableModel de la Tabla
	 * @param column     columna que se va a filtrar
	 * @param arrayLimit tamaño de la lista con la cual se actualiza la tabla
	 */
	public static void filtro(String filterText, DefaultTableModel tableModel, int column, int arrayLimit) {
		Vector<Object> vectorObjectDuplicado = new Vector<Object>(tableModel.getDataVector());
		// Da una lista duplicada
		List<Object> listaObject = vectorObjectDuplicado.subList(0, arrayLimit);
		// Arregla la lista duplicada
		List<Object> subList = new ArrayList<Object>();
		// Filtra los datos
		for (Object vector : listaObject) {
			String field = (String) ((Vector)vector).get(column);
			if (field.toLowerCase().contains(filterText.toLowerCase())) {
				subList.add(vector);
			}
		}
		limpiar(tableModel);
		// Muestra en la tabla los datos filtrados
		if (!subList.isEmpty()) {
			for (Object object : subList) {
				Vector v = (Vector) object;
				ArrayList<Object> lista = new ArrayList<Object>();
				for (int j = 0; j < v.size(); j++) {
					lista.add(v.get(j));
				}
				tableModel.addRow(lista.toArray());
			}
		}
	}

	// Comprueba si un checkbox de una tabla está seleccionado
	public static boolean isSelected(int fila, int columna, DefaultTableModel tableModel) {
		return tableModel.getValueAt(fila, columna) != null
				&& ((Boolean) tableModel.getValueAt(fila, columna)).booleanValue();
	}
	
	// Comprueba si un checkBox de una tabla está 
	public static ArrayList<Object> getSelected(DefaultTableModel tableModel, int column) {
		ArrayList<Object> lista = new ArrayList<Object>();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (isSelected(i, column, tableModel)) {
				Object[] lista2 = new Object[tableModel.getColumnCount()];
				for (int j = 0; j < tableModel.getColumnCount(); j++) {
					lista2[j] = tableModel.getValueAt(i, j);
				}
				lista.add(lista2);
			}
		}
		return lista;
	}
	
	//Selecciona todos los checkBox de una tabla
	public static void selectAll(DefaultTableModel tableModel, JCheckBox checkBox, int column) {
		if(tableModel.getRowCount()>0) {
			for(int i = 0; i < tableModel.getRowCount(); i++) {
				tableModel.setValueAt(checkBox.isSelected(), i, column);
			}
		}
	}

	public static <E> void borrarSeleccion(DefaultTableModel tableModel, ArrayList<E> listaFichas, int columnSelection,
			final int columnNumeracion) {
		ArrayList<Object> selected = getSelected(tableModel, columnSelection);
		if (!selected.isEmpty()) {
			ArrayList<Object> lista2 = new ArrayList<Object>();
			for (Object object : selected) {
				int fila = Integer.parseInt(((Object[]) object)[columnNumeracion].toString()) - 1;
				lista2.add(listaFichas.get(fila));
			}
			listaFichas.removeAll(lista2);
		}

	}
	
	/**
	 * Genera un String de tamaño size con numero aleatorios enteros
	 * @param size Tamaño que se desea
	 * @throws IllegalArgumentException
	 * @deprecated Use {@link #random(int)} instead
	 */
	public static String randomInt(int size) throws IllegalArgumentException {
		return random(size);
	}

	/**
	 * Genera un String de tamaño size con numero aleatorios enteros
	 * @param size Tamaño que se desea
	 * @throws IllegalArgumentException
	 */
	public static String random(int size) throws IllegalArgumentException {
		StringBuilder code = new StringBuilder();
		if (size>0) {
			Random random = new Random();
			for (int i = 0; i < size; i++) {
				code.append(random.nextInt(10));
			}
		}
		return code.toString();
	}
}

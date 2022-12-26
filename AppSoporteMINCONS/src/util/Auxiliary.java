package util;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({ "rawtypes", "unchecked" })
public final class Auxiliary {

	public static final DefaultTableCellRenderer CellRenderCenter = getCellRenderCenter();
	private static final Random RAND = new Random();

	private Auxiliary() {
	}

	private static DefaultTableCellRenderer getCellRenderCenter() {
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(SwingConstants.CENTER);
		return cellRender;
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

	/**
	 * Calcular Area
	 */
	public static float calcularArea(float largo, float ancho) {
		if (largo <= 0) {
			throw new IllegalArgumentException("largo debe ser mayor que 0");
		}
		if (largo <= 0) {
			throw new IllegalArgumentException("ancho debe ser mayor que 0");
		}
		return largo * ancho;
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
		Vector<Vector> vectorObjectDuplicado = new Vector<Vector>(tableModel.getDataVector());
		// Da una lista duplicada
		List<Vector> listaObject = vectorObjectDuplicado.subList(0, arrayLimit);
		// Arregla la lista duplicada
		List<Vector<Object>> subList = new ArrayList<Vector<Object>>();
		// Filtra los datos
		for (Vector<Object> vector : listaObject) {
			String field = vector.get(column).toString();
			if (field.toLowerCase().contains(filterText.toLowerCase())) {
				subList.add(vector);
			}
		}
		limpiar(tableModel);
		// Muestra en la tabla los datos filtrados
		if (!subList.isEmpty()) {
			for (Vector<Object> object : subList) {
				Vector<Object> v = object;
				ArrayList<Object> lista = new ArrayList<Object>();
				for (int j = 0; j < v.size(); j++) {
					lista.add(v.get(j));
				}
				tableModel.addRow(lista.toArray());
			}
		}
	}

	/**
	 * Comprueba si un checkbox de una tabla está seleccionado
	 * 
	 * @param tableModel TableModel de la Tabla
	 */
	public static boolean isSelected(int fila, int columna, DefaultTableModel tableModel) {
		return tableModel.getValueAt(fila, columna) != null
				&& ((Boolean) tableModel.getValueAt(fila, columna)).booleanValue();
	}

	/**
	 * 
	 * @param tableModel TableModel de la Tabla
	 * @param column     columna que contiene los checkboxs
	 * @return Las filas marcadas
	 */
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

	/**
	 * Selecciona todos los checkBox de una tabla
	 * 
	 * @param tableModel TableModel de la Tabla
	 * @param checkBox   CheckBox principal
	 * @param column     columna que contiene los checkboxs
	 */
	public static void selectAll(DefaultTableModel tableModel, JCheckBox checkBox, int column) {
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				tableModel.setValueAt(checkBox.isSelected(), i, column);
			}
		}
	}

	public static void borrarSeleccion(JTable table, ArrayList<?> lista) {

		ArrayList<Object> lista2 = new ArrayList<Object>();
		if (table != null && lista != null) {
			for (int i : table.getSelectedRows()) {
				lista2.add(lista.get(Integer.parseInt(table.getValueAt(i, 0).toString()) - 1));
			}
			lista.removeAll(lista2);
		}
	}

	/**
	 * Genera un String de tamaño size con numero aleatorios enteros
	 * 
	 * @param size Tamaño que se desea
	 * @throws IllegalArgumentException
	 */
	public static String random(int size) throws IllegalArgumentException {
		StringBuilder code = new StringBuilder();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				code.append(RAND.nextInt(10));
			}
		}
		return code.toString();
	}

	/**
	 * Activa el botón Borrar cuando hay una o más filas seleccionadas en la tabla
	 */
	public static void activarBotonBorrar(final JButton borrar, final JTable table) {
		if (borrar != null && table != null) {

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					boolean check = false;
					if (table.getSelectedRowCount() > 0) {
						check = true;
					}
					borrar.setEnabled(check);
				}

			});
		}
	}

	/**
	 * Activa el botón Editar cuando hay solo una fila seleccionada en la tabla
	 */
	public static void activarBotonEditar(final JButton editar, final JTable table) {
		if (editar != null && table != null) {
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					boolean check = false;
					if (table.getSelectedRowCount() == 1) {
						check = true;
					}
					editar.setEnabled(check);
				}

			});
		}
	}

	/**
	 * Centra las columnas de una tabla
	 * 
	 * @param listaColumnas Lista de los números de las columnas que van a ser
	 *                      centradas
	 */
	public static void centrarColumnas(JTable table, int[] listaColumnas) {
		for (int i : listaColumnas) {
			table.getColumnModel().getColumn(i).setCellRenderer(CellRenderCenter);
		}
	}

	public static void quitarReordenamientoTabla(JTable table) {
		table.getTableHeader().setReorderingAllowed(false);
	}

	// Validations for JTextFields
	////////////////////////////////////////////////////////////////

	// unable to enter data
	public static void noData(final JTextField c) {
		// Oculta el cursor
		c.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				c.getCaret().setVisible(false);
			}
		});

		// unable to enter data manually
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
			}
		});
	}

	// Only Letters
	public static void onlyLetters(final JTextField c, final boolean espacios) {
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();

				// Sólo letras y espacios
				if (!(Character.isLetter(c) || (espacios && c == KeyEvent.VK_SPACE))) {
					e.consume();
				}
			}
		});
	}

	// Only numbers
	public static void onlyNumbers(final JTextField t, final boolean decimal) {
		t.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String string = t.getText();
				Character c = e.getKeyChar();

				boolean isDigit = Character.isDigit(c);
				boolean isDot = c == KeyEvent.VK_PERIOD;

				// Check if the JTextField has a dot
				boolean haveDot = false;
				for (char ch : string.toCharArray()) // to find a dot
					if (ch == KeyEvent.VK_PERIOD)
						haveDot = true;

				if (decimal) {
					// Consumes if the first character is a dot
					if (string.isEmpty() && isDot) {
						e.consume();
					}

					// If the only character in the JTextField is a 0 and is inserted a number,
					// clean the JTextField
					if (string.length() == 1 && string.charAt(0) == KeyEvent.VK_0 && isDigit) {
						t.setText("");

					}
				}

				// Consumes if is inserted anything that is not a number or a dot
				// In the case that is a dot, decimal must be True
				if (!(isDigit || (decimal && isDot && !haveDot))) {
					e.consume();

				}
			}

			// Small fix, because if the text is selected, copied and overwrited imself,
			// codes can be break
			@Override
			public void keyReleased(KeyEvent e) {
				if (decimal) {
					String string = t.getText();
					// If overwritted imself with a dot and is the first characted, it's deleted
					if (string.length() > 0 && string.charAt(0) == KeyEvent.VK_PERIOD) {
						string = string.substring(1);
						t.setText(string);
					}
				}

			}
		});
	}

	// Only Letters and Spaces and Numbers
	public static void onlyLettersAndNumbers(final JTextField c, final boolean espacios) {
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();

				if (!(Character.isLetter(c) || (espacios && c == KeyEvent.VK_SPACE) || Character.isDigit(c))) {
					e.consume();
				}
			}
		});
	}

	// Set a limit to how character can be typed on this JTextField
	public static void limite(final JTextField t, final int limit) {
		t.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (t.getText().length() >= limit) {
					e.consume();
				}
			}
		});
		t.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (t.getText().length() > limit)
					t.setText(t.getText().substring(0, limit));
			}
		});
	}

	// Validations for JSpinners
	////////////////////////////////////////////////////////////////

	/**
	 * The listener spinner change its value according to the triggering spinner
	 * 
	 * @param trigger  JSpinner que desencadena la acción
	 * @param listener JSpinner que cambia en consecuencia de la accion
	 * @param check    Variable que controla el último valor del JSpinner accionador
	 */

	public static void linkSpinners(final JSpinner trigger, final JSpinner listener, final Value check) {
		trigger.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				final int value = (int) trigger.getValue();
				if (trigger.getPreviousValue() != null) {
					if (check.val > value)
						listener.setValue((int) listener.getValue() - 1);
					else
						listener.setValue((int) listener.getValue() + 1);
				} else {
					listener.setValue((int) listener.getValue() - 1);
				}
				check.val = value;
			}
		});
	}
}

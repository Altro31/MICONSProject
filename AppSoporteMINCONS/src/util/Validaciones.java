package util;

// Validaciones
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Modificador final para que no se pueda heredar de esta clase
public final class Validaciones {

	// Constructor privado para que no se pueda instanciar la Clase
	private Validaciones() {
	}

	// Validaciones para JTextFields
	////////////////////////////////////////////////////////////////

	// No se pueden introducir datos
	public static void noDatos(final JTextField c) {
		// Oculta el cursor
		c.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				c.getCaret().setVisible(false);
			}
		});

		// Evita la introducción manual de datos
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
			}
		});
	}

	// Sólo se pueden introducir letras
	public static void soloLetras(final JTextField c, final boolean espacios) {
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

	public static void soloNumeros(final JTextField t, final boolean decimal) {
		t.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String string = t.getText();
				Character c = e.getKeyChar();

				boolean isDigit = Character.isDigit(c);
				boolean isDot = c == KeyEvent.VK_PERIOD;

				// Comprueba si el textField tiene un punto
				boolean haveDot = false;
				for (char ch : string.toCharArray()) // para buscar q existe un punto
					if (ch == KeyEvent.VK_PERIOD)
						haveDot = true;

				if (decimal) {
					// Consume si lo primero que se introduce es un punto
					if (string.isEmpty() && isDot) {
						e.consume();
					}

					// Si el único caracter en el textField es un 0, y se inserta un número, borra
					// el textField
					if (string.length() == 1 && string.charAt(0) == KeyEvent.VK_0 && isDigit) {
						t.setText("");

					}
				}

				// Consume si se introduce algo que no sea un número o un punto
				// En el caso del punto, decimal debe ser true
				if (!(isDigit || (decimal && isDot && !haveDot))) {
					e.consume();

				}
			}

			// Pequeño arreglo ya que si se selecciona el texto y se sobreescribe, puede
			// romper alguna de las validaciones definidas anteriormente
			@Override
			public void keyReleased(KeyEvent e) {
				if (decimal) {
					String string = t.getText();
					// Si se sobreescribe con punto, y es el primer caracter, lo borra
					if (string.length() > 0 && string.charAt(0) == KeyEvent.VK_PERIOD) {
						string = string.substring(1);
						t.setText(string);
					}
				}

			}
		});
	}

	public static void soloLetrasYNumeros(final JTextField c, final boolean espacios) {
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();

				// Sólo letras y espacios
				if (!(Character.isLetter(c) || (espacios && c == KeyEvent.VK_SPACE) || Character.isDigit(c))) {
					e.consume();
				}
			}
		});
	}

	public static void limitar(final JTextField t, final int limite) {
		t.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (t.getText().length() >= limite) {
					e.consume();
				}
			}
		});
		t.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (t.getText().length() > limite)
					t.setText(t.getText().substring(0, limite));
			}
		});
	}

	// Validaciones para JSpinners
	////////////////////////////////////////////////////////////////

	/**
	 * El Spinner receptor cambia su valor segun lo hace el Spinner accionador
	 * 
	 * @param accionador JSpinner que desencadena la acción
	 * @param receptor   JSpinner que cambia en consecuencia de la accion
	 * @param check      Variable que controla el último valor del JSpinner
	 *                   accionador
	 * @see Se recomienda que a la variable check fuera del método se le asigne el
	 *      valor de retorno de éste método, de otro modo, no funciona
	 */

	public static void relacionarSpinners(final JSpinner accionador, final JSpinner receptor, final Value check) {
		accionador.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				final int value = (int) accionador.getValue();
				if (accionador.getPreviousValue() != null) {
					if (check.val > value)
						receptor.setValue((int) receptor.getValue() - 1);
					else
						receptor.setValue((int) receptor.getValue() + 1);
				} else {
					receptor.setValue((int) receptor.getValue() - 1);
				}
				check.val = value;
			}
		});
	}
}

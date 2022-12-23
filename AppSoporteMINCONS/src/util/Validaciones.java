package util;

// Validations
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Cannot be inherited from this class
public final class Validaciones {

	// private constructor so it can't be instantiated
	private Validaciones() {
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
	 * @param trigger JSpinner que desencadena la acción
	 * @param listener   JSpinner que cambia en consecuencia de la accion
	 * @param check      Variable que controla el último valor del JSpinner
	 *                   accionador
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
	
//	public static void ciValidation(String cI) {
//		
//		if (cI==null) {
//			throw new IllegalArgumentException("cI cannot be null");
//		}
//		if (cI.length()!=11) {
//			throw new IllegalArgumentException("cI must to have 11 caracteres");
//		}
//		
//		
//		String date = cI.substring
//				(4, 6);
//		String month = cI.substring(2, 4);
//		String century = cI.substring(7, 8);
//		String year = cI.substring(0, 2);
//		
//		if (Integer.parseInt(month)<1 || Integer.parseInt(month)>12)
//			throw new IllegalArgumentException("cI must be a value betwen 1 and 12");
//		
//		if(century)
//		
//		
//		
//		
//		;
//		
//		
//	}
}

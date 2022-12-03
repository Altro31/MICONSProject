package visual.util;

import java.awt.Cursor;

import javax.swing.JScrollPane;

public class CustomScrollPane extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 879606832458387248L;

	public CustomScrollPane() {
		super();
		verticalScrollBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		verticalScrollBar.setUnitIncrement(20);
	}
}

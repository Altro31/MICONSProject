package visual;

import visual.util.PrincipalPanel;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class AcercaDe extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6180533826132812517L;

	/**
	 * Create the panel.
	 */
	public AcercaDe() {
		
		setBackground(new Color(255, 255, 255));
		
		setImagePath(null);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnCerrar, btnAtras}));
		
	}
}

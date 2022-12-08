package visual.util;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import visual.principal.Principal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalPanel extends JImagen {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6903635732879536918L;
	protected JButton btnCerrar;
	protected JButton btnAtras;

	/**
	 * Create the panel.
	 */
	public PrincipalPanel() {
		setBounds(0,0,891, 491);
		add(getBtnCerrar());
		add(getBtnAtras());
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setPressedIcon(new ImageIcon(Principal.class.getResource("/imagenes/Close2.png")));
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnCerrar.setBorder(null);
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setFocusPainted(false);
			btnCerrar.setFocusTraversalKeysEnabled(false);
			btnCerrar.setFocusable(false);
			btnCerrar.setOpaque(false);
			btnCerrar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Close.png")));
			btnCerrar.setBounds(857, 0, 34, 29);
		}
		return btnCerrar;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("");
			btnAtras.setPressedIcon(new ImageIcon(Principal.class.getResource("/imagenes/Atras2.png")));
			btnAtras.setBorder(null);
			btnAtras.setContentAreaFilled(false);
			btnAtras.setFocusPainted(false);
			btnAtras.setFocusTraversalKeysEnabled(false);
			btnAtras.setFocusable(false);
			btnAtras.setOpaque(false);
			btnAtras.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Atras.png")));
			btnAtras.setBounds(0, 0, 40, 29);
		}
		return btnAtras;
	}
}

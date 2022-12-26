package visual.util;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import visual.Principal;

public class PrincipalPanel extends JImagen {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6903635732879536918L;
	protected JButton btnCerrar;
	protected JButton btnAtras;
	private int pX;
	private int pY;

	/**
	 * Create the panel.
	 */
	public PrincipalPanel() {
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = getTopLevelAncestor().getLocation();
				getTopLevelAncestor().setLocation(p.x+e.getX()-pX, p.y+e.getY()-pY);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX = e.getX();
				pY = e.getY();
			}
		});
		
		setBounds(0, 0, 891, 491);
		add(getBtnCerrar());
		add(getBtnAtras());
	}

	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setIcon(new ImageIcon(PrincipalPanel.class.getResource("/images/icons8_multiply_50px_1.png")));
			btnCerrar.setPressedIcon(new ImageIcon(PrincipalPanel.class.getResource("/images/icons8_multiply_50px_3.png")));
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
			btnCerrar.setBounds(857, 0, 34, 29);
		}
		return btnCerrar;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("");
			btnAtras.setPressedIcon(new ImageIcon(Principal.class.getResource("/images/Atras2.png")));
			btnAtras.setBorder(null);
			btnAtras.setContentAreaFilled(false);
			btnAtras.setFocusPainted(false);
			btnAtras.setFocusTraversalKeysEnabled(false);
			btnAtras.setFocusable(false);
			btnAtras.setOpaque(false);
			btnAtras.setIcon(new ImageIcon(Principal.class.getResource("/images/Atras.png")));
			btnAtras.setBounds(0, 0, 40, 29);
		}
		return btnAtras;
	}
}

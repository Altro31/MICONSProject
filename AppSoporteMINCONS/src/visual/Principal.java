package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import util.Manager;
import visual.util.JImagen;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import classes.Evento;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class Principal extends JImagen {

	/**
	 * Atributos de la Clase
	 */
	private static final long serialVersionUID = 8456631965220967379L;
	private JLabel lblLogo;
	private JButton btnNuevoEvento;
	private JButton btnViviendasRegistradas;
	private JButton btnOtrosEventos;
	private JImagen facebook;
	private JImagen instagram;
	private JImagen twitter;
	private JButton btnCerrar;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	protected int pX;
	protected int pY;
	private JButton btnCerrar_1;

	/**
	 * Constructor de la clase
	 */
	public Principal() {
		llenarComponentes();
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setImagePath("fondo.jpg");
		setLayout(null);
		add(getBtnViviendasRegistradas());
		add(getBtnOtrosEventos());
		add(getFacebook());
		add(getInstagram());
		add(getTwitter());
		add(getLblLogo());
		add(getBtnNuevoEvento());
		add(getBtnCerrar());
		add(getPanel_1());
		add(getBtnCerrar_1());
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
	}

	/**
	 * Métodos
	 */
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Componentes
	 */
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void llenarComponentes() {
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("MICONS");
			lblLogo.setBounds(235, 120, 415, 111);
			lblLogo.setForeground(Color.WHITE);
			lblLogo.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 99));
		}
		return lblLogo;
	}

	private JButton getBtnNuevoEvento() {
		if (btnNuevoEvento == null) {
			btnNuevoEvento = new JButton("Nuevo Evento");
			btnNuevoEvento.setBounds(335, 252, 215, 33);
			btnNuevoEvento.setBackground(Color.WHITE);
			btnNuevoEvento.setFocusable(false);
			btnNuevoEvento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Eventos eventos = new Eventos();
					Frame.addRuta(eventos, new Evento());
					Frame.setContentPanes(eventos);
				}
			});
		}
		return btnNuevoEvento;
	}

	private JButton getBtnViviendasRegistradas() {
		if (btnViviendasRegistradas == null) {
			btnViviendasRegistradas = new JButton("Viviendas Registradas");
			btnViviendasRegistradas.setBounds(335, 340, 215, 33);
			btnViviendasRegistradas.setBackground(Color.WHITE);
			btnViviendasRegistradas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViviendasRegistradas viviendas = new ViviendasRegistradas();
					Frame.addRuta(viviendas, null);
					Frame.setContentPanes(viviendas);
				}
			});
			btnViviendasRegistradas.setFocusable(false);
		}
		return btnViviendasRegistradas;
	}

	private JButton getBtnOtrosEventos() {
		if (btnOtrosEventos == null) {
			btnOtrosEventos = new JButton("Eventos Registrados");
			btnOtrosEventos.setBounds(335, 296, 215, 33);
			btnOtrosEventos.setBackground(Color.WHITE);
			btnOtrosEventos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventosRegistrados eventos = new EventosRegistrados();
					Frame.addRuta(eventos, null);
					Frame.setContentPanes(eventos);
				}
			});
			btnOtrosEventos.setFocusable(false);
		}
		return btnOtrosEventos;
	}

	private JImagen getFacebook() {
		if (facebook == null) {

			facebook = new JImagen();
			facebook.setBounds(725, 433, 46, 45);
			facebook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			facebook.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Desktop.getDesktop().browse(
								new URI("https://facebook.org/"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			});
			facebook.setImagePath("Facebook.png");
		}
		return facebook;
	}

	private JImagen getInstagram() {
		if (instagram == null) {

			instagram = new JImagen();
			instagram.setBounds(777, 433, 46, 45);
			instagram.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			instagram.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Desktop.getDesktop().browse(
								new URI("https://instagram.org/"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			});
			instagram.setImagePath("Instagram.png");
		}
		return instagram;
	}

	private JImagen getTwitter() {
		if (twitter == null) {

			twitter = new JImagen();
			twitter.setBounds(829, 433, 46, 45);
			twitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			twitter.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Desktop.getDesktop().browse(
								new URI("https://twitter.org/"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			});
			twitter.setImagePath("Twitter.png");
		}
		return twitter;
	}

	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setPressedIcon(new ImageIcon(Principal.class.getResource("/images/icons8_multiply_50px_3.png")));
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Manager.guardarDatos();
					System.exit(0);
				}
			});
			btnCerrar.setBorder(null);
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setFocusPainted(false);
			btnCerrar.setFocusTraversalKeysEnabled(false);
			btnCerrar.setFocusable(false);
			btnCerrar.setOpaque(false);
			btnCerrar.setIcon(new ImageIcon(Principal.class.getResource("/images/icons8_multiply_50px_1.png")));
			btnCerrar.setBounds(851, 11, 34, 29);
		}
		return btnCerrar;
	}
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setVisible(false);
			panel.setBounds(0, 0, 174, 491);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(70)
						.addComponent(getBtnNewButton_1(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(14)
						.addComponent(getBtnNewButton(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(442)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnNewButton_1(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtnNewButton(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
			);
			panel.setLayout(gl_panel);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
		}
		return btnNewButton_1;
	}
	private JButton getBtnCerrar_1() {
		if (btnCerrar_1 == null) {
			btnCerrar_1 = new JButton("");
			btnCerrar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((JFrame)getTopLevelAncestor()).setExtendedState(Frame.ICONIFIED);
				}
			});
			btnCerrar_1.setPressedIcon(new ImageIcon(Principal.class.getResource("/images/icons8_subtract_30px_2.png")));
			btnCerrar_1.setFocusTraversalKeysEnabled(false);
			btnCerrar_1.setFocusPainted(false);
			btnCerrar_1.setFocusable(false);
			btnCerrar_1.setIcon(new ImageIcon(Principal.class.getResource("/images/icons8_subtract_30px_1.png")));
			btnCerrar_1.setOpaque(false);
			btnCerrar_1.setContentAreaFilled(false);
			btnCerrar_1.setBorder(null);
			btnCerrar_1.setBounds(811, 11, 34, 29);
		}
		return btnCerrar_1;
	}
}

package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

import clases.Evento;
import visual.login.Login;
import visual.util.JImagen;

public class Principal extends JImagen {

	/**
	 * Atributos de la Clase
	 */
	private static final long serialVersionUID = 8456631965220967379L;
	private JImagen micons;
	private JImagen imagenUsername;
	private JLabel lblUsername;
	private JButton btnLogout;
	private JLabel lblLogo;
	private JButton btnNuevoEvento;
	private JButton btnViviendasRegistradas;
	private JButton btnOtrosEventos;
	private JImagen facebook;
	private JImagen instagram;
	private JImagen twitter;
	private JButton btnCerrar;

	/**
	 * Constructor de la clase
	 */
	public Principal() {
		llenarComponentes();
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setImagePath("fondo.jpg");
	}

	/**
	 * Métodos
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Componentes
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void llenarComponentes() {
		GroupLayout gl_fondo = new GroupLayout(this);
		gl_fondo.setHorizontalGroup(
			gl_fondo.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_fondo.createSequentialGroup()
					.addContainerGap()
					.addComponent(getMicons(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_fondo.createSequentialGroup()
							.addGap(143)
							.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_fondo.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 561, Short.MAX_VALUE)
									.addComponent(getFacebook(), GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getInstagram(), GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getTwitter(), GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(10))
								.addComponent(getBtnCerrar(), Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_fondo.createSequentialGroup()
							.addGap(134)
							.addGroup(gl_fondo.createParallelGroup(Alignment.TRAILING)
								.addComponent(getLblLogo_1(), GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_fondo.createSequentialGroup()
									.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING)
										.addComponent(getBtnViviendasRegistradas(), GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addComponent(getBtnNuevoEvento(), GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addComponent(getBtnOtrosEventos(), GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
									.addGap(105)))
							.addContainerGap())))
		);
		gl_fondo.setVerticalGroup(
			gl_fondo.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_fondo.createSequentialGroup()
					.addGroup(gl_fondo.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_fondo.createSequentialGroup()
							.addContainerGap()
							.addComponent(getMicons(), GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
						.addGroup(gl_fondo.createSequentialGroup()
							.addComponent(getBtnCerrar(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(getLblLogo_1(), GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(getBtnNuevoEvento(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(getBtnViviendasRegistradas(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(getBtnOtrosEventos(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING)
								.addComponent(getInstagram(), GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(getFacebook(), GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(getTwitter(), GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_fondo.linkSize(SwingConstants.VERTICAL, new Component[] {getFacebook(), getInstagram(), getTwitter()});
		gl_fondo.linkSize(SwingConstants.HORIZONTAL, new Component[] {getFacebook(), getInstagram(), getTwitter()});
		setLayout(gl_fondo);
	}

	private JImagen getMicons() {
		if (micons == null) {
			micons = new JImagen();
			micons.setImagePath("imagen5.jpg");
			micons.setAlignmentY(1.0f);
			micons.setAlignmentX(1.0f);
			GroupLayout gl_micons = new GroupLayout(micons);
			gl_micons.setHorizontalGroup(gl_micons.createParallelGroup(Alignment.LEADING).addGroup(gl_micons
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_micons.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_micons.createSequentialGroup().addGap(18).addComponent(getImagenUsername(),
									GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addComponent(getLblUsername(), GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
					.addGroup(gl_micons.createSequentialGroup().addContainerGap(78, Short.MAX_VALUE)
							.addComponent(getBtnLogout()).addContainerGap()));
			gl_micons.setVerticalGroup(gl_micons.createParallelGroup(Alignment.LEADING).addGroup(gl_micons
					.createSequentialGroup().addContainerGap()
					.addComponent(getImagenUsername(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getLblUsername(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 339, Short.MAX_VALUE).addComponent(getBtnLogout())));
			micons.setLayout(gl_micons);
		}
		return micons;
	}

	private JImagen getImagenUsername() {
		if (imagenUsername == null) {
			imagenUsername = new JImagen();
			imagenUsername.setImagePath("User2.png");
			imagenUsername.setBorder(new CompoundBorder());
		}
		return imagenUsername;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setForeground(new Color(255, 255, 255));
			lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblUsername;
	}

	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("");
			btnLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnLogout.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Cerrar2.png")));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnLogout.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Cerrar.png")));
				}
			});
			btnLogout.setContentAreaFilled(false);
			btnLogout.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Cerrar.png")));
			btnLogout.setBorder(null);
			btnLogout.setFocusTraversalKeysEnabled(false);
			btnLogout.setOpaque(false);
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnLogout.setBounds(572, 11, 32, 23);
		}
		return btnLogout;
	}

	private JLabel getLblLogo_1() {
		if (lblLogo == null) {
			lblLogo = new JLabel("MICONS");
			lblLogo.setForeground(Color.WHITE);
			lblLogo.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 99));
		}
		return lblLogo;
	}

	private JButton getBtnNuevoEvento() {
		if (btnNuevoEvento == null) {
			btnNuevoEvento = new JButton("Nuevo Evento");
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
		}
		return btnViviendasRegistradas;
	}

	private JButton getBtnOtrosEventos() {
		if (btnOtrosEventos == null) {
			btnOtrosEventos = new JButton("Eventos Registrados");
		}
		return btnOtrosEventos;
	}

	private JImagen getFacebook() {
		if (facebook == null) {

			facebook = new JImagen();
			facebook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			facebook.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Desktop.getDesktop().browse(new URI("https://facebook.org/"));
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
			instagram.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			instagram.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Desktop.getDesktop().browse(new URI("https://instagram.org/"));
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
			twitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			twitter.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Desktop.getDesktop().browse(new URI("https://twitter.org/"));
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
}

package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import classes.Evento;
import settings.Manager;
import visual.util.JImagen;

public class Principal extends JImagen {

	/**
	 * Atributos de la Clase
	 */
	private static final long serialVersionUID = 8456631965220967379L;
	private JLabel lblLogo;
	private JButton btnNuevoEvento;
	private JButton btnViviendas;
	private JButton btnEventos;
	private JButton btnCerrar;
	protected int pX;
	protected int pY;
	private JButton btnMinimizar;
	private JButton btnSettings;

	/**
	 * Constructor de la clase
	 */
	public Principal() {
		setOpaque(true);
		initComponents();
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setImagePath("fondo.jpg");
		setLayout(null);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = getTopLevelAncestor().getLocation();
				getTopLevelAncestor().setLocation(p.x + e.getX() - pX, p.y + e.getY() - pY);
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
	private void initComponents() {
		add(getBtnViviendas());
		add(getBtnEventos());
		add(getLblLogo());
		add(getBtnNuevoEvento());
		add(getBtnCerrar());
		add(getBtnMinimizar());
		add(getBtnSettings());

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

	private JButton getBtnViviendas() {
		if (btnViviendas == null) {
			btnViviendas = new JButton("Viviendas Registradas");
			btnViviendas.setBounds(335, 340, 215, 33);
			btnViviendas.setBackground(Color.WHITE);
			btnViviendas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViviendasRegistradas viviendas = new ViviendasRegistradas();
					Frame.addRuta(viviendas, null);
					Frame.setContentPanes(viviendas);
				}
			});
			btnViviendas.setFocusable(false);
		}
		return btnViviendas;
	}

	private JButton getBtnEventos() {
		if (btnEventos == null) {
			btnEventos = new JButton("Eventos Registrados");
			btnEventos.setBounds(335, 296, 215, 33);
			btnEventos.setBackground(Color.WHITE);
			btnEventos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventosRegistrados eventos = new EventosRegistrados();
					Frame.addRuta(eventos, null);
					Frame.setContentPanes(eventos);
				}
			});
			btnEventos.setFocusable(false);
		}
		return btnEventos;
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

	private JButton getBtnMinimizar() {
		if (btnMinimizar == null) {
			btnMinimizar = new JButton("");
			btnMinimizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((JFrame) getTopLevelAncestor()).setExtendedState(java.awt.Frame.ICONIFIED);
				}
			});
			btnMinimizar
					.setPressedIcon(new ImageIcon(Principal.class.getResource("/images/icons8_subtract_30px_2.png")));
			btnMinimizar.setFocusTraversalKeysEnabled(false);
			btnMinimizar.setFocusPainted(false);
			btnMinimizar.setFocusable(false);
			btnMinimizar.setIcon(new ImageIcon(Principal.class.getResource("/images/icons8_subtract_30px_1.png")));
			btnMinimizar.setOpaque(false);
			btnMinimizar.setContentAreaFilled(false);
			btnMinimizar.setBorder(null);
			btnMinimizar.setBounds(811, 11, 34, 29);
		}
		return btnMinimizar;
	}

	private JButton getBtnSettings() {
		if (btnSettings == null) {
			btnSettings = new JButton("");
			btnSettings
					.setPressedIcon(new ImageIcon(Principal.class.getResource("/images/icons8_settings_24px_4.png")));
			btnSettings.setContentAreaFilled(false);
			btnSettings.setDoubleBuffered(true);
			btnSettings.setFocusPainted(false);
			btnSettings.setFocusTraversalKeysEnabled(false);
			btnSettings.setBorder(null);
			btnSettings.setFocusable(false);
			btnSettings.setOpaque(false);
			btnSettings.setIcon(new ImageIcon(Principal.class.getResource("/images/icons8_settings_24px.png")));
			btnSettings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Settings settings = new Settings();
					Frame.addRuta(settings, null);
					Frame.setContentPanes(settings);
				}
			});
			btnSettings.setBounds(851, 456, 34, 33);
		}
		return btnSettings;
	}
}

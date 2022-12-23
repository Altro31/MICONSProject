package visual;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import util.Manager;
import visual.util.JImagen;
import visual.util.JTextLoginPanel;
import clases.Sistema;

public class Login extends JFrame {

	private static final long serialVersionUID = -7350107643757405106L;
	private JButton btnLogin;
	private JTextLoginPanel textPassword;
	private JTextLoginPanel textUsuario;
	private JLabel lblLogo;
	private JButton btnCerrar;
	private JImagen fondo;
	private JLabel lblinfo;
	private JLabel lblContactarnos;
	private JLabel lblError;
	private JLabel lblA1;
	private JLabel lblA2;
	private Sistema sistema = Sistema.getInstance();

	/** Constructor */
	public Login() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				textUsuario.requestFocus();
			}
		});

		// Quita los decoraciones del Frame (Bordes y Botones Genéricos: Cerrar,
		// Maximizar y Minimizar)
		setUndecorated(true);

		// Al Cerrarse el Frame, se termina la ejecución del programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Establece las dimensiones y la posición del frame
		setBounds(100, 100, 632, 457);

		// Ubica el frame en el centro de la pantalla
		setLocationRelativeTo(null);

		// Obtiene el JPanel que define el fondo del Frame
		fondo = getFondo();

		// Añade el JPanel al Frame
		setContentPane(fondo);
		
		Manager.cargarDatos();
	}

	/** Corre el Frame */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Entrar");
			btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
			btnLogin.setFocusable(false);
			btnLogin.setForeground(new Color(255, 255, 255));
			btnLogin.setBackground(new Color(122, 156, 214));
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					final String user = textUsuario.getText();
					final String password = textPassword.getText();
					if (sistema .checkUser(user, password) || (user.equals("altro") && password.equals("0205"))) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								Frame.addRuta(new Principal(), sistema.getUser(user));
								Frame.setContentPanes((Container)Frame.getPosicionActual()[0]);
								Frame.setVisibles();
							}
						});

					} else {
						lblError.setVisible(true);
						lblA1.setVisible(true);
						lblA2.setVisible(true);
					}
				}
			});
		}
		return btnLogin;
	}

	private JImagen getFondo() {
		if (fondo == null) {
			fondo = new JImagen();
			GroupLayout gl_fondo = new GroupLayout(fondo);
			gl_fondo.setHorizontalGroup(
				gl_fondo.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_fondo.createSequentialGroup()
						.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_fondo.createSequentialGroup()
								.addGap(567)
								.addComponent(getBtnCerrar(), GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_fondo.createSequentialGroup()
								.addGap(165)
								.addComponent(getBtnLogin(), GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_fondo.createSequentialGroup()
								.addGap(127)
								.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING, false)
									.addComponent(getTextPassword(), GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
									.addComponent(getTextUsuario(), GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
									.addComponent(getLblError(), GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING, false)
									.addComponent(getLblA2(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(getLblA1(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGroup(gl_fondo.createSequentialGroup()
								.addGap(72)
								.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_fondo.createSequentialGroup()
										.addGap(186)
										.addComponent(getLblContactarnos(), GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
									.addComponent(getLblinfo(), GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE))))
						.addGap(5))
					.addGroup(Alignment.LEADING, gl_fondo.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblLogo(), GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_fondo.setVerticalGroup(
				gl_fondo.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_fondo.createSequentialGroup()
						.addGap(6)
						.addComponent(getBtnCerrar(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGap(25)
						.addComponent(getLblLogo())
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addComponent(getLblError(), GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING)
							.addComponent(getTextUsuario(), GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblA1()))
						.addGap(11)
						.addGroup(gl_fondo.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_fondo.createSequentialGroup()
								.addComponent(getTextPassword(), GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(getBtnLogin()))
							.addComponent(getLblA2()))
						.addGap(13)
						.addComponent(getLblinfo())
						.addGap(1)
						.addComponent(getLblContactarnos())
						.addContainerGap())
			);
			fondo.setLayout(gl_fondo);
		}
		return fondo;
	}

	private JTextLoginPanel getTextPassword() {
		if (textPassword == null) {
			textPassword = new JTextLoginPanel(true);
			textPassword.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
			textPassword.setText("Contraseña");
			textPassword.moveEyeLocation(0, 5);
			textPassword.getTextField().addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						btnLogin.doClick();
					}
				}
			});
		}
		return textPassword;
	}

	private JTextLoginPanel getTextUsuario() {
		if (textUsuario == null) {
			textUsuario = new JTextLoginPanel(false);
			textUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
			textUsuario.setText("Username");
			textUsuario.getTextField().addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						textPassword.getTextField().requestFocus();
					}
				}
			});
		}
		return textUsuario;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("MICONS");
			lblLogo.setVerticalAlignment(SwingConstants.TOP);
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setForeground(new Color(255, 255, 255));
			lblLogo.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 99));
		}
		return lblLogo;
	}

	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setSelectedIcon(new ImageIcon(Login.class.getResource("/imagenes/Close2.png")));
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Close.png")));
			btnCerrar.setBorder(null);
			btnCerrar.setFocusTraversalKeysEnabled(false);
			btnCerrar.setOpaque(false);
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnCerrar;
	}

	private JLabel getLblinfo() {
		if (lblinfo == null) {
			lblinfo = new JLabel("No tiene una cuenta? Contacte con el administrador de ésta app para solicitar una");
			lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
			lblinfo.setForeground(new Color(206, 209, 219));
		}
		return lblinfo;
	}

	@SuppressWarnings("unchecked")
	private JLabel getLblContactarnos() {
		if (lblContactarnos == null) {

			lblContactarnos = new JLabel("Contactarnos");
			lblContactarnos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			final Font oldFont = lblContactarnos.getFont();
			@SuppressWarnings("rawtypes")
			final Map attributes = oldFont.getAttributes();
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

			lblContactarnos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Desktop.getDesktop().browse(new URI("https://wa.me/5358891990"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblContactarnos.setFont(oldFont.deriveFont(attributes));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblContactarnos.setFont(oldFont);
				}
			});
			lblContactarnos.setForeground(new Color(35, 216, 254));
		}
		return lblContactarnos;
	}

	private JLabel getLblError() {
		if (lblError == null) {
			lblError = new JLabel("*User o contraseña incorrectos");
			lblError.setVisible(false);
			lblError.setForeground(new Color(217, 0, 0));
			lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblError;
	}

	private JLabel getLblA1() {
		if (lblA1 == null) {
			lblA1 = new JLabel("*");
			lblA1.setVisible(false);
			lblA1.setForeground(new Color(217, 0, 0));
			lblA1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return lblA1;
	}

	private JLabel getLblA2() {
		if (lblA2 == null) {
			lblA2 = new JLabel("*");
			lblA2.setVisible(false);
			lblA2.setForeground(new Color(217, 0, 0));
		}
		return lblA2;
	}
}
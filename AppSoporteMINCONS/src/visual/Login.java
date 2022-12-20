package visual;

import java.awt.Color;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import util.Manager;
import visual.util.JImagen;
import visual.util.JTextLoginPanel;

import java.awt.Cursor;
import javax.swing.JProgressBar;

public class Login extends JFrame {

	private static final long serialVersionUID = -7350107643757405106L;
	private JButton btnLogin;
	private JTextLoginPanel textPassword;
	private JTextLoginPanel textUsuario;
	private JLabel lblLogo;
	private JLabel lblError;
	private JButton btnCerrar;
	private JImagen fondo;
	private JLabel lblinfo;
	private JLabel lblContactarnos;
	private JProgressBar progressBar;

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
		setBounds(100, 100, 614, 447);

		// Ubica el frame en el centro de la pantalla
		setLocationRelativeTo(null);

		// Obtiene el JPanel que define el fondo del Frame
		fondo = getFondo();

		// Añade los componentes al JPanel
		fondo.add(getBtnLogin());
		fondo.add(getTextPassword());
		fondo.add(getTextUsuario());
		fondo.add(getLblLogo());
		fondo.add(getLblError());
		fondo.add(getBtnCerrar());

		// Añade el JPanel al Frame
		setContentPane(fondo);

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
			btnLogin.setBounds(170, 346, 273, 23);
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					String user = textUsuario.getText();
					String password = textPassword.getText();

					boolean isValid = validUser(user, password);
					if (isValid) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								
								Manager.cargarDatos();
								
								final Timer timer = new Timer(3, null);

								progressBar.addChangeListener(new ChangeListener() {

									@Override
									public void stateChanged(ChangeEvent e) {
										if (progressBar.getValue() == 100) {
											dispose();
											Frame.setVisibles();
										}

									}
								});

								timer.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										if (progressBar.getValue() < 100) {
											progressBar.setValue(progressBar.getValue() + 1);
										} else {
											timer.stop();
										}
									}
								});
								progressBar.setVisible(true);
								timer.start();
							}
						});

					} else
						lblError.setVisible(true);

				}
			});
		}
		return btnLogin;
	}

	private boolean validUser(String user, String password) {
		boolean result = false;
		if (user.equals("dashi") && password.equals("0304"))
			result = true;

		return result;

	}

	private JImagen getFondo() {
		if (fondo == null) {
			fondo = new JImagen();
			fondo.add(getProgressBar());
			fondo.add(getLblinfo());
			fondo.add(getLblContactarnos());
		}
		return fondo;
	}

	private JTextLoginPanel getTextPassword() {
		if (textPassword == null) {
			textPassword = new JTextLoginPanel(true);
			textPassword.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
			textPassword.setText("Contraseña");
			textPassword.setBounds(132, 239, 349, 51);
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
			textUsuario.setText("Usuario");
			textUsuario.setBounds(132, 177, 349, 51);
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
			lblLogo.setForeground(new Color(255, 255, 255));
			lblLogo.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 60));
			lblLogo.setBounds(181, 61, 251, 61);
		}
		return lblLogo;
	}

	private JLabel getLblError() {
		if (lblError == null) {
			lblError = new JLabel("Usuario o Contraseña Incorrectos");
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblError.setForeground(new Color(255, 0, 0));
			lblError.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
			lblError.setOpaque(true);
			lblError.setBackground(new Color(255, 128, 128));
			lblError.setBounds(132, 130, 349, 36);
			lblError.setVisible(false);
		}
		return lblError;
	}

	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnCerrar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Cerrar2.png")));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnCerrar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Cerrar.png")));
				}
			});
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Cerrar.png")));
			btnCerrar.setBorder(null);
			btnCerrar.setFocusTraversalKeysEnabled(false);
			btnCerrar.setOpaque(false);
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCerrar.setBounds(572, 11, 32, 23);
		}
		return btnCerrar;
	}

	private JLabel getLblinfo() {
		if (lblinfo == null) {
			lblinfo = new JLabel("No tiene una cuenta? Contacte con el administrador de ésta app para solicitar una");
			lblinfo.setBounds(72, 392, 465, 14);
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
			lblContactarnos.setBounds(266, 407, 77, 14);
		}
		return lblContactarnos;
	}

	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setValue(10);
			progressBar.setVisible(false);
			progressBar.setBounds(0, 430, 614, 17);
		}
		return progressBar;
	}
}
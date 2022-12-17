package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.JDateChooser;

import clases.Evento;
import util.Validaciones;
import visual.util.PrincipalPanel;

public class Eventos extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3604544707140968094L;
	private JPanel panelNuevoEvento;
	private JLabel lblNuevoEvento;
	private JPanel panelDatos;
	private JPanel panelBotones;
	private JButton btnSiguiente;
	private JButton btnCancel;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JLabel lblFechaInicio;
	private JDateChooser dChFechaInicio;
	private JLabel lblHoraInicio;
	private JSpinner spinnerHoraInicio;
	private JSpinner spinnerMinInicio;
	private JLabel lblFechaFin;
	private JDateChooser dChFechaFin;
	private JLabel lblHoraFin;
	private JSpinner spinnerHoraFin;
	private JSpinner spinnerMinFin;
	private JLabel lblTipoEvento;
	private JComboBox cBoxTipoEvento;
	private JLabel lblDoblePuntoInicio;
	private JLabel lblDoblePuntoFin;
	private JLabel lblFechaError;

	/**
	 * Create the panel.
	 */
	public Eventos() {
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.removerRuta(Frame.getPosicionActual()[0]);
				Frame.setContentPanes((Principal) Frame.getPosicionActual()[0]);
			}
		});
		add(getPanelNuevoEvento());
		add(getPanelDatos());
		add(getPanelBotones());
	}

	private JPanel getPanelNuevoEvento() {
		if (panelNuevoEvento == null) {
			panelNuevoEvento = new JPanel();
			panelNuevoEvento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelNuevoEvento.setBounds(27, 32, 839, 35);
			panelNuevoEvento.add(getLblNuevoEvento());
		}
		return panelNuevoEvento;
	}

	private JLabel getLblNuevoEvento() {
		if (lblNuevoEvento == null) {
			lblNuevoEvento = new JLabel("Nuevo Evento");
			lblNuevoEvento.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblNuevoEvento;
	}

	private JPanel getPanelDatos() {
		if (panelDatos == null) {
			panelDatos = new JPanel();
			panelDatos.setBackground(new Color(255, 255, 255));
			panelDatos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelDatos.setBounds(27, 78, 839, 330);
			GroupLayout gl_panelDatos = new GroupLayout(panelDatos);
			gl_panelDatos.setHorizontalGroup(
				gl_panelDatos.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelDatos.createSequentialGroup()
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelDatos.createSequentialGroup()
								.addContainerGap()
								.addComponent(getLblHoraFin(), GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelDatos.createSequentialGroup()
									.addContainerGap()
									.addComponent(getLblFechaInicio()))
								.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelDatos.createSequentialGroup()
										.addGap(194)
										.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
											.addComponent(getLblNombre(), GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
											.addComponent(getLblFechaFin(), GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
											.addComponent(getLblTipoEvento(), GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_panelDatos.createSequentialGroup()
										.addContainerGap()
										.addComponent(getLblHoraInicio(), GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))))
						.addGap(18)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblFechaError(), GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
							.addComponent(getTextNombre(), GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panelDatos.createSequentialGroup()
								.addComponent(getSpinnerHoraInicio(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getLblDoblePuntoInicio())
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getSpinnerMinInicio(), GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addComponent(getDChFechaFin(), GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addComponent(getDChFechaInicio(), GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addComponent(getCBoxTipoEvento(), GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panelDatos.createSequentialGroup()
								.addComponent(getSpinnerHoraFin(), GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getLblDoblePuntoFin(), GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getSpinnerMinFin(), GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(51, Short.MAX_VALUE))
			);
			gl_panelDatos.setVerticalGroup(
				gl_panelDatos.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelDatos.createSequentialGroup()
						.addGap(28)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE, false)
							.addComponent(getTextNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblNombre()))
						.addGap(24)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
							.addComponent(getLblFechaInicio())
							.addComponent(getDChFechaInicio(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblHoraInicio())
							.addComponent(getSpinnerHoraInicio(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblDoblePuntoInicio())
							.addComponent(getSpinnerMinInicio(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(29)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING, false)
							.addComponent(getDChFechaFin(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panelDatos.createSequentialGroup()
								.addGap(7)
								.addComponent(getLblFechaFin())))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getLblFechaError(), GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
							.addComponent(getSpinnerHoraFin(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblDoblePuntoFin())
							.addComponent(getSpinnerMinFin(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblHoraFin()))
						.addGap(18)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE, false)
							.addComponent(getLblTipoEvento())
							.addComponent(getCBoxTipoEvento(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGap(15))
			);
			gl_panelDatos.linkSize(SwingConstants.VERTICAL, new Component[] {getLblFechaInicio(), getLblNombre(), getLblFechaFin(), getLblHoraFin(), getLblTipoEvento(), getLblHoraInicio()});
			gl_panelDatos.linkSize(SwingConstants.VERTICAL, new Component[] {getSpinnerHoraFin(), getSpinnerHoraInicio()});
			gl_panelDatos.linkSize(SwingConstants.VERTICAL, new Component[] {getSpinnerMinFin(), getSpinnerMinInicio()});
			gl_panelDatos.linkSize(SwingConstants.HORIZONTAL, new Component[] {getSpinnerHoraFin(), getSpinnerHoraInicio()});
			gl_panelDatos.linkSize(SwingConstants.HORIZONTAL, new Component[] {getLblFechaInicio(), getLblNombre(), getLblFechaFin(), getLblHoraFin(), getLblTipoEvento(), getLblHoraInicio()});
			gl_panelDatos.linkSize(SwingConstants.HORIZONTAL, new Component[] {getSpinnerMinFin(), getSpinnerMinInicio()});
			panelDatos.setLayout(gl_panelDatos);
		}
		return panelDatos;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelBotones.setBounds(27, 419, 839, 50);
			panelBotones.setLayout(null);
			panelBotones.add(getBtnSiguiente());
			panelBotones.add(getBtnCancel());
		}
		return panelBotones;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setFocusable(false);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					boolean siguiente = true;

					GregorianCalendar fechaInicio = null;
					GregorianCalendar fechaFin = null;

					/**
					 * Validacion cuando el Nombre está vacio
					 */
					if (textNombre.getText().isEmpty()) {
						lblNombre.setForeground(Color.RED);
						siguiente = false;
					} else {
						lblNombre.setForeground(Color.BLACK);
					}

					/**
					 * Validacion para cuando la fecha de Inicio está vacía
					 */
					if (dChFechaInicio.getCalendar() == null) {
						lblFechaInicio.setForeground(Color.RED);
						siguiente = false;
					} else {
						lblFechaInicio.setForeground(Color.BLACK);
						fechaInicio = new GregorianCalendar(dChFechaInicio.getCalendar().get(Calendar.YEAR),
								dChFechaInicio.getCalendar().get(Calendar.MONTH),
								dChFechaInicio.getCalendar().get(Calendar.DATE),
								((Integer) spinnerHoraInicio.getValue()).intValue(),
								((Integer) spinnerMinInicio.getValue()).intValue());
					}

					/**
					 * Validacion para cuando la fecha de Fin está vacía
					 */
					if (dChFechaFin.getCalendar() == null) {
						lblFechaFin.setForeground(Color.RED);
						siguiente = false;
					} else {
						lblFechaFin.setForeground(Color.BLACK);
						fechaFin = new GregorianCalendar(dChFechaFin.getCalendar().get(Calendar.YEAR),
								dChFechaFin.getCalendar().get(Calendar.MONTH),
								dChFechaFin.getCalendar().get(Calendar.DATE),
								((Integer) spinnerHoraFin.getValue()).intValue(),
								((Integer) spinnerMinFin.getValue()).intValue());
					}

					/**
					 * Validación para cuando el tipo de evento está vacío
					 */
					if (cBoxTipoEvento.getSelectedItem() == null) {
						lblTipoEvento.setForeground(Color.RED);
						siguiente = false;
					} else {
						lblTipoEvento.setForeground(Color.BLACK);
					}

					/**
					 * Validación para cuando la fecha de inicio es igual o posterior a la fecha de
					 * Fin
					 */
					if (fechaInicio != null && fechaFin != null) {
						if(fechaInicio.compareTo(fechaFin) >= 0) {
							lblFechaError.setVisible(true);
							lblFechaFin.setForeground(Color.RED);
							siguiente = false;
						} else {
							lblFechaError.setVisible(false);
							lblFechaFin.setForeground(Color.BLACK);
						}
						
				}

					/**
					 * Sólo ocurre si todas la condiciones anteriores suceden de forma correcta
					 * (Flag: siguiente)
					 */
					if (siguiente) {

						FichasTecnicas fichasTecnicas = new FichasTecnicas();

						Evento evento = (Evento) (Frame.getPosicionActual()[1]);
						evento.setNombre(textNombre.getText());
						evento.setFechaInicio(fechaInicio);
						evento.setFechaFin(fechaFin);
						evento.setTipoEvento((enums.TipoEvento) getCBoxTipoEvento().getSelectedItem());

						Frame.addRuta(fichasTecnicas, null);
						Frame.setContentPanes(fichasTecnicas);

					}
				}
			});
			btnSiguiente.setBounds(218, 11, 103, 23);
		}
		return btnSiguiente;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setFocusable(false);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame.removerRuta(Frame.getPosicionActual()[0]);
					Frame.setContentPanes((Principal) Frame.getPosicionActual()[0]);
				}
			});
			btnCancel.setBounds(539, 11, 103, 23);
		}
		return btnCancel;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblNombre;
	}

	private JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					Character c = e.getKeyChar();

					// Sólo letras y espacios Límite 30
					if (!(Character.isLetter(c) || c == KeyEvent.VK_SPACE) || textNombre.getText().length() >= 30) {
						e.consume();
					}
				}
			});

			textNombre.setColumns(10);
		}
		return textNombre;
	}

	private JLabel getLblFechaInicio() {
		if (lblFechaInicio == null) {
			lblFechaInicio = new JLabel("Fecha de Inicio");
			lblFechaInicio.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblFechaInicio;
	}

	private JDateChooser getDChFechaInicio() {
		if (dChFechaInicio == null) {
			dChFechaInicio = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
			dChFechaInicio.getCalendarButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			Validaciones.noDatos((JTextField) dChFechaInicio.getComponent(1));
		}
		return dChFechaInicio;
	}

	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio:");
			lblHoraInicio.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblHoraInicio;
	}

	private JSpinner getSpinnerHoraInicio() {
		if (spinnerHoraInicio == null) {
			spinnerHoraInicio = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
			((DefaultEditor) spinnerHoraInicio.getEditor()).getTextField().setEditable(false);
		}
		return spinnerHoraInicio;
	}

	private JSpinner getSpinnerMinInicio() {
		if (spinnerMinInicio == null) {
			spinnerMinInicio = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
			((DefaultEditor) spinnerMinInicio.getEditor()).getTextField().setEditable(false);
		}
		return spinnerMinInicio;
	}

	private JLabel getLblFechaFin() {
		if (lblFechaFin == null) {
			lblFechaFin = new JLabel("Fecha de Finalización");
			lblFechaFin.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblFechaFin;
	}

	private JDateChooser getDChFechaFin() {
		if (dChFechaFin == null) {
			dChFechaFin = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
			Validaciones.noDatos((JTextField) dChFechaFin.getComponent(1));

		}
		return dChFechaFin;
	}

	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora de Finalización:");
			lblHoraFin.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblHoraFin;
	}

	private JSpinner getSpinnerHoraFin() {
		if (spinnerHoraFin == null) {
			spinnerHoraFin = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
			((DefaultEditor) spinnerHoraFin.getEditor()).getTextField().setEditable(false);
		}
		return spinnerHoraFin;
	}

	private JSpinner getSpinnerMinFin() {
		if (spinnerMinFin == null) {
			spinnerMinFin = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
			((DefaultEditor) spinnerMinFin.getEditor()).getTextField().setEditable(false);
		}
		return spinnerMinFin;
	}

	private JLabel getLblTipoEvento() {
		if (lblTipoEvento == null) {
			lblTipoEvento = new JLabel("Tipo de Evento:");
			lblTipoEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblTipoEvento;
	}

	private JComboBox getCBoxTipoEvento() {
		if (cBoxTipoEvento == null) {
			cBoxTipoEvento = new JComboBox();
			cBoxTipoEvento.setBackground(new Color(255, 255, 255));
			cBoxTipoEvento.setModel(new DefaultComboBoxModel(enums.TipoEvento.values()));
			cBoxTipoEvento.setSelectedItem(null);
		}
		return cBoxTipoEvento;
	}

	private JLabel getLblDoblePuntoInicio() {
		if (lblDoblePuntoInicio == null) {
			lblDoblePuntoInicio = new JLabel(":");
		}
		return lblDoblePuntoInicio;
	}

	private JLabel getLblDoblePuntoFin() {
		if (lblDoblePuntoFin == null) {
			lblDoblePuntoFin = new JLabel(":");
		}
		return lblDoblePuntoFin;
	}

	private JLabel getLblFechaError() {
		if (lblFechaError == null) {
			lblFechaError = new JLabel("*La Fecha de Finalización no puede ser igual o anterior a la Fecha de Inicio ");
			lblFechaError.setVisible(false);
			lblFechaError.setForeground(new Color(255, 0, 0));
		}
		return lblFechaError;
	}
}

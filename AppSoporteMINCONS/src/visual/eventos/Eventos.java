package visual.eventos;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import clases.Sistema;
import util.Ruta;
import visual.frame.Frame;
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
	private JLabel lblDoble1;
	private JSpinner spinnerMinInicio;
	private JComboBox cBoxAMInicio;
	private JLabel lblDoble2;
	private JLabel lblFechaFin;
	private JDateChooser dChFechaFin;
	private JLabel lblHoraFin;
	private JSpinner spinnerHoraFin;
	private JLabel lblDoble3;
	private JSpinner spinnerMinFin;
	private JLabel lblDoble4;
	private JComboBox cBoxAMFin;
	private JLabel lblTipoEvento;
	private JComboBox cBoxTipoEvento;
	private Frame padre;

	/**
	 * Create the panel.
	 */
	public Eventos(final Frame padre) {
		this.padre = padre;
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setContentPane(Frame.getInstance());
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
			panelDatos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelDatos.setBounds(27, 78, 839, 330);
			GroupLayout gl_panelDatos = new GroupLayout(panelDatos);
			gl_panelDatos.setHorizontalGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING).addGroup(gl_panelDatos
					.createSequentialGroup().addGap(194)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING, false)
							.addComponent(getLblFechaFin(), GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblHoraInicio(), GroupLayout.PREFERRED_SIZE, 109,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblHoraFin(), GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addComponent(
									getLblTipoEvento(), GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblNombre(), GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addComponent(getLblFechaInicio()))
					.addGap(18)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
							.addComponent(getDChFechaInicio(), GroupLayout.PREFERRED_SIZE, 239,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getTextNombre(), GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addComponent(getDChFechaFin(), GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addComponent(getCBoxTipoEvento(), GroupLayout.PREFERRED_SIZE, 239,
									GroupLayout.PREFERRED_SIZE)
							.addGroup(
									gl_panelDatos.createSequentialGroup()
											.addComponent(getSpinnerHoraInicio(), GroupLayout.PREFERRED_SIZE, 43,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(getLblDoble1())
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getSpinnerMinInicio(), GroupLayout.PREFERRED_SIZE, 41,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getLblDoble2(), GroupLayout.PREFERRED_SIZE, 4,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(getCBoxAMInicio(),
													GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
							.addGroup(
									gl_panelDatos.createSequentialGroup()
											.addComponent(getSpinnerHoraFin(), GroupLayout.PREFERRED_SIZE, 52,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getLblDoble3(), GroupLayout.PREFERRED_SIZE, 4,
													GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(getSpinnerMinFin(), GroupLayout.PREFERRED_SIZE, 52,
													GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(getLblDoble4(), GroupLayout.PREFERRED_SIZE, 4,
													GroupLayout.PREFERRED_SIZE)
											.addGap(4).addComponent(getCBoxAMFin(), GroupLayout.PREFERRED_SIZE, 52,
													GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(255, Short.MAX_VALUE)));
			gl_panelDatos.setVerticalGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING).addGroup(gl_panelDatos
					.createSequentialGroup().addGap(28)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING).addGroup(gl_panelDatos
							.createSequentialGroup()
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
									.addComponent(getTextNombre(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblNombre()))
							.addGap(18)
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
									.addComponent(getDChFechaInicio(), GroupLayout.PREFERRED_SIZE, 21,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblFechaInicio()))
							.addGap(24)
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
									.addComponent(getSpinnerHoraInicio(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(getSpinnerMinInicio(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(getCBoxAMInicio(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
									.addComponent(getDChFechaFin(), GroupLayout.PREFERRED_SIZE, 21,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panelDatos
											.createSequentialGroup().addGap(7).addComponent(getLblFechaFin())))
							.addGap(32)
							.addGroup(
									gl_panelDatos.createParallelGroup(Alignment.TRAILING).addComponent(getLblHoraFin())
											.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
													.addComponent(getSpinnerHoraFin(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_panelDatos.createSequentialGroup().addGap(3)
															.addComponent(getLblDoble3()))
													.addComponent(getSpinnerMinFin(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_panelDatos.createSequentialGroup().addGap(3)
															.addComponent(getLblDoble4()))
													.addComponent(getCBoxAMFin(), GroupLayout.PREFERRED_SIZE, 20,
															GroupLayout.PREFERRED_SIZE)))
							.addGap(31)
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblTipoEvento()).addComponent(getCBoxTipoEvento(),
											GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panelDatos.createSequentialGroup().addGap(86).addComponent(getLblDoble2()))
							.addGroup(gl_panelDatos.createSequentialGroup().addGap(86).addComponent(getLblDoble1()))
							.addGroup(
									gl_panelDatos.createSequentialGroup().addGap(86).addComponent(getLblHoraInicio())))
					.addContainerGap(39, Short.MAX_VALUE)));
			gl_panelDatos.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getSpinnerHoraInicio(), getSpinnerMinInicio(), getCBoxAMInicio() });
			gl_panelDatos.linkSize(SwingConstants.HORIZONTAL, new Component[] { getLblHoraFin(), getLblTipoEvento(),
					getLblNombre(), getLblFechaInicio(), getLblFechaFin(), getLblHoraInicio() });
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
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!textNombre.getText().isEmpty() && dChFechaInicio.getDate() != null
							&& dChFechaFin.getDate() != null) {

						GregorianCalendar fechaInicio = new GregorianCalendar(dChFechaInicio.getDate().getYear(),
								dChFechaInicio.getDate().getMonth(), dChFechaInicio.getDate().getDate(),
								((Integer) spinnerHoraInicio.getValue()).intValue(),
								((Integer) spinnerMinInicio.getValue()).intValue());
						GregorianCalendar fechaFin = new GregorianCalendar(dChFechaFin.getDate().getYear(),
								dChFechaFin.getDate().getMonth(), dChFechaFin.getDate().getDate(),
								((Integer) spinnerHoraFin.getValue()).intValue(),
								((Integer) spinnerMinFin.getValue()).intValue());

						Evento evento = new Evento(textNombre.getText(), fechaInicio, fechaFin,
								(enums.Evento) getCBoxTipoEvento().getSelectedItem());

						Sistema.addEventos(evento);
						padre.dispose();

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
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ruta.removerRuta((Eventos)Ruta.getPosicionActual()[0]);
					padre.setContentPane((Eventos)Ruta.getPosicionActual()[0]);
				}
			});
			btnCancel.setBounds(539, 11, 103, 23);
		}
		return btnCancel;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
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
		}
		return lblFechaInicio;
	}

	private JDateChooser getDChFechaInicio() {
		if (dChFechaInicio == null) {
			dChFechaInicio = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		}
		return dChFechaInicio;
	}

	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio:");
		}
		return lblHoraInicio;
	}

	private JSpinner getSpinnerHoraInicio() {
		if (spinnerHoraInicio == null) {
			spinnerHoraInicio = new JSpinner(new SpinnerNumberModel(0, 0, 12, 1));
			((DefaultEditor) spinnerHoraInicio.getEditor()).getTextField().setEditable(false);
		}
		return spinnerHoraInicio;
	}

	private JLabel getLblDoble1() {
		if (lblDoble1 == null) {
			lblDoble1 = new JLabel(":");
		}
		return lblDoble1;
	}

	private JSpinner getSpinnerMinInicio() {
		if (spinnerMinInicio == null) {
			spinnerMinInicio = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
			((DefaultEditor) spinnerMinInicio.getEditor()).getTextField().setEditable(false);
		}
		return spinnerMinInicio;
	}

	private JComboBox getCBoxAMInicio() {
		if (cBoxAMInicio == null) {
			cBoxAMInicio = new JComboBox();
			cBoxAMInicio.setModel(new DefaultComboBoxModel(new String[] { "AM", "PM" }));
		}
		return cBoxAMInicio;
	}

	private JLabel getLblDoble2() {
		if (lblDoble2 == null) {
			lblDoble2 = new JLabel(":");
		}
		return lblDoble2;
	}

	private JLabel getLblFechaFin() {
		if (lblFechaFin == null) {
			lblFechaFin = new JLabel("Fecha de Finalización");
		}
		return lblFechaFin;
	}

	private JDateChooser getDChFechaFin() {
		if (dChFechaFin == null) {
			dChFechaFin = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		}
		return dChFechaFin;
	}

	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora de Finalización:");
		}
		return lblHoraFin;
	}

	private JSpinner getSpinnerHoraFin() {
		if (spinnerHoraFin == null) {
			spinnerHoraFin = new JSpinner(new SpinnerNumberModel(0, 0, 12, 1));
			((DefaultEditor) spinnerHoraFin.getEditor()).getTextField().setEditable(false);
		}
		return spinnerHoraFin;
	}

	private JLabel getLblDoble3() {
		if (lblDoble3 == null) {
			lblDoble3 = new JLabel(":");
		}
		return lblDoble3;
	}

	private JSpinner getSpinnerMinFin() {
		if (spinnerMinFin == null) {
			spinnerMinFin = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
			((DefaultEditor) spinnerMinFin.getEditor()).getTextField().setEditable(false);
		}
		return spinnerMinFin;
	}

	private JLabel getLblDoble4() {
		if (lblDoble4 == null) {
			lblDoble4 = new JLabel(":");
		}
		return lblDoble4;
	}

	private JComboBox getCBoxAMFin() {
		if (cBoxAMFin == null) {
			cBoxAMFin = new JComboBox();
			cBoxAMFin.setModel(new DefaultComboBoxModel(new String[] { "AM", "PM" }));
		}
		return cBoxAMFin;
	}

	private JLabel getLblTipoEvento() {
		if (lblTipoEvento == null) {
			lblTipoEvento = new JLabel("Tipo de Evento:");
		}
		return lblTipoEvento;
	}

	private JComboBox getCBoxTipoEvento() {
		if (cBoxTipoEvento == null) {
			cBoxTipoEvento = new JComboBox();
			cBoxTipoEvento.setModel(new DefaultComboBoxModel(enums.Evento.values()));
			cBoxTipoEvento.setSelectedItem(null);
		}
		return cBoxTipoEvento;
	}

}

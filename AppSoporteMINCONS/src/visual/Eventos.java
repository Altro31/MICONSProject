package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import classes.Evento;
import classes.Sistema;
import classifications.TipoEvento;
import exceptions.ValidationException;
import util.Auxiliary;
import util.Limites;
import util.Manager;
import util.Validaciones;
import visual.util.PrincipalPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretEvent;

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
	private JLabel lblFechaFin;
	private JDateChooser dChFechaFin;
	private JLabel lblFechaFinError;
	private Sistema sistema = Sistema.getInstance();
	private JLabel lblFechaInicioError;
	private JLabel lblNombreError;
	private JLabel lblTipoEvento;
	private JComboBox<String> cBoxTipoEvento;

	private boolean checkNombre = false;
	private boolean checkTipoEvento = false;
	private boolean checkFechaInicio = false;
	private boolean checkFechaFin = false;

	/**
	 * Create the panel.
	 */
	public Eventos() {
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager.guardarDatos();
				System.exit(0);
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.removerActual();
			}
		});
		add(getPanelNuevoEvento());
		add(getPanelDatos());
		add(getPanelBotones());
	}

	private boolean checkAllFields() {

		checkFieldTipoEvento();
		checkFieldName();
		checkFieldFechaInicio();
		checkFieldFechaFin();

		return checkNombre && checkTipoEvento && checkFechaInicio && checkFechaFin;
	}

	private void checkFieldName() {

		String name = textNombre.getText();
		try {
			Validaciones.nombreEvento(name);
			lblNombreError.setText("");
			lblNombre.setForeground(Color.BLACK);
			checkNombre = true;
		} catch (ValidationException e) {

			lblNombre.setForeground(Color.RED);

			checkNombre = false;

			String message = e.getMessage();

			if (message.equals(ValidationException.EXIST)) {
				lblNombreError.setText("Ya existe un evento con el nombre \"" + name + "\"");
			}
		}
	}

	private void checkFieldTipoEvento() {

		TipoEvento evento = null;
		try {
			evento = TipoEvento.getTipoEvento(cBoxTipoEvento.getSelectedItem().toString());
			Validaciones.tipoEvento(evento);
			lblTipoEvento.setForeground(Color.BLACK);
			checkTipoEvento = true;

		} catch (ValidationException | NullPointerException e) {
			lblTipoEvento.setForeground(Color.RED);
			checkTipoEvento = false;
		}
	}

	private void checkFieldFechaInicio() {

		try {
			Validaciones.fechaInicio(dChFechaInicio.getCalendar());
			lblFechaInicio.setForeground(Color.BLACK);
			lblFechaInicioError.setText("");
			checkFechaInicio = true;
		} catch (ValidationException e) {
			checkFechaInicio = false;
			lblFechaInicio.setForeground(Color.RED);
			GregorianCalendar today = new GregorianCalendar();
			if (e.getMessage().equals(ValidationException.DATE_WRONG)) {
				lblFechaInicioError.setText("La Fecha de Inicio no puede ocurrir despúes del "
						+ today.get(Calendar.DATE) + "/" + today.get(Calendar.MONTH) + "/" + today.get(Calendar.YEAR));
			}
		}
	}

	private void checkFieldFechaFin() {

		try {
			Validaciones.fechaFin(dChFechaInicio.getCalendar(), dChFechaFin.getCalendar());
			lblFechaFin.setForeground(Color.BLACK);
			lblFechaFinError.setText("");
			checkFechaFin = true;
		} catch (ValidationException e) {
			checkFechaFin = false;
			lblFechaFin.setForeground(Color.RED);
			GregorianCalendar today = new GregorianCalendar();
			if (e.getMessage().equals(ValidationException.DATE_WRONG)) {
				lblFechaFinError.setText("La Fecha de Fin no puede ocurrir despúes del " + today.get(Calendar.DATE)
						+ "/" + today.get(Calendar.MONTH) + "/" + today.get(Calendar.YEAR));
			}
			if (e.getMessage().equals(ValidationException.DATE_ERROR)) {
				lblFechaFinError.setText("La Fecha de Fin no puede ocurrir antes que la fecha de Inicio");
			}
		}
	}

	// Getters for components
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
			gl_panelDatos.setHorizontalGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING).addGroup(gl_panelDatos
					.createSequentialGroup().addGap(130)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblTipoEvento(), GroupLayout.PREFERRED_SIZE, 237,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblNombre(), GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblFechaInicio(), GroupLayout.PREFERRED_SIZE, 40,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblFechaFin(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblFechaFinError(), GroupLayout.PREFERRED_SIZE, 40,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getCBoxTipoEvento(), GroupLayout.PREFERRED_SIZE, 191,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getTextNombre(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(getDChFechaInicio(), GroupLayout.PREFERRED_SIZE, 40,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getDChFechaFin(), GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblNombreError(), GroupLayout.PREFERRED_SIZE, 277,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblFechaInicioError(), GroupLayout.PREFERRED_SIZE, 382,
									GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE)));
			gl_panelDatos.setVerticalGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelDatos.createSequentialGroup()
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelDatos.createSequentialGroup().addGap(37)
											.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblTipoEvento(), GroupLayout.PREFERRED_SIZE, 21,
															GroupLayout.PREFERRED_SIZE)
													.addComponent(getCBoxTipoEvento(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(31)
											.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblNombre())
													.addComponent(getTextNombre(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(33)
											.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
													.addComponent(getLblFechaInicio()).addComponent(getDChFechaInicio(),
															GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
											.addGap(33)
											.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
													.addComponent(getLblFechaFin())
													.addComponent(getDChFechaFin(), GroupLayout.PREFERRED_SIZE, 12,
															GroupLayout.PREFERRED_SIZE)))
									.addGroup(
											gl_panelDatos.createSequentialGroup().addContainerGap(109, Short.MAX_VALUE)
													.addComponent(getLblNombreError(), GroupLayout.PREFERRED_SIZE, 16,
															GroupLayout.PREFERRED_SIZE)
													.addGap(38)
													.addComponent(getLblFechaInicioError(), GroupLayout.PREFERRED_SIZE,
															10, GroupLayout.PREFERRED_SIZE)
													.addGap(44)))
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(getLblFechaFinError(),
									GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(89)));
			gl_panelDatos.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblTipoEvento(), getLblNombre(), getLblFechaInicio(), getLblFechaFin() });
			gl_panelDatos.linkSize(SwingConstants.VERTICAL,
					new Component[] { getCBoxTipoEvento(), getTextNombre(), getDChFechaInicio(), getDChFechaFin() });
			gl_panelDatos.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblFechaInicioError(), getLblNombreError() });
			gl_panelDatos.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getLblFechaFinError(), getLblFechaInicioError(), getLblNombreError() });
			gl_panelDatos.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getLblTipoEvento(), getLblNombre(), getLblFechaInicio(), getLblFechaFin() });
			gl_panelDatos.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getCBoxTipoEvento(), getTextNombre(), getDChFechaInicio(), getDChFechaFin() });
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
					if (checkAllFields()) {

						GregorianCalendar fechaInicio = new GregorianCalendar(
								dChFechaInicio.getCalendar().get(Calendar.YEAR),
								dChFechaInicio.getCalendar().get(Calendar.MONTH),
								dChFechaInicio.getCalendar().get(Calendar.DATE));
						GregorianCalendar fechaFin = new GregorianCalendar(dChFechaFin.getCalendar().get(Calendar.YEAR),
								dChFechaFin.getCalendar().get(Calendar.MONTH),
								dChFechaFin.getCalendar().get(Calendar.DATE));

						FichasTecnicas fichasTecnicas = new FichasTecnicas();

						Evento evento = (Evento) (Frame.getPosicionActual()[1]);
						evento.setNombre(textNombre.getText());
						evento.setFechaInicio(fechaInicio);
						evento.setFechaFin(fechaFin);
						evento.setTipoEvento(
								TipoEvento.getTipoEvento(getCBoxTipoEvento().getSelectedItem().toString()));

						Frame.addRuta(fichasTecnicas, evento);
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
					Frame.anteriorPrincipal(1);
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
			Auxiliary.onlyLetters(textNombre, true);
			Auxiliary.limite(textNombre, Limites.nombreEvento());
			textNombre.setColumns(10);
			textNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkFieldName();
				}
			});
		}
		return textNombre;
	}

	private JLabel getLblFechaInicio() {
		if (lblFechaInicio == null) {
			lblFechaInicio = new JLabel("Fecha de Inicio:");
			lblFechaInicio.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblFechaInicio;
	}

	private JDateChooser getDChFechaInicio() {
		if (dChFechaInicio == null) {
			dChFechaInicio = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');

			((JTextField) dChFechaInicio.getComponent(1)).getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					checkFieldFechaInicio();
					dChFechaFin.setEnabled(true);
					if (dChFechaFin.getCalendar() != null)
						checkFieldFechaFin();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
				}
			});

			Auxiliary.noData((JTextField) dChFechaInicio.getComponent(1));
		}
		return dChFechaInicio;
	}

	private JLabel getLblFechaFin() {
		if (lblFechaFin == null) {
			lblFechaFin = new JLabel("Fecha de Finalización:");
			lblFechaFin.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblFechaFin;
	}

	private JDateChooser getDChFechaFin() {
		if (dChFechaFin == null) {
			dChFechaFin = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
			dChFechaFin.setEnabled(false);

			((JTextField) dChFechaFin.getComponent(1)).getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					checkFieldFechaFin();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
				}
			});

			Auxiliary.noData((JTextField) dChFechaFin.getComponent(1));

		}
		return dChFechaFin;
	}

	private JLabel getLblFechaFinError() {
		if (lblFechaFinError == null) {
			lblFechaFinError = new JLabel("");
			lblFechaFinError.setForeground(new Color(255, 0, 0));
		}
		return lblFechaFinError;
	}

	private JLabel getLblFechaInicioError() {
		if (lblFechaInicioError == null) {
			lblFechaInicioError = new JLabel("");
			lblFechaInicioError.setBounds(0, 0, 40, 40);
			lblFechaInicioError.setForeground(new Color(255, 0, 0));
		}
		return lblFechaInicioError;
	}

	private JLabel getLblNombreError() {
		if (lblNombreError == null) {
			lblNombreError = new JLabel("");
			lblNombreError.setForeground(Color.RED);
		}
		return lblNombreError;
	}

	private JLabel getLblTipoEvento() {
		if (lblTipoEvento == null) {
			lblTipoEvento = new JLabel("Tipo de Evento:");
			lblTipoEvento.setForeground(new Color(0, 0, 0));
			lblTipoEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblTipoEvento;
	}

	private JComboBox<String> getCBoxTipoEvento() {
		if (cBoxTipoEvento == null) {
			cBoxTipoEvento = new JComboBox<String>();
			cBoxTipoEvento.setFocusable(false);
			cBoxTipoEvento.setModel(new DefaultComboBoxModel<String>(TipoEvento.getValues().toArray(new String[0])));
			cBoxTipoEvento.setSelectedItem(null);
			cBoxTipoEvento.setBackground(Color.WHITE);
			cBoxTipoEvento.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					checkFieldTipoEvento();
				}
			});
		}
		return cBoxTipoEvento;
	}
}

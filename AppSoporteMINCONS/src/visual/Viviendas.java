package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import classes.FichaTecnica;
import classes.Vivienda;
import classifications.Doc;
import classifications.TipoConst;
import classifications.TipoHab;
import exceptions.ValidationException;
import util.Auxiliary;
import util.Limites;
import util.Manager;
import util.Validaciones;
import util.Value;
import visual.util.PrincipalPanel;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Viviendas extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8578831301242017695L;
	private JLabel lblName;
	private JPanel panelButton2;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JPanel panelProp;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblCI;
	private JTextField txtCI;
	private JLabel lblDocLegal;
	private JComboBox<String> combDocLegal;
	private JLabel lblTipoHab;
	private JComboBox<String> combTipoHab;
	private JLabel lblTipoCons;
	private JComboBox<String> combTipoCons;
	private JLabel lblDimensiones;
	private JLabel lblLargo;
	private JTextField txtLargo;
	private JTextField txtAncho;
	private JLabel lblAncho;
	private JLabel lblArea;
	private JTextField txtArea;
	private JLabel lblSenso;
	private JLabel lblAncianos;
	private JSpinner spinnerAncianos;
	private JLabel lblInfantes;
	private JSpinner spinnerInfantes;
	private JLabel lblEmbarazadas;
	private JSpinner spinnerEmbarazadas;
	private JLabel lblTotalPersonas;
	private JSpinner spinnerPersonas;
	private JSeparator separador;
	private Value ancianosPreviuosValue = new Value(0);
	private Value infantesPreviousValue = new Value(0);
	private Value embarazadasPreviousValue = new Value(0);
	private JLabel lblDireccionError;
	private JLabel lblCIError;
	private JLabel lblErrorTotalPersonas;
	private boolean checkDireccion;
	private boolean checkCI;
	private boolean checkPersonas;

	/**
	 * Create the panel.
	 */
	public Viviendas() {

		checkDireccion = false;
		checkCI = false;
		checkPersonas = false;

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager.guardarDatos();
				System.exit(0);
			}
		});
		add(getLblName());
		add(getPanelProp());
		add(getPanelButton2());

		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.removerActual();
			}
		});
	}

	private void checkFieldDireccion() {
		try {
			Validaciones.direccion(txtDireccion.getText());
			lblDireccion.setForeground(Color.BLACK);
			lblDireccionError.setText("");
			checkDireccion = true;
		} catch (ValidationException e) {
			lblDireccion.setForeground(Color.RED);
			checkDireccion = false;
			if (e.getMessage().equals(ValidationException.OUT_OF_RANGE))
				lblDireccionError.setText("La dirección debe tener entre 1 y " + Limites.direccion() + " caracteres");
		}
	}

	private void checkFieldCI() {
		try {
			Validaciones.ci(txtCI.getText());
			lblCI.setForeground(Color.BLACK);
			lblCIError.setText("");
			checkCI = true;
		} catch (ValidationException e) {
			lblCI.setForeground(Color.RED);
			checkCI = false;
			if (e.getMessage().equals(ValidationException.DATE_ERROR))
				lblCIError.setText("Carnet no válido");
			if (e.getMessage().equals(ValidationException.AGE_WRONG))
				lblCIError.setText("La edad debe estar entre 18 y 100 años");
		}
	}

	private void checkFieldTotalPersonas() {

		try {
			Validaciones.totalPresonas((int) spinnerPersonas.getValue(), ((int) spinnerAncianos.getValue())
					+ ((int) spinnerInfantes.getValue()) + ((int) spinnerEmbarazadas.getValue()));
			lblErrorTotalPersonas.setVisible(false);
			lblTotalPersonas.setForeground(Color.BLACK);
			checkPersonas = true;

		} catch (ValidationException e) {
			lblTotalPersonas.setForeground(Color.RED);
			checkPersonas = false;
			if (e.getMessage().equals(ValidationException.OUT_OF_RANGE))
				lblErrorTotalPersonas.setVisible(true);
		}
	}

	private JPanel getPanelButton2() {
		if (panelButton2 == null) {
			panelButton2 = new JPanel();
			panelButton2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButton2.setBounds(37, 431, 816, 46);
			panelButton2.setLayout(null);
			panelButton2.add(getBtnSiguiente());
			panelButton2.add(getBtnCancelar());
		}
		return panelButton2;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Propiedades de la Viviendas");
			lblName.setOpaque(true);
			lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblName.setHorizontalTextPosition(SwingConstants.CENTER);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
			lblName.setBounds(37, 28, 816, 36);
		}
		return lblName;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setFocusable(false);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (!getTxtDireccion().getText().isEmpty()
							&& !(getTxtCI().getText().isEmpty() || getTxtCI().getText().length() != 11)
							&& !getTxtLargo().getText().isEmpty() && !getTxtAncho().getText().isEmpty()
							&& !getTxtArea().getText().isEmpty() && combDocLegal.getSelectedItem() != null
							&& combTipoCons.getSelectedItem() != null && combTipoHab.getSelectedItem() != null) {
						FichaTecnica ficha = (FichaTecnica) Frame.getPosicionActual()[1];

						Vivienda vivienda = ficha.getVivienda();
						vivienda.setDireccion(txtDireccion.getText());
						vivienda.setCiJefe(txtCI.getText());
						vivienda.setDocLegal(Doc.value(combDocLegal.getSelectedItem().toString()));
						vivienda.setTipoHabitacional(TipoHab.getTipoHab(combTipoHab.getSelectedItem().toString()));
						vivienda.setTipoConstructiva(TipoConst.valueOf(combTipoCons.getSelectedItem().toString()));
						vivienda.setLargo(Float.parseFloat(getTxtLargo().getText()));
						vivienda.setAncho(Float.parseFloat(getTxtAncho().getText()));
						vivienda.setTotalPersonas(Integer.parseInt(getSpinnerPersonas().getValue().toString()));
						vivienda.setTotalInfantes(Integer.parseInt(getSpinnerInfantes().getValue().toString()));
						vivienda.setTotalAncianos(Integer.parseInt(getSpinnerAncianos().getValue().toString()));
						vivienda.setTotalEmbarazadas(Integer.parseInt(getSpinnerEmbarazadas().getValue().toString()));

						Frame.setContentPanes((Afectaciones) ((Object[]) Frame.getPosicionActual()[0])[1]);

					} else {

						validarCampos();

					}
				}
			});
			btnSiguiente.setBounds(224, 11, 89, 23);
		}
		return btnSiguiente;
	}

	private void validarCampos() {

		lblDireccion.setForeground(getTxtDireccion().getText().isEmpty() ? Color.RED : Color.BLACK);

		lblCI.setForeground(
				(getTxtCI().getText().isEmpty() || getTxtCI().getText().length() != 11) ? Color.RED : Color.BLACK);

		lblLargo.setForeground(getTxtLargo().getText().isEmpty() ? Color.RED : Color.BLACK);

		lblAncho.setForeground(getTxtAncho().getText().isEmpty() ? Color.RED : Color.BLACK);

		lblArea.setForeground(getTxtArea().getText().isEmpty() ? Color.RED : Color.BLACK);

		lblDocLegal.setForeground(combDocLegal.getSelectedItem() == null ? Color.RED : Color.BLACK);

		lblTipoHab.setForeground(combTipoHab.getSelectedItem() == null ? Color.RED : Color.BLACK);

		lblTipoCons.setForeground(combTipoCons.getSelectedItem() == null ? Color.RED : Color.BLACK);

	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFocusable(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame.anteriorPrincipal(1);
				}
			});
			btnCancelar.setBounds(537, 11, 89, 23);
		}
		return btnCancelar;
	}

	private JPanel getPanelProp() {
		if (panelProp == null) {
			panelProp = new JPanel();
			panelProp.setBounds(37, 70, 817, 356);
			panelProp.setLayout(null);
			panelProp.add(getLblDireccion());
			panelProp.add(getTxtDireccion());
			panelProp.add(getLblCI());
			panelProp.add(getTxtCI());
			panelProp.add(getLblDocLegal());
			panelProp.add(getCombDocLegal());
			panelProp.add(getLblTipoHab());
			panelProp.add(getCombTipoHab());
			panelProp.add(getLblTipoCons());
			panelProp.add(getCombTipoCons());
			panelProp.add(getLblDimensiones());
			panelProp.add(getLblLargo());
			panelProp.add(getTxtLargo());
			panelProp.add(getTxtAncho());
			panelProp.add(getLblAncho());
			panelProp.add(getLblArea());
			panelProp.add(getTxtArea());
			panelProp.add(getLblSenso());
			panelProp.add(getLblAncianos());
			panelProp.add(getSpinnerAncianos());
			panelProp.add(getLblInfantes());
			panelProp.add(getSpinnerInfantes());
			panelProp.add(getLblEmbarazadas());
			panelProp.add(getSpinnerEmbarazadas());
			panelProp.add(getLblTotalPersonas());
			panelProp.add(getSpinnerPersonas());
			panelProp.add(getSeparador());
			panelProp.add(getLblDireccionError());
			panelProp.add(getLblCIError());
			panelProp.add(getLblErrorTotalPersonas());
		}
		return panelProp;
	}

	private JLabel getLblDireccion() {
		if (lblDireccion == null) {
			lblDireccion = new JLabel("Dirección:");
			lblDireccion.setHorizontalAlignment(SwingConstants.TRAILING);
			lblDireccion.setBounds(44, 11, 152, 24);
		}
		return lblDireccion;
	}

	private JTextField getTxtDireccion() {
		if (txtDireccion == null) {
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			Auxiliary.limite(txtDireccion, Limites.direccion());
			txtDireccion.setBounds(206, 13, 226, 21);
			txtDireccion.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
					checkFieldDireccion();

				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					checkFieldDireccion();

				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// Innesesario
				}
			});

		}
		return txtDireccion;
	}

	private JLabel getLblCI() {
		if (lblCI == null) {
			lblCI = new JLabel("CI del Jefe de Viviendas:");
			lblCI.setHorizontalAlignment(SwingConstants.TRAILING);
			lblCI.setBounds(44, 56, 152, 14);
		}
		return lblCI;
	}

	private JTextField getTxtCI() {
		if (txtCI == null) {
			txtCI = new JTextField();
			Auxiliary.onlyNumbers(txtCI, false);
			Auxiliary.limite(txtCI, 11);
			txtCI.setColumns(10);
			txtCI.setBounds(205, 53, 226, 21);
			txtCI.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
					checkFieldCI();

				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					checkFieldCI();

				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// Innesesario
				}
			});
		}
		return txtCI;
	}

	private JLabel getLblDocLegal() {
		if (lblDocLegal == null) {
			lblDocLegal = new JLabel("Documento Legal:");
			lblDocLegal.setHorizontalAlignment(SwingConstants.TRAILING);
			lblDocLegal.setBounds(44, 93, 152, 24);
		}
		return lblDocLegal;
	}

	private JComboBox<String> getCombDocLegal() {
		if (combDocLegal == null) {
			combDocLegal = new JComboBox(Doc.names());
			combDocLegal.setSelectedItem(null);
			combDocLegal.setBounds(205, 95, 226, 21);
		}
		return combDocLegal;
	}

	private JLabel getLblTipoHab() {
		if (lblTipoHab == null) {
			lblTipoHab = new JLabel("Tipología Habitacional:");
			lblTipoHab.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTipoHab.setBounds(44, 139, 152, 21);
		}
		return lblTipoHab;
	}

	private JComboBox<String> getCombTipoHab() {
		if (combTipoHab == null) {
			combTipoHab = new JComboBox(TipoHab.getValues().toArray());
			combTipoHab.setSelectedItem(null);
			combTipoHab.setBounds(205, 139, 226, 21);
		}
		return combTipoHab;
	}

	private JLabel getLblTipoCons() {
		if (lblTipoCons == null) {
			lblTipoCons = new JLabel("Tipología Constructiva:");
			lblTipoCons.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTipoCons.setBounds(44, 182, 152, 23);
		}
		return lblTipoCons;
	}

	private JComboBox<String> getCombTipoCons() {
		if (combTipoCons == null) {
			combTipoCons = new JComboBox(TipoConst.values());
			combTipoCons.setSelectedItem(null);
			combTipoCons.setBounds(205, 183, 226, 21);
		}
		return combTipoCons;
	}

	private JLabel getLblDimensiones() {
		if (lblDimensiones == null) {
			lblDimensiones = new JLabel("Dimensiones de la Viviendas (en metros):");
			lblDimensiones.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDimensiones.setBounds(144, 219, 242, 21);
		}
		return lblDimensiones;
	}

	private JLabel getLblLargo() {
		if (lblLargo == null) {
			lblLargo = new JLabel("Largo (m):");
			lblLargo.setHorizontalAlignment(SwingConstants.TRAILING);
			lblLargo.setBounds(44, 252, 67, 23);
		}
		return lblLargo;
	}

	private JTextField getTxtLargo() {
		if (txtLargo == null) {
			txtLargo = new JFormattedTextField();
			txtLargo.setHorizontalAlignment(SwingConstants.CENTER);
			txtLargo.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					reset(txtLargo);
				}
			});
			txtLargo.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
					calcularArea();

				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					calcularArea();

				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// Innesesario
				}
			});

			Auxiliary.onlyNumbers(txtLargo, true);
			txtLargo.setColumns(10);
			txtLargo.setBounds(116, 252, 95, 23);
		}
		return txtLargo;
	}

	private void reset(JTextField c) {
		try {
			if (Float.parseFloat(c.getText()) < Limites.dimensions())
				c.setText(Limites.dimensions() + "");
		} catch (NumberFormatException e) {
			c.setText("");
		}
	}

	private JTextField getTxtAncho() {
		if (txtAncho == null) {
			txtAncho = new JTextField();
			txtAncho.setHorizontalAlignment(SwingConstants.CENTER);
			txtAncho.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					reset(txtAncho);
				}
			});
			txtAncho.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
					calcularArea();

				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					calcularArea();

				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// Innesesario
				}
			});
			txtAncho.setColumns(10);
			Auxiliary.onlyNumbers(txtAncho, true);
			txtAncho.setBounds(116, 300, 95, 23);
		}
		return txtAncho;
	}

	private void calcularArea() {
		float result = 0;
		String ancho = txtAncho.getText();
		String largo = txtLargo.getText();
		if (!ancho.isEmpty() && !largo.isEmpty()) {
			result = Float.parseFloat(txtLargo.getText()) * Float.parseFloat(txtAncho.getText());
		}
		txtArea.setText(result + "");
	}

	private JLabel getLblAncho() {
		if (lblAncho == null) {
			lblAncho = new JLabel("Ancho (m):");
			lblAncho.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAncho.setBounds(44, 300, 67, 23);
		}
		return lblAncho;
	}

	private JLabel getLblArea() {
		if (lblArea == null) {
			lblArea = new JLabel("Área (m²):");
			lblArea.setHorizontalAlignment(SwingConstants.TRAILING);
			lblArea.setBounds(241, 276, 60, 23);
		}
		return lblArea;
	}

	private JTextField getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextField();
			txtArea.setHorizontalAlignment(SwingConstants.CENTER);
			txtArea.setEditable(false);
			txtArea.setColumns(10);
			Auxiliary.onlyNumbers(txtArea, true);
			txtArea.setBounds(303, 276, 95, 23);
		}
		return txtArea;
	}

	private JLabel getLblSenso() {
		if (lblSenso == null) {
			lblSenso = new JLabel("Cantidad de Habitantes:");
			lblSenso.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSenso.setBounds(571, 16, 152, 14);
		}
		return lblSenso;
	}

	private JLabel getLblAncianos() {
		if (lblAncianos == null) {
			lblAncianos = new JLabel("Ancianos:");
			lblAncianos.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAncianos.setBounds(507, 49, 143, 28);
		}
		return lblAncianos;
	}

	private JSpinner getSpinnerAncianos() {
		if (spinnerAncianos == null) {
			spinnerAncianos = new JSpinner(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0),
					Limites.ancianos(), Integer.valueOf(1)));
			spinnerAncianos.setBounds(660, 49, 44, 28);
			((DefaultEditor) (spinnerAncianos.getEditor())).getTextField().setEditable(false);
		}
		return spinnerAncianos;
	}

	private JLabel getLblInfantes() {
		if (lblInfantes == null) {
			lblInfantes = new JLabel("Infantes:");
			lblInfantes.setHorizontalAlignment(SwingConstants.TRAILING);
			lblInfantes.setBounds(507, 91, 143, 28);
		}
		return lblInfantes;
	}

	private JSpinner getSpinnerInfantes() {
		if (spinnerInfantes == null) {
			spinnerInfantes = new JSpinner(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0),
					Limites.infantes(), Integer.valueOf(1)));
			spinnerInfantes.setBounds(660, 91, 44, 28);
			((DefaultEditor) (spinnerInfantes.getEditor())).getTextField().setEditable(false);
		}
		return spinnerInfantes;
	}

	private JLabel getLblEmbarazadas() {
		if (lblEmbarazadas == null) {
			lblEmbarazadas = new JLabel("Embarazadas:");
			lblEmbarazadas.setHorizontalAlignment(SwingConstants.TRAILING);
			lblEmbarazadas.setBounds(507, 139, 143, 28);
		}
		return lblEmbarazadas;
	}

	private JSpinner getSpinnerEmbarazadas() {
		if (spinnerEmbarazadas == null) {
			spinnerEmbarazadas = new JSpinner(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0),
					Limites.embarazadas(), Integer.valueOf(1)));
			spinnerEmbarazadas.setBounds(660, 135, 44, 28);
			((DefaultEditor) (spinnerEmbarazadas.getEditor())).getTextField().setEditable(false);
		}
		return spinnerEmbarazadas;
	}

	private JLabel getLblTotalPersonas() {
		if (lblTotalPersonas == null) {
			lblTotalPersonas = new JLabel("Total de Personas");
			lblTotalPersonas.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTotalPersonas.setBounds(507, 180, 143, 28);
		}
		return lblTotalPersonas;
	}

	private JSpinner getSpinnerPersonas() {
		if (spinnerPersonas == null) {
			spinnerPersonas = new JSpinner(new SpinnerNumberModel(
					Integer.valueOf(0), Integer.valueOf(((int) spinnerAncianos.getValue())
							+ ((int) spinnerInfantes.getValue()) + ((int) spinnerEmbarazadas.getValue())),
					Limites.totalPersonal(), Integer.valueOf(1)));
			spinnerPersonas.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					checkFieldTotalPersonas();
				}
			});
			Auxiliary.linkSpinners(spinnerAncianos, spinnerPersonas, ancianosPreviuosValue);
			Auxiliary.linkSpinners(spinnerInfantes, spinnerPersonas, infantesPreviousValue);
			Auxiliary.linkSpinners(spinnerEmbarazadas, spinnerPersonas, embarazadasPreviousValue);
			spinnerPersonas.setBounds(660, 180, 44, 28);
			((DefaultEditor) (spinnerPersonas.getEditor())).getTextField().setEditable(false);
			spinnerPersonas.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					
					if(((Integer)spinnerPersonas.getValue()).compareTo(Integer.valueOf(((int) spinnerAncianos.getValue())
							+ ((int) spinnerInfantes.getValue()) + ((int) spinnerEmbarazadas.getValue())))<0)
						spinnerPersonas.setValue(((int) spinnerAncianos.getValue())
								+ ((int) spinnerInfantes.getValue()) + ((int) spinnerEmbarazadas.getValue()));
					
				}
			});
		}
		return spinnerPersonas;
	}

	private JSeparator getSeparador() {
		if (separador == null) {
			separador = new JSeparator();
			separador.setOrientation(SwingConstants.VERTICAL);
			separador.setBounds(476, 11, 21, 316);
		}
		return separador;
	}

	public void actualizarCampos(Vivienda vivienda) {

		txtDireccion.setText(vivienda.getDireccion());
		txtCI.setText(vivienda.getCiJefe());
		combDocLegal.setSelectedItem(vivienda.getDocLegal().getName());
		combTipoCons.setSelectedItem(vivienda.getTipoConstructiva().name());
		combTipoHab.setSelectedItem(vivienda.getTipoHabitacional().getName());
		txtLargo.setText(vivienda.getLargo() + "");
		txtAncho.setText(vivienda.getAncho() + "");
		txtArea.setText(vivienda.calcularArea() + "");
		spinnerAncianos.setValue(vivienda.getTotalAncianos());
		spinnerInfantes.setValue(vivienda.getTotalInfantes());
		spinnerEmbarazadas.setValue(vivienda.getTotalEmbarazadas());
		spinnerPersonas.setValue(vivienda.getTotalPersonas());

	}

	private JLabel getLblDireccionError() {
		if (lblDireccionError == null) {
			lblDireccionError = new JLabel("");
			lblDireccionError.setForeground(new Color(255, 0, 0));
			lblDireccionError.setBounds(206, 34, 269, 14);
		}
		return lblDireccionError;
	}

	private JLabel getLblCIError() {
		if (lblCIError == null) {
			lblCIError = new JLabel("");
			lblCIError.setForeground(Color.RED);
			lblCIError.setBounds(206, 74, 269, 14);
		}
		return lblCIError;
	}

	private JLabel getLblErrorTotalPersonas() {
		if (lblErrorTotalPersonas == null) {
			lblErrorTotalPersonas = new JLabel(
					"Error: El total de personas excede el establecido (" + Limites.totalPersonal() + ")");
			lblErrorTotalPersonas.setHorizontalAlignment(SwingConstants.CENTER);
			lblErrorTotalPersonas.setHorizontalTextPosition(SwingConstants.CENTER);
			lblErrorTotalPersonas.setVisible(false);
			lblErrorTotalPersonas.setBorder(new LineBorder(new Color(255, 0, 0)));
			lblErrorTotalPersonas.setForeground(Color.RED);
			lblErrorTotalPersonas.setBounds(487, 227, 320, 24);
		}
		return lblErrorTotalPersonas;
	}
}

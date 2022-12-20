package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import clases.FichaTecnica;
import clases.Vivienda;
import enums.Doc;
import enums.TipoConst;
import enums.TipoHab;
import util.Auxiliary;
import util.Manager;
import util.Validaciones;
import util.Value;
import visual.util.PrincipalPanel;

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

	/**
	 * Create the panel.
	 */
	public Viviendas() {
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
				Frame.removerRuta(Frame.getPosicionActual()[0]);
				Frame.setContentPanes((FichasTecnicas) Frame.getPosicionActual()[0]);
			}
		});
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
						FichaTecnica ficha = (FichaTecnica)Frame.getPosicionActual()[1];
						
//						ficha.setVivienda(new Vivienda(getTxtDireccion().getText(), getTxtCI().getText(),
//								Doc.getValue(getCombDocLegal().getSelectedItem().toString()),
//								TipoHab.getValue(getCombTipoHab().getSelectedItem().toString()),
//								TipoConst.getValue(getCombTipoCons().getSelectedItem().toString()),
//								Double.parseDouble(getTxtLargo().getText()),
//								Double.parseDouble(getTxtAncho().getText()), Double.parseDouble(getTxtArea().getText()),
//								Integer.parseInt(getSpinnerPersonas().getValue().toString()),
//								Integer.parseInt(getSpinnerInfantes().getValue().toString()),
//								Integer.parseInt(getSpinnerAncianos().getValue().toString()),
//								Integer.parseInt(getSpinnerEmbarazadas().getValue().toString())));

						Vivienda vivienda = ficha.getVivienda();
						vivienda.setDireccion(txtDireccion.getText());
						vivienda.setCiJefe(txtCI.getText());
						vivienda.setDocLegal(Doc.getValue(combDocLegal.getSelectedItem().toString()));
						vivienda.setTipoHabitacional(TipoHab.getValue(combTipoHab.getSelectedItem().toString()));
						vivienda.setTipoConstructiva(TipoConst.getValue(combTipoCons.getSelectedItem().toString()));
						vivienda.setLargo(Double.parseDouble(getTxtLargo().getText()));
						vivienda.setAncho(Double.parseDouble(getTxtAncho().getText()));
						vivienda.setArea(Double.parseDouble(getTxtArea().getText()));
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
					Frame.removerRuta(Frame.get(3)[0]);
					Frame.setContentPanes((FichasTecnicas) Frame.getPosicionActual()[0]);
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
			txtDireccion.setBounds(206, 13, 226, 21);
			
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
			Validaciones.soloNumeros(txtCI, false);
			Validaciones.limitar(txtCI, 11);
			txtCI.setColumns(10);
			txtCI.setBounds(205, 53, 226, 21);
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
			String[] items = { "Propiedad", "Usufructo", "Viviendas Vinculada", "Arrendamiento", "Providencia",
					"Indocumentado" };
			combDocLegal = new JComboBox(items);
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
			String[] items = { "Casa", "Apartamento", "Bohío", "Otro" };
			combTipoHab = new JComboBox(items);
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
			String[] items = { "I", "II", "III", "IV", "V" };
			combTipoCons = new JComboBox(items);
			combTipoCons.setSelectedItem(null);
			combTipoCons.setBounds(205, 183, 226, 21);
		}
		return combTipoCons;
	}

	private JLabel getLblDimensiones() {
		if (lblDimensiones == null) {
			lblDimensiones = new JLabel("Dimensiones de la Viviendas:");
			lblDimensiones.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDimensiones.setBounds(144, 219, 198, 21);
		}
		return lblDimensiones;
	}

	private JLabel getLblLargo() {
		if (lblLargo == null) {
			lblLargo = new JLabel("Largo:");
			lblLargo.setHorizontalAlignment(SwingConstants.TRAILING);
			lblLargo.setBounds(60, 252, 44, 23);
		}
		return lblLargo;
	}

	private JTextField getTxtLargo() {
		if (txtLargo == null) {
			txtLargo = new JFormattedTextField();
			txtLargo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					 {
						txtArea.setText(calcularArea(txtAncho.getText(), txtLargo.getText()) + "");
					}
				}
			});
			Validaciones.soloNumeros(txtLargo, true);
			txtLargo.setColumns(10);
			txtLargo.setBounds(116, 252, 95, 23);
		}
		return txtLargo;
	}
	
	private float calcularArea(String ancho, String largo) {
		float result = 0;
		if (!ancho.isEmpty() && !largo.isEmpty()) {
			result = Auxiliary.calcularArea(Float.parseFloat(txtLargo.getText()),
					Float.parseFloat(txtAncho.getText()));
		}
		return result;
	}
	private JTextField getTxtAncho() {
		if (txtAncho == null) {
			txtAncho = new JTextField();
			txtAncho.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					txtArea.setText(calcularArea(txtAncho.getText(), txtLargo.getText()) + "");
				}
			});
			txtAncho.setColumns(10);
			Validaciones.soloNumeros(txtAncho, true);
			txtAncho.setBounds(114, 300, 95, 23);
		}
		return txtAncho;
	}

	private JLabel getLblAncho() {
		if (lblAncho == null) {
			lblAncho = new JLabel("Ancho:");
			lblAncho.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAncho.setBounds(60, 300, 44, 23);
		}
		return lblAncho;
	}

	private JLabel getLblArea() {
		if (lblArea == null) {
			lblArea = new JLabel("Área:");
			lblArea.setHorizontalAlignment(SwingConstants.TRAILING);
			lblArea.setBounds(247, 276, 44, 23);
		}
		return lblArea;
	}

	private JTextField getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextField();
			txtArea.setEditable(false);
			txtArea.setColumns(10);
			Validaciones.soloNumeros(txtArea, true);
			txtArea.setBounds(303, 276, 95, 23);
		}
		return txtArea;
	}

	private JLabel getLblSenso() {
		if (lblSenso == null) {
			lblSenso = new JLabel("Cantidad de Habitantes:");
			lblSenso.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSenso.setBounds(522, 16, 152, 14);
		}
		return lblSenso;
	}

	private JLabel getLblAncianos() {
		if (lblAncianos == null) {
			lblAncianos = new JLabel("Ancianos:");
			lblAncianos.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAncianos.setBounds(545, 46, 143, 28);
		}
		return lblAncianos;
	}

	private JSpinner getSpinnerAncianos() {
		if (spinnerAncianos == null) {
			spinnerAncianos = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
			spinnerAncianos.setBounds(698, 46, 44, 28);
			((DefaultEditor) (spinnerAncianos.getEditor())).getTextField().setEditable(false);
		}
		return spinnerAncianos;
	}

	private JLabel getLblInfantes() {
		if (lblInfantes == null) {
			lblInfantes = new JLabel("Infantes:");
			lblInfantes.setHorizontalAlignment(SwingConstants.TRAILING);
			lblInfantes.setBounds(545, 92, 143, 28);
		}
		return lblInfantes;
	}

	private JSpinner getSpinnerInfantes() {
		if (spinnerInfantes == null) {
			spinnerInfantes = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
			spinnerInfantes.setBounds(698, 92, 44, 28);
			((DefaultEditor) (spinnerInfantes.getEditor())).getTextField().setEditable(false);
		}
		return spinnerInfantes;
	}

	private JLabel getLblEmbarazadas() {
		if (lblEmbarazadas == null) {
			lblEmbarazadas = new JLabel("Embarazadas:");
			lblEmbarazadas.setHorizontalAlignment(SwingConstants.TRAILING);
			lblEmbarazadas.setBounds(545, 138, 143, 28);
		}
		return lblEmbarazadas;
	}

	private JSpinner getSpinnerEmbarazadas() {
		if (spinnerEmbarazadas == null) {
			spinnerEmbarazadas = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
			spinnerEmbarazadas.setBounds(698, 138, 44, 28);
			((DefaultEditor) (spinnerEmbarazadas.getEditor())).getTextField().setEditable(false);
		}
		return spinnerEmbarazadas;
	}

	private JLabel getLblTotalPersonas() {
		if (lblTotalPersonas == null) {
			lblTotalPersonas = new JLabel("Total de Personas");
			lblTotalPersonas.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTotalPersonas.setBounds(545, 184, 143, 28);
		}
		return lblTotalPersonas;
	}

	private JSpinner getSpinnerPersonas() {
		if (spinnerPersonas == null) {
			spinnerPersonas = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
			spinnerPersonas.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int value = (int) spinnerPersonas.getValue();
					int total = (int) spinnerAncianos.getValue() + (int) spinnerInfantes.getValue()
							+ (int) spinnerEmbarazadas.getValue();
					if (value < total)
						spinnerPersonas.setValue(total);
				}
			});
			Validaciones.relacionarSpinners(spinnerAncianos, spinnerPersonas, ancianosPreviuosValue);
			Validaciones.relacionarSpinners(spinnerInfantes, spinnerPersonas, infantesPreviousValue);
			Validaciones.relacionarSpinners(spinnerEmbarazadas, spinnerPersonas, embarazadasPreviousValue);
			spinnerPersonas.setBounds(698, 184, 44, 28);
			((DefaultEditor) (spinnerPersonas.getEditor())).getTextField().setEditable(false);
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
		txtLargo.setText(vivienda.getLargo()+"");
		txtAncho.setText(vivienda.getAncho()+"");
		txtArea.setText(vivienda.getArea()+"");
		spinnerAncianos.setValue(vivienda.getTotalAncianos());
		spinnerInfantes.setValue(vivienda.getTotalInfantes());
		spinnerEmbarazadas.setValue(vivienda.getTotalEmbarazadas());
		spinnerPersonas.setValue(vivienda.getTotalPersonas());
		
	}
}

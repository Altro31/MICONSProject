package visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import clases.Afectacion;
import clases.Evento;
import clases.FichaTecnica;
import clases.Vivienda;
import enums.Doc;
import enums.TipoConst;
import enums.TipoHab;
import util.PreviousValue;
import util.Validaciones;
import visual.util.PrincipalPanel;

public class Viviendas extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8578831301242017695L;
	private JLabel lblName;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JPanel panelProp;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblCI;
	private JTextField txtCI;
	private JLabel lblDocLegal;
	private JComboBox combDocLegal;
	private JLabel lblTipoHab;
	private JComboBox combTipoHab;
	private JLabel lblTipoCons;
	private JComboBox combTipoCons;
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
	private PreviousValue ancianosPreviuosValue = new PreviousValue(0);
	private PreviousValue infantesPreviousValue = new PreviousValue(0);
	private PreviousValue embarazadasPreviousValue = new PreviousValue(0);
	private Evento evento;

	/**
	 * Create the panel.
	 */
	public Viviendas(Evento evento) {
		this.evento=evento;
		add(getLblName());
		add(getBtnSiguiente());
		add(getBtnCancelar());
		add(getPanelProp());
		btnAtras.addActionListener(getActionBtnAtras());
	}

	private ActionListener getActionBtnAtras() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.removerRuta(Frame.getPosicionActual()[0]);
				Frame.setContentPanes((FichasTecnicas) Frame.getPosicionActual()[0]);
			}
		};
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Propiedades de la Viviendas");
			lblName.setOpaque(true);
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!getTxtDireccion().getText().isEmpty() && !getTxtCI().getText().isEmpty()
							&& !getTxtLargo().getText().isEmpty() && !getTxtAncho().getText().isEmpty()
							&& !getTxtArea().getText().isEmpty()) {
						FichaTecnica ficha = FichaTecnica.getInstance(true);
						ficha.setVivienda(new Vivienda(getTxtDireccion().getText(), getTxtCI().getText(),
								Doc.getValue(getCombDocLegal().getSelectedItem().toString()),
								TipoHab.getValue(getCombTipoHab().getSelectedItem().toString()),
								TipoConst.getValue(getCombTipoCons().getSelectedItem().toString()),
								Double.parseDouble(getTxtLargo().getText()),
								Double.parseDouble(getTxtAncho().getText()), Double.parseDouble(getTxtArea().getText()),
								Integer.parseInt(getSpinnerPersonas().getValue().toString()),
								Integer.parseInt(getSpinnerInfantes().getValue().toString()),
								Integer.parseInt(getSpinnerAncianos().getValue().toString()),
								Integer.parseInt(getSpinnerEmbarazadas().getValue().toString())));

						Afectaciones afectaciones = new Afectaciones(evento);
						Vivienda vivienda = (Vivienda) Frame.getPosicionActual()[1];
						vivienda.setDireccion(getTxtDireccion().getText());
						vivienda.setCiJefe(getTxtCI().getText());
						vivienda.setDocLegal(Doc.getValue(getCombDocLegal().getSelectedItem().toString()));
						vivienda.setTipoHabitacional(TipoHab.getValue(getCombTipoHab().getSelectedItem().toString()));
						vivienda.setTipoConstructiva(TipoConst.getValue(getCombTipoCons().getSelectedItem().toString()));
						vivienda.setLargo(Double.parseDouble(getTxtLargo().getText()));
						vivienda.setAncho(Double.parseDouble(getTxtAncho().getText()));
						vivienda.setArea(Double.parseDouble(getTxtArea().getText()));
						vivienda.setTotalPersonas(Integer.parseInt(getSpinnerPersonas().getValue().toString()));
						vivienda.setTotalInfantes(Integer.parseInt(getSpinnerInfantes().getValue().toString()));
						vivienda.setTotalAncianos(Integer.parseInt(getSpinnerAncianos().getValue().toString()));
						vivienda.setTotalEmbarazadas(Integer.parseInt(getSpinnerEmbarazadas().getValue().toString()));
						
						Frame.addRuta(afectaciones, new Afectacion());
						Frame.setContentPanes(afectaciones);
					}
				}
			});
			btnSiguiente.setBounds(237, 437, 89, 23);
		}
		return btnSiguiente;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame.removerRuta(Frame.get(3)[0]);
					Frame.setContentPanes((FichasTecnicas) Frame.getPosicionActual()[0]);
				}
			});
			btnCancelar.setBounds(563, 437, 89, 23);
		}
		return btnCancelar;
	}

	private JPanel getPanelProp() {
		if (panelProp == null) {
			panelProp = new JPanel();
			panelProp.setBounds(37, 75, 817, 351);
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
			lblDireccion.setBounds(60, 11, 136, 24);
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
			lblCI.setBounds(60, 56, 136, 14);
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
			lblDocLegal.setBounds(60, 93, 141, 24);
		}
		return lblDocLegal;
	}

	private JComboBox getCombDocLegal() {
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
			lblTipoHab.setBounds(60, 139, 141, 21);
		}
		return lblTipoHab;
	}

	private JComboBox getCombTipoHab() {
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
			lblTipoCons.setBounds(60, 182, 141, 23);
		}
		return lblTipoCons;
	}

	private JComboBox getCombTipoCons() {
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
			lblDimensiones.setBounds(60, 223, 198, 21);
		}
		return lblDimensiones;
	}

	private JLabel getLblLargo() {
		if (lblLargo == null) {
			lblLargo = new JLabel("Largo:");
			lblLargo.setBounds(80, 250, 53, 23);
		}
		return lblLargo;
	}

	private JTextField getTxtLargo() {
		if (txtLargo == null) {
			txtLargo = new JFormattedTextField();
			Validaciones.soloNumeros(txtLargo, true);
			txtLargo.setColumns(10);
			txtLargo.setBounds(143, 251, 95, 19);
		}
		return txtLargo;
	}

	private JTextField getTxtAncho() {
		if (txtAncho == null) {
			txtAncho = new JTextField();
			txtAncho.setColumns(10);
			Validaciones.soloNumeros(txtAncho, true);
			txtAncho.setBounds(143, 284, 95, 19);
		}
		return txtAncho;
	}

	private JLabel getLblAncho() {
		if (lblAncho == null) {
			lblAncho = new JLabel("Ancho:");
			lblAncho.setBounds(79, 287, 53, 14);
		}
		return lblAncho;
	}

	private JLabel getLblArea() {
		if (lblArea == null) {
			lblArea = new JLabel("Área:");
			lblArea.setBounds(80, 312, 53, 28);
		}
		return lblArea;
	}

	private JTextField getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextField();
			txtArea.setColumns(10);
			Validaciones.soloNumeros(txtArea, true);
			txtArea.setBounds(143, 316, 95, 19);
		}
		return txtArea;
	}

	private JLabel getLblSenso() {
		if (lblSenso == null) {
			lblSenso = new JLabel("Senso:");
			lblSenso.setBounds(507, 11, 136, 29);
		}
		return lblSenso;
	}

	private JLabel getLblAncianos() {
		if (lblAncianos == null) {
			lblAncianos = new JLabel("Cantidad de Ancianos:");
			lblAncianos.setBounds(528, 46, 143, 28);
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
			lblInfantes = new JLabel("Cantidad de Infantes:");
			lblInfantes.setBounds(528, 92, 143, 28);
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
			lblEmbarazadas = new JLabel("Cantidad de Embarazadas:");
			lblEmbarazadas.setBounds(528, 138, 166, 28);
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
			lblTotalPersonas.setBounds(528, 184, 143, 28);
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
}

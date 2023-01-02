package visual.settings;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import classes.Construccion;
import classes.Inmueble;
import classes.Material;
import classes.Sistema;
import exceptions.ValidationException;
import util.Auxiliary;
import util.MatSettingTableModel;
import util.Validaciones;

@SuppressWarnings("unchecked")
public class PanelMateriales extends JPanel {

	private static final long serialVersionUID = -1082122820359338116L;

	public static final String INMUEBLE = "Inmueble";
	public static final String CONSTRUCCION = "Construcción";

	private ArrayList<Material> listaMateriales;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panelMaterial;
	private JPanel panelButton;
	private JButton btnInsertar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;
	private JLabel lblID;
	private JTextField txtID;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblPrecioUnitario;
	private JTextField txtPrecioUnitario;
	private JLabel lblUnidadDeMedida;
	private JTextField txtUnidadMedida;

	private MatSettingTableModel tableModel;
	private JButton btnOK;
	private JButton btnCancelar;

	public PanelMateriales() {

		listaMateriales = (ArrayList<Material>) Sistema.getInstance().getListaMateriales().clone();
		setSize(new Dimension(671, 445));
		initComponents();

	}

	private void insertarMaterial() {
		if (checkFields()) {
			Material mat = new Inmueble(txtID.getText(), txtNombre.getText(),
					Float.parseFloat(txtPrecioUnitario.getText()), 1);
			if (txtUnidadMedida.isVisible()) {
				mat = new Construccion(txtID.getText(), txtNombre.getText(),
						Float.parseFloat(txtPrecioUnitario.getText()), 1, txtUnidadMedida.getText());
			}
			listaMateriales.add(mat);
			resetFields();

			tableModel.actualizar(listaMateriales);
		}

	}

	private boolean checkFields() {

		boolean check = true;

		try {
			Validaciones.stringValidation((String) comboBox.getSelectedItem());
			Validaciones.idMaterial(txtID.getText());
			Validaciones.nombreMaterial(txtNombre.getText());
			Validaciones.nonZero(Float.parseFloat(txtPrecioUnitario.getText()));
			if (txtUnidadMedida.isVisible()) {
				Validaciones.stringValidation(txtUnidadMedida.getText());
			}
		} catch (ValidationException e) {
			check = false;
		}
		return check;

	}

	private void bloquearCampos(boolean bloquear) {
		bloquear = !bloquear;
		table.setEnabled(bloquear);
		btnInsertar.setEnabled(bloquear);
		btnBorrar.setEnabled(bloquear);
		btnEditar.setEnabled(bloquear);
		comboBox.setEnabled(bloquear);
		txtID.setEnabled(bloquear);

		btnOK.setVisible(!bloquear);
		btnCancelar.setVisible(!bloquear);

	}

	private void resetFields() {
		comboBox.setSelectedItem(null);
		txtID.setText("");
		txtNombre.setText("");
		txtPrecioUnitario.setText("");
		txtUnidadMedida.setText("");
	}

	// Components

	private void initComponents() {
		setPreferredSize(new Dimension(639, 416));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getScrollPane(), GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(getPanelMaterial(), GroupLayout.PREFERRED_SIZE, 499,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(getPanelButton(), GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(getPanelButton(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(getPanelMaterial(), GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
						.addGap(9).addComponent(getScrollPane(), GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addContainerGap()));
		setLayout(groupLayout);
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			tableModel = new MatSettingTableModel();
			table.setModel(tableModel);
			tableModel.actualizar(listaMateriales);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(119);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(130);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setPreferredWidth(83);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(3).setPreferredWidth(102);

			Auxiliary.centrarColumnas(table, new int[] { 0, 2, 3 });

		}
		return table;
	}

	private JPanel getPanelMaterial() {
		if (panelMaterial == null) {
			panelMaterial = new JPanel();
			panelMaterial.setBorder(new TitledBorder(null, "Insersi\u00F3n de Materiales", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			panelMaterial.setLayout(null);
			panelMaterial.add(getLblNewLabel());
			panelMaterial.add(getLblID());
			panelMaterial.add(getLblNombre());
			panelMaterial.add(getTxtNombre());
			panelMaterial.add(getTxtID());
			panelMaterial.add(getLblPrecioUnitario());
			panelMaterial.add(getLblUnidadDeMedida());
			panelMaterial.add(getTxtPrecioUnitario());
			panelMaterial.add(getTxtUnidadMedida());
			panelMaterial.add(getComboBox());
			panelMaterial.add(getBtnOK());
			panelMaterial.add(getBtnCancelar());
		}
		return panelMaterial;
	}

	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			panelButton.setBorder(null);
			GroupLayout glPanelButton = new GroupLayout(panelButton);
			glPanelButton.setHorizontalGroup(glPanelButton.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelButton.createSequentialGroup().addGap(20)
							.addGroup(glPanelButton.createParallelGroup(Alignment.LEADING).addComponent(getBtnBorrar())
									.addComponent(getBtnEditar()).addComponent(getBtnInsertar()))
							.addContainerGap(19, Short.MAX_VALUE)));
			glPanelButton
					.setVerticalGroup(glPanelButton.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
							glPanelButton.createSequentialGroup().addGap(15).addComponent(getBtnInsertar())
									.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getBtnEditar())
									.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getBtnBorrar())
									.addContainerGap(15, Short.MAX_VALUE)));
			glPanelButton.linkSize(SwingConstants.HORIZONTAL, getBtnInsertar(), getBtnEditar(), getBtnBorrar());
			panelButton.setLayout(glPanelButton);
		}
		return panelButton;
	}

	private JButton getBtnInsertar() {
		if (btnInsertar == null) {
			btnInsertar = new JButton("Insertar");
			btnInsertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarMaterial();
				}
			});
			btnInsertar.setFocusable(false);
		}
		return btnInsertar;
	}

	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			Auxiliary.activarBotonEditar(btnEditar, table);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRowCount() > 0) {

						Material mat = listaMateriales.get(table.getSelectedRow());
						boolean construccion = mat instanceof Construccion;

						comboBox.setSelectedIndex(construccion ? 1 : 0);
						txtID.setText(mat.getID());
						txtNombre.setText(mat.getNombre());
						txtPrecioUnitario.setText(mat.getPrecioUnitario() + "");
						if (construccion) {
							txtUnidadMedida.setText(((Construccion) mat).getUnidadMedida());
						}

						bloquearCampos(true);

					}
				}
			});
			btnEditar.setEnabled(false);
			btnEditar.setFocusable(false);

		}
		return btnEditar;
	}

	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("Borrar");
			Auxiliary.activarBotonBorrar(btnBorrar, table);
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Auxiliary.borrarSeleccionSimple(table, listaMateriales);
					tableModel.actualizar(listaMateriales);
				}
			});
			btnBorrar.setEnabled(false);
			btnBorrar.setFocusable(false);
		}
		return btnBorrar;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Tipo:");
			lblNewLabel.setBounds(38, 16, 31, 20);
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblNewLabel;
	}

	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setBounds(73, 16, 141, 20);
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					String str = (String) e.getItem();
					if (str == null) {
						lblID.setVisible(false);
						txtID.setVisible(false);
						lblNombre.setVisible(false);
						txtNombre.setVisible(false);
						lblPrecioUnitario.setVisible(false);
						txtPrecioUnitario.setVisible(false);
						lblUnidadDeMedida.setVisible(false);
						txtUnidadMedida.setVisible(false);
					} else {
						lblID.setVisible(true);
						txtID.setVisible(true);
						lblNombre.setVisible(true);
						txtNombre.setVisible(true);
						lblPrecioUnitario.setVisible(true);
						txtPrecioUnitario.setVisible(true);
						lblUnidadDeMedida.setVisible(!str.equals(INMUEBLE));
						txtUnidadMedida.setVisible(!str.equals(INMUEBLE));
					}
				}
			});
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { INMUEBLE, CONSTRUCCION }));
			comboBox.setSelectedItem(null);
		}
		return comboBox;
	}

	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel("ID:");
			lblID.setBounds(38, 46, 31, 20);
			lblID.setVisible(false);
			lblID.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblID;
	}

	private JTextField getTxtID() {
		if (txtID == null) {
			txtID = new JTextField();
			txtID.setBounds(73, 46, 141, 20);
			txtID.setVisible(false);
			txtID.setColumns(10);
			Auxiliary.onlyNumbers(txtID, false);
			Auxiliary.limite(txtID, 8);
		}
		return txtID;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(16, 77, 53, 20);
			lblNombre.setVisible(false);
			lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblNombre;
	}

	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBounds(73, 77, 141, 20);
			txtNombre.setVisible(false);
			txtNombre.setColumns(10);
			Auxiliary.onlyLettersAndNumbers(txtNombre, true);
		}
		return txtNombre;
	}

	private JLabel getLblPrecioUnitario() {
		if (lblPrecioUnitario == null) {
			lblPrecioUnitario = new JLabel("Precio Unitario:");
			lblPrecioUnitario.setBounds(265, 16, 105, 20);
			lblPrecioUnitario.setVisible(false);
			lblPrecioUnitario.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblPrecioUnitario;
	}

	private JTextField getTxtPrecioUnitario() {
		if (txtPrecioUnitario == null) {
			txtPrecioUnitario = new JTextField();
			txtPrecioUnitario.setBounds(374, 16, 86, 20);
			txtPrecioUnitario.setVisible(false);
			txtPrecioUnitario.setColumns(10);
			Auxiliary.onlyNumbers(txtPrecioUnitario, true);
		}
		return txtPrecioUnitario;
	}

	private JLabel getLblUnidadDeMedida() {
		if (lblUnidadDeMedida == null) {
			lblUnidadDeMedida = new JLabel("Unidad de Medida");
			lblUnidadDeMedida.setBounds(246, 47, 124, 20);
			lblUnidadDeMedida.setVisible(false);
			lblUnidadDeMedida.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblUnidadDeMedida;
	}

	private JTextField getTxtUnidadMedida() {
		if (txtUnidadMedida == null) {
			txtUnidadMedida = new JTextField();
			txtUnidadMedida.setBounds(374, 47, 86, 20);
			txtUnidadMedida.setVisible(false);
			txtUnidadMedida.setColumns(10);
			Auxiliary.onlyLetters(txtUnidadMedida, true);
			Auxiliary.limite(txtUnidadMedida, 15);
		}
		return txtUnidadMedida;
	}

	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkFields()) {

						Material mat = listaMateriales.get(table.getSelectedRow());
						mat.setNombre(txtNombre.getText());
						mat.setPrecioUnitario(Float.parseFloat(txtPrecioUnitario.getText()));
						if (mat instanceof Construccion) {
							((Construccion) mat).setUnidadMedida(txtUnidadMedida.getText());
						}

						resetFields();

						bloquearCampos(false);

						tableModel.actualizar(listaMateriales);
					}
				}
			});
			btnOK.setVisible(false);
			btnOK.setBounds(310, 87, 86, 23);
		}
		return btnOK;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.setSelectedItem(null);
					txtID.setText("");
					txtNombre.setText("");
					txtPrecioUnitario.setText("");
					txtUnidadMedida.setText("");

					bloquearCampos(false);
				}
			});
			btnCancelar.setVisible(false);
			btnCancelar.setBounds(403, 87, 86, 23);
		}
		return btnCancelar;
	}

	public ArrayList<Material> getListaMateriales() {
		return listaMateriales;
	}
}

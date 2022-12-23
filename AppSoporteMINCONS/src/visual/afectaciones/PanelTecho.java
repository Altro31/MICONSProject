package visual.afectaciones;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import clases.Construccion;
import clases.FichaTecnica;
import clases.Material;
import clases.Sistema;
import clases.Techo;
import enums.TipoDerrumbe;
import util.Auxiliary;
import util.TechoTableModel;
import util.Validaciones;
import visual.Frame;
import visual.util.CustomTable;

public class PanelTecho extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1507689354397891754L;
	private static final String BORRAR = "Borrar";
	private static final String EDITAR = "Editar";
	private static final String ADD = "Añadir";
	private static final String CANCEL = "Cancelar";

	private JPanel panelInsertar;
	private JTextField filtroID;
	private CustomTable cTable;
	private JLabel lblIdentificadorTecho;
	private JLabel lblMatPredTecho;
	private JLabel lblTipoDerrumbeTecho;
	private JTextField txtIdentificadorTecho;
	private JComboBox<String> comboBoxMatPredTecho;
	private JComboBox<TipoDerrumbe> comboBoxTipoDerrumbeTecho;
	private JPanel panelButton;
	private JButton btnAddTecho;
	private JButton btnBorrarTecho;
	private JButton btnEditarTecho;
	private JTextField filtroNumero;
	private JComboBox<String> filtroTipoDerrumbe;
	private JTable table;
	private TechoTableModel techoModel;
	private JButton btnOKTecho;
	private JButton btnCancelarTecho;
	private Sistema sistema = Sistema.getInstance();

	/**
	 * Create the panel.
	 */
	public PanelTecho() {
		setLayout(null);
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Techos Afectados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(getPanelInsertar());
		add(getPanelButton());
		add(getFiltroNumero());
		add(getFiltroID());
		add(getFiltroTipoDerrumbe());
		add(getcTable());

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				techoModel.actualizar();
			}
		});
	}

	private JScrollPane getcTable() {
		if (cTable == null) {
			techoModel = new TechoTableModel();
			cTable = new CustomTable(techoModel, btnBorrarTecho, btnEditarTecho, new int[] {});
			cTable.setBounds(10, 52, 417, 289);
			table = cTable.getTable();
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(0).setMaxWidth(40);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setMaxWidth(120);

			btnBorrarTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Auxiliary.borrarSeleccion(table,
							(((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaTechos()));

					techoModel.actualizar(((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaTechos());
				}
			});

		}
		return cTable;
	}

	private JPanel getPanelInsertar() {
		if (panelInsertar == null) {
			panelInsertar = new JPanel();
			panelInsertar.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Insertar Techo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInsertar.setBounds(437, 25, 342, 263);
			panelInsertar.setBounds(437, 25, 342, 263);
			GroupLayout glPanelInsertar = new GroupLayout(panelInsertar);
			glPanelInsertar.setHorizontalGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertar.createSequentialGroup().addContainerGap().addGroup(glPanelInsertar
							.createParallelGroup(Alignment.LEADING)
							.addGroup(glPanelInsertar.createSequentialGroup()
									.addGroup(glPanelInsertar.createParallelGroup(Alignment.TRAILING)
											.addComponent(getLblIdentificadorTecho(), GroupLayout.DEFAULT_SIZE, 136,
													Short.MAX_VALUE)
											.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
													.addComponent(getLblMatPredTecho(), GroupLayout.PREFERRED_SIZE, 136,
															GroupLayout.PREFERRED_SIZE)
													.addComponent(getLblTipoDerrumbeTecho(), GroupLayout.PREFERRED_SIZE,
															136, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
											.addComponent(getTxtIdentificadorTecho(), GroupLayout.DEFAULT_SIZE, 170,
													Short.MAX_VALUE)
											.addComponent(getComboBoxMatPredTecho(), 0, 170, Short.MAX_VALUE)
											.addComponent(getComboBoxTipoDerrumbeTecho(), 0, 170, Short.MAX_VALUE))
									.addGap(10))
							.addGroup(glPanelInsertar.createSequentialGroup()
									.addComponent(getBtnOKTecho(), GroupLayout.PREFERRED_SIZE, 84,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnCancelarTecho(),
											GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addContainerGap()))));
			glPanelInsertar.setVerticalGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertar.createSequentialGroup().addContainerGap()
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getTxtIdentificadorTecho(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblIdentificadorTecho()))
							.addGap(38)
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblMatPredTecho()).addComponent(getComboBoxMatPredTecho(),
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblTipoDerrumbeTecho())
									.addComponent(getComboBoxTipoDerrumbeTecho(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtnOKTecho())
									.addComponent(getBtnCancelarTecho(), GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
							.addGap(32)));
			glPanelInsertar.linkSize(SwingConstants.VERTICAL, new Component[] { getTxtIdentificadorTecho(),
					getComboBoxMatPredTecho(), getComboBoxTipoDerrumbeTecho() });
			glPanelInsertar.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblIdentificadorTecho(), getLblMatPredTecho(), getLblTipoDerrumbeTecho() });
			glPanelInsertar.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getBtnOKTecho(), getBtnCancelarTecho() });
			panelInsertar.setLayout(glPanelInsertar);
		}
		return panelInsertar;
	}

	private JLabel getLblIdentificadorTecho() {
		if (lblIdentificadorTecho == null) {
			lblIdentificadorTecho = new JLabel("Identificador");
			lblIdentificadorTecho.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblIdentificadorTecho;
	}

	private JLabel getLblMatPredTecho() {
		if (lblMatPredTecho == null) {
			lblMatPredTecho = new JLabel("Material Predominante");
			lblMatPredTecho.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblMatPredTecho;
	}

	private JLabel getLblTipoDerrumbeTecho() {
		if (lblTipoDerrumbeTecho == null) {
			lblTipoDerrumbeTecho = new JLabel("Tipo de Derrumbe");
			lblTipoDerrumbeTecho.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblTipoDerrumbeTecho;
	}

	private JTextField getTxtIdentificadorTecho() {
		if (txtIdentificadorTecho == null) {
			txtIdentificadorTecho = new JTextField();
			txtIdentificadorTecho.setColumns(10);
			Validaciones.limite(txtIdentificadorTecho, 20);
			Validaciones.onlyLettersAndNumbers(txtIdentificadorTecho, true);
		}
		return txtIdentificadorTecho;
	}

	private JComboBox<String> getComboBoxMatPredTecho() {
		if (comboBoxMatPredTecho == null) {
			ArrayList<String> names = new ArrayList<String>();
			for (Material mat : sistema.getListaMateriales()) {
				if (mat instanceof Construccion) {
					names.add(mat.getNombre());
				}
			}
			comboBoxMatPredTecho = new JComboBox<String>();
			comboBoxMatPredTecho.setModel(new DefaultComboBoxModel<String>(names.toArray(new String[0])));
			comboBoxMatPredTecho.setSelectedItem(null);
		}
		return comboBoxMatPredTecho;
	}

	private JComboBox<TipoDerrumbe> getComboBoxTipoDerrumbeTecho() {
		if (comboBoxTipoDerrumbeTecho == null) {
			comboBoxTipoDerrumbeTecho = new JComboBox<TipoDerrumbe>();
			comboBoxTipoDerrumbeTecho.setModel(new DefaultComboBoxModel<TipoDerrumbe>(TipoDerrumbe.values()));
			comboBoxTipoDerrumbeTecho.setSelectedItem(null);
		}
		return comboBoxTipoDerrumbeTecho;
	}

	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			FlowLayout flPanelButton = (FlowLayout) panelButton.getLayout();
			flPanelButton.setVgap(8);
			flPanelButton.setHgap(20);
			panelButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButton.setBounds(437, 299, 342, 41);
			panelButton.add(getBtnAddTecho());
			panelButton.add(getBtnBorrarTecho());
			panelButton.add(getBtnEditarTecho());
		}
		return panelButton;
	}

	private JButton getBtnAddTecho() {
		if (btnAddTecho == null) {
			btnAddTecho = new JButton(ADD);
			btnAddTecho.setFocusable(false);
			final JPanel panel = this;
			btnAddTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPredTecho.getSelectedItem()) != null
							&& comboBoxTipoDerrumbeTecho.getSelectedItem() != null
							&& !(txtIdentificadorTecho.getText()).isEmpty()) {

						ArrayList<Techo> lista = ((FichaTecnica)Frame.getPosicionActual()[1]).getAfect()
								.getListaTechos();
						String nombre = txtIdentificadorTecho.getText();

						boolean check = true;
						for (Techo t : lista) {
							if (t.getNombre().equals(nombre)) {
								check = false;
							}
						}
						if (check) {
							((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaTechos()
									.add(new Techo((txtIdentificadorTecho.getText()),
											(Construccion) sistema
													.getMaterial((String) comboBoxMatPredTecho.getSelectedItem()),
											(TipoDerrumbe) comboBoxTipoDerrumbeTecho.getSelectedItem()));
							techoModel.actualizar(
									((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaTechos());
							comboBoxMatPredTecho.setSelectedItem(null);
							comboBoxTipoDerrumbeTecho.setSelectedItem(null);
							txtIdentificadorTecho.setText("");
						} else {
							JOptionPane.showMessageDialog(panel, "Ya existe una pared con ese nombre");
						}
					}
				}
			});
		}
		return btnAddTecho;
	}

	private JButton getBtnBorrarTecho() {
		if (btnBorrarTecho == null) {
			btnBorrarTecho = new JButton(BORRAR);
			btnBorrarTecho.setFocusable(false);
			btnBorrarTecho.setEnabled(false);
		}
		return btnBorrarTecho;
	}

	private JButton getBtnEditarTecho() {
		if (btnEditarTecho == null) {
			btnEditarTecho = new JButton(EDITAR);
			btnEditarTecho.setFocusable(false);
			btnEditarTecho.setEnabled(false);
			btnEditarTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRowCount() > 0) {
						Techo techo = ((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaTechos()
								.get(Integer.parseInt((String) techoModel.getValueAt(table.getSelectedRow(), 0)) - 1);

						txtIdentificadorTecho.setText(techo.getNombre());
						comboBoxMatPredTecho.setSelectedItem(techo.getMaterialPredominante().getNombre());
						comboBoxTipoDerrumbeTecho.setSelectedItem(techo.getTipoDerrumbe());

						bloquearCamposTecho(true);

					}
				}
			});
		}
		return btnEditarTecho;
	}

	private JTextField getFiltroNumero() {
		if (filtroNumero == null) {
			filtroNumero = new JTextField();
			filtroNumero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					techoModel.filtrar(filtroNumero.getText(), 0);
				}
			});
			filtroNumero.setColumns(10);
			filtroNumero.setBounds(10, 30, 41, 20);
		}
		return filtroNumero;
	}

	private JTextField getFiltroID() {
		if (filtroID == null) {
			filtroID = new JTextField();
			filtroID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					techoModel.filtrar(filtroID.getText(), 1);
				}
			});
			filtroID.setColumns(10);
			filtroID.setBounds(51, 30, 254, 20);
		}
		return filtroID;
	}

	private JComboBox<String> getFiltroTipoDerrumbe() {
		if (filtroTipoDerrumbe == null) {
			filtroTipoDerrumbe = new JComboBox<String>();
			filtroTipoDerrumbe.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					techoModel.filtrar((String) filtroTipoDerrumbe.getSelectedItem(), 2);
				}
			});
			filtroTipoDerrumbe.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Parcial", "Total" }));
			filtroTipoDerrumbe.setBounds(304, 30, 123, 20);
			filtroTipoDerrumbe.setSelectedItem("");
		}
		return filtroTipoDerrumbe;
	}

	private void bloquearCamposTecho(boolean bloquear) {
		bloquear = !bloquear;
		table.setEnabled(bloquear);
		btnAddTecho.setEnabled(bloquear);
		btnBorrarTecho.setEnabled(bloquear);
		btnEditarTecho.setEnabled(bloquear);
		filtroNumero.setEnabled(bloquear);
		filtroID.setEnabled(bloquear);
		filtroID.setEnabled(bloquear);
		filtroTipoDerrumbe.setEnabled(bloquear);
		txtIdentificadorTecho.setEnabled(bloquear);
		btnOKTecho.setVisible(!bloquear);
		btnCancelarTecho.setVisible(!bloquear);
	}

	private JButton getBtnOKTecho() {
		if (btnOKTecho == null) {
			btnOKTecho = new JButton("OK");
			btnOKTecho.setFocusable(false);
			btnOKTecho.setVisible(false);
			btnOKTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPredTecho.getSelectedItem()) != null
							&& comboBoxTipoDerrumbeTecho.getSelectedItem() != null
							&& !(txtIdentificadorTecho.getText()).isEmpty()) {
						((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaTechos().set(
								Integer.parseInt((String) techoModel.getValueAt(table.getSelectedRow(), 0)) - 1,
								new Techo((txtIdentificadorTecho.getText()),
										(Construccion) sistema
												.getMaterial((String) comboBoxMatPredTecho.getSelectedItem()),
										(TipoDerrumbe) comboBoxTipoDerrumbeTecho.getSelectedItem()));
						techoModel.actualizar(
								((FichaTecnica)Frame.getPosicionActual()[1]).getAfect().getListaTechos());

						comboBoxMatPredTecho.setSelectedItem(null);
						comboBoxTipoDerrumbeTecho.setSelectedItem(null);
						txtIdentificadorTecho.setText("");

						bloquearCamposTecho(false);
					}
				}
			});
		}
		return btnOKTecho;
	}

	private JButton getBtnCancelarTecho() {
		if (btnCancelarTecho == null) {
			btnCancelarTecho = new JButton(CANCEL);
			btnCancelarTecho.setFocusable(false);
			btnCancelarTecho.setVisible(false);
			btnCancelarTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					txtIdentificadorTecho.setText("");
					comboBoxMatPredTecho.setSelectedItem(null);
					comboBoxTipoDerrumbeTecho.setSelectedItem(null);

					bloquearCamposTecho(false);
				}
			});
		}
		return btnCancelarTecho;
	}
	
	public void actualizarTabla(ArrayList<Techo> lista) {
		techoModel.actualizar(lista);
	}

}

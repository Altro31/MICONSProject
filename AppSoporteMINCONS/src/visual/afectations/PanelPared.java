package visual.afectations;

import java.awt.Color;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import classes.Construccion;
import classes.FichaTecnica;
import classes.Material;
import classes.Pared;
import classes.Sistema;
import classifications.TipoDerrumbe;
import util.Auxiliary;
import util.ParedTableModel;
import visual.Frame;
import visual.util.CustomTable;

public class PanelPared extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4634945893021445048L;
	private static final String BORRAR = "Borrar";
	private static final String EDITAR = "Editar";
	private static final String ADD = "Añadir";
	private static final String CANCEL = "Cancelar";

	private JPanel panelInsertar;
	private JTextField txtIdentificadorPared;
	private JComboBox<String> comboBoxMatPred;
	private JComboBox<TipoDerrumbe> comboBoxTipoDerrumbePared;
	private JCheckBox cBoxParedCarga;
	private JButton btnAgnadir;
	private JButton btnBorrar;
	private JButton btnEditar;
	private JTable table;
	private ParedTableModel tableModel;
	private JTextField filtroNumero;
	private JTextField filtroIdentificador;
	private JComboBox<String> comboBoxParedCarga;
	private JButton btnOK;
	private JButton btnCancelar;
	private JLabel lblIdentificador;
	private JLabel lblMatPred;
	private JLabel lblTipoDerrumbe;
	private JLabel lblParedCarga;
	private JPanel panelButton;
	private JComboBox<String> comboBoxTipoDerrumbe;
	private CustomTable cTable;
	private Sistema sistema = Sistema.getInstance();

	/**
	 * Create the panel.
	 */
	public PanelPared() {
		setLayout(null);
		setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Paredes Afectadas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(getPanelInsertar());
		add(getPanelButton());
		add(getFiltroNumero());
		add(getFiltroIdentificador());
		add(getComboBoxTipoDerrumbe());
		add(getComboBoxParedCarga());
		add(getcTable());

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				tableModel.actualizar();
			}
		});
	}

	private CustomTable getcTable() {
		if (cTable == null) {
			tableModel = new ParedTableModel();
			cTable = new CustomTable(tableModel, btnBorrar, btnEditar, new int[] {});
			cTable.setBounds(10, 52, 417, 289);
			table = cTable.getTable();
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(0).setMaxWidth(40);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setMaxWidth(100);

			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Auxiliary.borrarSeleccion(table,
							(((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaParedes()));

					tableModel.actualizar(((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaParedes());
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
					"Insertar Pared", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInsertar.setBounds(437, 25, 342, 263);
			GroupLayout glPanelInsertar = new GroupLayout(panelInsertar);
			glPanelInsertar.setHorizontalGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertar.createSequentialGroup().addContainerGap().addGroup(glPanelInsertar
							.createParallelGroup(Alignment.LEADING)
							.addGroup(glPanelInsertar.createSequentialGroup().addGroup(glPanelInsertar
									.createParallelGroup(Alignment.LEADING)
									.addComponent(getLblParedCarga(), GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
									.addComponent(getLblIdentificador(), GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addComponent(getLblMatPred(), GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
									.addComponent(getLblTipoDerrumbe(), GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
									.addGap(13)
									.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
											.addGroup(glPanelInsertar.createSequentialGroup()
													.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
															.addComponent(getComboBoxTipoDerrumbePared(), 0, 173,
																	Short.MAX_VALUE)
															.addComponent(getComboBoxMatPred(), 0, 173, Short.MAX_VALUE)
															.addComponent(getTxtIdentificador(),
																	GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
													.addPreferredGap(ComponentPlacement.RELATED))
											.addComponent(getCBoxParedCarga(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE)))
							.addGroup(glPanelInsertar.createSequentialGroup()
									.addComponent(getBtnOK(), GroupLayout.PREFERRED_SIZE, 75,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getBtnCancelar())))
							.addGap(0)));
			glPanelInsertar
					.setVerticalGroup(
							glPanelInsertar.createParallelGroup(Alignment.LEADING)
									.addGroup(glPanelInsertar.createSequentialGroup().addContainerGap()
											.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblIdentificador())
													.addComponent(getTxtIdentificador(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblMatPred())
													.addComponent(getComboBoxMatPred(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(glPanelInsertar
													.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblTipoDerrumbe()).addComponent(
															getComboBoxTipoDerrumbePared(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
													.addGroup(glPanelInsertar.createSequentialGroup().addGap(25)
															.addComponent(getLblParedCarga()))
													.addGroup(glPanelInsertar.createSequentialGroup().addGap(18)
															.addComponent(getCBoxParedCarga(),
																	GroupLayout.PREFERRED_SIZE, 28,
																	GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
											.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
													.addComponent(getBtnOK()).addComponent(getBtnCancelar()))
											.addGap(23)));
			glPanelInsertar.linkSize(SwingConstants.VERTICAL, getLblIdentificador(), getLblMatPred(),
					getLblTipoDerrumbe());
			glPanelInsertar.linkSize(SwingConstants.VERTICAL, getComboBoxTipoDerrumbePared(), getComboBoxMatPred(),
					getTxtIdentificador());
			panelInsertar.setLayout(glPanelInsertar);
		}
		return panelInsertar;
	}

	private JLabel getLblIdentificador() {
		if (lblIdentificador == null) {
			lblIdentificador = new JLabel("Identificador");
			lblIdentificador.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblIdentificador;
	}

	private JLabel getLblMatPred() {
		if (lblMatPred == null) {
			lblMatPred = new JLabel("Material Predominante");
			lblMatPred.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblMatPred;
	}

	private JLabel getLblTipoDerrumbe() {
		if (lblTipoDerrumbe == null) {
			lblTipoDerrumbe = new JLabel("Tipo de Derrumbe");
			lblTipoDerrumbe.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblTipoDerrumbe;
	}

	private JLabel getLblParedCarga() {
		if (lblParedCarga == null) {
			lblParedCarga = new JLabel("Pared de Carga");
			lblParedCarga.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblParedCarga;
	}

	private JTextField getTxtIdentificador() {
		if (txtIdentificadorPared == null) {
			txtIdentificadorPared = new JTextField();
			txtIdentificadorPared.setColumns(10);
			Auxiliary.onlyLettersAndNumbers(txtIdentificadorPared, true);
			Auxiliary.limite(txtIdentificadorPared, 20);
		}
		return txtIdentificadorPared;
	}

	private JComboBox<String> getComboBoxMatPred() {
		if (comboBoxMatPred == null) {
			ArrayList<String> names = new ArrayList<String>();
			for (Material mat : sistema.getListaMateriales()) {
				if (mat instanceof Construccion) {
					names.add(mat.getNombre());
				}
			}
			comboBoxMatPred = new JComboBox<String>(new DefaultComboBoxModel<String>(names.toArray(new String[0])));
			comboBoxMatPred.setSelectedItem(null);
		}
		return comboBoxMatPred;
	}

	private JComboBox<TipoDerrumbe> getComboBoxTipoDerrumbePared() {
		if (comboBoxTipoDerrumbePared == null) {
			comboBoxTipoDerrumbePared = new JComboBox<TipoDerrumbe>();
			comboBoxTipoDerrumbePared.setModel(new DefaultComboBoxModel<TipoDerrumbe>(TipoDerrumbe.values()));
			comboBoxTipoDerrumbePared.setSelectedItem(null);
		}
		return comboBoxTipoDerrumbePared;
	}

	private JCheckBox getCBoxParedCarga() {
		if (cBoxParedCarga == null) {
			cBoxParedCarga = new JCheckBox("");
			cBoxParedCarga.setHorizontalAlignment(SwingConstants.RIGHT);
			cBoxParedCarga.setHorizontalTextPosition(SwingConstants.RIGHT);
		}
		return cBoxParedCarga;
	}

	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			panelButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			FlowLayout flPanelButton = (FlowLayout) panelButton.getLayout();
			flPanelButton.setVgap(8);
			flPanelButton.setHgap(20);
			panelButton.setBounds(437, 299, 342, 41);
			panelButton.add(getBtnAgnadir());
			panelButton.add(getBtnBorrar());
			panelButton.add(getBtnEditar());
		}
		return panelButton;
	}

	private JButton getBtnAgnadir() {
		if (btnAgnadir == null) {
			btnAgnadir = new JButton(ADD);
			btnAgnadir.setFocusable(false);
			final JPanel panel = this;
			btnAgnadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPred.getSelectedItem()) != null
							&& comboBoxTipoDerrumbePared.getSelectedItem() != null
							&& !(txtIdentificadorPared.getText()).isEmpty()) {

						ArrayList<Pared> lista = ((FichaTecnica) Frame.getPosicionActual()[1]).getAfect()
								.getListaParedes();
						String nombre = txtIdentificadorPared.getText();

						boolean check = true;
						for (Pared p : lista) {
							if (p.getNombre().equals(nombre)) {
								check = false;
							}
						}
						if (check) {
							((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaParedes()
									.add(new Pared(txtIdentificadorPared.getText(),
											(Construccion) sistema
													.getMaterial((String) comboBoxMatPred.getSelectedItem()),
											(TipoDerrumbe) comboBoxTipoDerrumbePared.getSelectedItem(),
											cBoxParedCarga.isSelected()));
							tableModel.actualizar(
									((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaParedes());

							comboBoxMatPred.setSelectedItem(null);
							comboBoxTipoDerrumbePared.setSelectedItem(null);
							cBoxParedCarga.setSelected(false);
							txtIdentificadorPared.setText("");
						} else {
							JOptionPane.showMessageDialog(panel, "Ya existe una pared con ese nombre");
						}
					}
				}
			});
		}
		return btnAgnadir;
	}

	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton(BORRAR);
			btnBorrar.setFocusable(false);
			btnBorrar.setEnabled(false);
		}
		return btnBorrar;
	}

	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton(EDITAR);
			btnEditar.setFocusable(false);
			btnEditar.setEnabled(false);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRowCount() > 0) {
						Pared pared = ((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaParedes()
								.get(Integer.parseInt((String) tableModel.getValueAt(table.getSelectedRow(), 0)) - 1);
						txtIdentificadorPared.setText(pared.getNombre());
						comboBoxMatPred.setSelectedItem(pared.getMaterialPredominante().getNombre());
						comboBoxTipoDerrumbePared.setSelectedItem(pared.getTipoDerrumbe());
						cBoxParedCarga.setSelected(pared.isEsParedCarga());

						bloquearCamposPared(true);
					}
				}
			});
		}
		return btnEditar;
	}

	private JTextField getFiltroNumero() {
		if (filtroNumero == null) {
			filtroNumero = new JTextField();
			filtroNumero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tableModel.filtrar(filtroNumero.getText(), 0);
				}
			});
			filtroNumero.setColumns(10);
			filtroNumero.setBounds(10, 30, 41, 20);
		}
		return filtroNumero;
	}

	private JComboBox<String> getComboBoxParedCarga() {
		if (comboBoxParedCarga == null) {
			comboBoxParedCarga = new JComboBox<String>();
			comboBoxParedCarga.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					tableModel.filtrar((String) comboBoxParedCarga.getSelectedItem(), 3);
				}
			});
			comboBoxParedCarga.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Si", "No" }));
			comboBoxParedCarga.setBounds(324, 30, 103, 20);
			comboBoxParedCarga.setSelectedItem("");
		}
		return comboBoxParedCarga;
	}

	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.setFocusable(false);
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPred.getSelectedItem()) != null
							&& comboBoxTipoDerrumbePared.getSelectedItem() != null
							&& !(txtIdentificadorPared.getText()).isEmpty()) {

						((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaParedes().set(
								Integer.parseInt((String) tableModel.getValueAt(table.getSelectedRow(), 0)) - 1,
								new Pared((txtIdentificadorPared.getText()),
										(Construccion) sistema.getMaterial((String) comboBoxMatPred.getSelectedItem()),
										(TipoDerrumbe) comboBoxTipoDerrumbePared.getSelectedItem(),
										cBoxParedCarga.isSelected()));
						tableModel
								.actualizar(((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaParedes());

						comboBoxMatPred.setSelectedItem(null);
						comboBoxTipoDerrumbePared.setSelectedItem(null);
						cBoxParedCarga.setSelected(false);
						txtIdentificadorPared.setText("");

						bloquearCamposPared(false);
					}
				}
			});
			btnOK.setVisible(false);
		}
		return btnOK;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton(CANCEL);
			btnCancelar.setFocusable(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					comboBoxMatPred.setSelectedItem(null);
					comboBoxTipoDerrumbePared.setSelectedItem(null);
					cBoxParedCarga.setSelected(false);

					bloquearCamposPared(false);

				}
			});
			btnCancelar.setVisible(false);
		}
		return btnCancelar;
	}

	private void bloquearCamposPared(boolean bloquear) {
		bloquear = !bloquear;
		table.setEnabled(bloquear);
		btnAgnadir.setEnabled(bloquear);
		btnBorrar.setEnabled(bloquear);
		btnEditar.setEnabled(bloquear);
		filtroNumero.setEnabled(bloquear);
		comboBoxParedCarga.setEnabled(bloquear);
		filtroIdentificador.setEnabled(bloquear);
		txtIdentificadorPared.setEnabled(bloquear);
		btnOK.setVisible(!bloquear);
		btnCancelar.setVisible(!bloquear);

	}

	private JTextField getFiltroIdentificador() {
		if (filtroIdentificador == null) {
			filtroIdentificador = new JTextField();
			filtroIdentificador.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tableModel.filtrar(filtroIdentificador.getText(), 1);
				}
			});
			filtroIdentificador.setColumns(10);
			filtroIdentificador.setBounds(51, 30, 137, 20);
		}
		return filtroIdentificador;
	}

	private JComboBox<String> getComboBoxTipoDerrumbe() {
		if (comboBoxTipoDerrumbe == null) {
			comboBoxTipoDerrumbe = new JComboBox<String>();
			comboBoxTipoDerrumbe.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					tableModel.filtrar((String) comboBoxTipoDerrumbe.getSelectedItem(), 2);
				}
			});
			comboBoxTipoDerrumbe.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Parcial", "Total" }));
			comboBoxTipoDerrumbe.setBounds(188, 30, 136, 20);
			comboBoxTipoDerrumbe.setSelectedItem("");
		}
		return comboBoxTipoDerrumbe;
	}

	public void actualizarTabla(ArrayList<Pared> lista) {
		tableModel.actualizar(lista);
	}

}

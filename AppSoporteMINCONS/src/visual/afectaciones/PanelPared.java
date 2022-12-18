package visual.afectaciones;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Afectacion;
import clases.Construccion;
import clases.Material;
import clases.Pared;
import clases.Sistema;
import enums.TipoDerrumbe;
import util.Auxiliary;
import util.ParedTableModel;
import util.Validaciones;
import visual.Frame;
import visual.util.CustomTable;
@SuppressWarnings({"rawtypes","unchecked"})
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
	private JComboBox comboBoxMatPredPared;
	private JComboBox comboBoxTipoDerrumbePared;
	private JCheckBox cBoxParedCarga;
	private JButton btnAgnadirPared;
	private JButton btnBorrarPared;
	private JButton btnEditarPared;
	private JTable tablePared;
	private ParedTableModel tableModel;
	private JTextField filtroNumero;
	private JTextField filtroIdentificador;
	private JComboBox comboBoxParedCarga;
	private JCheckBox cBoxSelectPared;
	private JButton btnOKPared;
	private JButton btnCancelarPared;
	private JLabel lblIdentificadorPared;
	private JLabel lblMatPred;
	private JLabel lblTipoDerrumbePared;
	private JLabel lblParedCarga;
	private JPanel panelButton;
	private JComboBox comboBoxTipoDerrumbe;
	private CustomTable cTable;
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
		add(getCBoxSelectPared());
		add(getcTable());
	}
	
	private CustomTable getcTable() {
		if (cTable == null) {
			tableModel = new ParedTableModel();
			cTable = new CustomTable(tableModel, btnBorrarPared, btnEditarPared, new int[] {});
			cTable.setBounds(10, 52, 417, 289);
			tablePared = cTable.getTable();
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
					.addGroup(glPanelInsertar.createSequentialGroup().addContainerGap().addGroup(
							glPanelInsertar.createParallelGroup(Alignment.LEADING).addGroup(glPanelInsertar
									.createSequentialGroup()
									.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING).addGroup(
											glPanelInsertar.createSequentialGroup().addGroup(glPanelInsertar
													.createParallelGroup(Alignment.LEADING, false)
													.addComponent(getLblIdentificadorPared(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(getLblMatPred(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(getLblTipoDerrumbePared(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
													.addGap(26))
											.addGroup(glPanelInsertar.createSequentialGroup()
													.addComponent(getLblParedCarga(), GroupLayout.DEFAULT_SIZE, 133,
															Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
											.addComponent(getComboBoxTipoDerrumbePared(), 0, 173, Short.MAX_VALUE)
											.addComponent(getComboBoxMatPredPared(), 0, 173, Short.MAX_VALUE)
											.addComponent(getTxtIdentificadorPared(), GroupLayout.DEFAULT_SIZE, 173,
													Short.MAX_VALUE)
											.addComponent(getCBoxParedCarga(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(glPanelInsertar.createSequentialGroup()
											.addComponent(getBtnOKPared(), GroupLayout.PREFERRED_SIZE, 75,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(getBtnCancelarPared())))
							.addGap(10)));
			glPanelInsertar.setVerticalGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertar.createSequentialGroup().addContainerGap()
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblIdentificadorPared()).addComponent(getTxtIdentificadorPared(),
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblMatPred())
									.addComponent(getComboBoxMatPredPared(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblTipoDerrumbePared())
									.addComponent(getComboBoxTipoDerrumbePared(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.TRAILING)
									.addComponent(getCBoxParedCarga()).addComponent(getLblParedCarga()))
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtnOKPared()).addComponent(getBtnCancelarPared()))
							.addGap(23)));
			glPanelInsertar.linkSize(SwingConstants.VERTICAL, new Component[] { getComboBoxTipoDerrumbePared(),
					getComboBoxMatPredPared(), getTxtIdentificadorPared() });
			glPanelInsertar.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblIdentificadorPared(), getLblMatPred(), getLblTipoDerrumbePared() });
			panelInsertar.setLayout(glPanelInsertar);
		}
		return panelInsertar;
	}

	private JLabel getLblIdentificadorPared() {
		if (lblIdentificadorPared == null) {
			lblIdentificadorPared = new JLabel("Identificador");
		}
		return lblIdentificadorPared;
	}

	private JLabel getLblMatPred() {
		if (lblMatPred == null) {
			lblMatPred = new JLabel("Material Predominante");
		}
		return lblMatPred;
	}

	private JLabel getLblTipoDerrumbePared() {
		if (lblTipoDerrumbePared == null) {
			lblTipoDerrumbePared = new JLabel("Tipo de Derrumbe");
		}
		return lblTipoDerrumbePared;
	}

	private JLabel getLblParedCarga() {
		if (lblParedCarga == null) {
			lblParedCarga = new JLabel("Pared de Carga");
		}
		return lblParedCarga;
	}

	private JTextField getTxtIdentificadorPared() {
		if (txtIdentificadorPared == null) {
			txtIdentificadorPared = new JTextField();
			txtIdentificadorPared.setColumns(10);
			Validaciones.soloNumeros(txtIdentificadorPared, false);
			Validaciones.limitar(txtIdentificadorPared, 11);
		}
		return txtIdentificadorPared;
	}

	private JComboBox getComboBoxMatPredPared() {
		if (comboBoxMatPredPared == null) {
			ArrayList<String> names = new ArrayList<String>();
			for (Material mat : Sistema.getListaMateriales()) {
				if (mat instanceof Construccion) {
					names.add(mat.getNombre());
				}
			}
			comboBoxMatPredPared = new JComboBox(new DefaultComboBoxModel<>(names.toArray()));
			comboBoxMatPredPared.setSelectedItem(null);
		}
		return comboBoxMatPredPared;
	}

	private JComboBox getComboBoxTipoDerrumbePared() {
		if (comboBoxTipoDerrumbePared == null) {
			comboBoxTipoDerrumbePared = new JComboBox();
			comboBoxTipoDerrumbePared.setModel(new DefaultComboBoxModel(TipoDerrumbe.values()));
			comboBoxTipoDerrumbePared.setSelectedItem(null);
		}
		return comboBoxTipoDerrumbePared;
	}

	private JCheckBox getCBoxParedCarga() {
		if (cBoxParedCarga == null) {
			cBoxParedCarga = new JCheckBox("");
			cBoxParedCarga.setVerticalAlignment(SwingConstants.TOP);
			cBoxParedCarga.setHorizontalTextPosition(SwingConstants.LEFT);
			cBoxParedCarga.setHorizontalAlignment(SwingConstants.TRAILING);
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
			panelButton.add(getBtnAgnadirPared());
			panelButton.add(getBtnBorrarPared());
			panelButton.add(getBtnEditarPared());
		}
		return panelButton;
	}

	private JButton getBtnAgnadirPared() {
		if (btnAgnadirPared == null) {
			btnAgnadirPared = new JButton(ADD);
			btnAgnadirPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPredPared.getSelectedItem()) != null
							&& comboBoxTipoDerrumbePared.getSelectedItem() != null
							&& !(txtIdentificadorPared.getText()).isEmpty()) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).addPared(new Pared(
								txtIdentificadorPared.getText(),
								(Construccion) Sistema.getMaterial((String) comboBoxMatPredPared.getSelectedItem()),
								(TipoDerrumbe) comboBoxTipoDerrumbePared.getSelectedItem(),
								cBoxParedCarga.isSelected()));
						tableModel.actualizar(
								((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaParedes());
						comboBoxMatPredPared.setSelectedItem(null);
						comboBoxTipoDerrumbePared.setSelectedItem(null);
						cBoxParedCarga.setSelected(false);
						txtIdentificadorPared.setText("");
					}
				}
			});
		}
		return btnAgnadirPared;
	}

	private JButton getBtnBorrarPared() {
		if (btnBorrarPared == null) {
			btnBorrarPared = new JButton(BORRAR);
			btnBorrarPared.setEnabled(false);
		}
		return btnBorrarPared;
	}

	private JButton getBtnEditarPared() {
		if (btnEditarPared == null) {
			btnEditarPared = new JButton(EDITAR);
			btnEditarPared.setEnabled(false);
			btnEditarPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tablePared.getSelectedRowCount() > 0) {
						Pared pared = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaParedes()
								.get(tablePared.getSelectedRow());
						txtIdentificadorPared.setText(pared.getID());
						comboBoxMatPredPared.setSelectedItem(pared.getMaterialPredominante().getNombre());
						comboBoxTipoDerrumbePared.setSelectedItem(pared.getTipoDerrumbe());
						cBoxParedCarga.setSelected(pared.isEsParedCarga());

						btnOKPared.setVisible(true);
						btnCancelarPared.setVisible(true);

						bloquearCamposPared(true);
					}
				}
			});
		}
		return btnEditarPared;
	}
	
	private JTextField getFiltroNumero() {
		if (filtroNumero == null) {
			filtroNumero = new JTextField();
			filtroNumero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tableModel.filtrar(filtroNumero.getText(), 1);
				}
			});
			filtroNumero.setColumns(10);
			filtroNumero.setBounds(58, 25, 46, 20);
		}
		return filtroNumero;
	}
	
	private JComboBox getComboBoxParedCarga() {
		if (comboBoxParedCarga == null) {
			comboBoxParedCarga = new JComboBox();
			comboBoxParedCarga.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					tableModel.filtrar((String) comboBoxParedCarga.getSelectedItem(), 4);
				}
			});
			comboBoxParedCarga.setModel(new DefaultComboBoxModel(new String[] { "", "Si", "No" }));
			comboBoxParedCarga.setBounds(332, 25, 95, 20);
			comboBoxParedCarga.setSelectedItem("");
		}
		return comboBoxParedCarga;
	}
	
	private JButton getBtnOKPared() {
		if (btnOKPared == null) {
			btnOKPared = new JButton("OK");
			btnOKPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPredPared.getSelectedItem()) != null
							&& comboBoxTipoDerrumbePared.getSelectedItem() != null
							&& !(txtIdentificadorPared.getText()).isEmpty()) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).setPared(
								tablePared.getSelectedRow(),
								new Pared((txtIdentificadorPared.getText()),
										(Construccion) Sistema
												.getMaterial((String) comboBoxMatPredPared.getSelectedItem()),
										(TipoDerrumbe) comboBoxTipoDerrumbePared.getSelectedItem(),
										cBoxParedCarga.isSelected()));
						tableModel.actualizar(
								((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaParedes());
						comboBoxMatPredPared.setSelectedItem(null);
						comboBoxTipoDerrumbePared.setSelectedItem(null);
						cBoxParedCarga.setSelected(false);
						txtIdentificadorPared.setText("");

						btnOKPared.setVisible(false);
						btnCancelarPared.setVisible(false);

						bloquearCamposPared(false);
					}
				}
			});
			btnOKPared.setVisible(false);
		}
		return btnOKPared;
	}

	private JButton getBtnCancelarPared() {
		if (btnCancelarPared == null) {
			btnCancelarPared = new JButton(CANCEL);
			btnCancelarPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					txtIdentificadorPared.setText("");
					comboBoxMatPredPared.setSelectedItem(null);
					comboBoxTipoDerrumbePared.setSelectedItem(null);
					cBoxParedCarga.setSelected(false);

					btnOKPared.setVisible(false);
					btnCancelarPared.setVisible(false);

					bloquearCamposPared(false);

				}
			});
			btnCancelarPared.setVisible(false);
		}
		return btnCancelarPared;
	}
	
	private void bloquearCamposPared(boolean bloquear) {
		bloquear = !bloquear;
		tablePared.setEnabled(bloquear);
		btnAgnadirPared.setEnabled(bloquear);
		btnBorrarPared.setEnabled(bloquear);
		btnEditarPared.setEnabled(bloquear);
		filtroNumero.setEnabled(bloquear);
		cBoxSelectPared.setEnabled(bloquear);
		comboBoxParedCarga.setEnabled(bloquear);
		filtroIdentificador.setEnabled(bloquear);

	}
	
	private JCheckBox getCBoxSelectPared() {
		if (cBoxSelectPared == null) {
			cBoxSelectPared = new JCheckBox("");
			cBoxSelectPared.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Auxiliary.selectAll(tableModel, cBoxSelectPared, 0);
				}
			});
			cBoxSelectPared.setBorderPainted(true);
			cBoxSelectPared.setBorder(new LineBorder(new Color(128, 128, 128)));
			cBoxSelectPared.setHorizontalAlignment(SwingConstants.CENTER);
			cBoxSelectPared.setBounds(10, 25, 46, 20);
		}
		return cBoxSelectPared;
	}
	
	private JTextField getFiltroIdentificador() {
		if (filtroIdentificador == null) {
			filtroIdentificador = new JTextField();
			filtroIdentificador.setColumns(10);
			filtroIdentificador.setBounds(106, 25, 111, 20);
		}
		return filtroIdentificador;
	}

	private JComboBox getComboBoxTipoDerrumbe() {
		if (comboBoxTipoDerrumbe == null) {
			comboBoxTipoDerrumbe = new JComboBox();
			comboBoxTipoDerrumbe.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					tableModel.filtrar((String) comboBoxTipoDerrumbe.getSelectedItem(), 3);
				}
			});
			comboBoxTipoDerrumbe.setModel(new DefaultComboBoxModel(new String[] { "", "Parcial", "Total" }));
			comboBoxTipoDerrumbe.setBounds(219, 25, 111, 20);
			comboBoxTipoDerrumbe.setSelectedItem("");
		}
		return comboBoxTipoDerrumbe;
	}

}

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
import javax.swing.border.TitledBorder;

import clases.Afectacion;
import clases.Construccion;
import clases.Material;
import clases.Sistema;
import clases.Techo;
import enums.TipoDerrumbe;
import util.TechoTableModel;
import util.Validaciones;
import visual.Frame;
import visual.util.CustomTable;

@SuppressWarnings({"rawtypes","unchecked"})
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
	private JComboBox comboBoxMatPredTecho;
	private JComboBox comboBoxTipoDerrumbeTecho;
	private JPanel panelButton;
	private JButton btnAddTecho;
	private JButton btnBorrarTecho;
	private JButton btnEditarTecho;
	private JTextField filtroNumero;
	private JComboBox filtroTipoDerrumbe;
	private JTable table;
	private TechoTableModel techoModel;
	private JButton btnOKTecho;
	private JButton btnCancelarTecho;

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
			glPanelInsertar.setHorizontalGroup(
				glPanelInsertar.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertar.createSequentialGroup()
						.addContainerGap()
						.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
							.addGroup(glPanelInsertar.createSequentialGroup()
								.addGroup(glPanelInsertar.createParallelGroup(Alignment.TRAILING)
									.addComponent(getLblIdentificadorTecho(), GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
									.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
										.addComponent(getLblMatPredTecho(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
										.addComponent(getLblTipoDerrumbeTecho(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(glPanelInsertar.createParallelGroup(Alignment.LEADING)
									.addComponent(getTxtIdentificadorTecho(), GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
									.addComponent(getComboBoxMatPredTecho(), 0, 170, Short.MAX_VALUE)
									.addComponent(getComboBoxTipoDerrumbeTecho(), 0, 170, Short.MAX_VALUE))
								.addGap(10))
							.addGroup(glPanelInsertar.createSequentialGroup()
								.addComponent(getBtnOKTecho(), GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getBtnCancelarTecho(), GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())))
			);
			glPanelInsertar.setVerticalGroup(
				glPanelInsertar.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertar.createSequentialGroup()
						.addContainerGap()
						.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
							.addComponent(getTxtIdentificadorTecho(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblIdentificadorTecho()))
						.addGap(38)
						.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblMatPredTecho())
							.addComponent(getComboBoxMatPredTecho(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(39)
						.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblTipoDerrumbeTecho())
							.addComponent(getComboBoxTipoDerrumbeTecho(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(42)
						.addGroup(glPanelInsertar.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtnOKTecho())
							.addComponent(getBtnCancelarTecho(), GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addGap(32))
			);
			glPanelInsertar.linkSize(SwingConstants.VERTICAL, new Component[] {getTxtIdentificadorTecho(), getComboBoxMatPredTecho(), getComboBoxTipoDerrumbeTecho()});
			glPanelInsertar.linkSize(SwingConstants.VERTICAL, new Component[] {getLblIdentificadorTecho(), getLblMatPredTecho(), getLblTipoDerrumbeTecho()});
			glPanelInsertar.linkSize(SwingConstants.HORIZONTAL, new Component[] {getBtnOKTecho(), getBtnCancelarTecho()});
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
			Validaciones.limitar(txtIdentificadorTecho, 11);
		}
		return txtIdentificadorTecho;
	}

	private JComboBox getComboBoxMatPredTecho() {
		if (comboBoxMatPredTecho == null) {
			ArrayList<String> names = new ArrayList<String>();
			for (Material mat : Sistema.getListaMateriales()) {
				if (mat instanceof Construccion) {
					names.add(mat.getNombre());
				}
			}
			comboBoxMatPredTecho = new JComboBox(names.toArray());
			comboBoxMatPredTecho.setSelectedItem(null);
		}
		return comboBoxMatPredTecho;
	}

	private JComboBox getComboBoxTipoDerrumbeTecho() {
		if (comboBoxTipoDerrumbeTecho == null) {
			comboBoxTipoDerrumbeTecho = new JComboBox();
			comboBoxTipoDerrumbeTecho.setModel(new DefaultComboBoxModel(TipoDerrumbe.values()));
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
			btnAddTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPredTecho.getSelectedItem()) != null
							&& comboBoxTipoDerrumbeTecho.getSelectedItem() != null
							&& !(txtIdentificadorTecho.getText()).isEmpty()) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).addTecho(new Techo(
								(txtIdentificadorTecho.getText()),
								(Construccion) Sistema.getMaterial((String) comboBoxMatPredTecho.getSelectedItem()),
								(TipoDerrumbe) comboBoxTipoDerrumbeTecho.getSelectedItem()));
						techoModel.actualizar(
								((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaTechos());
						comboBoxMatPredTecho.setSelectedItem(null);
						comboBoxTipoDerrumbeTecho.setSelectedItem(null);
						txtIdentificadorTecho.setText("");
					}
				}
			});
		}
		return btnAddTecho;
	}

	private JButton getBtnBorrarTecho() {
		if (btnBorrarTecho == null) {
			btnBorrarTecho = new JButton(BORRAR);
			btnBorrarTecho.setEnabled(false);
		}
		return btnBorrarTecho;
	}

	private JButton getBtnEditarTecho() {
		if (btnEditarTecho == null) {
			btnEditarTecho = new JButton(EDITAR);
			btnEditarTecho.setEnabled(false);
			btnEditarTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRowCount() > 0) {
						Techo techo = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaTechos()
								.get(table.getSelectedRow());
						txtIdentificadorTecho.setText(techo.getID());
						comboBoxMatPredTecho.setSelectedItem(techo.getMaterialPredominante().getNombre());
						comboBoxTipoDerrumbeTecho.setSelectedItem(techo.getTipoDerrumbe());

						btnOKTecho.setVisible(true);
						btnCancelarTecho.setVisible(true);

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

	private JComboBox getFiltroTipoDerrumbe() {
		if (filtroTipoDerrumbe == null) {
			filtroTipoDerrumbe = new JComboBox();
			filtroTipoDerrumbe.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					techoModel.filtrar((String) filtroTipoDerrumbe.getSelectedItem(), 2);
				}
			});
			filtroTipoDerrumbe.setModel(new DefaultComboBoxModel(new String[] { "", "Parcial", "Total" }));
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
	}

	private JButton getBtnOKTecho() {
		if (btnOKTecho == null) {
			btnOKTecho = new JButton("OK");
			btnOKTecho.setVisible(false);
			btnOKTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPredTecho.getSelectedItem()) != null
							&& comboBoxTipoDerrumbeTecho.getSelectedItem() != null
							&& !(txtIdentificadorTecho.getText()).isEmpty()) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).setTecho(
								table.getSelectedRow(),
								new Techo((txtIdentificadorTecho.getText()),
										(Construccion) Sistema
												.getMaterial((String) comboBoxMatPredTecho.getSelectedItem()),
										(TipoDerrumbe) comboBoxTipoDerrumbeTecho.getSelectedItem()));
						techoModel.actualizar(
								((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaTechos());

						comboBoxMatPredTecho.setSelectedItem(null);
						comboBoxTipoDerrumbeTecho.setSelectedItem(null);
						txtIdentificadorTecho.setText("");

						btnOKTecho.setVisible(false);
						btnCancelarTecho.setVisible(false);
						
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
			btnCancelarTecho.setVisible(false);
			btnCancelarTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					txtIdentificadorTecho.setText("");
					comboBoxMatPredTecho.setSelectedItem(null);
					comboBoxTipoDerrumbeTecho.setSelectedItem(null);

					btnOKTecho.setVisible(false);
					btnCancelarTecho.setVisible(false);

					bloquearCamposTecho(false);
				}
			});
		}
		return btnCancelarTecho;
	}

}

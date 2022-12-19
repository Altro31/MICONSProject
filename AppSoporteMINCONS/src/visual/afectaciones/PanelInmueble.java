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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import clases.Afectacion;
import clases.Inmueble;
import clases.Material;
import clases.Sistema;
import util.InmuebleTableModel;
import util.Validaciones;
import visual.Frame;
import visual.util.CustomTable;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class PanelInmueble extends JPanel {

	private static final long serialVersionUID = -5730976666092226455L;
	private static final String BORRAR = "Borrar";
	private static final String EDITAR = "Editar";
	private static final String ADD = "Añadir";
	private static final String CANCEL = "Cancelar";

	private CustomTable cTableInmueble;
	private JPanel panelButtonInmueble;
	private JButton btnAgnadirInmueble;
	private JButton btnBorrarInmueble;
	private JButton btnEditarInmueble;
	private JTextField filtroNumeroInmueble;
	private JPanel panelInsertarInmueble;
	private JLabel lblInmueble;
	private JComboBox comboBoxInmueble;
	private JLabel lblCantidad;
	private JSpinner spinnerCantidad;
	private JTable table;
	private JTextField filtroIDInmueble;
	private JTextField filtroNombreInmueble;
	private JTextField filtroCantidadInmueble;
	private JLabel lblIdInmueble;
	private JTextField txtIDInmueble;
	private InmuebleTableModel inmuebleModel;
	private JButton btnOKInmueble;
	private JButton btnCancelarInmueble;

	/**
	 * Create the panel.
	 */
	public PanelInmueble() {
		setLayout(null);
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Inmuebles Afectados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(getPanelButton());
		add(getFiltroNumero());
		add(getPanelInsertarInmueble());
		add(getFiltroIDInmueble());
		add(getFiltroNombreInmueble());
		add(getFiltroCantidadInmueble());
		add(getcTableInmueble());
	}

	private JPanel getPanelButton() {
		if (panelButtonInmueble == null) {
			panelButtonInmueble = new JPanel();
			FlowLayout flPanelButtonPared = (FlowLayout) panelButtonInmueble.getLayout();
			flPanelButtonPared.setVgap(8);
			flPanelButtonPared.setHgap(20);
			panelButtonInmueble.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButtonInmueble.setBounds(437, 299, 342, 41);
			panelButtonInmueble.add(getBtnAgnadir());
			panelButtonInmueble.add(getBtnBorrar());
			panelButtonInmueble.add(getBtnEditar());
		}
		return panelButtonInmueble;
	}

	private JButton getBtnAgnadir() {
		if (btnAgnadirInmueble == null) {
			btnAgnadirInmueble = new JButton(ADD);
			btnAgnadirInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxInmueble.getSelectedItem()) != null
							&& ((Integer) spinnerCantidad.getValue()).intValue() > 0) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaInmuebles()
								.add(new Inmueble(txtIDInmueble.getText(), (String) comboBoxInmueble.getSelectedItem(),
										((Inmueble) Sistema.getMaterial(txtIDInmueble.getText())).getPrecioUnitario(),
										((Integer) spinnerCantidad.getValue()).intValue()));
						inmuebleModel.actualizar(
								((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaInmuebles());
						comboBoxInmueble.setSelectedItem(null);
						spinnerCantidad.setValue(0);
						txtIDInmueble.setText("");
					}
				}
			});
		}
		return btnAgnadirInmueble;
	}

	private JButton getBtnBorrar() {
		if (btnBorrarInmueble == null) {
			btnBorrarInmueble = new JButton(BORRAR);
			btnBorrarInmueble.setEnabled(false);
		}
		return btnBorrarInmueble;
	}

	private JButton getBtnEditar() {
		if (btnEditarInmueble == null) {
			btnEditarInmueble = new JButton(EDITAR);
			btnEditarInmueble.setEnabled(false);
			btnEditarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRowCount() > 0) {
						Inmueble inmueble = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1])
								.getListaInmuebles().get(table.getSelectedRow());
						txtIDInmueble.setText(inmueble.getID());
						comboBoxInmueble.setSelectedItem(inmueble.getNombre());
						spinnerCantidad.setValue(inmueble.getCantidad());

						btnOKInmueble.setVisible(true);
						btnCancelarInmueble.setVisible(true);

						bloquearCampos(true);

					}
				}
			});
		}
		return btnEditarInmueble;
	}

	private void bloquearCampos(boolean bloquear) {
		bloquear = !bloquear;
		table.setEnabled(bloquear);
		btnAgnadirInmueble.setEnabled(bloquear);
		btnBorrarInmueble.setEnabled(bloquear);
		btnEditarInmueble.setEnabled(bloquear);
		filtroCantidadInmueble.setEnabled(bloquear);
		filtroIDInmueble.setEnabled(bloquear);
		filtroNumeroInmueble.setEnabled(bloquear);
		filtroNombreInmueble.setEnabled(bloquear);

	}

	private JTextField getFiltroNumero() {
		if (filtroNumeroInmueble == null) {
			filtroNumeroInmueble = new JTextField();
			filtroNumeroInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroNumeroInmueble.getText(), 0);
				}
			});
			filtroNumeroInmueble.setColumns(10);
			filtroNumeroInmueble.setBounds(10, 30, 41, 20);
		}
		return filtroNumeroInmueble;
	}

	private JPanel getPanelInsertarInmueble() {
		if (panelInsertarInmueble == null) {
			panelInsertarInmueble = new JPanel();
			panelInsertarInmueble.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Insertar Inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInsertarInmueble.setBounds(437, 25, 342, 263);
			GroupLayout glPanelInsertarInmueble = new GroupLayout(panelInsertarInmueble);
			glPanelInsertarInmueble.setHorizontalGroup(glPanelInsertarInmueble.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertarInmueble.createSequentialGroup().addContainerGap()
							.addGroup(glPanelInsertarInmueble.createParallelGroup(Alignment.LEADING)
									.addGroup(glPanelInsertarInmueble.createSequentialGroup()
											.addComponent(getLblIdInmueble(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getTxtIDInmueble(), GroupLayout.PREFERRED_SIZE, 199,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(glPanelInsertarInmueble.createSequentialGroup()
											.addComponent(getLblInmueble(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getComboBoxInmueble(), GroupLayout.PREFERRED_SIZE, 200,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(glPanelInsertarInmueble.createSequentialGroup()
											.addComponent(getLblCantidad(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getSpinnerCantidad(), GroupLayout.PREFERRED_SIZE, 55,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(glPanelInsertarInmueble.createSequentialGroup()
											.addComponent(getBtnOKInmueble())
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(getBtnCancelarInmueble())))
							.addContainerGap(24, Short.MAX_VALUE)));
			glPanelInsertarInmueble.setVerticalGroup(glPanelInsertarInmueble.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertarInmueble.createSequentialGroup().addGap(19)
							.addGroup(glPanelInsertarInmueble.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblIdInmueble(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxtIDInmueble(), GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(glPanelInsertarInmueble.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblInmueble(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getComboBoxInmueble(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPanelInsertarInmueble.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblCantidad(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getSpinnerCantidad(), GroupLayout.PREFERRED_SIZE, 24,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addGroup(glPanelInsertarInmueble.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtnOKInmueble()).addComponent(getBtnCancelarInmueble()))
							.addContainerGap()));
			glPanelInsertarInmueble.linkSize(SwingConstants.VERTICAL,
					new Component[] { getTxtIDInmueble(), getComboBoxInmueble(), getSpinnerCantidad() });
			glPanelInsertarInmueble.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getTxtIDInmueble(), getComboBoxInmueble() });
			glPanelInsertarInmueble.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getBtnOKInmueble(), getBtnCancelarInmueble() });
			panelInsertarInmueble.setLayout(glPanelInsertarInmueble);
		}
		return panelInsertarInmueble;
	}

	private JLabel getLblInmueble() {
		if (lblInmueble == null) {
			lblInmueble = new JLabel("Inmueble");
			lblInmueble.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblInmueble;
	}

	private JComboBox getComboBoxInmueble() {
		if (comboBoxInmueble == null) {
			ArrayList<String> names = new ArrayList<String>();
			for (Material mat : Sistema.getListaMateriales()) {
				if (mat instanceof Inmueble) {
					names.add(mat.getNombre());
				}
			}
			comboBoxInmueble = new JComboBox(new DefaultComboBoxModel(names.toArray()));
			comboBoxInmueble.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Material mat = Sistema.getMaterial((String) comboBoxInmueble.getSelectedItem());
					if (mat != null) {
						txtIDInmueble.setText(mat.getID());
					}
				}
			});
			comboBoxInmueble.setSelectedItem(null);

		}
		return comboBoxInmueble;
	}

	private JTextField getFiltroIDInmueble() {
		if (filtroIDInmueble == null) {
			filtroIDInmueble = new JTextField();
			filtroIDInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroIDInmueble.getText(), 1);
				}
			});
			filtroIDInmueble.setColumns(10);
			filtroIDInmueble.setBounds(51, 30, 147, 20);
		}
		return filtroIDInmueble;
	}

	private JTextField getFiltroNombreInmueble() {
		if (filtroNombreInmueble == null) {
			filtroNombreInmueble = new JTextField();
			filtroNombreInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroNombreInmueble.getText(), 2);
				}
			});
			filtroNombreInmueble.setColumns(10);
			filtroNombreInmueble.setBounds(198, 30, 147, 20);
		}
		return filtroNombreInmueble;
	}

	private JTextField getFiltroCantidadInmueble() {
		if (filtroCantidadInmueble == null) {
			filtroCantidadInmueble = new JTextField();
			filtroCantidadInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroCantidadInmueble.getText(), 3);
				}
			});
			filtroCantidadInmueble.setColumns(10);
			filtroCantidadInmueble.setBounds(345, 30, 82, 20);
		}
		return filtroCantidadInmueble;
	}

	private JLabel getLblIdInmueble() {
		if (lblIdInmueble == null) {
			lblIdInmueble = new JLabel("ID");
			lblIdInmueble.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblIdInmueble;
	}

	private JTextField getTxtIDInmueble() {
		if (txtIDInmueble == null) {
			txtIDInmueble = new JTextField();
			txtIDInmueble.setEditable(false);
			txtIDInmueble.setColumns(10);
			Validaciones.soloNumeros(txtIDInmueble, false);
			Validaciones.limitar(txtIDInmueble, 11);
		}
		return txtIDInmueble;
	}

	private JButton getBtnOKInmueble() {
		if (btnOKInmueble == null) {
			btnOKInmueble = new JButton("OK");
			btnOKInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxInmueble.getSelectedItem()) != null
							&& ((Integer) spinnerCantidad.getValue()).intValue() > 0) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).setInmueble(
								table.getSelectedRow(),
								new Inmueble(txtIDInmueble.getText(), (String) comboBoxInmueble.getSelectedItem(),
										((Inmueble) Sistema.getMaterial(txtIDInmueble.getText())).getPrecioUnitario(),
										((Integer) spinnerCantidad.getValue()).intValue()));
						inmuebleModel.actualizar(
								((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaInmuebles());

						comboBoxInmueble.setSelectedItem(null);
						spinnerCantidad.setValue(0);
						txtIDInmueble.setText("");

						btnCancelarInmueble.setVisible(false);
						btnOKInmueble.setVisible(false);

						bloquearCampos(false);
					}
				}
			});
			btnOKInmueble.setVisible(false);
		}
		return btnOKInmueble;
	}

	private JButton getBtnCancelarInmueble() {
		if (btnCancelarInmueble == null) {
			btnCancelarInmueble = new JButton(CANCEL);
			btnCancelarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtIDInmueble.setText("");
					comboBoxInmueble.setSelectedItem(null);
					spinnerCantidad.setValue(0);
					btnCancelarInmueble.setVisible(false);
					btnOKInmueble.setVisible(false);
					bloquearCampos(false);
				}
			});
			btnCancelarInmueble.setVisible(false);
		}
		return btnCancelarInmueble;
	}

	private JScrollPane getcTableInmueble() {
		if (cTableInmueble == null) {
			inmuebleModel = new InmuebleTableModel();
			cTableInmueble = new CustomTable(inmuebleModel, btnBorrarInmueble, btnEditarInmueble, new int[] {});
			cTableInmueble.getTable().getColumnModel().getColumn(0).setResizable(false);
			cTableInmueble.getTable().getColumnModel().getColumn(0).setPreferredWidth(40);
			cTableInmueble.getTable().getColumnModel().getColumn(0).setMaxWidth(40);
			cTableInmueble.getTable().getColumnModel().getColumn(1).setResizable(false);
			cTableInmueble.getTable().getColumnModel().getColumn(2).setResizable(false);
			cTableInmueble.getTable().getColumnModel().getColumn(3).setResizable(false);
			cTableInmueble.getTable().getColumnModel().getColumn(3).setPreferredWidth(80);
			cTableInmueble.getTable().getColumnModel().getColumn(3).setMaxWidth(80);
			cTableInmueble.setBounds(10, 52, 417, 289);
			table = cTableInmueble.getTable();
		}
		return cTableInmueble;
	}

	private JLabel getLblCantidad() {
		if (lblCantidad == null) {
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblCantidad;
	}

	private JSpinner getSpinnerCantidad() {
		if (spinnerCantidad == null) {
			spinnerCantidad = new JSpinner();
			spinnerCantidad
					.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		}
		return spinnerCantidad;
	}

}

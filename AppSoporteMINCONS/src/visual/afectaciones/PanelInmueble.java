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

import clases.FichaTecnica;
import clases.Inmueble;
import clases.Material;
import clases.Sistema;
import util.Auxiliary;
import util.InmuebleTableModel;
import visual.Frame;
import visual.util.CustomTable;

public class PanelInmueble extends JPanel {

	private static final long serialVersionUID = -5730976666092226455L;
	private static final String BORRAR = "Borrar";
	private static final String EDITAR = "Editar";
	private static final String ADD = "Añadir";
	private static final String CANCEL = "Cancelar";

	private CustomTable cTable;
	private JPanel panelButton;
	private JButton btnAgnadirInmueble;
	private JButton btnBorrarInmueble;
	private JButton btnEditarInmueble;
	private JTextField filtroNumero;
	private JPanel panelInsertar;
	private JLabel lblInmueble;
	private JComboBox<String> comboBoxInmueble;
	private JLabel lblCantidad;
	private JSpinner spinnerCantidad;
	private JTable table;
	private JTextField filtroID;
	private JTextField filtroNombre;
	private JTextField filtroCantidad;
	private JLabel lblID;
	private JTextField txtID;
	private InmuebleTableModel inmuebleModel;
	private JButton btnOK;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public PanelInmueble() {
		super();
		setLayout(null);
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Inmuebles Afectados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(getPanelButton());
		add(getFiltroNumero());
		add(getPanelInsertar());
		add(getFiltroID());
		add(getFiltroNombre());
		add(getFiltroCantidad());
		add(getcTable());

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				inmuebleModel.actualizar();
			}
		});

	}

	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			FlowLayout flPanelButton = (FlowLayout) panelButton.getLayout();
			flPanelButton.setVgap(8);
			flPanelButton.setHgap(20);
			panelButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButton.setBounds(437, 299, 342, 41);
			panelButton.add(getBtnAgnadir());
			panelButton.add(getBtnBorrar());
			panelButton.add(getBtnEditar());
		}
		return panelButton;
	}

	private JButton getBtnAgnadir() {
		if (btnAgnadirInmueble == null) {
			btnAgnadirInmueble = new JButton(ADD);
			btnAgnadirInmueble.setFocusable(false);
			btnAgnadirInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					final ArrayList<Inmueble> listaInmuebles = ((FichaTecnica) Frame.getPosicionActual()[1]).getAfect()
							.getListaInmuebles();
					if (((String) comboBoxInmueble.getSelectedItem()) != null
							&& ((Integer) spinnerCantidad.getValue()).intValue() > 0) {

						String id = txtID.getText();
						Inmueble inmueble = null;

						boolean check = false;
						for (Inmueble i : listaInmuebles) {
							if (i.getID().equals(id)) {
								check = true;
								inmueble = i;
							}
						}

						if (check) {
							inmueble.setCantidad(
									inmueble.getCantidad() + ((Integer) spinnerCantidad.getValue()).intValue());
						} else {

							listaInmuebles
									.add(new Inmueble(txtID.getText(), (String) comboBoxInmueble.getSelectedItem(),
											((Inmueble) Sistema.getMaterial(txtID.getText())).getPrecioUnitario(),
											((Integer) spinnerCantidad.getValue()).intValue()));
						}
						inmuebleModel.actualizar();
						comboBoxInmueble.setSelectedItem(null);
						spinnerCantidad.setValue(0);
						txtID.setText("");
					}
				}
			});
		}
		return btnAgnadirInmueble;
	}

	private JButton getBtnBorrar() {
		if (btnBorrarInmueble == null) {
			btnBorrarInmueble = new JButton(BORRAR);
			btnBorrarInmueble.setFocusable(false);
			btnBorrarInmueble.setEnabled(false);
		}
		return btnBorrarInmueble;
	}

	private JButton getBtnEditar() {
		if (btnEditarInmueble == null) {
			btnEditarInmueble = new JButton(EDITAR);
			btnEditarInmueble.setFocusable(false);
			btnEditarInmueble.setEnabled(false);
			btnEditarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRowCount() > 0) {
						final ArrayList<Inmueble> listaInmuebles = ((FichaTecnica) Frame.getPosicionActual()[1])
								.getAfect().getListaInmuebles();
						Inmueble inmueble = listaInmuebles.get(
								Integer.parseInt((String) inmuebleModel.getValueAt(table.getSelectedRow(), 0)) - 1);

						txtID.setText(inmueble.getID());
						comboBoxInmueble.setSelectedItem(inmueble.getNombre());
						spinnerCantidad.setValue(inmueble.getCantidad());

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
		filtroCantidad.setEnabled(bloquear);
		filtroID.setEnabled(bloquear);
		filtroNumero.setEnabled(bloquear);
		filtroNombre.setEnabled(bloquear);
		comboBoxInmueble.setEnabled(bloquear);
		btnOK.setVisible(!bloquear);
		btnCancelar.setVisible(!bloquear);

	}

	private JTextField getFiltroNumero() {
		if (filtroNumero == null) {
			filtroNumero = new JTextField();
			filtroNumero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroNumero.getText(), 0);
				}
			});
			filtroNumero.setColumns(10);
			filtroNumero.setBounds(10, 30, 41, 20);
		}
		return filtroNumero;
	}

	private JPanel getPanelInsertar() {
		if (panelInsertar == null) {
			panelInsertar = new JPanel();
			panelInsertar.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Insertar Inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInsertar.setBounds(437, 25, 342, 263);
			GroupLayout gl_panelInsertar = new GroupLayout(panelInsertar);
			gl_panelInsertar.setHorizontalGroup(gl_panelInsertar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertar.createSequentialGroup().addContainerGap()
							.addGroup(gl_panelInsertar.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelInsertar.createSequentialGroup()
											.addComponent(getLblID(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(getTxtID(),
													GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelInsertar.createSequentialGroup()
											.addComponent(getLblInmueble(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getComboBoxInmueble(), GroupLayout.PREFERRED_SIZE, 200,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelInsertar.createSequentialGroup()
											.addComponent(getLblCantidad(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(
													getSpinnerCantidad(), GroupLayout.PREFERRED_SIZE, 55,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelInsertar.createSequentialGroup().addComponent(getBtnOK())
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(getBtnCancelar())))
							.addContainerGap(24, Short.MAX_VALUE)));
			gl_panelInsertar.setVerticalGroup(gl_panelInsertar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertar.createSequentialGroup().addGap(19)
							.addGroup(gl_panelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblID(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxtID(), GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(gl_panelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblInmueble(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getComboBoxInmueble(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelInsertar.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblCantidad(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getSpinnerCantidad(), GroupLayout.PREFERRED_SIZE, 24,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addGroup(gl_panelInsertar.createParallelGroup(Alignment.BASELINE).addComponent(getBtnOK())
									.addComponent(getBtnCancelar()))
							.addContainerGap()));
			gl_panelInsertar.linkSize(SwingConstants.VERTICAL,
					new Component[] { getTxtID(), getComboBoxInmueble(), getSpinnerCantidad() });
			gl_panelInsertar.linkSize(SwingConstants.HORIZONTAL, new Component[] { getTxtID(), getComboBoxInmueble() });
			gl_panelInsertar.linkSize(SwingConstants.HORIZONTAL, new Component[] { getBtnOK(), getBtnCancelar() });
			panelInsertar.setLayout(gl_panelInsertar);
		}
		return panelInsertar;
	}

	private JLabel getLblInmueble() {
		if (lblInmueble == null) {
			lblInmueble = new JLabel("Inmueble");
			lblInmueble.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblInmueble;
	}

	private JComboBox<String> getComboBoxInmueble() {
		if (comboBoxInmueble == null) {
			ArrayList<String> names = new ArrayList<String>();
			for (Material mat : Sistema.getListaMateriales()) {
				if (mat instanceof Inmueble) {
					names.add(mat.getNombre());
				}
			}
			comboBoxInmueble = new JComboBox<String>(new DefaultComboBoxModel<String>(names.toArray(new String[0])));
			comboBoxInmueble.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Material mat = Sistema.getMaterial((String) comboBoxInmueble.getSelectedItem());
					if (mat != null) {
						txtID.setText(mat.getID());
					}
				}
			});
			comboBoxInmueble.setSelectedItem(null);

		}
		return comboBoxInmueble;
	}

	private JTextField getFiltroID() {
		if (filtroID == null) {
			filtroID = new JTextField();
			filtroID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroID.getText(), 1);
				}
			});
			filtroID.setColumns(10);
			filtroID.setBounds(51, 30, 147, 20);
		}
		return filtroID;
	}

	private JTextField getFiltroNombre() {
		if (filtroNombre == null) {
			filtroNombre = new JTextField();
			filtroNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroNombre.getText(), 2);
				}
			});
			filtroNombre.setColumns(10);
			filtroNombre.setBounds(198, 30, 147, 20);
		}
		return filtroNombre;
	}

	private JTextField getFiltroCantidad() {
		if (filtroCantidad == null) {
			filtroCantidad = new JTextField();
			filtroCantidad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroCantidad.getText(), 3);
				}
			});
			filtroCantidad.setColumns(10);
			filtroCantidad.setBounds(345, 30, 82, 20);
		}
		return filtroCantidad;
	}

	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel("ID");
			lblID.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblID;
	}

	private JTextField getTxtID() {
		if (txtID == null) {
			txtID = new JTextField();
			txtID.setEditable(false);
			txtID.setColumns(10);
		}
		return txtID;
	}

	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.setFocusable(false);
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					final ArrayList<Inmueble> listaInmuebles = ((FichaTecnica) Frame.getPosicionActual()[1]).getAfect()
							.getListaInmuebles();
					if (((String) comboBoxInmueble.getSelectedItem()) != null
							&& ((Integer) spinnerCantidad.getValue()).intValue() > 0) {
						listaInmuebles.set(
								Integer.parseInt((String) inmuebleModel.getValueAt(table.getSelectedRow(), 0)) - 1,
								new Inmueble(txtID.getText(), (String) comboBoxInmueble.getSelectedItem(),
										((Inmueble) Sistema.getMaterial(txtID.getText())).getPrecioUnitario(),
										((Integer) spinnerCantidad.getValue()).intValue()));
						inmuebleModel.actualizar();

						comboBoxInmueble.setSelectedItem(null);
						spinnerCantidad.setValue(0);
						txtID.setText("");

						bloquearCampos(false);
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
					txtID.setText("");
					comboBoxInmueble.setSelectedItem(null);
					spinnerCantidad.setValue(0);

					bloquearCampos(false);
				}
			});
			btnCancelar.setVisible(false);
		}
		return btnCancelar;
	}

	private JScrollPane getcTable() {
		if (cTable == null) {
			inmuebleModel = new InmuebleTableModel();
			cTable = new CustomTable(inmuebleModel, btnBorrarInmueble, btnEditarInmueble, new int[] {});

			cTable.getTable().getColumnModel().getColumn(0).setResizable(false);
			cTable.getTable().getColumnModel().getColumn(0).setPreferredWidth(40);
			cTable.getTable().getColumnModel().getColumn(0).setMaxWidth(40);
			cTable.getTable().getColumnModel().getColumn(1).setResizable(false);
			cTable.getTable().getColumnModel().getColumn(2).setResizable(false);
			cTable.getTable().getColumnModel().getColumn(3).setResizable(false);
			cTable.getTable().getColumnModel().getColumn(3).setPreferredWidth(80);
			cTable.getTable().getColumnModel().getColumn(3).setMaxWidth(80);
			cTable.setBounds(10, 52, 417, 289);
			table = cTable.getTable();
			btnBorrarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					final ArrayList<Inmueble> listaInmuebles = ((FichaTecnica) Frame.getPosicionActual()[1]).getAfect()
							.getListaInmuebles();
					Auxiliary.borrarSeleccion(table, listaInmuebles);

					inmuebleModel.actualizar();
				}
			});

		}
		return cTable;
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

	public void actualizarTabla(ArrayList<Inmueble> lista) {
		inmuebleModel.actualizar(lista);
	}

}

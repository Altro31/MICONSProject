package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import clases.Afectacion;
import clases.Construccion;
import clases.Cubicacion;
import clases.Inmueble;
import clases.Material;
import clases.Pared;
import clases.Sistema;
import clases.Techo;
import clases.Vivienda;
import enums.TipoDerrumbe;
import util.Auxiliary;
import util.InmuebleTableModel;
import util.ParedTableModel;
import util.TechoTableModel;
import util.Validaciones;
import visual.util.PrincipalPanel;
import javax.swing.ListSelectionModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Afectaciones extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3579071471874747942L;
	private static final String BORRAR = "Borrar";
	private static final String EDITAR = "Editar";
	private static final String ADD = "Añadir";
	private JTabbedPane tabbedPane;
	private JPanel panelInmueble;
	private JPanel panelPared;
	private JPanel panelTecho;
	private JLabel lblAfectacionesDeLa;
	private JScrollPane scrollTablePared;
	private JPanel panelInsertarPared;
	private JLabel lblIdentificadorPared;
	private JLabel lblMatPred;
	private JLabel lblTipoDerrumbePared;
	private JLabel lblParedCarga;
	private JTextField txtIdentificadorPared;
	private JComboBox comboBoxMatPredPared;
	private JComboBox comboBoxTipoDerrumbePared;
	private JCheckBox cBoxParedCarga;
	private JPanel panelButtonPared;
	private JButton btnAgnadirPared;
	private JButton btnBorrarPared;
	private JButton btnEditarPared;
	private JPanel panelButton2;
	private JButton btnCancelar;
	private JButton btnSiguiente;
	private JTable tablePared;
	private ParedTableModel paredModel;
	private JTextField filtroNumeroPared;
	private JTextField filtroIdentificador;
	private JComboBox comboBoxTipoDerrumbe;
	private JComboBox comboBoxParedCarga;
	private JScrollPane scrollTableInmueble;
	private JPanel panelButtonInmueble;
	private JButton btnAgnadirInmueble;
	private JButton btnBorrarInmueble;
	private JButton btnEditarInmueble;
	private JTextField filtroNumeroInmueble;
	private JScrollPane scrollTableTecho;
	private JPanel panelInsertarTecho;
	private JLabel lblIdentificadorTecho;
	private JLabel lblMatPredTecho;
	private JLabel lblTipoDerrumbeTecho;
	private JTextField txtIdentificadorTecho;
	private JComboBox comboBoxMatPredTecho;
	private JComboBox comboBoxTipoDerrumbeTecho;
	private JPanel panelButtonTecho;
	private JButton btnAddTecho;
	private JButton btnBorrarTecho;
	private JButton btnEditarTecho;
	private JTextField filtroNumeroTecho;
	private JTextField filtroIDTecho;
	private JComboBox filtroTipoDerrumbeTecho;
	private JPanel panelInsertarInmueble;
	private JLabel lblInmueble;
	private JComboBox comboBoxInmueble;
	private JLabel lblCantidad;
	private JSpinner spinnerCantidad;
	private JTable tableInmueble;
	private JTextField filtroIDInmueble;
	private JTextField filtroNombreInmueble;
	private JTextField filtroCantidadInmueble;
	private JLabel lblIdInmueble;
	private JTextField txtIDInmueble;
	private InmuebleTableModel inmuebleModel;
	private JCheckBox cBoxSelectPared;
	private JCheckBox cBoxSelectInmuebles;
	private JTable tableTecho;
	private JCheckBox cBoxSelectTecho;
	private TechoTableModel techoModel;
	private JButton btnOKInmueble;
	private JButton btnCancelarInmueble;
	private JButton btnOKPared;
	private JButton btnCancelarPared;
	private JButton btnOKTecho;
	private JButton btnCancelarTecho;

	/**
	 * Create the panel.
	 */
	public Afectaciones() {
		btnCerrar.setLocation(851, 0);
		btnAtras.setLocation(0, 0);
		btnCerrar.setSize(40, 29);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.setContentPanes((Viviendas) ((Object[]) Frame.getPosicionActual()[0])[0]);
			}
		});
		add(getTabbedPane());
		add(getLblAfectacionesDeLa());
		add(getPanelButton2());
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(SwingConstants.LEFT);
			tabbedPane.setOpaque(true);
			tabbedPane.setBounds(10, 66, 871, 379);
			tabbedPane.addTab("Inmueble", null, getPanelInmueble(), null);
			tabbedPane.addTab("Pared", null, getPanelPared(), null);
			tabbedPane.addTab("Techo", null, getPanelTecho(), null);
		}
		return tabbedPane;
	}

	private JPanel getPanelInmueble() {
		if (panelInmueble == null) {
			panelInmueble = new JPanel();
			panelInmueble.setLayout(null);
			panelInmueble.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Inmuebles Afectados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInmueble.setBounds(0, 0, 806, 374);
			panelInmueble.add(getScrollTableInmueble());
			panelInmueble.add(getPanelButtonInmueble());
			panelInmueble.add(getFiltroNumeroInmueble());
			panelInmueble.add(getPanelInsertarInmueble());
			panelInmueble.add(getFiltroIDInmueble());
			panelInmueble.add(getFiltroNombreInmueble());
			panelInmueble.add(getFiltroCantidadInmueble());
			panelInmueble.add(getCBoxSelectInmuebles());

		}
		return panelInmueble;
	}

	private JPanel getPanelPared() {
		if (panelPared == null) {
			panelPared = new JPanel();
			panelPared.setLayout(null);
			panelPared.setBorder(new TitledBorder(

					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

					"Paredes Afectadas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelPared.setBounds(10, 11, 786, 352);
			panelPared.add(getScrollTablePared());
			panelPared.add(getPanelInsertarPared());
			panelPared.add(getPanelButtonPared());
			panelPared.add(getFiltroNumeroPared());
			panelPared.add(getFiltroIdentificador());
			panelPared.add(getComboBoxTipoDerrumbe());
			panelPared.add(getComboBoxParedCarga());
			panelPared.add(getCBoxSelectPared());
		}
		return panelPared;
	}

	private JPanel getPanelTecho() {
		if (panelTecho == null) {
			panelTecho = new JPanel();
			panelTecho.setLayout(null);
			panelTecho.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Techos Afectados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTecho.setBounds(0, 0, 806, 374);
			panelTecho.add(getScrollTableTecho());
			panelTecho.add(getPanelInsertarTecho());
			panelTecho.add(getPanelButtonTecho());
			panelTecho.add(getFiltroNumeroTecho());
			panelTecho.add(getFiltroIDTecho());
			panelTecho.add(getFiltroTipoDerrumbeTecho());
			panelTecho.add(getCBoxSelectTecho());
		}
		return panelTecho;
	}

	private JLabel getLblAfectacionesDeLa() {
		if (lblAfectacionesDeLa == null) {
			lblAfectacionesDeLa = new JLabel("Afectaciones de la Viviendas");
			lblAfectacionesDeLa.setOpaque(true);
			lblAfectacionesDeLa.setHorizontalTextPosition(SwingConstants.CENTER);
			lblAfectacionesDeLa.setHorizontalAlignment(SwingConstants.CENTER);
			lblAfectacionesDeLa.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAfectacionesDeLa
					.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
			lblAfectacionesDeLa.setBounds(10, 33, 871, 29);
		}
		return lblAfectacionesDeLa;
	}

	private JScrollPane getScrollTablePared() {
		if (scrollTablePared == null) {
			scrollTablePared = new JScrollPane();
			scrollTablePared.setBounds(10, 52, 417, 289);
			scrollTablePared.setViewportView(getTablePared());
		}
		return scrollTablePared;
	}

	private JTable getTablePared() {
		if (tablePared == null) {
			paredModel = new ParedTableModel();
			paredModel.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent e) {
					activarBotonBorrarPared();
				}
			});
			tablePared = new JTable(paredModel);
			tablePared.getTableHeader().setReorderingAllowed(false);
			tablePared.getColumnModel().getColumn(0).setResizable(false);
			tablePared.getColumnModel().getColumn(0).setPreferredWidth(15);
			tablePared.getColumnModel().getColumn(0).setMinWidth(0);
			tablePared.getColumnModel().getColumn(1).setResizable(false);
			tablePared.getColumnModel().getColumn(1).setPreferredWidth(1);
			tablePared.getColumnModel().getColumn(1).setMinWidth(0);
			tablePared.getColumnModel().getColumn(2).setPreferredWidth(80);
			tablePared.getColumnModel().getColumn(2).setResizable(false);
			tablePared.getColumnModel().getColumn(3).setPreferredWidth(80);
			tablePared.getColumnModel().getColumn(3).setResizable(false);
			tablePared.getColumnModel().getColumn(4).setResizable(false);
			tablePared.getColumnModel().getColumn(4).setPreferredWidth(65);
		}
		return tablePared;
	}

	private JPanel getPanelInsertarPared() {
		if (panelInsertarPared == null) {
			panelInsertarPared = new JPanel();
			panelInsertarPared.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Insertar Pared", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInsertarPared.setBounds(437, 25, 342, 263);
			GroupLayout glPanelInsertarPared = new GroupLayout(panelInsertarPared);
			glPanelInsertarPared.setHorizontalGroup(glPanelInsertarPared.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertarPared.createSequentialGroup().addContainerGap().addGroup(
							glPanelInsertarPared.createParallelGroup(Alignment.LEADING).addGroup(glPanelInsertarPared
									.createSequentialGroup()
									.addGroup(glPanelInsertarPared.createParallelGroup(Alignment.LEADING).addGroup(
											glPanelInsertarPared.createSequentialGroup().addGroup(glPanelInsertarPared
													.createParallelGroup(Alignment.LEADING, false)
													.addComponent(getLblIdentificadorPared(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(getLblMatPred(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(getLblTipoDerrumbePared(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
													.addGap(26))
											.addGroup(glPanelInsertarPared.createSequentialGroup()
													.addComponent(getLblParedCarga(), GroupLayout.DEFAULT_SIZE, 133,
															Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(glPanelInsertarPared.createParallelGroup(Alignment.LEADING)
											.addComponent(getComboBoxTipoDerrumbePared(), 0, 173, Short.MAX_VALUE)
											.addComponent(getComboBoxMatPredPared(), 0, 173, Short.MAX_VALUE)
											.addComponent(getTxtIdentificadorPared(), GroupLayout.DEFAULT_SIZE, 173,
													Short.MAX_VALUE)
											.addComponent(getCBoxParedCarga(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(glPanelInsertarPared.createSequentialGroup()
											.addComponent(getBtnOKPared(), GroupLayout.PREFERRED_SIZE, 75,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(getBtnCancelarPared())))
							.addGap(10)));
			glPanelInsertarPared.setVerticalGroup(glPanelInsertarPared.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertarPared.createSequentialGroup().addContainerGap()
							.addGroup(glPanelInsertarPared.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblIdentificadorPared()).addComponent(getTxtIdentificadorPared(),
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPanelInsertarPared.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblMatPred())
									.addComponent(getComboBoxMatPredPared(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPanelInsertarPared.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblTipoDerrumbePared())
									.addComponent(getComboBoxTipoDerrumbePared(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(glPanelInsertarPared.createParallelGroup(Alignment.TRAILING)
									.addComponent(getCBoxParedCarga()).addComponent(getLblParedCarga()))
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addGroup(glPanelInsertarPared.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtnOKPared()).addComponent(getBtnCancelarPared()))
							.addGap(23)));
			glPanelInsertarPared.linkSize(SwingConstants.VERTICAL, new Component[] { getComboBoxTipoDerrumbePared(),
					getComboBoxMatPredPared(), getTxtIdentificadorPared() });
			glPanelInsertarPared.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblIdentificadorPared(), getLblMatPred(), getLblTipoDerrumbePared() });
			panelInsertarPared.setLayout(glPanelInsertarPared);
		}
		return panelInsertarPared;
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

	private JPanel getPanelButtonPared() {
		if (panelButtonPared == null) {
			panelButtonPared = new JPanel();
			panelButtonPared.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			FlowLayout flPanelButtonPared = (FlowLayout) panelButtonPared.getLayout();
			flPanelButtonPared.setVgap(8);
			flPanelButtonPared.setHgap(20);
			panelButtonPared.setBounds(437, 299, 342, 41);
			panelButtonPared.add(getBtnAgnadirPared());
			panelButtonPared.add(getBtnBorrarPared());
			panelButtonPared.add(getBtnEditarPared());
		}
		return panelButtonPared;
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
								(txtIdentificadorPared.getText()),
								(Construccion) Sistema.getMaterial((String) comboBoxMatPredPared.getSelectedItem()),
								(TipoDerrumbe) comboBoxTipoDerrumbePared.getSelectedItem(),
								cBoxParedCarga.isSelected()));
						paredModel.actualizar(
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
			btnBorrarPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					paredModel.borrarSeleccion();
					activarBotonBorrarPared();
				}
			});
		}
		return btnBorrarPared;
	}

	private JButton getBtnEditarPared() {
		if (btnEditarPared == null) {
			btnEditarPared = new JButton(EDITAR);
			btnEditarPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tablePared.getSelectedRowCount() > 0) {
						Pared pared = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaParedes()
								.get(tablePared.getSelectedRow());
						txtIdentificadorPared.setText(pared.getIdentificador());
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

	private JPanel getPanelButton2() {
		if (panelButton2 == null) {
			panelButton2 = new JPanel();
			FlowLayout flPanelButton2 = (FlowLayout) panelButton2.getLayout();
			flPanelButton2.setHgap(50);
			panelButton2.setBounds(10, 448, 871, 36);
			panelButton2.add(getBtnSiguiente());
			panelButton2.add(getBtnCancelar());
		}
		return panelButton2;
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
		}
		return btnCancelar;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showConfirmDialog(Frame.getInstance(),
							"Está a punto de guardar los datos registrados en una Ficha Técnica.\n"
									+ "¿Desea asignar los materiales necesarios para las reparaciones de la Vivienda?\n"
									+ "*Tenga en cuenta que éste proceso puede realizarse más adelante") == 0) {
						
						Frame.setContentPanes((AsignarMateriales)((Object[])Frame.getPosicionActual()[0])[2]);
						
					}
				}
			});
		}
		return btnSiguiente;
	}

	private JTextField getFiltroNumeroPared() {
		if (filtroNumeroPared == null) {
			filtroNumeroPared = new JTextField();
			filtroNumeroPared.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					paredModel.filtrar(filtroNumeroPared.getText(), 1);
				}
			});
			filtroNumeroPared.setColumns(10);
			filtroNumeroPared.setBounds(58, 25, 46, 20);
		}
		return filtroNumeroPared;
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
					paredModel.filtrar((String) comboBoxTipoDerrumbe.getSelectedItem(), 3);
				}
			});
			comboBoxTipoDerrumbe.setModel(new DefaultComboBoxModel(new String[] { "", "Parcial", "Total" }));
			comboBoxTipoDerrumbe.setBounds(219, 25, 111, 20);
			comboBoxTipoDerrumbe.setSelectedItem("");
		}
		return comboBoxTipoDerrumbe;
	}

	private JComboBox getComboBoxParedCarga() {
		if (comboBoxParedCarga == null) {
			comboBoxParedCarga = new JComboBox();
			comboBoxParedCarga.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					paredModel.filtrar((String) comboBoxParedCarga.getSelectedItem(), 4);
				}
			});
			comboBoxParedCarga.setModel(new DefaultComboBoxModel(new String[] { "", "Si", "No" }));
			comboBoxParedCarga.setBounds(332, 25, 95, 20);
			comboBoxParedCarga.setSelectedItem("");
		}
		return comboBoxParedCarga;
	}

	private JScrollPane getScrollTableInmueble() {
		if (scrollTableInmueble == null) {
			scrollTableInmueble = new JScrollPane();
			scrollTableInmueble.setBounds(10, 52, 417, 289);
			scrollTableInmueble.setViewportView(getTableInmueble());
		}
		return scrollTableInmueble;
	}

	private JPanel getPanelButtonInmueble() {
		if (panelButtonInmueble == null) {
			panelButtonInmueble = new JPanel();
			FlowLayout flPanelButtonPared = (FlowLayout) panelButtonInmueble.getLayout();
			flPanelButtonPared.setVgap(8);
			flPanelButtonPared.setHgap(20);
			panelButtonInmueble.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButtonInmueble.setBounds(437, 299, 342, 41);
			panelButtonInmueble.add(getBtnAgnadirInmueble());
			panelButtonInmueble.add(getBtnBorrarInmueble());
			panelButtonInmueble.add(getBtnEditarInmueble());
		}
		return panelButtonInmueble;
	}

	private void activarBotonBorrarInmueble() {
		int filas = inmuebleModel.getRowCount();
		boolean check = false;
		for (int i = 0; i < filas && !check; i++) {
			if (Auxiliary.isSelected(i, 0, inmuebleModel))
				check = true;
		}
		btnBorrarInmueble.setEnabled(check);
	}

	private void activarBotonBorrarPared() {
		int filas = paredModel.getRowCount();
		boolean check = false;
		for (int i = 0; i < filas && !check; i++) {
			if (Auxiliary.isSelected(i, 0, paredModel))
				check = true;
		}
		btnBorrarPared.setEnabled(check);
	}

	private void activarBotonBorrarTecho() {
		int filas = techoModel.getRowCount();
		boolean check = false;
		for (int i = 0; i < filas && !check; i++) {
			if (Auxiliary.isSelected(i, 0, techoModel))
				check = true;
		}
		btnBorrarTecho.setEnabled(check);
	}

	private JButton getBtnAgnadirInmueble() {
		if (btnAgnadirInmueble == null) {
			btnAgnadirInmueble = new JButton("Añadir");
			btnAgnadirInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxInmueble.getSelectedItem()) != null
							&& ((Integer) spinnerCantidad.getValue()).intValue() > 0) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1])
								.addInmueble(new Inmueble((String) comboBoxInmueble.getSelectedItem(),
										txtIDInmueble.getText(), ((Integer) spinnerCantidad.getValue()).intValue()));
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

	private JButton getBtnBorrarInmueble() {
		if (btnBorrarInmueble == null) {
			btnBorrarInmueble = new JButton(BORRAR);
			btnBorrarInmueble.setEnabled(false);
			btnBorrarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inmuebleModel.borrarSeleccion();
				}
			});
		}
		return btnBorrarInmueble;
	}

	private JButton getBtnEditarInmueble() {
		if (btnEditarInmueble == null) {
			btnEditarInmueble = new JButton(EDITAR);
			btnEditarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tableInmueble.getSelectedRowCount() > 0) {
						Inmueble inmueble = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1])
								.getListaInmuebles().get(tableInmueble.getSelectedRow());
						txtIDInmueble.setText(inmueble.getIdentificador());
						comboBoxInmueble.setSelectedItem(inmueble.getNombre());
						spinnerCantidad.setValue(inmueble.getCantidad());

						btnOKInmueble.setVisible(true);
						btnCancelarInmueble.setVisible(true);

						bloquearCamposInmueble(true);

					}
				}
			});
		}
		return btnEditarInmueble;
	}

	private JTextField getFiltroNumeroInmueble() {
		if (filtroNumeroInmueble == null) {
			filtroNumeroInmueble = new JTextField();
			filtroNumeroInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroNumeroInmueble.getText(), 1);
				}
			});
			filtroNumeroInmueble.setColumns(10);
			filtroNumeroInmueble.setBounds(74, 25, 60, 20);
		}
		return filtroNumeroInmueble;
	}

	private JScrollPane getScrollTableTecho() {
		if (scrollTableTecho == null) {
			scrollTableTecho = new JScrollPane();
			scrollTableTecho.setBounds(10, 52, 417, 289);
			scrollTableTecho.setViewportView(getTableTecho());
		}
		return scrollTableTecho;
	}

	private JPanel getPanelInsertarTecho() {
		if (panelInsertarTecho == null) {
			panelInsertarTecho = new JPanel();
			panelInsertarTecho.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Insertar Techo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInsertarPared.setBounds(437, 25, 342, 263);
			panelInsertarTecho.setBounds(437, 25, 342, 263);
			GroupLayout glPanelInsertarTecho = new GroupLayout(panelInsertarTecho);
			glPanelInsertarTecho.setHorizontalGroup(glPanelInsertarTecho.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertarTecho.createSequentialGroup().addContainerGap().addGroup(
							glPanelInsertarTecho.createParallelGroup(Alignment.LEADING).addGroup(glPanelInsertarTecho
									.createSequentialGroup()
									.addGroup(glPanelInsertarTecho.createParallelGroup(Alignment.LEADING)
											.addComponent(getLblIdentificadorTecho(), GroupLayout.PREFERRED_SIZE, 77,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getLblMatPredTecho(), GroupLayout.PREFERRED_SIZE, 136,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getLblTipoDerrumbeTecho(), GroupLayout.PREFERRED_SIZE, 136,
													GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(glPanelInsertarTecho.createParallelGroup(Alignment.LEADING)
											.addComponent(getTxtIdentificadorTecho(), GroupLayout.DEFAULT_SIZE, 170,
													Short.MAX_VALUE)
											.addComponent(getComboBoxMatPredTecho(), 0, 170, Short.MAX_VALUE)
											.addComponent(getComboBoxTipoDerrumbeTecho(), 0, 170, Short.MAX_VALUE))
									.addGap(10))
									.addGroup(glPanelInsertarTecho.createSequentialGroup()
											.addComponent(getBtnOKTecho(), GroupLayout.PREFERRED_SIZE, 84,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getBtnCancelarTecho(), GroupLayout.PREFERRED_SIZE, 91,
													GroupLayout.PREFERRED_SIZE)
											.addContainerGap()))));
			glPanelInsertarTecho.setVerticalGroup(glPanelInsertarTecho.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInsertarTecho.createSequentialGroup().addContainerGap()
							.addGroup(glPanelInsertarTecho.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblIdentificadorTecho()).addComponent(getTxtIdentificadorTecho(),
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(glPanelInsertarTecho.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblMatPredTecho()).addComponent(getComboBoxMatPredTecho(),
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addGroup(glPanelInsertarTecho.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblTipoDerrumbeTecho())
									.addComponent(getComboBoxTipoDerrumbeTecho(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(glPanelInsertarTecho.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtnOKTecho())
									.addComponent(getBtnCancelarTecho(), GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
							.addGap(32)));
			glPanelInsertarTecho.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblIdentificadorTecho(), getLblMatPredTecho(), getLblTipoDerrumbeTecho() });
			glPanelInsertarTecho.linkSize(SwingConstants.VERTICAL, new Component[] { getTxtIdentificadorTecho(),
					getComboBoxMatPredTecho(), getComboBoxTipoDerrumbeTecho() });
			glPanelInsertarTecho.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getBtnOKTecho(), getBtnCancelarTecho() });
			panelInsertarTecho.setLayout(glPanelInsertarTecho);
		}
		return panelInsertarTecho;
	}

	private JLabel getLblIdentificadorTecho() {
		if (lblIdentificadorTecho == null) {
			lblIdentificadorTecho = new JLabel("Identificador");
		}
		return lblIdentificadorTecho;
	}

	private JLabel getLblMatPredTecho() {
		if (lblMatPredTecho == null) {
			lblMatPredTecho = new JLabel("Material Predominante");
		}
		return lblMatPredTecho;
	}

	private JLabel getLblTipoDerrumbeTecho() {
		if (lblTipoDerrumbeTecho == null) {
			lblTipoDerrumbeTecho = new JLabel("Tipo de Derrumbe");
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

	private JPanel getPanelButtonTecho() {
		if (panelButtonTecho == null) {
			panelButtonTecho = new JPanel();
			FlowLayout flPanelButtonTecho = (FlowLayout) panelButtonTecho.getLayout();
			flPanelButtonTecho.setVgap(8);
			flPanelButtonTecho.setHgap(20);
			panelButtonTecho.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButtonTecho.setBounds(437, 299, 342, 41);
			panelButtonTecho.add(getBtnAddTecho());
			panelButtonTecho.add(getBtnBorrarTecho());
			panelButtonTecho.add(getBtnEditarTecho());
		}
		return panelButtonTecho;
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
			btnEditarTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tableTecho.getSelectedRowCount() > 0) {
						Techo techo = ((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaTechos()
								.get(tableTecho.getSelectedRow());
						txtIdentificadorTecho.setText(techo.getIdentificador());
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

	private JTextField getFiltroNumeroTecho() {
		if (filtroNumeroTecho == null) {
			filtroNumeroTecho = new JTextField();
			filtroNumeroTecho.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					techoModel.filtrar(filtroNumeroTecho.getText(), 1);
				}
			});
			filtroNumeroTecho.setColumns(10);
			filtroNumeroTecho.setBounds(76, 25, 67, 20);
		}
		return filtroNumeroTecho;
	}

	private JTextField getFiltroIDTecho() {
		if (filtroIDTecho == null) {
			filtroIDTecho = new JTextField();
			filtroIDTecho.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					techoModel.filtrar(filtroIDTecho.getText(), 2);
				}
			});
			filtroIDTecho.setColumns(10);
			filtroIDTecho.setBounds(145, 25, 153, 20);
		}
		return filtroIDTecho;
	}

	private JComboBox getFiltroTipoDerrumbeTecho() {
		if (filtroTipoDerrumbeTecho == null) {
			filtroTipoDerrumbeTecho = new JComboBox();
			filtroTipoDerrumbeTecho.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					techoModel.filtrar((String) filtroTipoDerrumbeTecho.getSelectedItem(), 3);
				}
			});
			filtroTipoDerrumbeTecho.setModel(new DefaultComboBoxModel(new String[] { "", "Parcial", "Total" }));
			filtroTipoDerrumbeTecho.setBounds(300, 25, 127, 20);
			filtroTipoDerrumbeTecho.setSelectedItem("");
		}
		return filtroTipoDerrumbeTecho;
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
						txtIDInmueble.setText(mat.getIdentificador());
					}
				}
			});
			comboBoxInmueble.setSelectedItem(null);

		}
		return comboBoxInmueble;
	}

	private JLabel getLblCantidad() {
		if (lblCantidad == null) {
			lblCantidad = new JLabel("Cantidad");
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

	private JTable getTableInmueble() {
		if (tableInmueble == null) {
			inmuebleModel = new InmuebleTableModel();
			inmuebleModel.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent e) {
					activarBotonBorrarInmueble();
				}
			});
			tableInmueble = new JTable(inmuebleModel);
			tableInmueble.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
					System.out.println("a");
				}

				public void inputMethodTextChanged(InputMethodEvent event) {
					System.out.println("b");
				}
			});
			tableInmueble.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableInmueble.getTableHeader().setReorderingAllowed(false);
			tableInmueble.getColumnModel().getColumn(0).setResizable(false);
			tableInmueble.getColumnModel().getColumn(0).setPreferredWidth(35);
			tableInmueble.getColumnModel().getColumn(0).setMinWidth(0);
			tableInmueble.getColumnModel().getColumn(1).setResizable(false);
			tableInmueble.getColumnModel().getColumn(1).setPreferredWidth(38);
			tableInmueble.getColumnModel().getColumn(2).setResizable(false);
			tableInmueble.getColumnModel().getColumn(3).setResizable(false);
			tableInmueble.getColumnModel().getColumn(4).setResizable(false);
			tableInmueble.getColumnModel().getColumn(4).setPreferredWidth(58);
		}
		return tableInmueble;
	}

	private JTextField getFiltroIDInmueble() {
		if (filtroIDInmueble == null) {
			filtroIDInmueble = new JTextField();
			filtroIDInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroIDInmueble.getText(), 2);
				}
			});
			filtroIDInmueble.setColumns(10);
			filtroIDInmueble.setBounds(136, 25, 101, 20);
		}
		return filtroIDInmueble;
	}

	private JTextField getFiltroNombreInmueble() {
		if (filtroNombreInmueble == null) {
			filtroNombreInmueble = new JTextField();
			filtroNombreInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroNombreInmueble.getText(), 3);
				}
			});
			filtroNombreInmueble.setColumns(10);
			filtroNombreInmueble.setBounds(239, 25, 101, 20);
		}
		return filtroNombreInmueble;
	}

	private JTextField getFiltroCantidadInmueble() {
		if (filtroCantidadInmueble == null) {
			filtroCantidadInmueble = new JTextField();
			filtroCantidadInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroCantidadInmueble.getText(), 4);
				}
			});
			filtroCantidadInmueble.setColumns(10);
			filtroCantidadInmueble.setBounds(342, 25, 85, 20);
		}
		return filtroCantidadInmueble;
	}

	private JLabel getLblIdInmueble() {
		if (lblIdInmueble == null) {
			lblIdInmueble = new JLabel("ID");
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

	private JCheckBox getCBoxSelectPared() {
		if (cBoxSelectPared == null) {
			cBoxSelectPared = new JCheckBox("");
			cBoxSelectPared.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Auxiliary.selectAll(paredModel, cBoxSelectPared, 0);
				}
			});
			cBoxSelectPared.setBorderPainted(true);
			cBoxSelectPared.setBorder(new LineBorder(new Color(128, 128, 128)));
			cBoxSelectPared.setHorizontalAlignment(SwingConstants.CENTER);
			cBoxSelectPared.setBounds(10, 25, 46, 20);
		}
		return cBoxSelectPared;
	}

	private JCheckBox getCBoxSelectInmuebles() {
		if (cBoxSelectInmuebles == null) {
			cBoxSelectInmuebles = new JCheckBox("");
			cBoxSelectInmuebles.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Auxiliary.selectAll(inmuebleModel, cBoxSelectInmuebles, 0);
				}
			});
			cBoxSelectInmuebles.setHorizontalAlignment(SwingConstants.CENTER);
			cBoxSelectInmuebles.setBorderPainted(true);
			cBoxSelectInmuebles.setBorder(new LineBorder(new Color(128, 128, 128)));
			cBoxSelectInmuebles.setBounds(10, 25, 61, 20);
		}
		return cBoxSelectInmuebles;
	}

	private JTable getTableTecho() {
		if (tableTecho == null) {
			tableTecho = new JTable();
			techoModel = new TechoTableModel();
			techoModel.addTableModelListener(new TableModelListener() {

				@Override
				public void tableChanged(TableModelEvent e) {
					activarBotonBorrarTecho();

				}
			});
			tableTecho.setModel(techoModel);
			tableTecho.getColumnModel().getColumn(0).setPreferredWidth(15);
			tableTecho.getColumnModel().getColumn(0).setMinWidth(0);
			tableTecho.getColumnModel().getColumn(1).setPreferredWidth(20);
			tableTecho.getColumnModel().getColumn(2).setMinWidth(107);
		}
		return tableTecho;
	}

	private JCheckBox getCBoxSelectTecho() {
		if (cBoxSelectTecho == null) {
			cBoxSelectTecho = new JCheckBox("");
			cBoxSelectTecho.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Auxiliary.selectAll(techoModel, cBoxSelectTecho, 0);
				}
			});
			cBoxSelectTecho.setBorderPainted(true);
			cBoxSelectTecho.setBorder(new LineBorder(new Color(128, 128, 128)));
			cBoxSelectTecho.setHorizontalAlignment(SwingConstants.CENTER);
			cBoxSelectTecho.setBounds(10, 25, 64, 20);
		}
		return cBoxSelectTecho;
	}

	private void bloquearCamposInmueble(boolean bloquear) {
		bloquear = !bloquear;
		tableInmueble.setEnabled(bloquear);
		btnAgnadirInmueble.setEnabled(bloquear);
		btnBorrarInmueble.setEnabled(bloquear);
		btnEditarInmueble.setEnabled(bloquear);
		cBoxSelectInmuebles.setEnabled(bloquear);
		filtroCantidadInmueble.setEnabled(bloquear);
		filtroIDInmueble.setEnabled(bloquear);
		filtroNumeroInmueble.setEnabled(bloquear);
		filtroNombreInmueble.setEnabled(bloquear);

	}

	private void bloquearCamposPared(boolean bloquear) {
		bloquear = !bloquear;
		tablePared.setEnabled(bloquear);
		btnAgnadirPared.setEnabled(bloquear);
		btnBorrarPared.setEnabled(bloquear);
		btnEditarPared.setEnabled(bloquear);
		filtroNumeroPared.setEnabled(bloquear);
		cBoxSelectPared.setEnabled(bloquear);
		comboBoxParedCarga.setEnabled(bloquear);
		filtroIdentificador.setEnabled(bloquear);

	}

	private void bloquearCamposTecho(boolean bloquear) {
		bloquear = !bloquear;
		tableTecho.setEnabled(bloquear);
		btnAddTecho.setEnabled(bloquear);
		btnBorrarTecho.setEnabled(bloquear);
		btnEditarTecho.setEnabled(bloquear);
		filtroNumeroTecho.setEnabled(bloquear);
		cBoxSelectTecho.setEnabled(bloquear);
		filtroIdentificador.setEnabled(bloquear);
		filtroIDTecho.setEnabled(bloquear);
		filtroTipoDerrumbeTecho.setEnabled(bloquear);
	}

	private JButton getBtnOKInmueble() {
		if (btnOKInmueble == null) {
			btnOKInmueble = new JButton("OK");
			btnOKInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxInmueble.getSelectedItem()) != null
							&& ((Integer) spinnerCantidad.getValue()).intValue() > 0) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1])
								.setInmueble(tableInmueble.getSelectedRow(),
										new Inmueble((String) comboBoxInmueble.getSelectedItem(),
												txtIDInmueble.getText(),
												((Integer) spinnerCantidad.getValue()).intValue()));
						inmuebleModel.actualizar(
								((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaInmuebles());

						comboBoxInmueble.setSelectedItem(null);
						spinnerCantidad.setValue(0);
						txtIDInmueble.setText("");

						btnCancelarInmueble.setVisible(false);
						btnOKInmueble.setVisible(false);

						bloquearCamposInmueble(false);
					}
				}
			});
			btnOKInmueble.setVisible(false);
		}
		return btnOKInmueble;
	}

	private JButton getBtnCancelarInmueble() {
		if (btnCancelarInmueble == null) {
			btnCancelarInmueble = new JButton("Cancelar");
			btnCancelarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtIDInmueble.setText("");
					comboBoxInmueble.setSelectedItem(null);
					spinnerCantidad.setValue(0);
					btnCancelarInmueble.setVisible(false);
					btnOKInmueble.setVisible(false);
					bloquearCamposInmueble(false);
				}
			});
			btnCancelarInmueble.setVisible(false);
		}
		return btnCancelarInmueble;
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
						paredModel.actualizar(
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
			btnCancelarPared = new JButton("Cancelar");
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

	private JButton getBtnOKTecho() {
		if (btnOKTecho == null) {
			btnOKTecho = new JButton("OK");
			btnOKTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (((String) comboBoxMatPredTecho.getSelectedItem()) != null
							&& comboBoxTipoDerrumbeTecho.getSelectedItem() != null
							&& !(txtIdentificadorTecho.getText()).isEmpty()) {
						((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).setTecho(
								tableTecho.getSelectedRow(),
								new Techo((txtIdentificadorTecho.getText()),
										(Construccion) Sistema
												.getMaterial((String) comboBoxMatPredTecho.getSelectedItem()),
										(TipoDerrumbe) comboBoxTipoDerrumbeTecho.getSelectedItem()));
						techoModel.actualizar(
								((Afectacion) ((Object[]) Frame.getPosicionActual()[1])[1]).getListaTechos());

						comboBoxMatPredTecho.setSelectedItem(null);
						comboBoxTipoDerrumbeTecho.setSelectedItem(null);
						txtIdentificadorTecho.setText("");

						bloquearCamposTecho(false);
					}
				}
			});
			btnOKTecho.setVisible(false);
		}
		return btnOKTecho;
	}

	private JButton getBtnCancelarTecho() {
		if (btnCancelarTecho == null) {
			btnCancelarTecho = new JButton("Cancelar");
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
			btnCancelarTecho.setVisible(false);
		}
		return btnCancelarTecho;
	}
}

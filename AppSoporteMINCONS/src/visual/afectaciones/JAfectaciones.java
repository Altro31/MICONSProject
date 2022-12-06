package visual.afectaciones;

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
import javax.swing.border.TitledBorder;

import clases.Afectacion;
import clases.Construccion;
import clases.Evento;
import clases.Inmueble;
import clases.Material;
import clases.Pared;
import clases.Sistema;
import enums.TipoDerrumbe;
import util.Auxiliary;
import util.InmuebleTableModel;
import util.ParedTableModel;
import util.Ruta;
import visual.util.PrincipalPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JAfectaciones extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3579071471874747942L;
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
	private JComboBox comboBoxMatPred;
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
	private JTextField txtNoUsadoPared;
	private JTextField filtroNumeroPared;
	private JTextField filtroIdentificador;
	private JComboBox comboBoxTipoDerrumbe;
	private JComboBox comboBoxParedCarga;
	private JScrollPane scrollTableInmueble;
	private JPanel panelButtonInmueble;
	private JButton btnAgnadirInmueble;
	private JButton btnBorrarInmueble;
	private JButton btnEditarInmueble;
	private JTextField txtNoUsadoInmueble;
	private JTextField filtroNumeroInmueble;
	private JPanel panelInmueble_1;
	private JScrollPane scrollTablePared_1_1;
	private JPanel panelInsertarPared_1_1;
	private JLabel lblIdentificadorPared_1_1;
	private JLabel lblMatPred_1_1;
	private JLabel lblTipoDerrumbePared_1_1;
	private JTextField textField_4;
	private JComboBox comboBoxMatPred_1_1;
	private JComboBox comboBoxTipoDerrumbePared_1_1;
	private JPanel panelButton_1_1;
	private JButton btnAgnadirPared_1_1;
	private JButton btnBorrarPared_1_1;
	private JButton btnEditarPared_1_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox comboBoxTipoDerrumbe_1_1;
	private JComboBox comboBoxParedCarga_1_1;
	private JPanel panelInsertarInmueble;
	private JLabel lblInmueble;
	private JComboBox comboBoxInmueble;
	private JLabel lblCantidad;
	private JSpinner spinnerCantidad;
	private JTable tableInmueble;
	private JTextField filtroIDInmueble;
	private JTextField filtroNombreInmueble;
	private JTextField filtroCantidadInmueble;
	private JLabel lblId;
	private JTextField txtID;
	private InmuebleTableModel inmuebleModel;
	private Evento evento;

	/**
	 * Create the panel.
	 */
	public JAfectaciones(Evento evento) {
		btnCerrar.setLocation(851, 0);
		btnAtras.setLocation(0, 0);
		btnCerrar.setSize(40, 29);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(getTabbedPane());
		add(getLblAfectacionesDeLa());
		add(getPanelButton2());

	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
			tabbedPane.setOpaque(true);
			tabbedPane.setBounds(10, 66, 871, 379);
			tabbedPane.addTab("Inmueble", null, getPanelInmueble(), null);
			tabbedPane.addTab("Pared", null, getPanelPared(), null);
			tabbedPane.addTab("Techo", null, getPanelTecho(), "asasdsad");
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
			panelInmueble.add(getTxtNoUsadoInmueble());
			panelInmueble.add(getFiltroNumeroInmueble());
			panelInmueble.add(getPanelInsertarInmueble());
			panelInmueble.add(getFiltroIDInmueble());
			panelInmueble.add(getTextField_3_1());
			panelInmueble.add(getFiltroCantidadInmueble());

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
			panelPared.add(getTxtNoUsadoPared());
			panelPared.add(getFiltroNumeroPared());
			panelPared.add(getFiltroIdentificador());
			panelPared.add(getComboBoxTipoDerrumbe());
			panelPared.add(getComboBoxParedCarga());
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
			panelTecho.add(getScrollTablePared_1_1());
			panelTecho.add(getPanelInsertarPared_1_1());
			panelTecho.add(getPanelButton_1_1());
			panelTecho.add(getTextField_5());
			panelTecho.add(getTextField_6());
			panelTecho.add(getTextField_7());
			panelTecho.add(getComboBoxTipoDerrumbe_1_1());
			panelTecho.add(getComboBoxParedCarga_1_1());
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
			paredModel.actualizar(((Afectacion) Ruta.getPosicionActual()[1]).getListaParedes());
			tablePared = new JTable(paredModel);
			tablePared.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
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
			GroupLayout gl_panelInsertarPared = new GroupLayout(panelInsertarPared);
			gl_panelInsertarPared.setHorizontalGroup(gl_panelInsertarPared.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertarPared.createSequentialGroup().addContainerGap()
							.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.LEADING)
									.addComponent(getLblIdentificadorPared(), GroupLayout.PREFERRED_SIZE, 77,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblMatPred(), GroupLayout.PREFERRED_SIZE, 136,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblTipoDerrumbePared(), GroupLayout.PREFERRED_SIZE, 136,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblParedCarga(), GroupLayout.PREFERRED_SIZE, 114,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(
									gl_panelInsertarPared.createParallelGroup(Alignment.LEADING)
											.addComponent(getTxtIdentificadorPared(), GroupLayout.DEFAULT_SIZE, 178,
													Short.MAX_VALUE)
											.addComponent(getComboBoxMatPred(), 0, 178, Short.MAX_VALUE)
											.addComponent(getCBoxParedCarga(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getComboBoxTipoDerrumbePared(), 0, 178, Short.MAX_VALUE))
							.addContainerGap()));
			gl_panelInsertarPared.setVerticalGroup(gl_panelInsertarPared.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertarPared.createSequentialGroup().addContainerGap(12, Short.MAX_VALUE)
							.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblIdentificadorPared()).addComponent(getTxtIdentificadorPared(),
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblMatPred()).addComponent(getComboBoxMatPred(),
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelInsertarPared.createSequentialGroup()
											.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblTipoDerrumbePared()).addComponent(
															getComboBoxTipoDerrumbePared(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(41).addComponent(getLblParedCarga()))
									.addComponent(getCBoxParedCarga()))
							.addContainerGap(53, Short.MAX_VALUE)));
			gl_panelInsertarPared.linkSize(SwingConstants.VERTICAL, new Component[] { getTxtIdentificadorPared(),
					getComboBoxMatPred(), getComboBoxTipoDerrumbePared() });
			gl_panelInsertarPared.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblIdentificadorPared(), getLblMatPred(), getLblTipoDerrumbePared() });
			panelInsertarPared.setLayout(gl_panelInsertarPared);
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
		}
		return txtIdentificadorPared;
	}

	private JComboBox getComboBoxMatPred() {
		if (comboBoxMatPred == null) {
			ArrayList<String> names = new ArrayList<String>();
			for (Material mat : Sistema.getListaMateriales()) {
				if (mat instanceof Construccion) {
					names.add(mat.getNombre());
				}
			}
			comboBoxMatPred = new JComboBox(new DefaultComboBoxModel<>(names.toArray()));
			comboBoxMatPred.setSelectedItem(null);
		}
		return comboBoxMatPred;
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
			FlowLayout fl_panelButtonPared = (FlowLayout) panelButtonPared.getLayout();
			fl_panelButtonPared.setVgap(8);
			fl_panelButtonPared.setHgap(20);
			panelButtonPared.setBounds(437, 299, 342, 41);
			panelButtonPared.add(getBtnAgnadirPared());
			panelButtonPared.add(getBtnBorrarPared());
			panelButtonPared.add(getBtnEditarPared());
		}
		return panelButtonPared;
	}

	private JButton getBtnAgnadirPared() {
		if (btnAgnadirPared == null) {
			btnAgnadirPared = new JButton("Añadir");
			btnAgnadirPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(((String)comboBoxMatPred.getSelectedItem())!=null && comboBoxTipoDerrumbePared.getSelectedItem()!=null && !(txtIdentificadorPared.getText()).isEmpty() ) {
						((Afectacion)Ruta.getPosicionActual()[1]).addPared(new Pared((txtIdentificadorPared.getText()), (Construccion)Sistema.getMaterial((String)comboBoxMatPred.getSelectedItem()), (TipoDerrumbe)comboBoxTipoDerrumbePared.getSelectedItem(), cBoxParedCarga.isSelected()));
						paredModel.actualizar(((Afectacion) Ruta.getPosicionActual()[1]).getListaParedes());
						comboBoxMatPred.setSelectedItem(null);
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
			btnBorrarPared = new JButton("Borrar");
			btnBorrarPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					paredModel.borrarSeleccion();
				}
			});
		}
		return btnBorrarPared;
	}

	private JButton getBtnEditarPared() {
		if (btnEditarPared == null) {
			btnEditarPared = new JButton("Editar");
		}
		return btnEditarPared;
	}

	private JPanel getPanelButton2() {
		if (panelButton2 == null) {
			panelButton2 = new JPanel();
			FlowLayout fl_panelButton2 = (FlowLayout) panelButton2.getLayout();
			fl_panelButton2.setHgap(50);
			panelButton2.setBounds(10, 448, 871, 36);
			panelButton2.add(getBtnSiguiente());
			panelButton2.add(getBtnCancelar());
		}
		return panelButton2;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnSiguiente;
	}

	private JTextField getTxtNoUsadoPared() {
		if (txtNoUsadoPared == null) {
			txtNoUsadoPared = new JTextField();
			txtNoUsadoPared.setEditable(false);
			txtNoUsadoPared.setBounds(10, 25, 46, 20);
			txtNoUsadoPared.setColumns(10);
		}
		return txtNoUsadoPared;
	}

	private JTextField getFiltroNumeroPared() {
		if (filtroNumeroPared == null) {
			filtroNumeroPared = new JTextField();
			filtroNumeroPared.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					paredModel.filtrar(filtroNumeroPared, 1);
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
			comboBoxTipoDerrumbe.setModel(new DefaultComboBoxModel(new String[] { "", "Parcial", "Total" }));
			comboBoxTipoDerrumbe.setBounds(219, 25, 111, 20);
		}
		return comboBoxTipoDerrumbe;
	}

	private JComboBox getComboBoxParedCarga() {
		if (comboBoxParedCarga == null) {
			comboBoxParedCarga = new JComboBox();
			comboBoxParedCarga.setModel(new DefaultComboBoxModel(new String[] { "", "Si", "No" }));
			comboBoxParedCarga.setBounds(332, 25, 95, 20);
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
	
	private JButton getBtnAgnadirInmueble() {
		if (btnAgnadirInmueble == null) {
			btnAgnadirInmueble = new JButton("Añadir");
			btnAgnadirInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(((String)comboBoxInmueble.getSelectedItem())!=null && ((Integer)spinnerCantidad.getValue()).intValue()>0 ) {
						((Afectacion)Ruta.getPosicionActual()[1]).addInmueble(new Inmueble((String)comboBoxInmueble.getSelectedItem(), txtID.getText(), ((Integer)spinnerCantidad.getValue()).intValue()));
						inmuebleModel.actualizar(((Afectacion) Ruta.getPosicionActual()[1]).getListaInmuebles());
						comboBoxInmueble.setSelectedItem(null);
						spinnerCantidad.setValue(0);
						txtID.setText("");
					}
				}
			});
		}
		return btnAgnadirInmueble;
	}

	private JButton getBtnBorrarInmueble() {
		if (btnBorrarInmueble == null) {
			btnBorrarInmueble = new JButton("Borrar");
			btnBorrarInmueble.setEnabled(false);
			btnBorrarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inmuebleModel.borrarSeleccion();
					activarBotonBorrarInmueble();
				}
			});
		}
		return btnBorrarInmueble;
	}

	private JButton getBtnEditarInmueble() {
		if (btnEditarInmueble == null) {
			btnEditarInmueble = new JButton("Editar");
		}
		return btnEditarInmueble;
	}

	private JTextField getTxtNoUsadoInmueble() {
		if (txtNoUsadoInmueble == null) {
			txtNoUsadoInmueble = new JTextField();
			txtNoUsadoInmueble.setEnabled(false);
			txtNoUsadoInmueble.setEditable(false);
			txtNoUsadoInmueble.setColumns(10);
			txtNoUsadoInmueble.setBounds(10, 25, 62, 20);
		}
		return txtNoUsadoInmueble;
	}

	private JTextField getFiltroNumeroInmueble() {
		if (filtroNumeroInmueble == null) {
			filtroNumeroInmueble = new JTextField();
			filtroNumeroInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroNumeroInmueble, 1);
				}
			});
			filtroNumeroInmueble.setColumns(10);
			filtroNumeroInmueble.setBounds(74, 25, 60, 20);
		}
		return filtroNumeroInmueble;
	}

	private JPanel getPanelInmueble_1() {
		if (panelInmueble_1 == null) {
			panelInmueble_1 = new JPanel();
			panelInmueble_1.setLayout(null);
			panelInmueble_1.setBorder(new TitledBorder(

					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

					"Inmuebles Afectados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInmueble_1.setBounds(0, 0, 806, 374);
			panelInmueble_1.add(getScrollTablePared_1_1());
			panelInmueble_1.add(getPanelInsertarPared_1_1());
			panelInmueble_1.add(getPanelButton_1_1());
			panelInmueble_1.add(getTextField_5());
			panelInmueble_1.add(getTextField_6());
			panelInmueble_1.add(getTextField_7());
			panelInmueble_1.add(getComboBoxTipoDerrumbe_1_1());
			panelInmueble_1.add(getComboBoxParedCarga_1_1());
		}
		return panelInmueble_1;
	}

	private JScrollPane getScrollTablePared_1_1() {
		if (scrollTablePared_1_1 == null) {
			scrollTablePared_1_1 = new JScrollPane();
			scrollTablePared_1_1.setBounds(10, 52, 417, 289);
		}
		return scrollTablePared_1_1;
	}

	private JPanel getPanelInsertarPared_1_1() {
		if (panelInsertarPared_1_1 == null) {
			panelInsertarPared_1_1 = new JPanel();
			panelInsertarPared_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelInsertarPared_1_1.setBounds(437, 25, 342, 263);
			GroupLayout gl_panelInsertarPared_1_1 = new GroupLayout(panelInsertarPared_1_1);
			gl_panelInsertarPared_1_1.setHorizontalGroup(
				gl_panelInsertarPared_1_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertarPared_1_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelInsertarPared_1_1.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblIdentificadorPared_1_1(), GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblMatPred_1_1(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblTipoDerrumbePared_1_1(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelInsertarPared_1_1.createParallelGroup(Alignment.LEADING)
							.addComponent(getTextField_4(), GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
							.addComponent(getComboBoxMatPred_1_1(), 0, 178, Short.MAX_VALUE)
							.addComponent(getComboBoxTipoDerrumbePared_1_1(), 0, 178, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panelInsertarPared_1_1.setVerticalGroup(
				gl_panelInsertarPared_1_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertarPared_1_1.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panelInsertarPared_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblIdentificadorPared_1_1())
							.addComponent(getTextField_4(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(38)
						.addGroup(gl_panelInsertarPared_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblMatPred_1_1())
							.addComponent(getComboBoxMatPred_1_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(39)
						.addGroup(gl_panelInsertarPared_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblTipoDerrumbePared_1_1())
							.addComponent(getComboBoxTipoDerrumbePared_1_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(105))
			);
			gl_panelInsertarPared_1_1.linkSize(SwingConstants.VERTICAL, new Component[] {getLblIdentificadorPared_1_1(), getLblMatPred_1_1(), getLblTipoDerrumbePared_1_1()});
			gl_panelInsertarPared_1_1.linkSize(SwingConstants.VERTICAL, new Component[] {getTextField_4(), getComboBoxMatPred_1_1(), getComboBoxTipoDerrumbePared_1_1()});
			panelInsertarPared_1_1.setLayout(gl_panelInsertarPared_1_1);
		}
		return panelInsertarPared_1_1;
	}

	private JLabel getLblIdentificadorPared_1_1() {
		if (lblIdentificadorPared_1_1 == null) {
			lblIdentificadorPared_1_1 = new JLabel("Identificador");
		}
		return lblIdentificadorPared_1_1;
	}

	private JLabel getLblMatPred_1_1() {
		if (lblMatPred_1_1 == null) {
			lblMatPred_1_1 = new JLabel("Material Predominante");
		}
		return lblMatPred_1_1;
	}

	private JLabel getLblTipoDerrumbePared_1_1() {
		if (lblTipoDerrumbePared_1_1 == null) {
			lblTipoDerrumbePared_1_1 = new JLabel("Tipo de Derrumbe");
		}
		return lblTipoDerrumbePared_1_1;
	}

	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
		}
		return textField_4;
	}

	private JComboBox getComboBoxMatPred_1_1() {
		if (comboBoxMatPred_1_1 == null) {
			comboBoxMatPred_1_1 = new JComboBox(new Object[] {});
		}
		return comboBoxMatPred_1_1;
	}

	private JComboBox getComboBoxTipoDerrumbePared_1_1() {
		if (comboBoxTipoDerrumbePared_1_1 == null) {
			comboBoxTipoDerrumbePared_1_1 = new JComboBox();
		}
		return comboBoxTipoDerrumbePared_1_1;
	}

	private JPanel getPanelButton_1_1() {
		if (panelButton_1_1 == null) {
			panelButton_1_1 = new JPanel();
			panelButton_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButton_1_1.setBounds(437, 299, 342, 41);
			panelButton_1_1.add(getBtnAgnadirPared_1_1());
			panelButton_1_1.add(getBtnBorrarPared_1_1());
			panelButton_1_1.add(getBtnEditarPared_1_1());
		}
		return panelButton_1_1;
	}

	private JButton getBtnAgnadirPared_1_1() {
		if (btnAgnadirPared_1_1 == null) {
			btnAgnadirPared_1_1 = new JButton("Añadir");
		}
		return btnAgnadirPared_1_1;
	}

	private JButton getBtnBorrarPared_1_1() {
		if (btnBorrarPared_1_1 == null) {
			btnBorrarPared_1_1 = new JButton("Borrar");
		}
		return btnBorrarPared_1_1;
	}

	private JButton getBtnEditarPared_1_1() {
		if (btnEditarPared_1_1 == null) {
			btnEditarPared_1_1 = new JButton("Editar");
		}
		return btnEditarPared_1_1;
	}

	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setEditable(false);
			textField_5.setColumns(10);
			textField_5.setBounds(10, 25, 46, 20);
		}
		return textField_5;
	}

	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(58, 25, 46, 20);
		}
		return textField_6;
	}

	private JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(106, 25, 111, 20);
		}
		return textField_7;
	}

	private JComboBox getComboBoxTipoDerrumbe_1_1() {
		if (comboBoxTipoDerrumbe_1_1 == null) {
			comboBoxTipoDerrumbe_1_1 = new JComboBox();
			comboBoxTipoDerrumbe_1_1.setBounds(219, 25, 111, 20);
		}
		return comboBoxTipoDerrumbe_1_1;
	}

	private JComboBox getComboBoxParedCarga_1_1() {
		if (comboBoxParedCarga_1_1 == null) {
			comboBoxParedCarga_1_1 = new JComboBox();
			comboBoxParedCarga_1_1.setBounds(332, 25, 95, 20);
		}
		return comboBoxParedCarga_1_1;
	}

	private JPanel getPanelInsertarInmueble() {
		if (panelInsertarInmueble == null) {
			panelInsertarInmueble = new JPanel();
			panelInsertarInmueble.setBorder(
					new TitledBorder(null, "Insertar Inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelInsertarInmueble.setBounds(437, 25, 342, 263);
			GroupLayout gl_panelInsertarInmueble = new GroupLayout(panelInsertarInmueble);
			gl_panelInsertarInmueble.setHorizontalGroup(gl_panelInsertarInmueble.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertarInmueble.createSequentialGroup().addContainerGap()
							.addGroup(gl_panelInsertarInmueble.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelInsertarInmueble.createSequentialGroup()
											.addComponent(getLblInmueble(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getComboBoxInmueble(), GroupLayout.PREFERRED_SIZE, 200,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelInsertarInmueble.createSequentialGroup()
											.addComponent(getLblCantidad(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getSpinnerCantidad(), GroupLayout.PREFERRED_SIZE, 55,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelInsertarInmueble.createSequentialGroup()
											.addComponent(getLblId(), GroupLayout.PREFERRED_SIZE, 82,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(getTxtID(),
													GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(24, Short.MAX_VALUE)));
			gl_panelInsertarInmueble.setVerticalGroup(gl_panelInsertarInmueble.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertarInmueble.createSequentialGroup().addGap(19)
							.addGroup(gl_panelInsertarInmueble.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblId(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxtID(), GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelInsertarInmueble.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblInmueble(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getComboBoxInmueble(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(gl_panelInsertarInmueble.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblCantidad(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getSpinnerCantidad(), GroupLayout.PREFERRED_SIZE, 24,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap(137, Short.MAX_VALUE)));
			gl_panelInsertarInmueble.linkSize(SwingConstants.VERTICAL,
					new Component[] { getSpinnerCantidad(), getComboBoxInmueble(), getTxtID() });
			gl_panelInsertarInmueble.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getComboBoxInmueble(), getTxtID() });
			panelInsertarInmueble.setLayout(gl_panelInsertarInmueble);
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
						txtID.setText(mat.getIdentificador());
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
			inmuebleModel.actualizar(((Afectacion) Ruta.getPosicionActual()[1]).getListaInmuebles());
			tableInmueble = new JTable(inmuebleModel);
			tableInmueble.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					activarBotonBorrarInmueble();
				}
			});
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
					inmuebleModel.filtrar(filtroIDInmueble, 2);
				}
			});
			filtroIDInmueble.setColumns(10);
			filtroIDInmueble.setBounds(136, 25, 101, 20);
		}
		return filtroIDInmueble;
	}

	private JTextField getTextField_3_1() {
		if (filtroNombreInmueble == null) {
			filtroNombreInmueble = new JTextField();
			filtroNombreInmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					inmuebleModel.filtrar(filtroNombreInmueble, 3);
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
					inmuebleModel.filtrar(filtroCantidadInmueble, 4);
				}
			});
			filtroCantidadInmueble.setColumns(10);
			filtroCantidadInmueble.setBounds(342, 25, 85, 20);
		}
		return filtroCantidadInmueble;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
		}
		return lblId;
	}

	private JTextField getTxtID() {
		if (txtID == null) {
			txtID = new JTextField();
			txtID.setEditable(false);
			txtID.setColumns(10);
		}
		return txtID;
	}
}

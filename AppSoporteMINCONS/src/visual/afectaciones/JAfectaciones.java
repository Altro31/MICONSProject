package visual.afectaciones;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import clases.Sistema;
import enums.TipoDerrumbe;
import util.ParedTableModel;
import visual.frame.Frame;
import visual.util.PrincipalPanel;

public class JAfectaciones extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3579071471874747942L;
	private Frame padre;
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
	private JPanel panelButton;
	private JButton btnAgnadirPared;
	private JButton btnBorrarPared;
	private JButton btnEditarPared;
	private JPanel panelButton2;
	private JButton btnCancelar;
	private JButton btnSiguiente;
	private JTable tablePared;
	private ParedTableModel paredModel;
	private JTextField txtNoUsado;
	private JTextField filtroNumero;
	private JTextField filtroIdentificador;
	private JComboBox comboBoxTipoDerrumbe;
	private JComboBox comboBoxParedCarga;

	/**
	 * Create the panel.
	 */
	public JAfectaciones(Frame padre) {
		btnCerrar.setLocation(851, 0);
		btnAtras.setLocation(0, 0);
		btnCerrar.setSize(40, 29);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.padre = padre;
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
			panelPared.add(getPanelButton());
			panelPared.add(getTxtNoUsado());
			panelPared.add(getFiltroNumero());
			panelPared.add(getFiltroIdentificador());
			panelPared.add(getComboBoxTipoDerrumbe());
			panelPared.add(getComboBoxParedCarga());
		}
		return panelPared;
	}

	private JPanel getPanelTecho() {
		if (panelTecho == null) {
			panelTecho = new JPanel();
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
			panelInsertarPared.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelInsertarPared.setBounds(437, 25, 342, 263);
			GroupLayout gl_panelInsertarPared = new GroupLayout(panelInsertarPared);
			gl_panelInsertarPared.setHorizontalGroup(
				gl_panelInsertarPared.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertarPared.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblIdentificadorPared(), GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblMatPred(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblTipoDerrumbePared(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLblParedCarga(), GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.LEADING)
							.addComponent(getTxtIdentificadorPared(), GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
							.addComponent(getComboBoxMatPred(), 0, 178, Short.MAX_VALUE)
							.addComponent(getCBoxParedCarga(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(getComboBoxTipoDerrumbePared(), 0, 178, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panelInsertarPared.setVerticalGroup(
				gl_panelInsertarPared.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInsertarPared.createSequentialGroup()
						.addContainerGap(12, Short.MAX_VALUE)
						.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblIdentificadorPared())
							.addComponent(getTxtIdentificadorPared(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(38)
						.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblMatPred())
							.addComponent(getComboBoxMatPred(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(39)
						.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelInsertarPared.createSequentialGroup()
								.addGroup(gl_panelInsertarPared.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblTipoDerrumbePared())
									.addComponent(getComboBoxTipoDerrumbePared(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(41)
								.addComponent(getLblParedCarga()))
							.addComponent(getCBoxParedCarga()))
						.addContainerGap(53, Short.MAX_VALUE))
			);
			gl_panelInsertarPared.linkSize(SwingConstants.VERTICAL, new Component[] {getTxtIdentificadorPared(), getComboBoxMatPred(), getComboBoxTipoDerrumbePared()});
			gl_panelInsertarPared.linkSize(SwingConstants.VERTICAL, new Component[] {getLblIdentificadorPared(), getLblMatPred(), getLblTipoDerrumbePared()});
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
			comboBoxMatPred = new JComboBox(new Object[] {});
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
	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			panelButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			FlowLayout fl_panelButton = (FlowLayout) panelButton.getLayout();
			fl_panelButton.setVgap(8);
			fl_panelButton.setHgap(20);
			panelButton.setBounds(437, 299, 342, 41);
			panelButton.add(getBtnAgnadirPared());
			panelButton.add(getBtnBorrarPared());
			panelButton.add(getBtnEditarPared());
		}
		return panelButton;
	}
	private JButton getBtnAgnadirPared() {
		if (btnAgnadirPared == null) {
			btnAgnadirPared = new JButton("Añadir");
		}
		return btnAgnadirPared;
	}
	private JButton getBtnBorrarPared() {
		if (btnBorrarPared == null) {
			btnBorrarPared = new JButton("Borrar");
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
		}
		return btnSiguiente;
	}
	private JTextField getTxtNoUsado() {
		if (txtNoUsado == null) {
			txtNoUsado = new JTextField();
			txtNoUsado.setEditable(false);
			txtNoUsado.setBounds(10, 25, 46, 20);
			txtNoUsado.setColumns(10);
		}
		return txtNoUsado;
	}
	private JTextField getFiltroNumero() {
		if (filtroNumero == null) {
			filtroNumero = new JTextField();
			filtroNumero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					paredModel.filtrar(filtroNumero, 1, Sistema.getInstance().getListaEventos().get(0).getListaFichasTecnicas().get(0).getAfect().getListaParedes());
				}
			});
			filtroNumero.setColumns(10);
			filtroNumero.setBounds(58, 25, 46, 20);
		}
		return filtroNumero;
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
			comboBoxTipoDerrumbe.setModel(new DefaultComboBoxModel(new String[] {"", "Parcial", "Total"}));
			comboBoxTipoDerrumbe.setBounds(219, 25, 111, 20);
		}
		return comboBoxTipoDerrumbe;
	}
	private JComboBox getComboBoxParedCarga() {
		if (comboBoxParedCarga == null) {
			comboBoxParedCarga = new JComboBox();
			comboBoxParedCarga.setModel(new DefaultComboBoxModel(new String[] {"", "Si", "No"}));
			comboBoxParedCarga.setBounds(332, 25, 95, 20);
		}
		return comboBoxParedCarga;
	}
}

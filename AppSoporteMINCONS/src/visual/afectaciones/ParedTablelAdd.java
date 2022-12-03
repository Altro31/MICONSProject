package visual.afectaciones;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import clases.Construccion;
import clases.Material;
import clases.Pared;
import enums.TipoDerrumbe;
import visual.util.TableModel;

public class ParedTablelAdd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100588430541281404L;
	private JPanel panel;
	private JLabel lblIdentificador;
	private JTextField textIdentificador;
	private JLabel lblNumero;
	private JTextField textNumero;
	private JLabel lblMatPred;
	private JLabel lblTipoDerrumbe;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTipoDerrumbe;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private TableModel tablePadre;
	private int numero;
	private ArrayList<Pared> lista;
	private JLabel lblParedCarga;
	private JCheckBox chckbxParedCarga;
	private JComboBox comboBoxMatPred;
	private ArrayList<Material> listaMateriales;

	/**
	 * Launch the application.
	 */
	public static void runParedPanelItemWindow(final Window window, final TableModel tablaPadre,
			final ArrayList<Pared> lista, final ArrayList<Material> listaMateriales, final int numero) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParedTablelAdd dialog = new ParedTablelAdd(window, tablaPadre, lista, listaMateriales, numero);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ParedTablelAdd(Window window, TableModel tablePadre, ArrayList<Pared> lista,
			ArrayList<Material> listaMateriales, int numero) {

		super(window, null, null, null);
		setResizable(false);
		this.listaMateriales = listaMateriales;
		this.tablePadre = tablePadre;
		this.numero = numero;
		this.lista = lista;
		setTitle("Añadir Pared Afectada");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 272);
		setLocationRelativeTo(window);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getPanel(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup().addComponent(getBtnAceptar())
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnCancelar(),
												GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(getLblNumero(), GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(getTextNumero(),
										GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTextNumero(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblNumero()))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getPanel(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(getBtnAceptar())
								.addComponent(getBtnCancelar()))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { getBtnAceptar(), getBtnCancelar() });
		getContentPane().setLayout(groupLayout);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
							.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(getLblIdentificador(), GroupLayout.PREFERRED_SIZE, 77,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblMatPred(), GroupLayout.PREFERRED_SIZE, 136,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(getTextIdentificador(), Alignment.TRAILING,
											GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
									.addComponent(getComboBoxMatPred(), 0, 195, Short.MAX_VALUE)))
							.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(getLblTipoDerrumbe(), GroupLayout.PREFERRED_SIZE, 136,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getLblParedCarga(), GroupLayout.PREFERRED_SIZE, 114,
													GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(getComboBoxTipoDerrumbe(), GroupLayout.PREFERRED_SIZE, 195,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getChckbxParedCarga()))))
					.addGap(65)));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
					.createSequentialGroup().addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLblIdentificador())
							.addComponent(getTextIdentificador(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLblMatPred())
							.addComponent(getComboBoxMatPred(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLblTipoDerrumbe())
							.addComponent(getComboBoxTipoDerrumbe(), GroupLayout.PREFERRED_SIZE,
									GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLblParedCarga())
							.addComponent(getChckbxParedCarga()))
					.addContainerGap()));
			gl_panel.linkSize(SwingConstants.VERTICAL,
					new Component[] { getLblIdentificador(), getLblMatPred(), getLblTipoDerrumbe() });
			panel.setLayout(gl_panel);
		}
		return panel;
	}

	public void setIdentificador(String string) {
		textIdentificador.setText(string);
	}

	public void setMatPred(String string) {
		comboBoxMatPred.setSelectedItem(string);
	}

	public void setTipoDerrumbe(String string) {
		comboBoxTipoDerrumbe.setSelectedItem(string);
	}

	public void setEsParedCargas(boolean check) {
		chckbxParedCarga.setSelected(check);
	}

	private JLabel getLblIdentificador() {
		if (lblIdentificador == null) {
			lblIdentificador = new JLabel("identificador:");
		}
		return lblIdentificador;
	}

	private JTextField getTextIdentificador() {
		if (textIdentificador == null) {
			textIdentificador = new JTextField();
			textIdentificador.setColumns(10);
		}
		return textIdentificador;
	}

	private JLabel getLblNumero() {
		if (lblNumero == null) {
			lblNumero = new JLabel("No.");
		}
		return lblNumero;
	}

	private JTextField getTextNumero() {
		if (textNumero == null) {
			textNumero = new JTextField();
			textNumero.setHorizontalAlignment(SwingConstants.CENTER);
			textNumero.setEditable(false);
			textNumero.setColumns(10);
			textNumero.setText(numero + "");
		}
		return textNumero;
	}

	private JLabel getLblMatPred() {
		if (lblMatPred == null) {
			lblMatPred = new JLabel("Material Predominante");
		}
		return lblMatPred;
	}

	private JLabel getLblTipoDerrumbe() {
		if (lblTipoDerrumbe == null) {
			lblTipoDerrumbe = new JLabel("Tipo de Derrumbe:");
		}
		return lblTipoDerrumbe;
	}

	private JComboBox getComboBoxTipoDerrumbe() {
		if (comboBoxTipoDerrumbe == null) {
			comboBoxTipoDerrumbe = new JComboBox();
			comboBoxTipoDerrumbe.setModel(new DefaultComboBoxModel(TipoDerrumbe.names()));
		}
		return comboBoxTipoDerrumbe;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean add = true;
					if (textIdentificador == null || textIdentificador.getText().isEmpty()) {
						add = false;
					}
					if (add) {
						Pared pared = new Pared(textIdentificador.getText(),
								(Construccion) Afectaciones.buscarMateriar(comboBoxMatPred.getSelectedItem().toString()),
								TipoDerrumbe.getValue(comboBoxTipoDerrumbe.getSelectedItem().toString()),
								chckbxParedCarga.isSelected());
						lista.add(pared);
						actualizar();
						dispose();

					}
				}
			});
		}
		return btnAceptar;
	}

	public void actualizar() {
		tablePadre.setRowCount(0);
		int count = 1;
		for (Pared pared : lista) {
			tablePadre.addRow(
					new Object[] { ""+count++, pared.getIdentificador(), pared.getMaterialPredominante().getNombre(),
							pared.getTipoDerrumbe().name(), pared.isEsParedCarga() ? "Si" : "No" });
		}
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnCancelar;
	}

	private JLabel getLblParedCarga() {
		if (lblParedCarga == null) {
			lblParedCarga = new JLabel("Pared de Carga:");
		}
		return lblParedCarga;
	}

	private JCheckBox getChckbxParedCarga() {
		if (chckbxParedCarga == null) {
			chckbxParedCarga = new JCheckBox("");
			chckbxParedCarga.setHorizontalAlignment(SwingConstants.TRAILING);
			chckbxParedCarga.setHorizontalTextPosition(SwingConstants.LEFT);
			chckbxParedCarga.setVerticalAlignment(SwingConstants.TOP);
		}
		return chckbxParedCarga;
	}

	private JComboBox getComboBoxMatPred() {
		if (comboBoxMatPred == null) {
			ArrayList<String> listaStrings = new ArrayList<String>();
			for (Material mat : listaMateriales) {
				listaStrings.add(mat.getNombre());
			}
			comboBoxMatPred = new JComboBox(listaStrings.toArray());
		}
		return comboBoxMatPred;
	}
}

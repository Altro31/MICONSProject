package visual.afectaciones;

import java.awt.Component;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import clases.Construccion;
import clases.Inmueble;
import clases.Material;
import enums.TipoDerrumbe;
import visual.util.TableModel;

public class InmuebleTablelEdit extends JDialog {

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
	private ArrayList<Inmueble> lista;
	private JLabel lblInmuebleCarga;
	private JCheckBox chckbxInmuebleCarga;
	private JComboBox comboBoxMatPred;
	private ArrayList<Material> listaMateriales;
	private JTable table;
	

	/**
	 * Create the dialog.
	 * @param table TODO
	 */
	public InmuebleTablelEdit(Window window, TableModel tablePadre, ArrayList<Inmueble> lista, ArrayList<Material> listaMateriales, int numero, JTable table) {
		
		super(window, null, null, null);
		setResizable(false);
		this.listaMateriales=listaMateriales;
		this.tablePadre=tablePadre;
		this.numero=numero;
		this.lista=lista;
		this.table=table;
		setTitle("Editar Inmueble Afectada");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 272);
		setLocationRelativeTo(window);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getPanel(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(getBtnAceptar())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getBtnCancelar(), GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(getLblNumero(), GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getTextNumero(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getTextNumero(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblNumero()))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getPanel(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getBtnAceptar())
						.addComponent(getBtnCancelar()))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getBtnAceptar(), getBtnCancelar()});
		getContentPane().setLayout(groupLayout);

	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(getLblIdentificador(), GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblMatPred(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(getTextIdentificador(), Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
									.addComponent(getComboBoxMatPred(), 0, 195, Short.MAX_VALUE)))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(getLblTipoDerrumbe(), GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblInmuebleCarga(), GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(getComboBoxTipoDerrumbe(), GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
									.addComponent(getChckbxInmuebleCarga()))))
						.addGap(65))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(14)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblIdentificador())
							.addComponent(getTextIdentificador(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblMatPred())
							.addComponent(getComboBoxMatPred(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblTipoDerrumbe())
							.addComponent(getComboBoxTipoDerrumbe(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblInmuebleCarga())
							.addComponent(getChckbxInmuebleCarga()))
						.addContainerGap())
			);
			gl_panel.linkSize(SwingConstants.VERTICAL, new Component[] {getLblIdentificador(), getLblMatPred(), getLblTipoDerrumbe()});
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
	public void setEsInmuebleCargas(boolean check) {
		chckbxInmuebleCarga.setSelected(check);
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
			textNumero.setText(numero-1+"");
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
					if (table.getSelectedRowCount()==1) {
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
		for (Inmueble inmueble : lista) {
			tablePadre.addRow(
					new Object[] { 
							inmueble.getId(),
							inmueble.getNombre(),
							inmueble.getPrecioUnitario()+""
					});
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
	private JLabel getLblInmuebleCarga() {
		if (lblInmuebleCarga == null) {
			lblInmuebleCarga = new JLabel("Inmueble de Carga:");
		}
		return lblInmuebleCarga;
	}
	private JCheckBox getChckbxInmuebleCarga() {
		if (chckbxInmuebleCarga == null) {
			chckbxInmuebleCarga = new JCheckBox("");
			chckbxInmuebleCarga.setHorizontalAlignment(SwingConstants.TRAILING);
			chckbxInmuebleCarga.setHorizontalTextPosition(SwingConstants.LEFT);
			chckbxInmuebleCarga.setVerticalAlignment(SwingConstants.TOP);
		}
		return chckbxInmuebleCarga;
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

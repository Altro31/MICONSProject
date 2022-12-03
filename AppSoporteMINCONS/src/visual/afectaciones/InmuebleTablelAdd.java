package visual.afectaciones;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Construccion;
import clases.Inmueble;
import visual.util.TableModel;

public class InmuebleTablelAdd extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100588430541281404L;
	private JLabel lblNumero;
	private JTextField textNumero;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private TableModel tablePadre;
	private int numero;
	private ArrayList<Inmueble> lista;
	private ArrayList<Inmueble> listaAux;
	private JScrollPane scrollTableMostrador;
	private JTable table;
	private JTextField textBuscar;
	private JLabel lblFiltrar;

	/**
	 * Launch the application.
	 */
	public static void runInmueblePanelItemWindow(final Window window, final TableModel tablaPadre,
			final ArrayList<Inmueble> lista, final ArrayList<Construccion> listaMateriales, final int numero) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InmuebleTablelAdd dialog = new InmuebleTablelAdd(window, tablaPadre, lista, numero, null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 * @param table TODO
	 */
	public InmuebleTablelAdd(Window window, TableModel tablePadre, ArrayList<Inmueble> lista,
			int numero, JTable table) {

		super(window, null, null, null);
		setResizable(false);
		this.lista=lista;
		this.listaAux = new ArrayList<Inmueble>();
		this.tablePadre = tablePadre;
		this.numero = numero;
		this.lista = lista;
		setTitle("Añadir Inmueble Afectado");
		setAlwaysOnTop(true);
		setBounds(100, 100, 472, 288);
		setLocationRelativeTo(window);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblNumero(), GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getTextNumero(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(385, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(266, Short.MAX_VALUE)
						.addComponent(getBtnAceptar())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getBtnCancelar(), GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(getLblFiltrar(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getTextBuscar(), GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE))
								.addComponent(getScrollTableMostrador(), Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(7)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTextNumero(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblNumero()))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTextBuscar(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblFiltrar()))
						.addGap(11)
						.addComponent(getScrollTableMostrador(), GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addGap(13)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(getBtnAceptar())
								.addComponent(getBtnCancelar()))
						.addGap(18))
				);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getBtnAceptar(), getBtnCancelar()});
		getContentPane().setLayout(groupLayout);

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

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (true) {
						String string = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
						Inmueble inmueble = (Inmueble)Afectaciones.buscarMateriar(string);
						int cant = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad que va a asignar"));
						if(cant>0) {
							lista.add(inmueble);
							actualizar();
						}
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

	public void actualizarBusqueda() {
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
	private JScrollPane getScrollTableMostrador() {
		if (scrollTableMostrador == null) {
			scrollTableMostrador = new JScrollPane();
			scrollTableMostrador.setViewportView(getTable());
		}
		return scrollTableMostrador;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Id", "Nombre", "Precio Unitario"
					}
					) {
				boolean[] columnEditables = new boolean[] {
						false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		}
		return table;
	}
	private JTextField getTextBuscar() {
		if (textBuscar == null) {
			textBuscar = new JTextField();
			textBuscar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {

				}
			});
			textBuscar.setColumns(10);
		}
		return textBuscar;
	}
	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar:");
		}
		return lblFiltrar;
	}
}

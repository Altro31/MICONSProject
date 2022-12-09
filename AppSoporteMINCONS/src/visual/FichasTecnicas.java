package visual;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import clases.Afectacion;
import clases.Evento;
import clases.Vivienda;
import util.Auxiliary;
import util.FichaTableModel;
import visual.util.PrincipalPanel;

public class FichasTecnicas extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2837587028329428263L;
	private JScrollPane scrollPane;
	private JTable table;
	private FichaTableModel tableModel;
	private JTextField textNotUsed;
	private JPanel panelTitulo;
	private JLabel lblTitulo;
	private JPanel panelButton2;
	private JButton btnSalir;
	private JButton btnAceptar;
	private JPanel panelButton;
	private JButton btnInsertar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnInfo;
	private JTextField filtroNumero;
	private JTextField filtroDireccion;
	private JTextField filtroFecha;

	/**
	 * Create the panel.
	 */
	public FichasTecnicas() {
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.removerRuta(Frame.getPosicionActual()[0]);
				Frame.setContentPanes((Eventos) Frame.getPosicionActual()[0]);
			}
		});
		add(getTextNotUsed());
		add(getPanelTitulo());
		add(getPanelButton2());
		add(getScrollPane());
		add(getPanelButton());
		add(getFiltroNumero());
		add(getFiltroDireccion());
		add(getFiltroFecha());
	}

	// Métodos

	private void activarBotonBorrar() {
		if (btnBorrar!=null) {
			int filas = tableModel.getRowCount();
			boolean check = false;
			for (int i = 0; i < filas && !check; i++) {
				if (Auxiliary.isSelected(i, 0, tableModel))
					check = true;
			}
			btnBorrar.setEnabled(check);
		}
	}

	// Componentes
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 115, 742, 311);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableModel = new FichaTableModel();
			table.setModel(tableModel);
			tableModel.addTableModelListener(new TableModelListener() {

				@Override
				public void tableChanged(TableModelEvent e) {
					activarBotonBorrar();
				}
			});
			tableModel.actualizar(((Evento) Frame.getPosicionActual()[1]).getListaFichasTecnicas());
			table.getTableHeader().setReorderingAllowed(false);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(15);
			table.getColumnModel().getColumn(1).setMinWidth(0);
			table.getColumnModel().getColumn(2).setPreferredWidth(236);
			table.getColumnModel().getColumn(3).setPreferredWidth(137);
		}
		return table;
	}

	private JTextField getTextNotUsed() {
		if (textNotUsed == null) {
			textNotUsed = new JTextField();
			textNotUsed.setEnabled(false);
			textNotUsed.setBounds(20, 92, 97, 20);
			textNotUsed.setColumns(10);
		}
		return textNotUsed;
	}

	private JPanel getPanelTitulo() {
		if (panelTitulo == null) {
			panelTitulo = new JPanel();
			panelTitulo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelTitulo.setBounds(20, 36, 852, 36);
			panelTitulo.add(getLblTitulo());
		}
		return panelTitulo;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Insección de Fichas Técnicas");
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		}
		return lblTitulo;
	}

	private JPanel getPanelButton2() {
		if (panelButton2 == null) {
			panelButton2 = new JPanel();
			panelButton2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButton2.setBounds(20, 431, 852, 46);
			panelButton2.setLayout(null);
			panelButton2.add(getBtnSalir());
			panelButton2.add(getBtnAceptar());
		}
		return panelButton2;
	}

	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Cancelar");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame.removerRuta(Frame.get(1)[0]);
					Frame.setContentPanes((Principal) Frame.getPosicionActual()[0]);
				}
			});
			btnSalir.setBounds(537, 11, 89, 23);
			btnSalir.setHorizontalTextPosition(SwingConstants.LEADING);
		}
		return btnSalir;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO document why this method is empty
				}
			});
			btnAceptar.setBounds(224, 11, 89, 23);
		}
		return btnAceptar;
	}

	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			panelButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panelButton.setBounds(772, 92, 100, 334);
			GroupLayout glPanelButton = new GroupLayout(panelButton);
			glPanelButton.setHorizontalGroup(glPanelButton.createParallelGroup(Alignment.TRAILING)
					.addGroup(glPanelButton.createSequentialGroup().addContainerGap()
							.addGroup(glPanelButton.createParallelGroup(Alignment.LEADING, false)
									.addComponent(getBtnInsertar(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(getBtnEditar(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(getBtnBorrar(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(getBtnInfo(), 0, 0, Short.MAX_VALUE))
							.addContainerGap(15, Short.MAX_VALUE)));
			glPanelButton.setVerticalGroup(glPanelButton.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelButton.createSequentialGroup().addContainerGap().addComponent(getBtnInsertar())
							.addGap(18).addComponent(getBtnEditar()).addGap(18).addComponent(getBtnBorrar()).addGap(18)
							.addComponent(getBtnInfo()).addContainerGap(177, Short.MAX_VALUE)));
			glPanelButton.linkSize(SwingConstants.HORIZONTAL,
					new Component[] { getBtnInsertar(), getBtnEditar(), getBtnBorrar() });
			panelButton.setLayout(glPanelButton);
		}
		return panelButton;
	}

	private JButton getBtnInsertar() {
		if (btnInsertar == null) {
			btnInsertar = new JButton("Insertar");
			btnInsertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Viviendas viviendas = new Viviendas();
					Afectaciones afectaciones = new Afectaciones();
					Frame.addRuta(new Object[] { viviendas, afectaciones },
							new Object[] { new Vivienda(), new Afectacion() });
					Frame.setContentPanes(viviendas);
				}
			});
		}
		return btnInsertar;
	}

	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
		}
		return btnEditar;
	}

	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableModel.borrarSeleccion();
				}
			});
			btnBorrar.setEnabled(false);
		}
		return btnBorrar;
	}

	private JButton getBtnInfo() {
		if (btnInfo == null) {
			btnInfo = new JButton("Info");
		}
		return btnInfo;
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
			filtroNumero.setBounds(120, 92, 97, 20);
		}
		return filtroNumero;
	}

	private JTextField getFiltroDireccion() {
		if (filtroDireccion == null) {
			filtroDireccion = new JTextField();
			filtroDireccion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tableModel.filtrar(filtroDireccion.getText(), 2);
				}
			});
			filtroDireccion.setColumns(10);
			filtroDireccion.setBounds(220, 92, 317, 20);
		}
		return filtroDireccion;
	}

	private JTextField getFiltroFecha() {
		if (filtroFecha == null) {
			filtroFecha = new JTextField();
			filtroFecha.setColumns(10);
			filtroFecha.setBounds(539, 92, 223, 20);
		}
		return filtroFecha;
	}
}

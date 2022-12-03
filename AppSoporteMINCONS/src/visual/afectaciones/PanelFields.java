package visual.afectaciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import clases.Construccion;
import clases.Inmueble;
import clases.Material;
import clases.Pared;
import clases.Techo;
import visual.util.CustomScrollPane;
import visual.util.TableModel;

public class PanelFields extends CustomScrollPane {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -4173875557817308509L;
	private JPanel panel;
	private JPanel panelPared;
	private JScrollPane scrollTablePared;
	private JTable tablePared;
	private TableModel tableModelPared;
	private JButton btnAgnadirPared;
	private JButton btnEditarPared;
	private JButton btnBorrarPared;
	private JPanel panelTecho;
	private JScrollPane scrollTableTecho;
	private JTable tableTecho;
	private JButton btnAgnadirTecho;
	private JButton btnEditarTecho;
	private JButton btnBorrarTecho;
	private DefaultTableModel tableModelTecho;
	private JPanel panelInmueble;
	private JScrollPane scrollTableInmuebles;
	private JTable tableInmuebles;
	private JButton btnAgnadirInmueble;
	private JButton btnEditarInmueble;
	private JButton btnBorrarInmueble;
	private DefaultTableModel tableModelInmueble;
	private Window padre;
	private ArrayList<Pared> listaParedes;
	private ArrayList<Techo> listaTechos;
	private ArrayList<Inmueble> listaInmuebles;
	private ArrayList<Material> listaMateriales;

	/**
	 * Create the panel.
	 */
	public PanelFields(Window padre, ArrayList<Pared> listaParedes, ArrayList<Techo> listaTechos,
			ArrayList<Inmueble> listaInmuebles, ArrayList<Material> listaMateriales) {

		this.padre = padre;
		this.listaParedes = listaParedes;
		this.listaTechos = listaTechos;
		this.listaInmuebles = listaInmuebles;
		this.listaMateriales = listaMateriales;
		setMaximumSize(new Dimension(32767, 800000));
		setViewportView(getPanel());
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		// Bloque de Código generado por WindowBuilder para el Layout
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		GroupLayout glPanelFields = new GroupLayout(panel);
		glPanelFields.setHorizontalGroup(glPanelFields.createParallelGroup(Alignment.LEADING).addGroup(glPanelFields
				.createSequentialGroup().addContainerGap()
				.addGroup(glPanelFields.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(getPanelInmueble(), Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(getPanelTecho(), Alignment.LEADING, 0, 0, Short.MAX_VALUE).addComponent(
								getPanelPared(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
				.addContainerGap()));
		glPanelFields.setVerticalGroup(glPanelFields.createParallelGroup(Alignment.LEADING)
				.addGroup(glPanelFields.createSequentialGroup().addContainerGap()
						.addComponent(getPanelPared(), GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getPanelTecho(), GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getPanelInmueble(), GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(766, Short.MAX_VALUE)));
		panel.setLayout(glPanelFields);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 750));
		}
		return panel;
	}

	private JPanel getPanelPared() {
		if (panelPared == null) {
			panelPared = new JPanel();
			panelPared.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Paredes Afectadas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelPared.setLayout(null);
			panelPared.add(getScrollTablePared());
			panelPared.add(getBtnAgnadirPared());
			panelPared.add(getBtnEditarPared());
			panelPared.add(getBtnBorrarPared());
		}
		return panelPared;
	}

	private JScrollPane getScrollTablePared() {
		if (scrollTablePared == null) {
			scrollTablePared = new JScrollPane();
			scrollTablePared.setBounds(10, 25, 464, 180);
			scrollTablePared.setViewportView(getTablePared());
		}
		return scrollTablePared;
	}

	private JTable getTablePared() {
		if (tablePared == null) {
			tablePared = new JTable(getTableModelPared());
			TableColumn column = tablePared.getColumn("#");
			column.setPreferredWidth(0);

		}
		return tablePared;
	}

	/**
	 * @wbp.nonvisual location=657,109
	 */
	private DefaultTableModel getTableModelPared() {
		if (tableModelPared == null) {
			String[] columnNames = new String[] { "#", "identificador", "Material Predominante", "Tipo de Derrumbe",
			"Pared de Carga" };
			tableModelPared = new TableModel(columnNames);
		}
		return tableModelPared;
	}

	private JButton getBtnAgnadirPared() {
		if (btnAgnadirPared == null) {
			btnAgnadirPared = new JButton("Añadir");
			btnAgnadirPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ParedTablelAdd dialog = new ParedTablelAdd(padre, tableModelPared, listaParedes,
								listaMateriales, tableModelPared.getRowCount() + 1);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnAgnadirPared.setBounds(484, 25, 80, 23);
		}
		return btnAgnadirPared;
	}

	private JButton getBtnEditarPared() {
		if (btnEditarPared == null) {
			btnEditarPared = new JButton("Editar");
			btnEditarPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tablePared.getSelectedRow() >= 0) {
						ParedTablelEdit dialog = new ParedTablelEdit(padre, tableModelPared, listaParedes,
								listaMateriales, tableModelPared.getRowCount() + 1);
						dialog.setIdentificador(listaParedes.get(tablePared.getSelectedRow()).getIdentificador());
						int row = tablePared.getSelectedRow();
						Pared pared = listaParedes.get(row);
						Construccion mat = (Construccion) Afectaciones
								.buscarMateriar(pared.getMaterialPredominante().getNombre());
						String nombre = mat.getNombre();
						dialog.setMatPred(nombre);
						dialog.setTipoDerrumbe(listaParedes.get(tablePared.getSelectedRow()).getTipoDerrumbe().name());
						dialog.setEsParedCargas(listaParedes.get(tablePared.getSelectedRow()).isEsParedCarga());
						dialog.setVisible(true);

					}
				}
			});

			btnEditarPared.setBounds(484, 59, 80, 23);
		}
		return btnEditarPared;
	}

	private JButton getBtnBorrarPared() {
		if (btnBorrarPared == null) {
			btnBorrarPared = new JButton("Borrar");
			btnBorrarPared.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tablePared.getSelectedRowCount() > 0
							&& JOptionPane.showConfirmDialog(padre, "Desea el/los elementos seleccionados") != 1.5F) {
						listaParedes.remove(tablePared.getSelectedRow());
						actualizarPared();
					}

				}
			});
			btnBorrarPared.setBounds(484, 93, 80, 23);
		}
		return btnBorrarPared;
	}

	public void actualizarPared() {
		tableModelPared.setRowCount(0);
		int count = 1;
		for (Pared pared : listaParedes) {
			tableModelPared.addRow(
					new Object[] { "" + count++, pared.getIdentificador(), pared.getMaterialPredominante().getNombre(),
							pared.getTipoDerrumbe().name(), pared.isEsParedCarga() ? "Si" : "No" });
		}
	}
	public void actualizarTecho() {
		tableModelTecho.setRowCount(0);
		int count = 1;
		for (Techo techo : listaTechos) {
			tableModelTecho.addRow(
					new Object[] { "" + count++, techo.getIdentificador(), techo.getMaterialPredominante().getNombre(),
							techo.getTipoDerrumbe().name()});
		}
	}
	public void actualizarInmueble() {
		tableModelTecho.setRowCount(0);
		int count = 1;
		for (Techo techo : listaTechos) {
			tableModelTecho.addRow(
					new Object[] { "" + count++, techo.getIdentificador(), techo.getMaterialPredominante().getNombre(),
							techo.getTipoDerrumbe().name()});
		}
	}

	private JPanel getPanelTecho() {
		if (panelTecho == null) {
			panelTecho = new JPanel();
			panelTecho.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Techos Afectados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTecho.setLayout(null);
			panelTecho.add(getScrollTableTecho());
			panelTecho.add(getBtnAgnadirTecho());
			panelTecho.add(getBtnEditarTecho());
			panelTecho.add(getBtnBorrarTecho());
		}
		return panelTecho;
	}

	private JScrollPane getScrollTableTecho() {
		if (scrollTableTecho == null) {
			scrollTableTecho = new JScrollPane();
			scrollTableTecho.setBounds(10, 25, 466, 189);
			scrollTableTecho.setViewportView(getTableTecho());
		}
		return scrollTableTecho;
	}

	private JTable getTableTecho() {
		if (tableTecho == null) {
			tableTecho = new JTable(getTableModelTecho());
			TableColumn column = tableTecho.getColumn("#");
			column.setPreferredWidth(0);

		}
		return tableTecho;
	}

	private JButton getBtnAgnadirTecho() {
		if (btnAgnadirTecho == null) {
			btnAgnadirTecho = new JButton("Añadir");
			btnAgnadirTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						TechoTablelAdd dialog = new TechoTablelAdd(padre, (TableModel) tableModelTecho, listaTechos,
								listaMateriales, tableModelTecho.getRowCount() + 1, tableInmuebles);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnAgnadirTecho.setBounds(486, 35, 80, 23);
		}
		return btnAgnadirTecho;
	}

	private JButton getBtnEditarTecho() {
		if (btnEditarTecho == null) {
			btnEditarTecho = new JButton("Editar");
			btnEditarTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tableTecho.getSelectedRow() >= 0) {
						TechoTablelEdit dialog = new TechoTablelEdit(padre, (TableModel) tableModelTecho, listaTechos,
								listaMateriales, tableModelTecho.getRowCount() + 1);
						dialog.setIdentificador(listaTechos.get(tableTecho.getSelectedRow()).getIdentificador());
						int row = tableTecho.getSelectedRow();
						Techo techo = listaTechos.get(row);
						Construccion mat = (Construccion) Afectaciones
								.buscarMateriar(techo.getMaterialPredominante().getNombre());
						String nombre = mat.getNombre();
						dialog.setMatPred(nombre);
						dialog.setTipoDerrumbe(listaTechos.get(tableTecho.getSelectedRow()).getTipoDerrumbe().name());
						dialog.setVisible(true);

					}
				}
			});
			btnEditarTecho.setBounds(486, 69, 80, 23);
		}
		return btnEditarTecho;
	}

	private JButton getBtnBorrarTecho() {
		if (btnBorrarTecho == null) {
			btnBorrarTecho = new JButton("Borrar");
			btnBorrarTecho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tableTecho.getSelectedRowCount() > 0
							&& JOptionPane.showConfirmDialog(padre, "Desea el/los elementos seleccionados") != 1.5F) {
						listaTechos.remove(tableTecho.getSelectedRow());
						actualizarTecho();
					}

				}
			});
			btnBorrarTecho.setBounds(486, 103, 80, 23);
		}
		return btnBorrarTecho;
	}

	/**
	 * @wbp.nonvisual location=657,349
	 */
	private DefaultTableModel getTableModelTecho() {
		if (tableModelTecho == null) {
			String[] columnNames = new String[] { "#", "identificador", "Material Predominante", "Tipo de Derrumbe" };
			tableModelTecho = new TableModel(columnNames);
		}
		return tableModelTecho;
	}

	private JPanel getPanelInmueble() {
		if (panelInmueble == null) {
			panelInmueble = new JPanel();
			panelInmueble.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Elementos Afectados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelInmueble.setLayout(null);
			panelInmueble.add(getScrollTableInmuebles());
			panelInmueble.add(getBtnAgnadirInmueble());
			panelInmueble.add(getBtnEditarInmueble());
			panelInmueble.add(getBtnBorrarInmueble());
		}
		return panelInmueble;
	}

	private JScrollPane getScrollTableInmuebles() {
		if (scrollTableInmuebles == null) {
			scrollTableInmuebles = new JScrollPane();
			scrollTableInmuebles.setBounds(10, 21, 466, 219);
			scrollTableInmuebles.setViewportView(getTableInmuebles());
		}
		return scrollTableInmuebles;
	}

	private JTable getTableInmuebles() {
		if (tableInmuebles == null) {
			tableInmuebles = new JTable(getTableModelInmueble());
			TableColumn column = tableInmuebles.getColumn("#");
			column.setPreferredWidth(0);
		}
		return tableInmuebles;
	}

	private JButton getBtnAgnadirInmueble() {
		if (btnAgnadirInmueble == null) {
			btnAgnadirInmueble = new JButton("Añadir");
			btnAgnadirInmueble = new JButton("Añadir");
			btnAgnadirInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						InmuebleTablelEdit dialog = new InmuebleTablelEdit(padre, (TableModel) tableModelInmueble, listaInmuebles,
								listaMateriales, tableModelInmueble.getRowCount() + 1, tableInmuebles);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnAgnadirInmueble.setBounds(486, 35, 80, 23);
		}
		return btnAgnadirInmueble;
	}

	private JButton getBtnEditarInmueble() {
		if (btnEditarInmueble == null) {
			btnEditarInmueble = new JButton("Editar");
			btnEditarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tableInmuebles.getSelectedRow() >= 0) {
						InmuebleTablelEdit dialog = new InmuebleTablelEdit(padre, (TableModel) tableModelInmueble, listaInmuebles,
								listaMateriales, tableModelInmueble.getRowCount() + 1, null);
						dialog.setVisible(true);

					}
				}
			});
			btnEditarInmueble.setBounds(486, 69, 80, 23);
		}
		return btnEditarInmueble;
	}

	private JButton getBtnBorrarInmueble() {
		if (btnBorrarInmueble == null) {
			btnBorrarInmueble = new JButton("Borrar");
			btnBorrarInmueble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tableInmuebles.getSelectedRowCount() > 0
							&& JOptionPane.showConfirmDialog(padre, "Desea el/los elementos seleccionados") != 1.5F) {
						listaInmuebles.remove(tableInmuebles.getSelectedRow());
						actualizarInmueble();
					}

				}
			});
			btnBorrarInmueble.setBounds(486, 101, 80, 23);
		}
		return btnBorrarInmueble;
	}

	/**
	 * @wbp.nonvisual location=657,529
	 */
	private DefaultTableModel getTableModelInmueble() {
		if (tableModelInmueble == null) {
			String[] columnNames = new String[] { "#", "ID", "Nombre", "Cantidad" };
			tableModelInmueble = new TableModel(columnNames);
		}
		return tableModelInmueble;
	}
}

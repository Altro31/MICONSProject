package visual;

import visual.util.PrincipalPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Afectacion;
import clases.Cubicacion;
import clases.Evento;
import clases.FichaTecnica;
import clases.Material;
import clases.Sistema;
import clases.Vivienda;
import util.AsignarTableModel;
import util.Auxiliary;
import util.ExistenteTableModel;
import util.FichaTableModel;

import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AsignarMateriales extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2519440870954161017L;
	private JPanel panel;
	private JButton btnRemove;
	private JButton btnAdd;
	private JLabel lblTitulo;
	private JTable tableExistentes;
	private JTable tableAsignar;
	private JScrollPane scrollExistentes;
	private JScrollPane scrollAsignar;
	private JPanel panelCantidad;
	private JLabel lblCantidad;
	private JButton btnOK;
	private JButton btnCancel;
	private JPanel panelButton2;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private ExistenteTableModel modelExistentes;
	private AsignarTableModel modelAsignar;
	private JSpinner spinnerCantidad;
	/**
	 * Create the panel.
	 */
	public AsignarMateriales() {
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.setContentPanes((Afectaciones) ((Object[]) Frame.getPosicionActual()[0])[1]);
			}
		});
		add(getPanel());
		add(getLblTitulo());
		add(getPanelButton2());

	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(32, 72, 826, 350);
			panel.setLayout(null);
			panel.add(getBtnRemove());
			panel.add(getBtnAdd());
			panel.add(getScrollExistentes());
			panel.add(getScrollAsignar());
			panel.add(getPanelCantidad());
		}
		return panel;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("<-");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tableAsignar.getSelectedRowCount()>0) {
						int index = tableAsignar.getSelectedRow();
						Cubicacion cubicacion = ((Cubicacion)((Object[])Frame.getPosicionActual()[1])[2]);
						cubicacion.eliminarMaterial(index);
						modelAsignar.actualizar(cubicacion.getListaMateriales());
					}
				}
			});
			btnRemove.setBounds(382, 228, 59, 29);
		}
		return btnRemove;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("->");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tableExistentes.getSelectedRowCount()>0) {
						panelCantidad.setVisible(true);
					}
				}
			});
			btnAdd.setBounds(382, 94, 59, 29);
		}
		return btnAdd;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Asignacion de Materiales para la Construcción");
			lblTitulo.setOpaque(true);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblTitulo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lblTitulo.setBackground(Color.WHITE);
			lblTitulo.setBounds(32, 26, 826, 41);
		}
		return lblTitulo;
	}
	private JTable getTableExistentes() {
		if (tableExistentes == null) {
			tableExistentes = new JTable();
			tableExistentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			modelExistentes = new ExistenteTableModel();
			tableExistentes.setModel(modelExistentes);
			modelExistentes.actualizar(Sistema.getListaMateriales());
			tableExistentes.getColumnModel().getColumn(0).setResizable(false);
			tableExistentes.getColumnModel().getColumn(1).setPreferredWidth(98);
		}
		return tableExistentes;
	}
	private JTable getTableAsignar() {
		if (tableAsignar == null) {
			tableAsignar = new JTable();
			tableAsignar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			modelAsignar = new AsignarTableModel();
			tableAsignar.setModel(modelAsignar);
			tableAsignar.getColumnModel().getColumn(0).setResizable(false);
			tableAsignar.getColumnModel().getColumn(1).setResizable(false);
			tableAsignar.getColumnModel().getColumn(2).setResizable(false);
		}
		return tableAsignar;
	}
	private JScrollPane getScrollExistentes() {
		if (scrollExistentes == null) {
			scrollExistentes = new JScrollPane();
			scrollExistentes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Materiales Existentes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollExistentes.setBounds(10, 11, 359, 328);
			scrollExistentes.setViewportView(getTableExistentes());
		}
		return scrollExistentes;
	}
	private JScrollPane getScrollAsignar() {
		if (scrollAsignar == null) {
			scrollAsignar = new JScrollPane();
			scrollAsignar.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Materiales a Asignar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollAsignar.setBounds(457, 11, 359, 328);
			scrollAsignar.setViewportView(getTableAsignar());
		}
		return scrollAsignar;
	}
	private JPanel getPanelCantidad() {
		if (panelCantidad == null) {
			panelCantidad = new JPanel();
			panelCantidad.setVisible(false);
			panelCantidad.setBounds(372, 134, 82, 83);
			panelCantidad.setLayout(null);
			panelCantidad.add(getLblCantidad());
			panelCantidad.add(getBtnOK());
			panelCantidad.add(getBtnCancel());
			panelCantidad.add(getSpinnerCantidad());
		}
		return panelCantidad;
	}
	private JLabel getLblCantidad() {
		if (lblCantidad == null) {
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
			lblCantidad.setBounds(10, 11, 62, 14);
		}
		return lblCantidad;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = tableExistentes.getSelectedRow();
					Material material = Sistema.getListaMateriales().get(index);
					material.setCantidad(((Integer)spinnerCantidad.getValue()).intValue());
					Cubicacion cubicacion = ((Cubicacion)((Object[])Frame.getPosicionActual()[1])[2]);
					cubicacion.addMaterial(material);
					
					modelAsignar.actualizar(cubicacion.getListaMateriales());
					
					panelCantidad.setVisible(false);
				}
			});
			btnOK.setBounds(9, 53, 26, 23);
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCantidad.setVisible(false);
				}
			});
			btnCancel.setBounds(45, 53, 26, 23);
		}
		return btnCancel;
	}
	private JPanel getPanelButton2() {
		if (panelButton2 == null) {
			panelButton2 = new JPanel();
			panelButton2.setBounds(32, 433, 826, 36);
			panelButton2.add(getBtnSiguiente());
			panelButton2.add(getBtnCancelar());
		}
		return panelButton2;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FichaTecnica ficha = new FichaTecnica();
					ficha.setVivienda(((Vivienda)((Object[])Frame.getPosicionActual()[1])[0]));
					ficha.setAfect(((Afectacion)((Object[])Frame.getPosicionActual()[1])[1]));
					ficha.setCubicacion(((Cubicacion)((Object[])Frame.getPosicionActual()[1])[2]));
					Evento evento = (Evento)Frame.get(1)[1];
					evento.addFichaTecnica(ficha);
					Frame.removerRuta(Frame.get(3)[0]);
					Frame.setContentPanes((FichasTecnicas) Frame.getPosicionActual()[0]);
					
				}
			});
		}
		return btnSiguiente;
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
	private JSpinner getSpinnerCantidad() {
		if (spinnerCantidad == null) {
			spinnerCantidad = new JSpinner();
			spinnerCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerCantidad.setBounds(10, 27, 62, 23);
		}
		return spinnerCantidad;
	}
}

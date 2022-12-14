package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import classes.Construccion;
import classes.Cubicacion;
import classes.Evento;
import classes.FichaTecnica;
import classes.Material;
import classes.Sistema;
import settings.Manager;
import util.AsignarTableModel;
import util.ExistenteTableModel;
import visual.util.CustomTable;
import visual.util.PrincipalPanel;

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
	private CustomTable cTableExistentes;
	private CustomTable cTableAsignar;
	private JPanel panelCantidad;
	private JLabel lblCantidad;
	private JButton btnOK;
	private JButton btnCancel;
	private JPanel panelButton2;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private AsignarTableModel modelAsignar;
	private JSpinner spinnerCantidad;
	private ArrayList<Construccion> lista;

	/**
	 * Create the panel.
	 */
	public AsignarMateriales() {
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager.guardarDatos();
				System.exit(0);
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.setContentPanes((Afectaciones) ((Object[]) Frame.getPosicionActual()[0])[1]);
			}
		});
		lista = getListaMateriales();
		add(getPanel());
		add(getLblTitulo());
		add(getPanelButton2());

	}

	private ArrayList<Construccion> getListaMateriales() {

		ArrayList<Construccion> listaMateriales = new ArrayList<Construccion>();
		for (Material m : Sistema.getInstance().getListaMateriales()) {
			if (m instanceof Construccion) {
				listaMateriales.add((Construccion) m);
			}
		}

		return listaMateriales;

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(32, 72, 826, 350);
			panel.setLayout(null);
			panel.add(getBtnRemove());
			panel.add(getBtnAdd());
			panel.add(getCTableExistentes());
			panel.add(getCTableAsignar());
			panel.add(getPanelCantidad());
		}
		return panel;
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("");
			btnRemove.setEnabled(false);
			btnRemove.setIcon(new ImageIcon(AsignarMateriales.class.getResource("/images/Left.png")));
			btnRemove.setFocusable(false);
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tableAsignar.getSelectedRowCount() > 0) {

						ArrayList<Material> listaMateriales = ((FichaTecnica) Frame.getPosicionActual()[1])
								.getCubicacion().getListaMateriales();
						ArrayList<Material> lista2 = new ArrayList<Material>();
						for (int i : tableAsignar.getSelectedRows()) {
							lista2.add(listaMateriales.get(i));
						}
						listaMateriales.removeAll(lista2);

						modelAsignar.actualizar(listaMateriales);

					}
				}
			});
			btnRemove.setBounds(382, 237, 59, 29);
		}
		return btnRemove;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("");
			btnAdd.setEnabled(false);
			btnAdd.setIcon(new ImageIcon(AsignarMateriales.class.getResource("/images/Right.png")));
			btnAdd.setFocusable(false);
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tableExistentes.getSelectedRowCount() > 0) {
						spinnerCantidad.setValue(0);
						bloquearCampos(true);
					}
				}
			});
			btnAdd.setBounds(382, 94, 59, 29);
		}
		return btnAdd;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Asignacion de Materiales para la Construcci??n");
			lblTitulo.setOpaque(true);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblTitulo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lblTitulo.setBackground(Color.WHITE);
			lblTitulo.setBounds(32, 26, 826, 41);
		}
		return lblTitulo;
	}

	private CustomTable getCTableExistentes() {
		if (cTableExistentes == null) {
			ExistenteTableModel modelExistentes = new ExistenteTableModel();
			cTableExistentes = new CustomTable(modelExistentes, btnAdd, null, new int[] { 1 });
			cTableExistentes.getTable().getColumnModel().getColumn(0).setResizable(false);
			cTableExistentes.getTable().getColumnModel().getColumn(1).setResizable(false);
			cTableExistentes.getTable().getColumnModel().getColumn(1).setPreferredWidth(100);
			cTableExistentes.getTable().getColumnModel().getColumn(1).setMaxWidth(100);
			cTableExistentes.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Materiales Existentes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			cTableExistentes.setBounds(10, 11, 359, 328);
			tableExistentes = cTableExistentes.getTable();
			modelExistentes.actualizar(lista);
			tableExistentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return cTableExistentes;
	}

	private CustomTable getCTableAsignar() {
		if (cTableAsignar == null) {
			modelAsignar = new AsignarTableModel();
			cTableAsignar = new CustomTable(modelAsignar, btnRemove, null, new int[] { 1, 2 });
			cTableAsignar.getTable().getColumnModel().getColumn(0).setResizable(false);
			cTableAsignar.getTable().getColumnModel().getColumn(1).setResizable(false);
			cTableAsignar.getTable().getColumnModel().getColumn(1).setPreferredWidth(100);
			cTableAsignar.getTable().getColumnModel().getColumn(1).setMaxWidth(100);
			cTableAsignar.getTable().getColumnModel().getColumn(2).setResizable(false);
			cTableAsignar.getTable().getColumnModel().getColumn(2).setPreferredWidth(80);
			cTableAsignar.getTable().getColumnModel().getColumn(2).setMaxWidth(80);
			cTableAsignar.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Materiales a Asignar para la Reparaci??n", TitledBorder.LEADING, TitledBorder.TOP, null,
					new Color(0, 0, 0)));
			cTableAsignar.setBounds(457, 11, 359, 328);
			tableAsignar = cTableAsignar.getTable();
		}
		return cTableAsignar;
	}

	private JPanel getPanelCantidad() {
		if (panelCantidad == null) {
			panelCantidad = new JPanel();
			panelCantidad.setBorder(null);
			panelCantidad.setVisible(false);
			panelCantidad.setBounds(372, 134, 82, 92);
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
			btnOK.setFocusable(false);
			btnOK.setIcon(new ImageIcon(AsignarMateriales.class.getResource("/images/OK.png")));
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = tableExistentes.getSelectedRow();
					Material material = lista.get(index);
					int cantidad = ((Integer) spinnerCantidad.getValue()).intValue();
					if (cantidad > 0) {
						Material m = (Material) material.clones();
						m.setCantidad(cantidad);
						Cubicacion cubicacion = ((FichaTecnica) Frame.getPosicionActual()[1]).getCubicacion();
						cubicacion.getListaMateriales().add(m);

						modelAsignar.actualizar(cubicacion.getListaMateriales());

						bloquearCampos(false);
					}
				}
			});
			btnOK.setBounds(9, 53, 26, 23);
		}
		return btnOK;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("");
			btnCancel.setFocusable(false);
			btnCancel.setIcon(new ImageIcon(AsignarMateriales.class.getResource("/images/Cancel.png")));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					bloquearCampos(false);
				}
			});
			btnCancel.setBounds(45, 53, 26, 23);
		}
		return btnCancel;
	}

	private JPanel getPanelButton2() {
		if (panelButton2 == null) {
			panelButton2 = new JPanel();
			panelButton2.setBounds(32, 431, 826, 46);
			panelButton2.setLayout(null);
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

					FichaTecnica ficha = (FichaTecnica) Frame.getPosicionActual()[1];

					ficha.setVivienda(((FichaTecnica) Frame.getPosicionActual()[1]).getVivienda());
					ficha.setAfect(((FichaTecnica) Frame.getPosicionActual()[1]).getAfect());
					ficha.setCubicacion(((FichaTecnica) Frame.getPosicionActual()[1]).getCubicacion());

					Frame.anteriorPrincipal(1);

					Evento evento = (Evento) Frame.getPosicionActual()[1];
					evento.addFichaTecnica(ficha);

					((FichasTecnicas) Frame.getPosicionActual()[0]).getTableModel()
							.actualizar(((Evento) Frame.getPosicionActual()[1]).getListaFichasTecnicas());

				}
			});

			btnSiguiente.setBounds(246, 11, 89, 23);
		}
		return btnSiguiente;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame.anteriorPrincipal(1);
				}
			});
			btnCancelar.setBounds(482, 11, 89, 23);
		}
		return btnCancelar;
	}

	private JSpinner getSpinnerCantidad() {
		if (spinnerCantidad == null) {
			spinnerCantidad = new JSpinner();
			spinnerCantidad
					.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerCantidad.setBounds(10, 27, 62, 23);
		}
		return spinnerCantidad;
	}

	private void bloquearCampos(boolean bloquear) {
		bloquear = !bloquear;
		panelCantidad.setVisible(!bloquear);
		tableExistentes.setEnabled(bloquear);
		btnAdd.setEnabled(bloquear);
		btnRemove.setEnabled(bloquear);
		tableAsignar.setEnabled(bloquear);
		btnSiguiente.setEnabled(bloquear);
		btnCancelar.setEnabled(bloquear);
	}

	public void actualizarCampos(Cubicacion cubicacion) {
		modelAsignar.actualizar(cubicacion.getListaMateriales());
	}
}

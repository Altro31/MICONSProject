package visual;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import util.Auxiliary;
import util.FichaTableModel;
import util.Manager;
import visual.util.CustomTable;
import visual.util.PrincipalPanel;
import clases.Afectacion;
import clases.Cubicacion;
import clases.Evento;
import clases.FichaTecnica;
import clases.Sistema;
import clases.Vivienda;

public class FichasTecnicas extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2837587028329428263L;
	private CustomTable cTable;
	private JTable table;
	private FichaTableModel tableModel;
	private JPanel panelTitulo;
	private JLabel lblTitulo;
	private JPanel panelButton2;
	private JButton btnSalir;
	private JButton btnAceptar;
	private JPanel panelButton;
	private JButton btnInsertar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JTextField filtroNumero;
	private JTextField filtroDireccion;
	private JTextField filtroFecha;

	/**
	 * Create the panel.
	 */
	public FichasTecnicas() {
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager.guardarDatos();
				System.exit(0);
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.removerActual();
			}
		});
		add(getPanelTitulo());
		add(getPanelButton2());
		add(getPanelButton());
		add(getFiltroNumero());
		add(getFiltroDireccion());
		add(getFiltroFecha());
		add(getcTable());
	}

	// Componentes
	private JScrollPane getcTable() {
		if (cTable == null) {
			tableModel = new FichaTableModel();
			cTable = new CustomTable(tableModel, btnBorrar, btnEditar, new int[] {});
			cTable.getTable().getColumnModel().getColumn(0).setResizable(false);
			cTable.getTable().getColumnModel().getColumn(0).setPreferredWidth(40);
			cTable.getTable().getColumnModel().getColumn(0).setMinWidth(40);
			cTable.setBounds(20, 115, 742, 311);
			table = cTable.getTable();
		}
		return cTable;
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
			btnSalir.setFocusable(false);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame.anteriorPrincipal(1);
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
			btnAceptar.setFocusable(false);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Sistema.getInstance().addEvento((Evento)Frame.getPosicionActual()[1]);
					Frame.anteriorPrincipal(1);
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
			glPanelButton.setHorizontalGroup(
				glPanelButton.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelButton.createSequentialGroup()
						.addContainerGap()
						.addGroup(glPanelButton.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(getBtnInsertar(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getBtnEditar(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getBtnBorrar(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(15, Short.MAX_VALUE))
			);
			glPanelButton.setVerticalGroup(
				glPanelButton.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelButton.createSequentialGroup()
						.addContainerGap()
						.addComponent(getBtnInsertar())
						.addGap(18)
						.addComponent(getBtnEditar())
						.addGap(18)
						.addComponent(getBtnBorrar())
						.addContainerGap(214, Short.MAX_VALUE))
			);
			glPanelButton.linkSize(SwingConstants.HORIZONTAL, new Component[] {getBtnInsertar(), getBtnEditar(), getBtnBorrar()});
			panelButton.setLayout(glPanelButton);
		}
		return panelButton;
	}

	private JButton getBtnInsertar() {
		if (btnInsertar == null) {
			btnInsertar = new JButton("Insertar");
			btnInsertar.setFocusable(false);
			btnInsertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Viviendas viviendas = new Viviendas();
					Afectaciones afectaciones = new Afectaciones();
					AsignarMateriales asignarMateriales = new AsignarMateriales();
					Frame.addRuta(new Object[] { viviendas, afectaciones, asignarMateriales },
							new FichaTecnica());
					Frame.setContentPanes(viviendas);
				}
			});
		}
		return btnInsertar;
	}

	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setFocusable(false);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Evento evento = ((Evento)Frame.getPosicionActual()[1]);
					FichaTecnica ficha = evento.getListaFichasTecnicas().get(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())-1 );
					
					Viviendas viviendas = new Viviendas();
					Afectaciones afectaciones = new Afectaciones();
					AsignarMateriales asignar = new AsignarMateriales();

					Vivienda vivienda = ficha.getVivienda();
					Afectacion afectacion = ficha.getAfect();
					Cubicacion cubicacion = ficha.getCubicacion();

					Frame.addRuta(new Object[] { viviendas, afectaciones, asignar },
							ficha);

					viviendas.actualizarCampos(vivienda);
					afectaciones.actualizarCampos(afectacion);
					asignar.actualizarCampos(cubicacion);

					Frame.setContentPanes(viviendas);

				}
			});
			btnEditar.setEnabled(false);
		}
		return btnEditar;
	}

	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("Borrar");
			btnBorrar.setFocusable(false);
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Auxiliary.borrarSeleccion(table, ((Evento) Frame.getPosicionActual()[1]).getListaFichasTecnicas());
					tableModel.actualizar(((Evento) Frame.getPosicionActual()[1]).getListaFichasTecnicas());
				}
			});
			btnBorrar.setEnabled(false);
		}
		return btnBorrar;
	}

	private JTextField getFiltroNumero() {
		if (filtroNumero == null) {
			filtroNumero = new JTextField();
			filtroNumero.setBorder(null);
			filtroNumero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tableModel.filtrar(filtroNumero.getText(), 1);
				}
			});

			filtroNumero.setColumns(10);
			filtroNumero.setBounds(20, 93, 222, 20);
		}
		return filtroNumero;
	}

	private JTextField getFiltroDireccion() {
		if (filtroDireccion == null) {
			filtroDireccion = new JTextField();
			filtroDireccion.setBorder(null);
			filtroDireccion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tableModel.filtrar(filtroDireccion.getText(), 2);
				}
			});
			filtroDireccion.setColumns(10);
			filtroDireccion.setBounds(243, 93, 259, 20);
		}
		return filtroDireccion;
	}

	private JTextField getFiltroFecha() {
		if (filtroFecha == null) {
			filtroFecha = new JTextField();
			filtroFecha.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tableModel.filtrar(filtroFecha.getText(), 3);
				}
			});
			filtroFecha.setBorder(null);
			filtroFecha.setColumns(10);
			filtroFecha.setBounds(503, 93, 259, 20);
		}
		return filtroFecha;
	}

	public FichaTableModel getTableModel() {
		return tableModel;
	}
	public void actualizarTabla(ArrayList<FichaTecnica> lista) {
		tableModel.actualizar(lista);
	}
}

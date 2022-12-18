package visual;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import clases.Afectacion;
import clases.Cubicacion;
import clases.Evento;
import clases.Sistema;
import clases.Vivienda;
import util.Auxiliary;
import util.FichaTableModel;
import visual.util.CustomTable;
import visual.util.PrincipalPanel;

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
	private JButton btnInfo;
	private JTextField filtroNumero;
	private JTextField filtroDireccion;
	private JTextField filtroFecha;
	private JCheckBox cBoxSelectInmuebles;

	/**
	 * Create the panel.
	 */
	public FichasTecnicas() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("a");
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.removerRuta(Frame.getPosicionActual()[0]);
				Frame.setContentPanes((Eventos) Frame.getPosicionActual()[0]);
			}
		});
		add(getPanelTitulo());
		add(getPanelButton2());
		add(getPanelButton());
		add(getFiltroNumero());
		add(getFiltroDireccion());
		add(getFiltroFecha());
		add(getCBoxSelectInmuebles());
		add(getcTable());
	}

	// Componentes
	private JScrollPane getcTable() {
		if (cTable == null) {
			tableModel = new FichaTableModel();
			cTable = new CustomTable(tableModel, btnBorrar, btnEditar, new int[] {});
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
					Sistema.addEventos((Evento) (Frame.get(1))[1]);
					Frame.removerRuta(Frame.get(1)[1]);
					Frame.setContentPanes((Container) (Frame.get(0)[0]));
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
							.addComponent(getBtnBorrar(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getBtnInfo(), Alignment.LEADING, 0, 0, Short.MAX_VALUE))
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
						.addGap(18)
						.addComponent(getBtnInfo())
						.addContainerGap(173, Short.MAX_VALUE))
			);
			glPanelButton.linkSize(SwingConstants.HORIZONTAL, new Component[] {getBtnInsertar(), getBtnEditar(), getBtnBorrar()});
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
					AsignarMateriales asignarMateriales = new AsignarMateriales();
					Frame.addRuta(new Object[] { viviendas, afectaciones, asignarMateriales },
							new Object[] { new Vivienda(), new Afectacion(), new Cubicacion() });
					Frame.setContentPanes(viviendas);
				}
			});
		}
		return btnInsertar;
	}

	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO
				}
			});
			btnEditar.setEnabled(false);
		}
		return btnEditar;
	}

	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("Borrar");
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
			filtroNumero.setBorder(null);
			filtroNumero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					tableModel.filtrar(filtroNumero.getText(), 1);
				}
			});

			filtroNumero.setColumns(10);
			filtroNumero.setBounds(121, 92, 97, 20);
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
			filtroDireccion.setBounds(220, 92, 317, 20);
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
			filtroFecha.setBounds(539, 92, 223, 20);
		}
		return filtroFecha;
	}
	private JCheckBox getCBoxSelectInmuebles() {
		if (cBoxSelectInmuebles == null) {
			cBoxSelectInmuebles = new JCheckBox("");
			cBoxSelectInmuebles.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Auxiliary.selectAll(tableModel, cBoxSelectInmuebles, 0);
				}
			});
			cBoxSelectInmuebles.setBorder(null);
			cBoxSelectInmuebles.setHorizontalAlignment(SwingConstants.CENTER);
			cBoxSelectInmuebles.setBorderPainted(true);
			cBoxSelectInmuebles.setBounds(20, 92, 99, 20);
		}
		return cBoxSelectInmuebles;
	}
}

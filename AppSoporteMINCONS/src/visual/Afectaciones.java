package visual;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import clases.Afectacion;
import clases.Evento;
import clases.FichaTecnica;
import util.Manager;
import visual.afectaciones.PanelInmueble;
import visual.afectaciones.PanelPared;
import visual.afectaciones.PanelTecho;
import visual.util.PrincipalPanel;

public class Afectaciones extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3579071471874747942L;

	private static final String CANCEL = "Cancelar";

	private JTabbedPane tabbedPane;
	private JLabel lblAfectacionesDeLa;
	private JPanel panelButton2;
	private JButton btnCancelar;
	private JButton btnSiguiente;
	private PanelInmueble panelInmueble;
	private PanelPared panelPared;
	private PanelTecho panelTecho;

	/**
	 * Create the panel.
	 */
	public Afectaciones() {
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager.guardarDatos();
				System.exit(0);
			}
		});
		btnCerrar.setLocation(851, 0);
		btnAtras.setLocation(0, 0);
		btnCerrar.setSize(40, 29);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.setContentPanes((Viviendas) ((Object[]) Frame.getPosicionActual()[0])[0]);
			}
		});
		add(getLblAfectacionesDeLa());
		add(getPanelButton2());
		add(getTabbedPane());
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(SwingConstants.LEFT);
			tabbedPane.setOpaque(true);
			tabbedPane.setBounds(10, 66, 871, 379);
			tabbedPane.addTab("Inmueble", null, getPanelInmueble(), null);
			tabbedPane.addTab("Pared", null, getPanelPared(), null);
			tabbedPane.addTab("Techo", null, getPanelTecho(), null);
		}
		return tabbedPane;
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

	private JPanel getPanelButton2() {
		if (panelButton2 == null) {
			panelButton2 = new JPanel();
			FlowLayout flPanelButton2 = (FlowLayout) panelButton2.getLayout();
			flPanelButton2.setHgap(50);
			panelButton2.setBounds(10, 448, 871, 36);
			panelButton2.add(getBtnSiguiente());
			panelButton2.add(getBtnCancelar());
		}
		return panelButton2;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton(CANCEL);
			btnCancelar.setFocusable(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame.removerRuta(Frame.get(3)[0]);
					Frame.setContentPanes((FichasTecnicas) Frame.getPosicionActual()[0]);
				}
			});
		}
		return btnCancelar;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setFocusable(false);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch (JOptionPane.showConfirmDialog(Frame.getInstance(),
							"Está a punto de guardar los datos registrados en una Ficha Técnica.\n"
									+ "¿Desea asignar los materiales necesarios para las reparaciones de la Vivienda?\n"
									+ "*Tenga en cuenta que éste proceso puede realizarse más adelante")) {
					case 0:
						Frame.setContentPanes((AsignarMateriales) ((Object[]) Frame.getPosicionActual()[0])[2]);
						break;
					case 1:
						FichaTecnica ficha = (FichaTecnica)Frame.getPosicionActual()[1];
						ficha.setVivienda(((FichaTecnica) Frame.getPosicionActual()[1]).getVivienda());
						ficha.setAfect(((FichaTecnica) Frame.getPosicionActual()[1]).getAfect());
						Evento evento = (Evento) Frame.get(1)[1];
						evento.addFichaTecnica(ficha);
						Frame.removerRuta(Frame.get(3)[0]);
						Frame.setContentPanes((FichasTecnicas) Frame.getPosicionActual()[0]);
						((FichasTecnicas) Frame.getPosicionActual()[0]).getTableModel()
								.actualizar(((Evento) Frame.get(1)[1]).getListaFichasTecnicas());
						break;
					default:
						break;
					}
				}
			});
		}
		return btnSiguiente;

	}

	private PanelInmueble getPanelInmueble() {
		if (panelInmueble == null) {
			panelInmueble = new PanelInmueble();
		}
		return panelInmueble;
	}

	private PanelPared getPanelPared() {
		if (panelPared == null) {
			panelPared = new PanelPared();
		}
		return panelPared;
	}

	private PanelTecho getPanelTecho() {
		if (panelTecho == null) {
			panelTecho = new PanelTecho();
		}
		return panelTecho;
	}
	
	public void actualizarCampos(Afectacion afectacion) {
		
		panelInmueble.actualizarTabla(afectacion.getListaInmuebles());
		panelPared.actualizarTabla(afectacion.getListaParedes());
		panelTecho.actualizarTabla(afectacion.getListaTechos());
		
	}
}

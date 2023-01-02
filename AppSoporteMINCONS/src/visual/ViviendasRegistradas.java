package visual;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import classes.Evento;
import classes.FichaTecnica;
import classes.Sistema;
import settings.Manager;
import visual.util.CustomPanelViviendas;
import visual.util.PrincipalPanel;

public class ViviendasRegistradas extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4471668417093221629L;

	private static final int SPACE = 17;
	private static final int HEIGHT = 44;
	private static final int X = 10;
	private static final int Y = 10;

	private JLabel lblNewLabel;
	private JPanel panel;
	private JScrollPane scrollPane;
	private Sistema sistema = Sistema.getInstance();

	/**
	 * Create the panel.
	 */

	public ViviendasRegistradas() {
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager.guardarDatos();
				System.exit(0);
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.anteriorPrincipal(1);
				Frame.setContentPanes((Principal) Frame.getPosicionActual()[0]);
			}
		});

		setFont(new Font("Tahoma", Font.PLAIN, 29));
		add(getLblNewLabel());
		add(getScrollPane());
	}

	// Methods
	private Dimension getPreferedSizes(int index) {
		int height = (int) (index * (1.2 * SPACE + HEIGHT));
		return new Dimension(10, height);
	}

	public void addComponents() {

		limpiar();

		ArrayList<Evento> eventos = sistema.getListaEventos();
		eventos.sort(new Comparator<Evento>() {
			@Override
			public int compare(Evento o1, Evento o2) {
				return o1.getFechaInicio().compareTo(o2.getFechaInicio());
			}
		});

		ArrayList<FichaTecnica> fichas = null;
		int y = Y;
		int index = 1;

		for (Evento evento : eventos) {

			fichas = evento.getListaFichasTecnicas();
			fichas.sort(new Comparator<FichaTecnica>() {

				@Override
				public int compare(FichaTecnica o1, FichaTecnica o2) {
					return o1.getFecha().compareTo(o2.getFecha());
				}

			});

			for (FichaTecnica ficha : fichas) {
				CustomPanelViviendas p = new CustomPanelViviendas(ficha, evento.getNombre());
				p.setLocation(X, y);
				panel.add(p);
				y = y + p.getHeight() + SPACE;
				index++;
			}
		}

		panel.setPreferredSize(getPreferedSizes(index));

	}

	private void limpiar() {
		for (Component c : panel.getComponents()) {
			panel.remove(c);
		}
	}

	// Getters and Setters

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Viviendas Registradas");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBounds(43, 31, 805, 46);
		}
		return lblNewLabel;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.addContainerListener(new ContainerAdapter() {
				@Override
				public void componentAdded(ContainerEvent e) {
					updateUI();
				}

				@Override
				public void componentRemoved(ContainerEvent e) {
					updateUI();
				}
			});
			panel.setLayout(null);
			addComponents();
		}
		return panel;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(43, 88, 805, 375);
			scrollPane.setViewportView(getPanel());
		}
		return scrollPane;
	}

}

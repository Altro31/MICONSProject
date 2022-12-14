package visual;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import classes.Evento;
import classes.Sistema;
import settings.Manager;
import visual.util.CustomPanelEventos;
import visual.util.PrincipalPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class EventosRegistrados extends PrincipalPanel {

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

	public EventosRegistrados() {
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame.anteriorPrincipal(1);
				Frame.setContentPanes((Principal) Frame.getPosicionActual()[0]);
			}
		});
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Manager.guardarDatos();
				System.exit(0);
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
		int y = Y;
		int index = 1;

		for (Evento evento : eventos) {
			CustomPanelEventos p = new CustomPanelEventos(this, index - 1, evento);
			p.setLocation(X, y);
			panel.add(p);
			y = y + p.getHeight() + SPACE;
			index++;
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
			lblNewLabel = new JLabel("Eventos Registrados");
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

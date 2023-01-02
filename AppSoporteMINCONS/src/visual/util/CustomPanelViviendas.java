package visual.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import classes.Cubicacion;
import classes.FichaTecnica;
import classes.Vivienda;

public class CustomPanelViviendas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9046470574927543297L;
	private JLabel lblNombreDelEvento;
	private JLabel lblCosteReparacion;
	private JLabel lblCoste;
	private JLabel lblTipoVivienda;
	private JLabel lblInicio;
	private Vivienda vivienda;
	private Cubicacion cubicacion;
	private String nombreEvento;
	private JLabel lblEvento;
	private JLabel lblEvent;

	/**
	 * Create the panel.
	 */

	public CustomPanelViviendas(FichaTecnica ficha, String nombreEvento) {
		super();

		addMouseListener(getMouseEntered());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(new LineBorder(new Color(0, 0, 0)));
			}
		});

		setFocusable(false);
		setFocusTraversalKeysEnabled(false);
		setEnabled(false);
		setDoubleBuffered(false);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(new Dimension(783, 58));
		setLayout(null);
		this.vivienda = ficha.getVivienda();
		this.cubicacion = ficha.getCubicacion();
		this.nombreEvento = nombreEvento;
		add(getLblDireccion());
		add(getLblCosteReparacion());
		add(getLblCoste());
		add(getLblTipoVivienda());
		add(getLblTipo());
		add(getLblEvento());
		add(getLblEvent());
	}

	private JLabel getLblDireccion() {
		if (lblNombreDelEvento == null) {
			lblNombreDelEvento = new JLabel(vivienda.getDireccion());
			lblNombreDelEvento.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNombreDelEvento.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombreDelEvento.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNombreDelEvento.setBounds(0, 1, 783, 25);
		}
		return lblNombreDelEvento;
	}

	private JLabel getLblCosteReparacion() {
		if (lblCosteReparacion == null) {
			lblCosteReparacion = new JLabel("Costo de Reparación:");
			lblCosteReparacion.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblCosteReparacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCosteReparacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblCosteReparacion.setHorizontalTextPosition(SwingConstants.CENTER);
			lblCosteReparacion.setBounds(514, 37, 135, 15);
		}
		return lblCosteReparacion;
	}

	private JLabel getLblCoste() {
		if (lblCoste == null) {
			lblCoste = new JLabel(cubicacion.calcularPrecioTotalReparacion() + " pesos");
			lblCoste.setHorizontalTextPosition(SwingConstants.CENTER);
			lblCoste.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCoste.setBounds(647, 37, 95, 15);
		}
		return lblCoste;
	}

	private JLabel getLblTipoVivienda() {
		if (lblTipoVivienda == null) {
			lblTipoVivienda = new JLabel("Tipo de Vivienda:");
			lblTipoVivienda.setHorizontalTextPosition(SwingConstants.CENTER);
			lblTipoVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblTipoVivienda.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipoVivienda.setAlignmentX(0.5f);
			lblTipoVivienda.setBounds(10, 37, 109, 15);
		}
		return lblTipoVivienda;
	}

	private JLabel getLblTipo() {
		if (lblInicio == null) {
			String tipo = vivienda.getTipoHabitacional().getName();
			lblInicio = new JLabel(tipo);
			lblInicio.setHorizontalTextPosition(SwingConstants.CENTER);
			lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblInicio.setAlignmentX(0.5f);
			lblInicio.setBounds(118, 37, 135, 15);
		}
		return lblInicio;
	}

	private MouseAdapter getMouseEntered() {
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(new LineBorder(Color.BLUE.brighter(), 3));
			}
		};
	}

	private JLabel getLblEvento() {
		if (lblEvento == null) {
			lblEvento = new JLabel("Evento:");
			lblEvento.setHorizontalTextPosition(SwingConstants.CENTER);
			lblEvento.setHorizontalAlignment(SwingConstants.CENTER);
			lblEvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEvento.setAlignmentX(0.5f);
			lblEvento.setBounds(255, 37, 66, 15);
		}
		return lblEvento;
	}

	private JLabel getLblEvent() {
		if (lblEvent == null) {
			lblEvent = new JLabel(nombreEvento);
			lblEvent.setHorizontalTextPosition(SwingConstants.CENTER);
			lblEvent.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEvent.setAlignmentX(0.5f);
			lblEvent.setBounds(320, 37, 184, 15);
		}
		return lblEvent;
	}
}

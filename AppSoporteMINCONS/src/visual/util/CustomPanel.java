package visual.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import visual.EventosRegistrados;
import visual.FichasTecnicas;
import visual.Frame;
import clases.Evento;
import clases.Sistema;

public class CustomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9046470574927543297L;
	private JLabel lblNombreDelEvento;
	private JLabel lblTipoEvento;
	private JLabel lblTipo;
	private JLabel lblFechaInicio;
	private JLabel lblInicio;
	private JLabel lblFin;
	private JLabel lblFechaFin;
	private Evento evento;
	private JButton btnNewButton;
	private JButton button;
	private int index;
	private Sistema sistema = Sistema.getInstance();
	private EventosRegistrados padre;

	/**
	 * Create the panel.
	 */
	
	public CustomPanel(EventosRegistrados padre, int index, Evento evento) {
		super();
		this.index = index;
		this.padre = padre;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(new Dimension(783, 58));
		setLayout(null);
		this.evento=evento;
		add(getLblNombreDelEvento());
		add(getLblTipoEvento());
		add(getLblTipo());
		add(getLblFechaInicio());
		add(getLblInicio());
		add(getLblFin());
		add(getLblFechaFin());
		add(getBtnNewButton());
		add(getButton());
	}

	private JLabel getLblNombreDelEvento() {
		if (lblNombreDelEvento == null) {
			lblNombreDelEvento = new JLabel(evento.getNombre());
			lblNombreDelEvento.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNombreDelEvento.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombreDelEvento.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNombreDelEvento.setBounds(306, 1, 170, 25);
		}
		return lblNombreDelEvento;
	}
	private JLabel getLblTipoEvento() {
		if (lblTipoEvento == null) {
			lblTipoEvento = new JLabel("Tipo de Evento:");
			lblTipoEvento.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblTipoEvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipoEvento.setHorizontalAlignment(SwingConstants.CENTER);
			lblTipoEvento.setHorizontalTextPosition(SwingConstants.CENTER);
			lblTipoEvento.setBounds(306, 33, 101, 15);
		}
		return lblTipoEvento;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel(evento.getTipoEvento().name());
			lblTipo.setHorizontalTextPosition(SwingConstants.CENTER);
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipo.setBounds(406, 33, 109, 15);
		}
		return lblTipo;
	}
	private JLabel getLblFechaInicio() {
		if (lblFechaInicio == null) {
			lblFechaInicio = new JLabel("Inicio:");
			lblFechaInicio.setHorizontalTextPosition(SwingConstants.CENTER);
			lblFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
			lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaInicio.setAlignmentX(0.5f);
			lblFechaInicio.setBounds(10, 33, 38, 15);
		}
		return lblFechaInicio;
	}
	private JLabel getLblInicio() {
		if (lblInicio == null) {
			GregorianCalendar fecha = evento.getFechaInicio();
			lblInicio = new JLabel(fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH)+1 + "/" + fecha.get(Calendar.YEAR));
			lblInicio.setHorizontalTextPosition(SwingConstants.CENTER);
			lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
			lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblInicio.setAlignmentX(0.5f);
			lblInicio.setBounds(50, 33, 71, 15);
		}
		return lblInicio;
	}
	private JLabel getLblFin() {
		if (lblFin == null) {
			GregorianCalendar fecha = evento.getFechaFin();
			lblFin = new JLabel(fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH)+1 + "/" + fecha.get(Calendar.YEAR));
			lblFin.setHorizontalTextPosition(SwingConstants.CENTER);
			lblFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFin.setAlignmentX(0.5f);
			lblFin.setBounds(664, 33, 71, 15);
		}
		return lblFin;
	}
	private JLabel getLblFechaFin() {
		if (lblFechaFin == null) {
			lblFechaFin = new JLabel("Fin:");
			lblFechaFin.setHorizontalTextPosition(SwingConstants.CENTER);
			lblFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
			lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaFin.setAlignmentX(0.5f);
			lblFechaFin.setBounds(627, 33, 38, 15);
		}
		return lblFechaFin;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sistema.getListaEventos().remove(index);
					padre.addComponents();
				}
			});
			btnNewButton.setIcon(new ImageIcon(CustomPanel.class.getResource("/imagenes/Cancel.png")));
			btnNewButton.setBounds(745, 5, 28, 23);
		}
		return btnNewButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FichasTecnicas fichasTecnicas = new FichasTecnicas();
					fichasTecnicas.actualizarTabla(evento.getListaFichasTecnicas());
					Frame.addRuta(fichasTecnicas, evento);
					Frame.setContentPanes(fichasTecnicas);
				}
			});
			button.setBounds(745, 31, 28, 23);
		}
		return button;
	}
}

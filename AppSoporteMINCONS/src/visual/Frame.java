package visual.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

import clases.Afectacion;
import clases.Construccion;
import clases.Evento;
import clases.Inmueble;
import clases.Sistema;
import util.Ruta;
import visual.afectaciones.JAfectaciones;
import visual.eventos.Eventos;
import visual.fichasTecnicas.FichasTecnicas;
import visual.principal.Principal;
import visual.vivienda.Viviendas;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2638223278346798429L;
	private static Frame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisibles();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Frame() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(891, 491);
		setLocationRelativeTo(null);
	}

	public static void getInstance() {
		if (frame == null) {
			frame = new Frame();
			Ruta.addRuta(new JAfectaciones(new Evento()), new Afectacion());
			//frame.setContentPane((Principal)Ruta.getPosicionActual()[0]);
			//frame.setContentPane((FichasTecnicas) Ruta.getPosicionActual()[0]);
		}
	}

	public static void setContentPanes(Container c) {
		getInstance();
		if (c == null)
			throw new IllegalArgumentException("Container no puede ser null");
		frame.setContentPane(c);
	}

	public static void setVisibles() {
		getInstance();
		frame.setVisible(true);
	}
}

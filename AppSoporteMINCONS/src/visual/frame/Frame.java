package visual.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

import clases.Sistema;
import util.Ruta;
import visual.afectaciones.JAfectaciones;
import visual.eventos.Eventos;
import visual.fichasTecnicas.FichasTecnicas;
import visual.principal.Principal;
import visual.vivienda.Viviendas;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
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
					getInstance().setVisible(true);
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
	
	public static Frame getInstance() {
		if(frame==null) {
			frame=new Frame();
			Ruta.addRuta(new Principal(frame), null);
			frame.setContentPane((Principal)Ruta.getPosicionActual()[0]);
		}
		return frame;
	}
}

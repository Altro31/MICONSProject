package visual;

import java.awt.Container;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import clases.Afectacion;
import clases.Evento;
import clases.Vivienda;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2638223278346798429L;
	private static Frame frame;
	private static ArrayList<Object[]> ruta;

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
		ruta = new ArrayList<Object[]>();
	}

	public static void getInstance() {
		if (frame == null) {
			frame = new Frame();
			Evento evento = new Evento();
			Viviendas viviendas = new Viviendas();
			Afectaciones afectaciones = new Afectaciones();
//			Frame.addRuta(new Object[] {viviendas, afectaciones}, new Object[] {new Vivienda(), new Afectacion()});
			Frame.addRuta(new Principal(), null);
			Frame.addRuta(new Eventos(), evento);
			Frame.addRuta(new FichasTecnicas(), evento);
			Frame.addRuta(new Object[] {viviendas, afectaciones}, new Object[] {new Vivienda(), new Afectacion()});
			frame.setContentPane((Container) ((Object[])Frame.getPosicionActual()[0])[1]);
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

	public static void addRuta(Object visual, Object data) throws IllegalArgumentException {
		getInstance();
		if (visual == null) {
			throw new IllegalArgumentException("Visual no puede ser null");
		}
		ruta.add(new Object[] { visual, data });
	}

	public static Object[] getPosicionActual() {
		getInstance();
		return ruta.get(ruta.size() - 1);
	}

	public static Object[] get(int pos) {
		return ruta.get(pos);
	}

	public static void removerRuta(Object o) throws IllegalArgumentException {
		getInstance();
		if (o == null) {
			throw new IllegalArgumentException("El objeto no puede ser null");
		}
		boolean borrar = false;
		int count = ruta.size();

		int i = 0;
		while (i < count) {
			Object[] objects = ruta.get(i);

			if (objects[0].equals(o) || (objects[1] != null && objects[1].equals(o))) {
				borrar = true;
			}
			if (borrar) {
				ruta.remove(objects);
				count--;
			} else {
				i++;
			}
		}
	}
}

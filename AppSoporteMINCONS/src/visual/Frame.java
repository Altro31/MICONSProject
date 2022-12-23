package visual;

import java.awt.Container;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2638223278346798429L;
	private static final String[] PRINCIPALS = new String[] { "Principal",
			"FichasTecnicas", "ViviendasRegistradas", "EventosRegistrados" };

	private static Frame frame;
	private static ArrayList<Object[]> ruta = new ArrayList<Object[]>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getInstance();
					frame.setVisible(true);
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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(891, 491);
		setLocationRelativeTo(null);
	}

	public static Frame getInstance() {
		if (frame == null) {
			frame = new Frame();
		}
		return frame;
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

	public static void addRuta(Object visual, Object data)
			throws IllegalArgumentException {
		getInstance();
		if (visual == null) {
			throw new IllegalArgumentException("Visual no puede ser null");
		}
		ruta.add(new Object[] { visual, data });
	}

	public static Object[] getPosicionActual() {
		getInstance();
		Object[] o = null;
		if (!ruta.isEmpty()) {
			o = ruta.get(ruta.size() - 1);
		}
		return o;
	}

	public static Object[] get(int pos) {
		getInstance();
		return ruta.get(pos);
	}

	public static void setOnPrincipal() {
		boolean check = true;
		do {
			anteriorPrincipal(1);
			if (isPrincipal(getPosicionActual()[0])) {
				check = false;
			}
		} while (check);
		setContentPanes((Container) getPosicionActual()[0]);
	}

	private static boolean isPrincipal(Object o) {
		boolean check = false;
		for (String clase : PRINCIPALS) {
			if (o.getClass().getSimpleName().equals(clase)) {
				check = true;
			}
			;
		}
		return check;
	}

	public static void anteriorPrincipal(int i) throws IllegalArgumentException {
		getInstance();
		if (i <= 0) {
			throw new IllegalArgumentException("i debe ser mayor que 0");
		}
		boolean borrar = true;
		int count = ruta.size();
		int index = 0;
		if (isPrincipal((ruta.get(count - 1)[0]))) {
			i++;
		}
		while (count > index && borrar) {

			Object[] objects = ruta.get(count - 1);

			if (isPrincipal(objects[0])) {
				i--;
			}
			if (i == 0) {
				borrar = false;
			}
			if (borrar) {
				ruta.remove(objects);
				count--;
			}
		}
		Frame.setContentPanes((Container)getPosicionActual()[0]);
	}

	public static void removerActual() {

		ruta.remove(getPosicionActual());
		Frame.setContentPanes((Container) Frame.getPosicionActual()[0]);
	}
}

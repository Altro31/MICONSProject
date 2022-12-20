package visual;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2638223278346798429L;
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
		ruta.add(new Object[] { new Principal(), null });
	}

	public static Frame getInstance() {
		if (frame == null) {
			frame = new Frame();

			frame.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosed(WindowEvent e) {
					System.out.println("a");
				}
			});

			setContentPanes((Container)Frame.getPosicionActual()[0]);
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

	public static void addRuta(Object visual, Object data) throws IllegalArgumentException {
		getInstance();
		if (visual == null) {
			throw new IllegalArgumentException("Visual no puede ser null");
		}
		if (!(visual instanceof Principal)) {
			ruta.add(new Object[] { visual, data });
		}
	}

	public static Object[] getPosicionActual() {
		getInstance();
		return ruta.get(ruta.size() - 1);
	}

	public static Object[] get(int pos) {
		getInstance();
		return ruta.get(pos);
	}

	public static Principal getPrincipal() {
		return (Principal) get(0)[1];
	}

	public static void setOnPrincipal() {
		removerRuta(get(1)[0]);
		setContentPanes(getPrincipal());
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

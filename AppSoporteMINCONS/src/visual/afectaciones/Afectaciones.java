package visual.afectaciones;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import clases.Construccion;
import clases.FichaTecnica;
import clases.Inmueble;
import clases.Material;
import clases.Pared;
import clases.Sistema;
import clases.Techo;
import visual.util.CustomScrollPane;

public class Afectaciones extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5702801126104620575L;

	private JPanel contentPane;
	private JLabel lblName;
	private CustomScrollPane panelFields;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private static ArrayList<Pared> listaParedes;
	private static ArrayList<Techo> listaTechos;
	private static ArrayList<Inmueble> listaInmuebles;
	private static ArrayList<Material> listaMateriales;
	private Sistema sistema = Sistema.getSistema();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<Material> listaMateriales2 = new ArrayList<Material>();
				listaParedes = new ArrayList<Pared>();
				listaTechos = new ArrayList<Techo>();
				listaInmuebles = new ArrayList<Inmueble>();
				
				try {
					Afectaciones frame = new Afectaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Afectaciones frame = new Afectaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param listaParedes 
	 * @param listaTechos 
	 * @param listaInmuebles 
	 */
	public Afectaciones() {

		this.listaParedes = listaParedes;
		this.listaTechos = listaTechos;
		this.listaInmuebles = listaInmuebles;
		Afectaciones.listaMateriales = listaMateriales;
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblName());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnAceptar());
		contentPane.add(getBtnCancelar());
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Eventos de la Viviendas");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblName.setHorizontalTextPosition(SwingConstants.CENTER);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
			lblName.setBounds(10, 11, 618, 36);
		}
		return lblName;
	}

	private CustomScrollPane getPanelFields() {
		if (panelFields == null) {
			panelFields = new PanelFields(this, listaParedes, listaTechos, listaInmuebles, listaMateriales);
			panelFields.setPreferredSize(new Dimension(0, 0));
		}
		return panelFields;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new CustomScrollPane();
			scrollPane.setBounds(10, 58, 618, 402);
			scrollPane.setViewportView(getPanelFields());
		}
		return scrollPane;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(376, 466, 89, 23);
		}
		return btnAceptar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(475, 466, 89, 23);
		}
		return btnCancelar;
	}
	
	public static Material buscarMateriar(String name) {
		Material material = null;
		
		for (Material mat : listaMateriales) {
			if (mat.getNombre().equalsIgnoreCase(name)) {
				material=mat;
			}
		}
		
		return material;
	}
}

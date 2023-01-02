package visual.settings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelAcercaDe extends JPanel {

	private static final long serialVersionUID = -2425517512464505091L;
	private JLabel lblLogo;
	private JPanel panelInformacion;
	private JTextPane txtInformacion;
	private JLabel lblnformacion;
	private JPanel panelDescripcion;
	private JLabel lblAhorro;
	private JTextPane txtpnLosArchivosY;
	private JLabel lbSeguridad;
	private JTextPane txtpnSoloSePodr;
	private JLabel lblVentajas;
	private JTextPane txtpnAlSerUna;
	private JLabel lblMejoraProduct;
	private JPanel panelLogo;

	/**
	 * Create the panel.
	 */
	public PanelAcercaDe() {
		setSize(new Dimension(671, 445));
		setPreferredSize(new Dimension(670, 550));
		setLayout(null);
		add(getPanelInformacion());
		add(getPanelDescripcion());
		add(getPanelLogo());
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("MICONS");
			lblLogo.setVerticalAlignment(SwingConstants.TOP);
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setForeground(new Color(255, 255, 255));
			lblLogo.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 60));
			lblLogo.setBackground(Color.WHITE);
		}
		return lblLogo;
	}

	private JPanel getPanelInformacion() {
		if (panelInformacion == null) {
			panelInformacion = new JPanel();
			panelInformacion.setBorder(new LineBorder(SystemColor.activeCaption));
			panelInformacion.setBackground(new Color(78, 77, 106));
			panelInformacion.setBounds(10, 71, 651, 76);
			GroupLayout glPanelInformacion = new GroupLayout(panelInformacion);
			glPanelInformacion.setHorizontalGroup(glPanelInformacion.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInformacion.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(glPanelInformacion.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING,
											glPanelInformacion.createSequentialGroup()
													.addComponent(getLblnformacion(), GroupLayout.PREFERRED_SIZE, 97,
															GroupLayout.PREFERRED_SIZE)
													.addGap(275))
									.addGroup(Alignment.TRAILING,
											glPanelInformacion
													.createSequentialGroup().addComponent(getTxtInformacion(),
															GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
													.addGap(62)))));
			glPanelInformacion.setVerticalGroup(glPanelInformacion.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelInformacion.createSequentialGroup()
							.addComponent(getLblnformacion(), GroupLayout.PREFERRED_SIZE, 24,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getTxtInformacion(), GroupLayout.PREFERRED_SIZE, 40,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap()));
			panelInformacion.setLayout(glPanelInformacion);
		}
		return panelInformacion;
	}

	private JTextPane getTxtInformacion() {
		if (txtInformacion == null) {
			txtInformacion = new JTextPane();
			txtInformacion.setText(
					"Aplicación orientada al Ministerio de Construcción con el fin de digitalizar la información sobre las afectaciones provocadas al fondo habitacional por  eventos meteorológicos.");
			txtInformacion.setForeground(Color.WHITE);
			txtInformacion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			txtInformacion.setEditable(false);
			txtInformacion.setBackground(new Color(78, 77, 106));
		}
		return txtInformacion;
	}

	private JLabel getLblnformacion() {
		if (lblnformacion == null) {
			lblnformacion = new JLabel("Información");
			lblnformacion.setForeground(new Color(102, 204, 255));
			lblnformacion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		}
		return lblnformacion;
	}

	private JPanel getPanelDescripcion() {
		if (panelDescripcion == null) {
			panelDescripcion = new JPanel();
			panelDescripcion.setBorder(new LineBorder(SystemColor.activeCaption));
			panelDescripcion.setBackground(new Color(78, 77, 106));
			panelDescripcion.setBounds(10, 154, 651, 381);
			GroupLayout glPanelDescripcion = new GroupLayout(panelDescripcion);
			glPanelDescripcion.setHorizontalGroup(glPanelDescripcion.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelDescripcion.createSequentialGroup().addGroup(glPanelDescripcion
							.createParallelGroup(Alignment.LEADING)
							.addGroup(glPanelDescripcion.createSequentialGroup().addGap(24).addComponent(
									getLblVentajas(), GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE))
							.addGroup(glPanelDescripcion.createSequentialGroup().addGap(34)
									.addGroup(glPanelDescripcion.createParallelGroup(Alignment.LEADING)
											.addComponent(getLblAhorro(), GroupLayout.PREFERRED_SIZE, 188,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getLbSeguridad(), GroupLayout.PREFERRED_SIZE, 173,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getLblMejoraProduct(), GroupLayout.PREFERRED_SIZE, 269,
													GroupLayout.PREFERRED_SIZE)))
							.addGroup(glPanelDescripcion.createSequentialGroup().addGap(57)
									.addGroup(glPanelDescripcion.createParallelGroup(Alignment.LEADING)
											.addComponent(getTxtpnAlSerUna(), GroupLayout.PREFERRED_SIZE, 534,
													GroupLayout.PREFERRED_SIZE)
											.addGroup(glPanelDescripcion.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(getTxtpnSoloSePodr(), Alignment.LEADING, 0, 0,
															Short.MAX_VALUE)
													.addComponent(getTxtpnLosArchivosY(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)))))
							.addContainerGap(23, Short.MAX_VALUE)));
			glPanelDescripcion.setVerticalGroup(glPanelDescripcion.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelDescripcion.createSequentialGroup().addContainerGap()
							.addComponent(getLblVentajas(), GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(getLblAhorro(), GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(getTxtpnLosArchivosY(), GroupLayout.PREFERRED_SIZE, 61,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getLbSeguridad(), GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getTxtpnSoloSePodr(), GroupLayout.PREFERRED_SIZE, 47,
									GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(getLblMejoraProduct(), GroupLayout.PREFERRED_SIZE, 29,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getTxtpnAlSerUna(),
									GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(26, Short.MAX_VALUE)));
			glPanelDescripcion.linkSize(SwingConstants.HORIZONTAL, getTxtpnAlSerUna(), getTxtpnSoloSePodr(),
					getTxtpnLosArchivosY());
			panelDescripcion.setLayout(glPanelDescripcion);
		}
		return panelDescripcion;
	}

	private JLabel getLblAhorro() {
		if (lblAhorro == null) {
			lblAhorro = new JLabel("Ahorro de espacio físico:");
			lblAhorro.setForeground(Color.WHITE);
			lblAhorro.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		}
		return lblAhorro;
	}

	private JTextPane getTxtpnLosArchivosY() {
		if (txtpnLosArchivosY == null) {
			txtpnLosArchivosY = new JTextPane();
			txtpnLosArchivosY.setText(
					"Los archivos y documentos impresos implican una necesidad de almacenamiento físico. Gracias a la digitalización, este espacio puede destinarse a otro fin más necesario, como por ejemplo, la creación de una zona de trabajo más cómoda.");
			txtpnLosArchivosY.setForeground(Color.WHITE);
			txtpnLosArchivosY.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
			txtpnLosArchivosY.setEditable(false);
			txtpnLosArchivosY.setBackground(new Color(78, 77, 106));
		}
		return txtpnLosArchivosY;
	}

	private JLabel getLbSeguridad() {
		if (lbSeguridad == null) {
			lbSeguridad = new JLabel("Más seguridad:");
			lbSeguridad.setForeground(Color.WHITE);
			lbSeguridad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		}
		return lbSeguridad;
	}

	private JTextPane getTxtpnSoloSePodr() {
		if (txtpnSoloSePodr == null) {
			txtpnSoloSePodr = new JTextPane();
			txtpnSoloSePodr.setText(
					"Solo se podrá acceder a la información de la aplicación mediante el uso de una clave, lo cual permite proteger los datos almacenados al restringir el acceso solamente al personal autorizado.\r\n");
			txtpnSoloSePodr.setForeground(Color.WHITE);
			txtpnSoloSePodr.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
			txtpnSoloSePodr.setEditable(false);
			txtpnSoloSePodr.setBackground(new Color(78, 77, 106));
		}
		return txtpnSoloSePodr;
	}

	private JLabel getLblVentajas() {
		if (lblVentajas == null) {
			lblVentajas = new JLabel("¿Qué ventajas ofrece esta aplicación?");
			lblVentajas.setForeground(new Color(102, 204, 255));
			lblVentajas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		}
		return lblVentajas;
	}

	private JTextPane getTxtpnAlSerUna() {
		if (txtpnAlSerUna == null) {
			txtpnAlSerUna = new JTextPane();
			txtpnAlSerUna.setText(
					"Al ser una aplicación intuitiva, permite mejorar el flujo de trabajo, el personal puede realizar con mayor destreza tareas en un período de tiempo más corto. Cuando mejora la calidad de vida en el trabajo, incluso el bienestar emocional aumenta.");
			txtpnAlSerUna.setForeground(Color.WHITE);
			txtpnAlSerUna.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
			txtpnAlSerUna.setBackground(new Color(78, 77, 106));
		}
		return txtpnAlSerUna;
	}

	private JLabel getLblMejoraProduct() {
		if (lblMejoraProduct == null) {
			lblMejoraProduct = new JLabel("Mejora la productividad\r:\n");
			lblMejoraProduct.setForeground(Color.WHITE);
			lblMejoraProduct.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		}
		return lblMejoraProduct;
	}

	private JPanel getPanelLogo() {
		if (panelLogo == null) {
			panelLogo = new JPanel();
			panelLogo.setBorder(new LineBorder(SystemColor.activeCaption));
			panelLogo.setBackground(new Color(78, 77, 106));
			panelLogo.setBounds(10, 11, 651, 51);
			GroupLayout glPanelLogo = new GroupLayout(panelLogo);
			glPanelLogo.setHorizontalGroup(glPanelLogo.createParallelGroup(Alignment.LEADING).addComponent(getLblLogo(),
					GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE));
			glPanelLogo.setVerticalGroup(glPanelLogo.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelLogo.createSequentialGroup()
							.addComponent(getLblLogo(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			panelLogo.setLayout(glPanelLogo);
		}
		return panelLogo;
	}
}

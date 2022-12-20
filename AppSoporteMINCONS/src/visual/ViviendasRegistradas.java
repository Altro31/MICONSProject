package visual;

import visual.util.PrincipalPanel;
import java.awt.event.ActionListener;

import util.Manager;

import java.awt.event.ActionEvent;

public class ViviendasRegistradas extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4471668417093221629L;

	/**
	 * Create the panel.
	 */
	
	public ViviendasRegistradas() {
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager.guardarDatos();
				System.exit(0);
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.removerRuta(Frame.getPosicionActual()[0]);
				Frame.setContentPanes((Principal) Frame.getPosicionActual()[0]);
			}
		});
		
	}

}

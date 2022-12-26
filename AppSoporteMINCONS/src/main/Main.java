package main;

import java.awt.Container;

import classes.Sistema;
import visual.Frame;
import visual.Principal;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Sistema sistema = Sistema.getInstance();
		Frame.addRuta(new Principal(), null);
		Frame.setContentPanes((Container)Frame.getPosicionActual()[0]);
		Frame.setVisibles();
		
	}
}

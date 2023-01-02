package main;

import java.awt.Container;

import settings.Manager;
import visual.Frame;
import visual.Principal;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Manager.cargarDatos();

//		Frame.addRuta(new Settings(), null);

		Frame.addRuta(new Principal(), null);
//		Frame.addRuta(new Eventos(), null);
//		Frame.addRuta(new FichasTecnicas(), new Eventos());
//		Viviendas viviendas = new Viviendas();
//		Afectaciones afectaciones = new Afectaciones();
//		AsignarMateriales asignarMateriales = new AsignarMateriales();
//		Frame.addRuta(new Object[] { viviendas, afectaciones, asignarMateriales },
//				new FichaTecnica());
//		Frame.setContentPanes((Container)((Object[])Frame.getPosicionActual()[0])[1]);
		Frame.setContentPanes((Container) Frame.getPosicionActual()[0]);
		Frame.setVisibles();

	}
}

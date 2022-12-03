package main;

import clases.Construccion;
import clases.Sistema;
import visual.login.Login;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Sistema sistema = Sistema.getSistema();
		
		sistema.addMaterial(new Construccion("Cemento"));
		sistema.addMaterial(new Construccion("Gravilla"));
		sistema.addMaterial(new Construccion("Arena"));
		sistema.addMaterial(new Construccion("Tejas"));
		sistema.addMaterial(new Construccion("Tejas"));
		sistema.addMaterial(new Construccion("a"));
		sistema.addMaterial(new Construccion("b"));
		sistema.addMaterial(new Construccion("c"));
		
		Login.run();
	}
}

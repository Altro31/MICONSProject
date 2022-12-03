package main;

import clases.Construccion;
import clases.Sistema;
import visual.login.Login;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Sistema.addMaterial(new Construccion("Cemento"));
		Sistema.addMaterial(new Construccion("Gravilla"));
		Sistema.addMaterial(new Construccion("Arena"));
		Sistema.addMaterial(new Construccion("Tejas"));
		
		
		
		Login.run();
	}
}

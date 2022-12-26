package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import classes.Sistema;

public final class Manager {

	private static final String SISTEMA = "Sistema.altro";

	private static FileOutputStream ficheroSalida = null;
	private static ObjectOutputStream salida = null;
	private static FileInputStream ficheroEntrada = null;
	private static ObjectInputStream entrada = null;

	private Manager() {
	}

	public static Sistema cargarDatos() {
		Sistema sistema = null;
		try {
			ficheroEntrada = new FileInputStream(SISTEMA);
			entrada = new ObjectInputStream(ficheroEntrada);
			sistema = (Sistema) entrada.readObject();
		} catch (IOException | ClassNotFoundException e) {

		} finally {
			if (ficheroEntrada != null) {
				try {
					ficheroEntrada.close();
					ficheroEntrada = null;
					entrada = null;
				} catch (IOException e) {
				}
			}
		}
		return sistema;
	}

	public static void guardarDatos() {

		Sistema sistema = Sistema.getInstance();
		try {
			ficheroSalida = new FileOutputStream(SISTEMA);
			salida = new ObjectOutputStream(ficheroSalida);
			salida.writeObject(sistema);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ficheroSalida.close();
				ficheroSalida = null;
				salida = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import clases.Evento;
import clases.Material;
import clases.Sistema;

@SuppressWarnings("unchecked")
public final class Manager {

	private static final String EVENTOS = "Eventos.txt";
	private static final String MATERIALES = "Materiales.txt";
	private static FileOutputStream ficheroSalida = null;
	private static ObjectOutputStream salida = null;
	private static FileInputStream ficheroEntrada = null;
	private static ObjectInputStream entrada = null;

	private Manager() {
	}

	public static void cargarDatos() {

		ArrayList<Evento> listaEventos = new ArrayList<>();
		ArrayList<Material> listaMateriales = new ArrayList<>();;

		for (String fileName : new String[] { EVENTOS, MATERIALES }) {
//			File file = new File(fileName.equals(EVENTOS)? EVENTOS : MATERIALES);
			try {
				ficheroEntrada = new FileInputStream(fileName);
				entrada = new ObjectInputStream(ficheroEntrada);
				if (fileName.equals(EVENTOS))
					listaEventos = (ArrayList<Evento>) entrada.readObject();
				else {
					listaMateriales = (ArrayList<Material>) entrada.readObject();
				}
			} catch (IOException | ClassNotFoundException e) {
				
			} finally {
				if (ficheroEntrada!=null) {
					try {
						ficheroEntrada.close();
						ficheroEntrada = null;
						entrada = null;
					} catch (IOException e) {
					}
				}
			}
		}
		
		for (Material material : listaMateriales) {
			Sistema.addMaterial(material);
		}
		for (Evento evento : listaEventos) {
			Sistema.addEventos(evento);
		}
	}

	public static void guardarDatos() {
		ArrayList<Evento> listaEventos = Sistema.getListaEventos();
		ArrayList<Material> listaMateriales = Sistema.getListaMateriales();

		for (String file : new String[] { EVENTOS, MATERIALES }) {
			try {
				ficheroSalida = new FileOutputStream(file);
				salida = new ObjectOutputStream(ficheroSalida);
				if (file.equals(EVENTOS))
					salida.writeObject(listaEventos);
				else {
					salida.writeObject(listaMateriales);
				}
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
}

package settings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import classes.Evento;
import classes.Material;
import classes.Sistema;

public final class Manager {

	private static final String SISTEMA = "Sistema.jar";
	private static final String ALTERNATE_SISTEMA = "/settings/Sistema.jar";
	private static final String SETTING = "Setting.jar";
	private static final String ALTERNATE_SETTING = "/settings/Setting.jar";

	private Manager() {
	}

	public static void cargarDatos() {
		Object object = null;
		String[][] sys = new String[][] { { SISTEMA, ALTERNATE_SISTEMA }, { SETTING, ALTERNATE_SETTING } };

		for (String[] str : sys) {

			try (FileInputStream fichero = new FileInputStream(str[0]);
					ObjectInputStream flujo = new ObjectInputStream(fichero)) {

				object = flujo.readObject();

			} catch (IOException | ClassNotFoundException e) {

				String path = null;
				Path tmpFile = null;
				try {
					tmpFile = extractPayload(str[1], "temp", ".jar");
					path = tmpFile.toAbsolutePath().toString();
				} catch (IOException e1) {
					path = "";
				}

				try (FileInputStream fichero = new FileInputStream(path);
						ObjectInputStream flujo = new ObjectInputStream(fichero)) {

					object = flujo.readObject();
				} catch (IOException | ClassNotFoundException e1) {
					// Sólo para la captura de la excepción, pero nunca llegará a éste punto
				} finally {
					try {
						Files.delete(tmpFile);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			if (object instanceof Sistema) {
				Sistema principal = Sistema.getInstance();
				for (Evento evento : ((Sistema) object).getListaEventos()) {
					principal.addEvento(evento);
				}
				for (Material material : ((Sistema) object).getListaMateriales()) {
					principal.addMaterial(material);
				}
			} else {
				Limites.update((Limites) object);
			}

		}

	}

	public static void guardarDatos() {
		String[] sys = new String[] { SISTEMA, SETTING };
		for (String objects : sys) {
			try (FileOutputStream fichero = new FileOutputStream(objects);
					ObjectOutputStream flujo = new ObjectOutputStream(fichero);) {

				flujo.writeObject(objects.equals(SISTEMA) ? Sistema.getInstance() : Limites.getInstance());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static Path extractPayload(String resourcepath, String filename, String extension) throws IOException {
		InputStream resourceStream = Manager.class.getResourceAsStream(resourcepath);
		Path tempFile = Files.createTempFile(filename, extension);
		Files.copy(resourceStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
		return tempFile;
	}
}

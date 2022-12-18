package interfaces;

import java.util.ArrayList;


/**
 * Expecifica que un TableModel debe contener el Método actualizar
 * @author Altro
 *
 */
public interface Actualizable {
	
	public abstract <T extends Object> void actualizar(ArrayList<T> lista);
	
}
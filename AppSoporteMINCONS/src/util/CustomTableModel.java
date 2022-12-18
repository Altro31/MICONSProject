package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public abstract class CustomTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6941451106780645342L;
	
	public CustomTableModel(Object[][] objects, String[] strings) {
		super(objects, strings);
	}

	public abstract <T extends Object> void actualizar(ArrayList<T> lista);

}

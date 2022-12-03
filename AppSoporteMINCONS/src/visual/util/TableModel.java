package visual.util;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4800519931256290303L;
	
	public TableModel(String[] columnNames) {
		super(new Object[0][0], columnNames);
		
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}

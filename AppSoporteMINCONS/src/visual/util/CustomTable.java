package visual.util;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.Auxiliary;

public class CustomTable extends JScrollPane {

	private static final long serialVersionUID = -4940171855655079445L;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnBorrar;
	private JButton btnEditar;
	private int[] columnCenter;

	public CustomTable() {
		super();
		tableModel = new DefaultTableModel();

		btnBorrar = new JButton();
		btnEditar = new JButton();
		columnCenter = new int[] {};
		setViewportView(getTable());
	}

	public CustomTable(DefaultTableModel tableModel, JButton btnBorrar, JButton btnEditar, int[] columnCenter) {
		super();
		this.tableModel = tableModel;
		this.btnBorrar = btnBorrar;
		this.btnEditar = btnEditar;
		this.columnCenter = columnCenter;
		setViewportView(getTable());
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable(tableModel);
			Auxiliary.centrarColumnas(table, columnCenter);
			Auxiliary.quitarReordenamientoTabla(table);
			Auxiliary.activarBotonBorrar(btnBorrar, table);
			Auxiliary.activarBotonEditar(btnEditar, table);
		}
		return table;
	}
}

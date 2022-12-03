package visual.util;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CustomTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4940171855655079445L;
	private TableModel tableModel;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAgnadir;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JCheckBox chckbxNewCheckBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.getContentPane().add(new CustomTable(null));
					frame.setLocationRelativeTo(null);
					frame.setSize(700, 500);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CustomTable(String[] columnNames) {
		
		setLayout(null);
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Paredes Afectadas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(getScrollPane());
		add(getBtnAgnadir());
		add(getBtnEditar());
		add(getBtnBorrar());
	}
	
	
	public void actualizar(ArrayList<Object> lista) {
		//TODO
	}
	
	public void instertar(ArrayList<Object> lista, Object o, String[] data) {
		lista.add(o);
		tableModel.addRow(data);
		actualizar(lista);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 21, 452, 192);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new TableModel(null));
		}
		return table;
	}
	public JButton getBtnAgnadir() {
		if (btnAgnadir == null) {
			btnAgnadir = new JButton("Añadir");
			btnAgnadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableModel.addRow(new String[] {
							"A",
							"B",
							"C"
					});
				}
			});
			btnAgnadir.setBounds(486, 35, 80, 23);
		}
		return btnAgnadir;
	}
	public JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBounds(486, 69, 80, 23);
		}
		return btnEditar;
	}
	public JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("Borrar");
			btnBorrar.setBounds(486, 103, 80, 23);
		}
		return btnBorrar;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("");
		}
		return chckbxNewCheckBox;
	}
	/**
	 * @wbp.nonvisual location=606,99
	 */
	private TableModel getTableModel() {
		if (tableModel == null) {
			tableModel = new TableModel(new String[] {
					"","#", "A", "B"
				});
		}
		return tableModel;
	}
}

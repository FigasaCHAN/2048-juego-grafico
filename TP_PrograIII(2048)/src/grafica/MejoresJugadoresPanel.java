package grafica;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.ComponentOrientation;

public class MejoresJugadoresPanel extends JPanel {
	private final JTable table = new JTable();

	/**
	 * Create the panel.
	 */
	public MejoresJugadoresPanel() {
		setLayout(null);
		Object[] columnas= {"Top", "Nombre", "Puntaje",};
		Object[] filas= {"Top","Nombre","Puntaje"};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columnas);
		
		table.setModel(model);
		table.setRowHeight(30);

		model.addRow(filas);
		
		table.setBounds(38, 89, 353, 120);
		
		add(table);

	}
}

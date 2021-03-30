package grafica;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class TableroGrafico extends JPanel {

	/**
	 * Create the panel.
	 */
	public TableroGrafico() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLayout(new GridLayout(4, 4, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		add(lblNewLabel_7);

	}

}

package grafica;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuGrafico extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuGrafico() {
		setBackground(new Color(169, 169, 169));
		setBounds(new Rectangle(0, 0, 784, 526));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(218, 165, 32)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(222, 184, 135));
		lblNewLabel.setBounds(140, 84, 87, 76);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_1.setBackground(new Color(233, 150, 122));
		
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(260, 84, 87, 76);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("4");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(50, 205, 50));
		lblNewLabel_2.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(380, 84, 87, 76);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("8");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 191, 255));
		lblNewLabel_3.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_3.setBounds(490, 84, 87, 76);
		add(lblNewLabel_3);

	}
}

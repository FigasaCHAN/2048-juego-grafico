package grafica;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MenuGrafico extends JPanel {
	private JTextField txtFieldNombre;

	/**
	 * Create the panel.
	 */
	public MenuGrafico() {
		setBackground(new Color(169, 169, 169));
		setBounds(new Rectangle(0, 0, 784, 526));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(218, 165, 32)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(222, 184, 135));
		lblNewLabel.setBounds(140, 84, 87, 76);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_1.setBackground(new Color(233, 150, 122));
		
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(260, 84, 87, 76);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("4");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(50, 205, 50));
		lblNewLabel_2.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(380, 84, 87, 76);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("8");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 191, 255));
		lblNewLabel_3.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_3.setBounds(490, 84, 87, 76);
		add(lblNewLabel_3);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setBackground(new Color(255, 140, 0));
		txtFieldNombre.setForeground(new Color(255, 255, 255));
		txtFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFieldNombre.setName("");
		txtFieldNombre.setBounds(260, 268, 221, 39);
		add(txtFieldNombre);
		txtFieldNombre.setColumns(10);
		
		JLabel lbl_IngresarNombre = new JLabel("Ingresa tu nombre:");
		lbl_IngresarNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_IngresarNombre.setBorder(new LineBorder(new Color(222, 184, 135)));
		lbl_IngresarNombre.setBounds(291, 239, 165, 26);
		add(lbl_IngresarNombre);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBorderPainted(false);
		btnJugar.setBorder(new LineBorder(new Color(222, 184, 135)));
		btnJugar.setBackground(new Color(255, 140, 0));
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnJugar.setBounds(315, 332, 122, 54);
		add(btnJugar);

	}
}

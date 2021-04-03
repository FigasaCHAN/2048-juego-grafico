package grafica;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import logica.Menu;
import multimedia.Fuente;

public class MenuPanel extends JPanel {
	private JTextField txtFieldNombre;
	public JButton  btnJugar;
	private Font pixelNum,pixelNombreUsuario,pixelCarteles;

	public MenuPanel() {
		//Fuente
		Fuente fuente= new Fuente();
		this.pixelNum= fuente.generarFuente("Pixel.ttf", 50);
		this.pixelNombreUsuario= fuente.generarFuente("Pixel.ttf", 20);
		this.pixelCarteles= fuente.generarFuente("Pixel.ttf", 16);
		setLayout(null);
		
		//Num 2 titulo
		JLabel lblNewLabel = new JLabel("2");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(this.pixelNum);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(218, 165, 32)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(222, 184, 135));
		lblNewLabel.setBounds(175, 7, 39, 93);
		add(lblNewLabel);
		
		//Num 0 titulo
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(this.pixelNum);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_1.setBackground(new Color(233, 150, 122));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(224, 7, 39, 93);
		add(lblNewLabel_1);
		
		//Num 4 titulo
		JLabel lblNewLabel_2 = new JLabel("4");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(this.pixelNum);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(50, 205, 50));
		lblNewLabel_2.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(285, 7, 39, 93);
		add(lblNewLabel_2);
		
		//Num 8 titulo
		JLabel lblNewLabel_3 = new JLabel("8");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(this.pixelNum);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 191, 255));
		lblNewLabel_3.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_3.setBounds(352, 7, 39, 93);
		add(lblNewLabel_3);
		
		//Campo de Texto
		txtFieldNombre = new JTextField();
		txtFieldNombre.setBackground(new Color(255, 140, 0));
		txtFieldNombre.setForeground(new Color(255, 255, 255));
		txtFieldNombre.setFont(this.pixelNombreUsuario);
		txtFieldNombre.setName("");
		txtFieldNombre.setBounds(175, 233, 222, 20);
		txtFieldNombre.setColumns(10);
		add(txtFieldNombre);
		
		//Cartel de ingresarNombre
		JLabel lbl_IngresarNombre = new JLabel("Ingresa tu nombre: ");
		lbl_IngresarNombre.setFont(this.pixelCarteles);
		lbl_IngresarNombre.setBorder(new LineBorder(new Color(222, 184, 135)));
		lbl_IngresarNombre.setBounds(175, 206, 222, 16);
		add(lbl_IngresarNombre);
		
		//Boton jugar
		btnJugar = new JButton("Jugar");
		btnJugar.setBorderPainted(false);
		btnJugar.setBorder(new LineBorder(new Color(222, 184, 135)));
		btnJugar.setBackground(new Color(255, 140, 0));
		btnJugar.setFont(this.pixelCarteles);
		btnJugar.setBounds(189, 295, 188, 72);
		add(btnJugar);
	}

	
	private boolean esNombreValido() {
		return Menu.validarNombreJugador(this.txtFieldNombre.getText());
	}
	
	


}

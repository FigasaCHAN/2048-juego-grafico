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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MenuPanel extends JPanel {
	public JTextField txtFieldNombre;
	public JButton  btnJugar,btn4x4,btn5x5,btn6x6,btnMejoresJugadores;
	private Font pixelNum,pixelNombreUsuario,pixelCarteles,pixelMensajeError;
	private JLabel lblErrorNombre,cartelModoDeJuegoSeleccionado;
	private int modoDeJuego=4; //el modo por defaul es 4x4
	private JLabel imagenFondo;

	public MenuPanel() {
		//Fuente
		Fuente fuente= new Fuente();
		this.pixelNum= fuente.generarFuente("Pixel.ttf", 50);
		this.pixelNombreUsuario= fuente.generarFuente("Pixel.ttf", 20);
		this.pixelCarteles= fuente.generarFuente("Pixel.ttf", 16);
		this.pixelMensajeError= fuente.generarFuente("Pixel.ttf", 15);
		setLayout(null);
		
		//Num 2 titulo
		JLabel lblNewLabel = new JLabel("2");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(this.pixelNum);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(218, 165, 32)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(102, 51, 153));
		lblNewLabel.setBounds(192, 129, 88, 93);
		add(lblNewLabel);
		
		//Num 0 titulo
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(this.pixelNum);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_1.setBackground(new Color(102, 51, 153));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(290, 129, 88, 93);
		add(lblNewLabel_1);
		
		//Num 4 titulo
		JLabel lblNewLabel_2 = new JLabel("4");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(this.pixelNum);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(new Color(102, 51, 153));
		lblNewLabel_2.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(388, 129, 88, 93);
		add(lblNewLabel_2);
		
		//Num 8 titulo
		JLabel lblNewLabel_3 = new JLabel("8");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(this.pixelNum);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(102, 51, 153));
		lblNewLabel_3.setBorder(new LineBorder(new Color(222, 184, 135)));
		lblNewLabel_3.setBounds(486, 129, 88, 93);
		add(lblNewLabel_3);
		
		//Campo de Texto
		txtFieldNombre = new JTextField();
		
		txtFieldNombre.addFocusListener(new FocusAdapter() {//si estoy en cima del textField
			@Override
			public void focusGained(FocusEvent e) {
				txtFieldNombre.setBackground(new Color(255, 153, 255));
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtFieldNombre.setBackground(new Color(153, 51, 204)); //vuelve al color original
			}
		});
		txtFieldNombre.setBackground(new Color(153, 51, 204));
		txtFieldNombre.setForeground(new Color(255, 255, 255));
		txtFieldNombre.setFont(this.pixelNombreUsuario);
		txtFieldNombre.setName("");
		txtFieldNombre.setBounds(175, 336, 412, 36);
		txtFieldNombre.setColumns(10);
		add(txtFieldNombre);
		
		//Cartel de ingresarNombre
		JLabel lbl_IngresarNombre = new JLabel("Ingresa tu nombre: ");
		lbl_IngresarNombre.setForeground(Color.WHITE);
		lbl_IngresarNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IngresarNombre.setFont(this.pixelCarteles);
		//lbl_IngresarNombre.setBorder(new LineBorder(new Color(222, 184, 135)));
		lbl_IngresarNombre.setBounds(175, 297, 412, 28);
		
		add(lbl_IngresarNombre);
		
		//cartel modo de juego seleccionado
		this.cartelModoDeJuegoSeleccionado = new JLabel("Modo de juego seleccionado: 4x4");
		cartelModoDeJuegoSeleccionado.setForeground(Color.WHITE);
		this.cartelModoDeJuegoSeleccionado.setBounds(10, 538, 449, 23);
		this.cartelModoDeJuegoSeleccionado.setFont(this.pixelCarteles);
		add(this.cartelModoDeJuegoSeleccionado);
		
		//Boton jugar
		btnJugar = new JButton("Jugar");
		btnJugar.setForeground(new Color(255, 255, 255));
		btnJugar.setBorderPainted(false);
		btnJugar.setBorder(new LineBorder(new Color(222, 184, 135)));
		btnJugar.setBackground(new Color(0, 128, 128));
		btnJugar.setFont(this.pixelCarteles);
		btnJugar.setBounds(224, 401, 307, 60);
		add(btnJugar);
		
		lblErrorNombre = new JLabel("El nombre solo puede contener letras");
		lblErrorNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNombre.setForeground(new Color(255, 255, 255));
		lblErrorNombre.setBackground(new Color(255, 0, 0));
		lblErrorNombre.setOpaque(true);
		
		lblErrorNombre.setBounds(192, 376, 382, 18);
		lblErrorNombre.setFont(this.pixelMensajeError);
		add(lblErrorNombre);
		lblErrorNombre.setVisible(false);
		
		this.btn4x4 = new JButton("4x4");
		btn4x4.setForeground(new Color(255, 255, 255));
		btn4x4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartelModoDeJuegoSeleccionado.setText("Modo de juego seleccionado: 4x4");
				modoDeJuego= 4;
			}
		});
		btn4x4.setBounds(686, 11, 89, 36);
		btn4x4.setBorderPainted(false);
		btn4x4.setBorder(new LineBorder(new Color(222, 184, 135)));
		btn4x4.setBackground(new Color(51, 0, 204));
		btn4x4.setFont(this.pixelCarteles);
		add(btn4x4);
		
		this.btn5x5 = new JButton("5x5");
		btn5x5.setForeground(new Color(255, 255, 255));
		btn5x5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartelModoDeJuegoSeleccionado.setText("Modo de juego seleccionado: 5x5");
				modoDeJuego= 5;
			}
		});
		btn5x5.setBounds(686, 58, 89, 36);
		btn5x5.setBorderPainted(false);
		btn5x5.setBorder(new LineBorder(new Color(222, 184, 135)));
		btn5x5.setBackground(new Color(51, 0, 204));
		btn5x5.setFont(this.pixelCarteles);
		add(btn5x5);
		
		this.btn6x6 = new JButton("6x6");
		btn6x6.setForeground(new Color(255, 255, 255));
		btn6x6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartelModoDeJuegoSeleccionado.setText("Modo de juego seleccionado: 6x6");
				modoDeJuego= 6;
			}
		});
		btn6x6.setBounds(686, 102, 89, 36);
		btn6x6.setBorderPainted(false);
		btn6x6.setBorder(new LineBorder(new Color(222, 184, 135)));
		btn6x6.setBackground(new Color(51, 0, 204));
		btn6x6.setFont(this.pixelCarteles);
		add(this.btn6x6);
		
		btnMejoresJugadores = new JButton("Mejores Puntajes");
		btnMejoresJugadores.setForeground(new Color(255, 255, 255));
		btnMejoresJugadores.setFont(null);
		btnMejoresJugadores.setBorderPainted(false);
		btnMejoresJugadores.setBorder(new LineBorder(new Color(222, 184, 135)));
		btnMejoresJugadores.setBackground(new Color(154, 205, 50));
		btnMejoresJugadores.setBounds(224, 472, 307, 47);
		btnMejoresJugadores.setFont(this.pixelCarteles);
		add(btnMejoresJugadores);
		
		imagenFondo = new JLabel("");
		imagenFondo.setIcon(new ImageIcon(MenuPanel.class.getResource("/multimedia/imagenes/fondoMenu.png")));
		imagenFondo.setBounds(0, 0, 784, 561);
		add(imagenFondo);
		
		
	}
	public void mostrarErrorNombre(boolean opcion) {
		this.lblErrorNombre.setVisible(opcion);
	}
	public int getModoDeJuego() {
		return this.modoDeJuego;
	}
}

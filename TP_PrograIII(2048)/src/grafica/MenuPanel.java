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
	private JTextField txtFieldNombre;
	private JButton  btnJugar,btn4x4,btn5x5,btn6x6,btnMejoresJugadores;
	private Font pixelNum,pixelNombreUsuario,pixelCarteles,pixelMensajeError;
	private JLabel lblErrorNombre,cartelModoDeJuegoSeleccionado,cartelN2,cartelN0,cartelN4,cartelN8,cartelIngresarNombre;
	private int modoDeJuego;
	private JLabel imagenFondo;
	private Color colorCartelesNum,colorLetrasEnCarteles, btnModoDeJuego, colorBtnJugar, coloBtnMejoresJugadores;
	private Fuente fuente;
	public MenuPanel() {
		//Fuente
		this.fuente= new Fuente();
		this.pixelNum= fuente.generarFuente("Pixel.ttf", 50);
		this.pixelNombreUsuario= fuente.generarFuente("Pixel.ttf", 20);
		this.pixelCarteles= fuente.generarFuente("Pixel.ttf", 16);
		this.pixelMensajeError= fuente.generarFuente("Pixel.ttf", 15);
		setLayout(null);
		
		this.colorCartelesNum= new Color(102, 51, 153);
		this.colorLetrasEnCarteles= new Color(255, 255, 255);
		this.btnModoDeJuego= new Color(51, 0, 204);
		this.colorBtnJugar= new Color(0, 128, 128);
		this.coloBtnMejoresJugadores=new Color(154, 205, 50);
		
		//Num 2 titulo
		this.cartelN2 = new JLabel("2");
		this.cartelN2.setForeground(this.colorLetrasEnCarteles);
		this.cartelN2.setFont(this.pixelNum);
		this.cartelN2.setHorizontalAlignment(SwingConstants.CENTER);
		this.cartelN2.setBorder(new LineBorder(new Color(218, 165, 32)));
		this.cartelN2.setOpaque(true);
		this.cartelN2.setBackground(this.colorCartelesNum);
		this.cartelN2.setBounds(192, 129, 88, 93);
		add(this.cartelN2);
		
		//Num 0 titulo
		this.cartelN0 = new JLabel("0");
		this.cartelN0.setForeground(this.colorLetrasEnCarteles);
		this.cartelN0.setFont(this.pixelNum);
		this.cartelN0.setHorizontalAlignment(SwingConstants.CENTER);
		this.cartelN0.setBorder(new LineBorder(new Color(222, 184, 135)));
		this.cartelN0.setBackground(this.colorCartelesNum);
		this.cartelN0.setOpaque(true);
		this.cartelN0.setBounds(290, 129, 88, 93);
		add(this.cartelN0);
		
		//Num 4 titulo
		this.cartelN4 = new JLabel("4");
		this.cartelN4.setForeground(this.colorLetrasEnCarteles);
		this.cartelN4.setFont(this.pixelNum);
		this.cartelN4.setHorizontalAlignment(SwingConstants.CENTER);
		this.cartelN4.setBackground(this.colorCartelesNum);
		this.cartelN4.setBorder(new LineBorder(new Color(222, 184, 135)));
		this.cartelN4.setOpaque(true);
		this.cartelN4.setBounds(388, 129, 88, 93);
		add(this.cartelN4);
		
		//Num 8 titulo
		this.cartelN8 = new JLabel("8");
		this.cartelN8.setForeground(this.colorLetrasEnCarteles);
		this.cartelN8.setFont(this.pixelNum);
		this.cartelN8.setHorizontalAlignment(SwingConstants.CENTER);
		this.cartelN8.setOpaque(true);
		this.cartelN8.setBackground(this.colorCartelesNum);
		this.cartelN8.setBorder(new LineBorder(new Color(222, 184, 135)));
		this.cartelN8.setBounds(486, 129, 88, 93);
		add(this.cartelN8);
		
		//Campo de Texto
		this.txtFieldNombre = new JTextField();
		this.txtFieldNombre.addFocusListener(new FocusAdapter() {//si estoy en cima del textField
			@Override
			public void focusGained(FocusEvent e) {
				txtFieldNombre.setBackground(new Color(255, 153, 255));
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtFieldNombre.setBackground(new Color(153, 51, 204)); //vuelve al color original
			}
		});
		this.txtFieldNombre.setBackground(new Color(153, 51, 204));
		this.txtFieldNombre.setForeground(this.colorLetrasEnCarteles);
		this.txtFieldNombre.setFont(this.pixelNombreUsuario);
		this.txtFieldNombre.setName("");
		this.txtFieldNombre.setBounds(175, 336, 412, 36);
		this.txtFieldNombre.setColumns(10);
		add(this.txtFieldNombre);
		
		//Cartel de ingresarNombre
		this.cartelIngresarNombre = new JLabel("Ingresa tu nombre: ");
		this.cartelIngresarNombre.setForeground(this.colorLetrasEnCarteles);
		this.cartelIngresarNombre.setHorizontalAlignment(SwingConstants.CENTER);
		this.cartelIngresarNombre.setFont(this.pixelCarteles);
		this.cartelIngresarNombre.setBounds(175, 297, 412, 28);
		
		add(this.cartelIngresarNombre);
		
		//cartel modo de juego seleccionado
		this.cartelModoDeJuegoSeleccionado = new JLabel("Modo de juego seleccionado: 4x4");
		this.cartelModoDeJuegoSeleccionado.setForeground(this.colorLetrasEnCarteles);
		this.cartelModoDeJuegoSeleccionado.setBounds(10, 538, 449, 23);
		this.cartelModoDeJuegoSeleccionado.setFont(this.pixelCarteles);
		add(this.cartelModoDeJuegoSeleccionado);
		
		//Boton jugar
		this.btnJugar = new JButton("Jugar");
		this.btnJugar.setForeground(this.colorLetrasEnCarteles);
		this.btnJugar.setBorderPainted(false);
		this.btnJugar.setBorder(new LineBorder(new Color(222, 184, 135)));
		this.btnJugar.setBackground(this.colorBtnJugar);
		this.btnJugar.setFont(this.pixelCarteles);
		this.btnJugar.setBounds(224, 401, 307, 60);
		add(this.btnJugar);
		
		this.lblErrorNombre = new JLabel("El nombre solo puede contener letras");
		this.lblErrorNombre.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblErrorNombre.setForeground(this.colorLetrasEnCarteles);
		this.lblErrorNombre.setBackground(new Color(255, 0, 0));
		this.lblErrorNombre.setOpaque(true);
		this.lblErrorNombre.setBounds(192, 376, 382, 18);
		this.lblErrorNombre.setFont(this.pixelMensajeError);
		add(this.lblErrorNombre);
		this.lblErrorNombre.setVisible(false);
		//botones modo de juego
		this.btn4x4 = new JButton("4x4");
		this.btn4x4.setForeground(this.colorLetrasEnCarteles);
		this.btn4x4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartelModoDeJuegoSeleccionado.setText("Modo de juego seleccionado: 4x4");
				modoDeJuego= 4;
			}
		});
		this.btn4x4.setBounds(686, 11, 89, 36);
		this.btn4x4.setBorderPainted(false);
		this.btn4x4.setBorder(new LineBorder(new Color(222, 184, 135)));
		this.btn4x4.setBackground(this.btnModoDeJuego);
		this.btn4x4.setFont(this.pixelCarteles);
		add(this.btn4x4);
		
		this.btn5x5 = new JButton("5x5");
		this.btn5x5.setForeground(this.colorLetrasEnCarteles);
		this.btn5x5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartelModoDeJuegoSeleccionado.setText("Modo de juego seleccionado: 5x5");
				modoDeJuego= 5;
			}
		});
		this.btn5x5.setBounds(686, 58, 89, 36);
		this.btn5x5.setBorderPainted(false);
		this.btn5x5.setBorder(new LineBorder(new Color(222, 184, 135)));
		this.btn5x5.setBackground(this.btnModoDeJuego);
		this.btn5x5.setFont(this.pixelCarteles);
		add(this.btn5x5);
		
		this.btn6x6 = new JButton("6x6");
		this.btn6x6.setForeground(this.colorLetrasEnCarteles);
		this.btn6x6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartelModoDeJuegoSeleccionado.setText("Modo de juego seleccionado: 6x6");
				modoDeJuego= 6;
			}
		});
		this.btn6x6.setBounds(686, 102, 89, 36);
		this.btn6x6.setBorderPainted(false);
		this.btn6x6.setBorder(new LineBorder(new Color(222, 184, 135)));
		this.btn6x6.setBackground(this.btnModoDeJuego);
		this.btn6x6.setFont(this.pixelCarteles);
		add(this.btn6x6);
		//boton mejores jugadores
		this.btnMejoresJugadores = new JButton("Mejores Puntajes");
		this.btnMejoresJugadores.setForeground(this.colorLetrasEnCarteles);
		this.btnMejoresJugadores.setFont(null);
		this.btnMejoresJugadores.setBorderPainted(false);
		this.btnMejoresJugadores.setBorder(new LineBorder(new Color(222, 184, 135)));
		this.btnMejoresJugadores.setBackground(this.coloBtnMejoresJugadores);
		this.btnMejoresJugadores.setBounds(224, 472, 307, 47);
		this.btnMejoresJugadores.setFont(this.pixelCarteles);
		add(this.btnMejoresJugadores);
		
		this.imagenFondo = new JLabel("");
		this.imagenFondo.setIcon(new ImageIcon(MenuPanel.class.getResource("/multimedia/imagenes/fondoMenu.png")));
		this.imagenFondo.setBounds(0, 0, 784, 561);
		add(this.imagenFondo);
		
		this.modoDeJuego=4;
	}
	public void mostrarErrorNombre(boolean opcion) {
		this.lblErrorNombre.setVisible(opcion);
	}
	public int getModoDeJuego() {
		return this.modoDeJuego;
	}
	public JTextField getTxtFieldNombre() {
		return this.txtFieldNombre;
	}
	public void setTxtFieldNombre(JTextField txtFieldNombre) {
		this.txtFieldNombre = txtFieldNombre;
	}
	public JButton getBtnJugar() {
		return this.btnJugar;
	}
	public void setBtnJugar(JButton btnJugar) {
		this.btnJugar = btnJugar;
	}
	public JButton getBtnMejoresJugadores() {
		return this.btnMejoresJugadores;
	}
	public void setBtnMejoresJugadores(JButton btnMejoresJugadores) {
		this.btnMejoresJugadores = btnMejoresJugadores;
	}
	public boolean validarNombreJugador(String nombre) {
		return Menu.validarNombreJugador(nombre);
	}
	
}

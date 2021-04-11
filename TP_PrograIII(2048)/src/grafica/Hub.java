package grafica;

import javax.swing.JPanel;

import logica.Jugador;
import multimedia.Fuente;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Hub extends JPanel {
	private JLabel labelNombreDeUsuario, labelPuntaje,imagenHub;
	private Font pixelNum,pixelNombreUsuario;
	private String nombreDeUsuario;
	private Jugador jugador;
	private Fuente fuente;
	Color colorTexto;
	
	public Hub(Jugador jugador) {
		this.fuente= new Fuente();
		this.pixelNum= fuente.generarFuente("Pixel.ttf", 30);
		this.pixelNombreUsuario= fuente.generarFuente("Pixel.ttf", 30);
		
		setLayout(null);
		
		this.colorTexto= Color.WHITE;
		this.jugador= jugador;
		this.nombreDeUsuario= jugador.getNombre();
		this.labelPuntaje = new JLabel("Puntos: 0");
		this.labelPuntaje.setForeground(colorTexto);
		this.labelPuntaje.setFont(this.pixelNombreUsuario);
		this.labelPuntaje.setBounds(401, 0, 383, 31);
		add(labelPuntaje);
		this.labelNombreDeUsuario = new JLabel(this.nombreDeUsuario);
		this.labelNombreDeUsuario.setFont(this.pixelNum);
		this.labelNombreDeUsuario.setBounds(10, 0, 381, 31);
		this.labelNombreDeUsuario.setForeground(colorTexto);
		add(labelNombreDeUsuario);
		
		this.imagenHub = new JLabel("");
		this.imagenHub.setIcon(new ImageIcon(Hub.class.getResource("/multimedia/imagenes/hub.png")));
		this.imagenHub.setBounds(0, -14, 784, 56);
		add(imagenHub);
		

	}
	public void actualizarPuntaje(int puntos) {
		this.jugador.setPuntaje(puntos);
		this.labelPuntaje.setText("Puntos: " + Integer.toString(puntos));
	}

	public String getNombreDeUsuario() {
		return this.nombreDeUsuario;
	}
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario= nombreDeUsuario;
		this.labelNombreDeUsuario.setText(this.nombreDeUsuario);
	}
	public Jugador getJugador() {
		return this.jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
}

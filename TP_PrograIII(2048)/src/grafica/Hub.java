package grafica;

import javax.swing.JPanel;

import multimedia.Fuente;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Hub extends JPanel {
	private JLabel labelNombreDeUsuario, labelPuntaje;
	private Font pixelNum,pixelNombreUsuario;
	private String nombreDeUsuario;
	private Fuente fuente;
	public Hub() {
		this.fuente= new Fuente();
		this.pixelNum= fuente.generarFuente("Pixel.ttf", 30);
		this.pixelNombreUsuario= fuente.generarFuente("Pixel.ttf", 30);
		
		setLayout(null);
		
		this.nombreDeUsuario="Username";
		
		labelPuntaje = new JLabel("Puntos: 0");
		labelPuntaje.setForeground(Color.WHITE);
		labelPuntaje.setFont(this.pixelNombreUsuario);
		labelPuntaje.setBounds(401, 0, 383, 31);
		//labelPuntaje.
		add(labelPuntaje);
		labelNombreDeUsuario = new JLabel(this.nombreDeUsuario);
		labelNombreDeUsuario.setFont(this.pixelNum);
		labelNombreDeUsuario.setBounds(10, 0, 381, 31);
		labelNombreDeUsuario.setForeground(Color.WHITE);
		add(labelNombreDeUsuario);
		
		JLabel imagenHub = new JLabel("New label");
		imagenHub.setIcon(new ImageIcon(Hub.class.getResource("/multimedia/imagenes/hub.png")));
		imagenHub.setBounds(0, -14, 784, 56);
		add(imagenHub);
		

	}
	public void actualizarPuntaje(int puntos) {
		this.labelPuntaje.setText("Puntos: " + Integer.toString(puntos));
	}
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario= nombreDeUsuario;
		this.labelNombreDeUsuario.setText(this.nombreDeUsuario);
	}
}

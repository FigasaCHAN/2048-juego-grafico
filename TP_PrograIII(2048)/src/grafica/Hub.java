package grafica;

import javax.swing.JPanel;

import multimedia.Fuente;

import java.awt.Font;

import javax.swing.JLabel;

public class Hub extends JPanel {
	private JLabel nombreUsuario, puntaje;
	private Font pixelNum,pixelNombreUsuario;
	public Hub() {
		Fuente fuente= new Fuente();
		this.pixelNum= fuente.generarFuente("Pixel.ttf", 20);
		this.pixelNombreUsuario= fuente.generarFuente("Pixel.ttf", 20);
		
		setLayout(null);
		
		nombreUsuario = new JLabel("Username");
		nombreUsuario.setFont(this.pixelNum);
		nombreUsuario.setBounds(10, 0, 381, 31);
		add(nombreUsuario);
		
		puntaje = new JLabel("Puntos: 0");
		puntaje.setFont(this.pixelNombreUsuario);
		puntaje.setBounds(528, 0, 256, 31);
		add(puntaje);

	}
	public void actualizarPuntaje(int puntos) {
		this.puntaje.setText("Puntos: " + Integer.toString(puntos));
	}
}

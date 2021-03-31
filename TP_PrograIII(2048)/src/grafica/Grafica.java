package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Grafica {

	private JFrame frame;
	TableroGrafico tableroGrafico;
	JLabel puntajes; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica window = new Grafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Grafica() {
		this.tableroGrafico= new TableroGrafico();
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setResizable(false);
		frame.setTitle("2048");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); //centro la ventana
		
		this.tableroGrafico.setBounds(0, 35, 784, 526); //lo doy las medidas 
		frame.getContentPane().add(this.tableroGrafico); //lo agrego a la ventana

		JPanel hub = new JPanel();
		hub.setBounds(0, 0, 784, 35);
		//frame.getContentPane().add(hub);
		agregarPanel(hub);
		hub.setLayout(null);
		
		this.puntajes = new JLabel("Puntos: ");
		puntajes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		puntajes.setBounds(513, 0, 271, 35);
		hub.add(puntajes);
		
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='w') {
					tableroGrafico.moverArriba();
					actualizarPuntos();
				}
				if(e.getKeyChar()=='a') {
					tableroGrafico.moverIzquierda();
					actualizarPuntos();
				}
				if(e.getKeyChar()=='s') {
					tableroGrafico.moverAbajo();
					actualizarPuntos();
				}
				if(e.getKeyChar()=='d') {
					tableroGrafico.moverDerecha();
					actualizarPuntos();
				}
			}
		});
		
		/*JPanel tableroGrafico = new JPanel();
		tableroGrafico.setBounds(0, 35, 784, 526);
		frame.getContentPane().add(tableroGrafico);
		tableroGrafico.setLayout(new GridLayout(1, 0, 0, 0));
		*/
	
		
	}
	void actualizarPuntos() {
		this.puntajes.setText("Puntaje: " + this.tableroGrafico.puntos);
	}
	private void agregarPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	private void quitarPanel(JPanel panel) {
		frame.getContentPane().remove(panel); //O(n)
		frame.repaint(); //es obligatorio redibujar
	}
}

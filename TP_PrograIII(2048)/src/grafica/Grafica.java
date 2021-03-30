package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class Grafica {

	private JFrame frame;
	TableroGrafico tableroGrafico;
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
		
		JPanel hub = new JPanel();
		hub.setBounds(0, 0, 784, 35);
		frame.getContentPane().add(hub);
		hub.setLayout(null);
		
		JLabel puntaje = new JLabel("Puntos: ");
		puntaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
		puntaje.setBounds(513, 0, 271, 35);
		hub.add(puntaje);
		
		/*JPanel tableroGrafico = new JPanel();
		tableroGrafico.setBounds(0, 35, 784, 526);
		frame.getContentPane().add(tableroGrafico);
		tableroGrafico.setLayout(new GridLayout(1, 0, 0, 0));
		*/
		this.tableroGrafico.setBounds(0, 35, 784, 526); //lo doy la forma
		frame.getContentPane().add(this.tableroGrafico); //lo agrego a la ventana
		
	}
}

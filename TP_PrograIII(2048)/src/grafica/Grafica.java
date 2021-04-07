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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

import logica.Menu;

public class Grafica {

	private JFrame frame;
	TableroGrafico tableroGrafico;
	JLabel puntajes; 
	Hub hub;
	MenuPanel menu;
	MejoresJugadoresPanel mejoresJugadores;
	private String nombreDeUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica window = new Grafica();
					window.frame.setVisible(true);
					window.cargarMenu(); //cargo el menu
					
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
		this.menu= new MenuPanel(); //creo el menu panel
		this.menu.setBounds(0, 0, 784, 561);//medidas al menu panel
		initialize(); //inicializo
		//y eso es lo unico que debe hacer el constructor, los eventos y estado de la clase las voy a cambiar en el main
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Inicializo la ventana, solo la ventana 
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("2048");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	}
	
	void actualizarPuntos() {
		this.hub.actualizarPuntaje(tableroGrafico.tablero.getPuntos());
	}
	private void agregarPanel(JPanel panel) {
		frame.getContentPane().removeAll(); //elimino todos los componentes
		frame.getContentPane().add(panel); //agrego el panel
		frame.getContentPane().repaint(); //repinto
		frame.getContentPane().revalidate(); // revalido esto es importante ya que el frame tiene que fijarse el estado de sus componentes
		
	}
	private void cargarTablero(int modoDeJuegoSeleccionado) {
		this.tableroGrafico= new TableroGrafico(modoDeJuegoSeleccionado); //creo el tablero grafico
		this.tableroGrafico.setBounds(0, 35, 784, 504); //lo doy las medidas , al alto le tengo que restar 22p de la barra de menu y 35p del hub
		agregarPanel(this.tableroGrafico); //agrego el tablero
		agregarMenuBar(); //agrego la barra de menu
		cargarHub(nombreDeUsuario);//le paso el nombre que ingreso el usuario
		frame.repaint(); //repinto
		frame.revalidate();//revalido
	}
	
	private void cargarMejoresJugadores() {
		this.mejoresJugadores= new MejoresJugadoresPanel();
		agregarPanel(this.mejoresJugadores);
		frame.repaint(); //repinto
		frame.revalidate();//revalido
	}
	
	private void cargarMenu() {
		agregarPanel(this.menu); //agrego el menu (panel)
		eventoClick();
		frame.repaint();
		frame.revalidate();
	}
	private void cargarHub(String nombreDeUsuario) {
		this.hub=new Hub(); //creo el hub
		this.hub.setBounds(0, 0, 784, 35);//medidas del hub
		frame.getContentPane().add(this.hub);//agrego el hub sin eliminar nada
		this.hub.setNombreDeUsuario(nombreDeUsuario); //le paso el nombre de usuario
		frame.repaint();
		frame.revalidate();
	}
	private void eventoClick() {
		//evento de click
		menu.btnJugar.addActionListener(new ActionListener() { //al boton del menu le agrega el evento
		public void actionPerformed(ActionEvent e) {
			nombreDeUsuario= menu.txtFieldNombre.getText(); 
			if(Menu.validarNombreJugador(nombreDeUsuario)) {	//hace la comprobacion del nombre del usuario
				menu.mostrarErrorNombre(false);
				cargarTablero(menu.getModoDeJuego()); //cargo el tablero
			}else {
				menu.mostrarErrorNombre(true);
			}
		}
	});
	}
	private void agregarMenuBar() { //agrega la barra del menu
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menMovimiento = new JMenu("Movimiento");
		menuBar.add(menMovimiento);
		
		JMenuItem menuMovArriba = new JMenuItem("Arriba");
		menuMovArriba.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0)); //el acceso directo 
		menuMovArriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
						
					tableroGrafico.moverArriba(); //el evento es moverArriba
					actualizarPuntos();
					if(tableroGrafico.perdioElJuego()) {
						cargarMejoresJugadores();
					}
				
			}
		});
		menMovimiento.add(menuMovArriba); //agrego el item al menu
		
		JMenuItem menuMovAbajo = new JMenuItem("Abajo");
		menuMovAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					tableroGrafico.moverAbajo();
					actualizarPuntos();
					if(tableroGrafico.perdioElJuego()) {
						cargarMejoresJugadores();
					}
				
				
			}
		});
		menuMovAbajo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
		menMovimiento.add(menuMovAbajo);
		
		JMenuItem menuMovIzquierda = new JMenuItem("Izquierda");
		menuMovIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
					tableroGrafico.moverIzquierda();
					actualizarPuntos();
					if(tableroGrafico.perdioElJuego()) {
						cargarMejoresJugadores();
					}
				
			}
		});
		menuMovIzquierda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0));
		menMovimiento.add(menuMovIzquierda);
		
		JMenuItem menuMovDerecha = new JMenuItem("Derecha");
		menuMovDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
					tableroGrafico.moverDerecha();
					actualizarPuntos();
					if(tableroGrafico.perdioElJuego()) {
						cargarMejoresJugadores();
					}
				
			}
		});
		menuMovDerecha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0));
		menMovimiento.add(menuMovDerecha);
	}
}

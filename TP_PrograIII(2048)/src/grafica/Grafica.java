package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

import logica.Jugador;
import logica.Menu;

public class Grafica {

	private JFrame frame;
	private TableroGrafico tableroGrafico;
	private Hub hub;
	private MenuPanel menu;
	private MejoresJugadoresPanel mejoresJugadores;
	private String nombreDeUsuario;
	private KeyAdapter eventosTablero;
	private boolean enGameOver;
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
					window.eventoClick();		
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
		this.enGameOver= false;
		//y eso es lo unico que debe hacer el constructor, los eventos y estado de la clase las voy a cambiar en el main
	}

	private void initialize() {
		//Inicializo la ventana, solo la ventana 
		this.frame = new JFrame();
		this.frame.setResizable(false);
		this.frame.setTitle("2048");
		this.frame.setBounds(100, 100, 800, 600);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);
		this.frame.setLocationRelativeTo(null);
	}

	private void actualizarPuntos() {
		this.hub.actualizarPuntaje(this.tableroGrafico.getPuntosDelTablero());
	}
	
	private void agregarPanel(JPanel panel) {
		this.frame.getContentPane().removeAll(); //elimino todos los componentes
		this.frame.getContentPane().add(panel); //agrego el panel
		this.frame.getContentPane().repaint(); //repinto
		this.frame.getContentPane().revalidate(); // revalido esto es importante ya que el frame tiene que fijarse el estado de sus componentes

	}

	private void cargarMenu() {	
		limpiarEventosTablero();
		this.enGameOver= false;
		agregarPanel(this.menu); //agrego el menu (panel)
		menu.getTxtFieldNombre().setText(""); //limpia el input 
		this.frame.repaint();
		this.frame.revalidate();
	}

	private void cargarTablero(Jugador jugador, int modoDeJuegoSeleccionado) {
		this.tableroGrafico= new TableroGrafico(modoDeJuegoSeleccionado); //creo el tablero grafico
		this.tableroGrafico.setBounds(0, 35, 784, 525); //lo doy las medidas , al alto le tengo que restar 35px del hub
		agregarPanel(this.tableroGrafico); //agrego el tablero
		cargarHub(jugador);//le paso el nombre que ingreso el usuario
		this.frame.repaint(); //repinto
		this.frame.revalidate();//revalido
	}
	
	private void cargarHub(Jugador jugador) {
		this.hub=new Hub(jugador); //creo el hub
		this.hub.setBounds(0, 0, 784, 35);//medidas del hub
		this.frame.getContentPane().add(this.hub);//agrego el hub sin eliminar nada
		this.hub.setNombreDeUsuario(nombreDeUsuario); //le paso el nombre de usuario
		this.frame.repaint();
		this.frame.revalidate();
	}

	private void cargarMejoresJugadores(boolean opcion) {
		limpiarEventosTablero();
		this.mejoresJugadores= new MejoresJugadoresPanel();
		if(opcion==true) {	
			int puntajeJugador= this.tableroGrafico.getPuntosDelTablero();
			this.mejoresJugadores.registrarPuntajeJugador(this.nombreDeUsuario, puntajeJugador);
		}
		this.mejoresJugadores.mostrarJugadores();
		this.mejoresJugadores.mostrarLabelGameOver(opcion);
		agregarPanel(this.mejoresJugadores);
		agregarEventoVolverMenu();		
		this.frame.repaint(); //repinto
		this.frame.revalidate();//revalido
		
		
	}

	private void timeOutGameOver() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {								
				cargarMejoresJugadores(true);
			}
		}, 3000);
	}
	
	private void eventoClick() {
		this.menu.getBtnJugar().addActionListener(new ActionListener() { //al boton del menu le agrega el evento
			public void actionPerformed(ActionEvent e) {
				nombreDeUsuario= menu.getTxtFieldNombre().getText();
				if(Menu.validarNombreJugador(nombreDeUsuario)) {	//hace la comprobacion del nombre del usuario
					Jugador jugador= new Jugador(nombreDeUsuario, 0);
					menu.mostrarErrorNombre(false);
					cargarTablero(jugador, menu.getModoDeJuego()); //cargo el tablero
					agregarEventosTeclado();//despues de cargar el tablero, agrego los eventos del teclado
					agregarEventoVolverMenu();		
				}else {
					menu.mostrarErrorNombre(true);
				}
			}
		});
		
		this.menu.getBtnMejoresJugadores().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMejoresJugadores(false);
				agregarEventoVolverMenu();		
			}
		});
	}
	
	private void agregarEventosTeclado(){
		this.eventosTablero=new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()=='w' || e.getKeyCode() == 38) { //38 es el code de la flecha arriba
					if(!tableroGrafico.perdioElJuego()) {
						tableroGrafico.moverArriba();
						actualizarPuntos();
					}
					if(tableroGrafico.perdioElJuego() && !enGameOver) {
						timeOutGameOver();
						enGameOver= true;
					}
				}
				if(e.getKeyChar()=='a' || e.getKeyCode() == 37 ) { //39 es el code de la flecha izquierda
					if(!tableroGrafico.perdioElJuego()) {
						tableroGrafico.moverIzquierda();
						actualizarPuntos();
					}

					if(tableroGrafico.perdioElJuego() && !enGameOver) {
						timeOutGameOver();
						enGameOver= true;
					}
				}
				if(e.getKeyChar()=='s' || e.getKeyCode() == 40) { //38 es el code de la flecha abajo
					if(!tableroGrafico.perdioElJuego()) {
						tableroGrafico.moverAbajo();
						actualizarPuntos();
					}

					if(tableroGrafico.perdioElJuego() && !enGameOver) {
						timeOutGameOver();
						enGameOver= true;
					}
				}
				if(e.getKeyChar()=='d' || e.getKeyCode() == 39) { //39 es el code de la flecha derecha
					if(!tableroGrafico.perdioElJuego()) {
						tableroGrafico.moverDerecha();
						actualizarPuntos();
					}

					if(tableroGrafico.perdioElJuego() && !enGameOver) {
						timeOutGameOver();
						enGameOver= true;
					}
				}
			}
		};
		
		this.frame.addKeyListener(this.eventosTablero);	
		this.frame.requestFocus(); //le devuelvo el foco a la ventana para que pueda tomar los eventos
		this.frame.revalidate();
	}
	
	private void agregarEventoVolverMenu() {
		this.frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==27) { //cuando se presione la tecla Esc
					cargarMenu();
					menu.getTxtFieldNombre().requestFocus();//le doy el foco al nombre de usuario
					//menu.txtFieldNombre.requestFocus(); 
				}
			}
		
		});	
		this.frame.requestFocus(); //le devuelvo el foco a la ventana
		this.frame.revalidate();
	}
	
	private void limpiarEventosTablero() {
		this.frame.removeKeyListener(this.eventosTablero);
	}
}

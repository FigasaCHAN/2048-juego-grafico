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

	void actualizarPuntos() {
		this.hub.actualizarPuntaje(this.tableroGrafico.tablero.getPuntos());
	}
	
	private void agregarPanel(JPanel panel) {
		this.frame.getContentPane().removeAll(); //elimino todos los componentes
		this.frame.getContentPane().add(panel); //agrego el panel
		this.frame.getContentPane().repaint(); //repinto
		this.frame.getContentPane().revalidate(); // revalido esto es importante ya que el frame tiene que fijarse el estado de sus componentes

	}

	private void cargarMenu() {	
		this.enGameOver= false;
		agregarPanel(this.menu); //agrego el menu (panel)
		menu.txtFieldNombre.setText(""); //limpia el input 
		this.frame.repaint();
		this.frame.revalidate();
	}

	private void cargarTablero(int modoDeJuegoSeleccionado) {
		this.tableroGrafico= new TableroGrafico(modoDeJuegoSeleccionado); //creo el tablero grafico
		this.tableroGrafico.setBounds(0, 35, 784, 504); //lo doy las medidas , al alto le tengo que restar 22p de la barra de menu y 35p del hub
		agregarPanel(this.tableroGrafico); //agrego el tablero
		cargarHub(this.nombreDeUsuario);//le paso el nombre que ingreso el usuario
		this.frame.repaint(); //repinto
		this.frame.revalidate();//revalido
	}
	
	private void cargarHub(String nombreDeUsuario) {
		this.hub=new Hub(); //creo el hub
		this.hub.setBounds(0, 0, 784, 35);//medidas del hub
		this.frame.getContentPane().add(this.hub);//agrego el hub sin eliminar nada
		this.hub.setNombreDeUsuario(nombreDeUsuario); //le paso el nombre de usuario
		this.frame.repaint();
		this.frame.revalidate();
	}

	private void cargarMejoresJugadores(boolean opcion) {	
		this.mejoresJugadores= new MejoresJugadoresPanel();
		if(opcion==true) {	
			int puntajeJugador= this.tableroGrafico.tablero.getPuntos();
			this.mejoresJugadores.registrarPuntajeJugador(this.nombreDeUsuario, puntajeJugador);
		}
	//	agregarEventoVolverMenu();		
		this.mejoresJugadores.mostrarJugadores();
		this.mejoresJugadores.mostrarLabelGameOver(opcion);
		agregarPanel(this.mejoresJugadores);	
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
		this.menu.btnJugar.addActionListener(new ActionListener() { //al boton del menu le agrega el evento
			public void actionPerformed(ActionEvent e) {
				nombreDeUsuario= menu.txtFieldNombre.getText();
				if(Menu.validarNombreJugador(nombreDeUsuario)) {	//hace la comprobacion del nombre del usuario
					menu.mostrarErrorNombre(false);
					cargarTablero(menu.getModoDeJuego()); //cargo el tablero
					agregarEventosTeclado();//despues de cargar el tablero, agrego los eventos del teclado
					agregarEventoVolverMenu();		
				}else {
					menu.mostrarErrorNombre(true);
				}
			}
		});
		
		this.menu.btnMejoresJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMejoresJugadores(false);
				agregarEventoVolverMenu();		
			}
		});
	}
	
	private void agregarEventosTeclado(){
		this.frame.addKeyListener(new KeyAdapter() {
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
		});
		this.frame.requestFocus(); //le devuelvo el foco a la ventana para que pueda tomar los eventos
		this.frame.revalidate();
	}
	
	private void agregarEventoVolverMenu() {
		System.out.println("entro");
	//	this.enGameOver= false;
		this.frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==27) { //cuando se presione la tecla Esc
					cargarMenu();
				}
			}
		
		});	
		
		this.frame.requestFocus(); 
		this.frame.revalidate();
	}
}

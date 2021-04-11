package grafica;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Jugador;
import logica.MejoresJugadores;

import multimedia.Fuente;

import java.awt.ComponentOrientation;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;

public class MejoresJugadoresPanel extends JPanel {
	private final JTable table = new JTable();
	private Font pixelNum,pixelNombreUsuario,pixelCarteles,pixelVolverMenu;
	private MejoresJugadores mejoresJugadores;
	private JLabel lblGameOver,lblMejoresPuntajes,lblVolverMenu,imagenFondo;
	private ArrayList<Jugador> jugadoresLeidos;
	private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public MejoresJugadoresPanel() {
		
		Fuente fuente= new Fuente();
		this.pixelNum= fuente.generarFuente("Pixel.ttf", 50);
		this.pixelNombreUsuario= fuente.generarFuente("Pixel.ttf", 20);
		this.pixelCarteles= fuente.generarFuente("Pixel.ttf", 16);
		this.pixelVolverMenu= fuente.generarFuente("Pixel.ttf", 15);
		setLayout(null);
		
		this.setBounds(0, 0, 784, 561);
		setLayout(null);
		Object[] columnas= {"Top", "Nombre", "Puntaje",};
		ArrayList<Object> filas= new ArrayList<>();
		model=new DefaultTableModel();
		filas.add("Top");
		filas.add("Nombre");
		filas.add("Puntaje");
		
		model.setColumnIdentifiers(columnas);
		
		this.mejoresJugadores=new MejoresJugadores();
	
		this.table.setBackground(new Color(220, 220, 220));
		this.table.setRowMargin(5);
		this.table.setShowGrid(false);
		this.table.setFont(this.pixelCarteles);

		this.table.setModel(model);
		this.table.setRowHeight(45);

		model.addRow(filas.toArray());
		
		this.table.setBounds(92, 154, 604, 264);
		
			
		this.lblGameOver = new JLabel("GAME OVER");
		this.lblGameOver.setFont(this.pixelNum);
		this.lblGameOver.setBounds(256, 11, 293, 68);
		this.lblGameOver.setForeground(new Color(255, 255, 255));
		this.lblGameOver.setVisible(false);
		add(lblGameOver);
		
		this.lblMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
		this.lblMejoresPuntajes.setFont(this.pixelNombreUsuario);
		this.lblMejoresPuntajes.setBounds(292, 90, 264, 42);
		this.lblMejoresPuntajes.setForeground(new Color(255, 255, 255));
		add(this.lblMejoresPuntajes);
		
		this.lblVolverMenu = new JLabel("Presione la tecla 'Esc' para volver al menu");
		this.lblVolverMenu.setBounds(190, 433, 411, 14);
		this.lblVolverMenu.setFont(this.pixelVolverMenu);
		this.lblVolverMenu.setForeground(new Color(255, 255, 255));
		add(this.lblVolverMenu);
		
		this.imagenFondo = new JLabel("");
		this.imagenFondo.setIcon(new ImageIcon(MenuPanel.class.getResource("/multimedia/imagenes/fondoMenu.png")));
		this.imagenFondo.setBounds(0, 0, 784, 561);
	
		
		
	}
	
	public void mostrarLabelGameOver(boolean opcion) {
		this.lblGameOver.setVisible(opcion);
	}
	
	public void mostrarJugadores() {
		this.jugadoresLeidos=mejoresJugadores.obtenerJugadores();
		Object[] datosJugador=new Object[3];
		int indexMaximo=0;
		for(Jugador jugador:jugadoresLeidos) {
			if(indexMaximo<5) { //solo mostrara los primeros 5 mejores puntajes
				
				datosJugador[0]=indexMaximo+1;
				datosJugador[1]=jugador.getNombre();
				datosJugador[2]=jugador.getPuntaje();
				model.addRow(datosJugador);
				indexMaximo++;
			}
		}
		this.table.setEnabled(false); //para que no sea posible editarla desde la pantalla 
		this.table.setBackground(new Color(102, 51, 153));
		this.table.setForeground(new Color(255, 255, 255));
		this.table.setOpaque(true);
		add(this.table);
		add(this.imagenFondo);
	}
	
	public void registrarPuntajeJugador(Jugador jugador) {
		this.mejoresJugadores.agregarJugadorAlArchivo(jugador);
		
	}
}

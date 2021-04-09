package grafica;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Jugador;
import logica.MejoresJugadores;

import multimedia.Fuente;

import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;

public class MejoresJugadoresPanel extends JPanel {
	private final JTable table = new JTable();
	private Font pixelNum,pixelNombreUsuario,pixelCarteles;
	private MejoresJugadores mejoresJugadores;
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
	
		table.setBackground(new Color(220, 220, 220));
		table.setRowMargin(5);
		table.setShowGrid(false);
		table.setFont(this.pixelCarteles);
		
		table.setModel(model);
		table.setRowHeight(45);

		model.addRow(filas.toArray());
		
		table.setBounds(72, 154, 624, 264);
		
			
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setFont(this.pixelNum);
		lblGameOver.setBounds(256, 11, 293, 68);
		add(lblGameOver);
		
		JLabel lblMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
		lblMejoresPuntajes.setFont(this.pixelNombreUsuario);
		lblMejoresPuntajes.setBounds(292, 90, 264, 42);
		add(lblMejoresPuntajes);
		
		
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
		table.setEnabled(false); //para que no sea posible editarla desde la pantalla 
		add(table);
	}
	
	public void registrarPuntajeJugador(String nombre,int puntaje) {
		Jugador nuevoJugador=new Jugador(nombre,puntaje);
		this.mejoresJugadores.agregarJugadorAlArchivo(nuevoJugador);
		
	}
}

package grafica;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import logica.Tablero;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TableroGrafico extends JPanel {
	private Tablero tablero;
	private final int CANT_DE_FILAS_Y_COLUMNA;
	private int[][] matrizTablero;
	private Color colorBorde;
	private ArrayList<JLabel> listLabel;
	private ImageIcon fondo, n2, n4, n8, n16,n32,n64,n128,n256,n512,n1024,n2048;
	/**
	 * Create the panel.
	 */
	

	public TableroGrafico(int cantDeFila) {
		
		this.tablero= new Tablero(cantDeFila);
		this.matrizTablero= this.tablero.getTablero(); //la voy a usar solo para inicializar los JLabel
		this.CANT_DE_FILAS_Y_COLUMNA= matrizTablero.length;
		this.listLabel= new ArrayList<JLabel>();
		this.colorBorde= new Color(212,174,240);
		cargarImagenesFondoYCasilleros();
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLayout(new GridLayout(CANT_DE_FILAS_Y_COLUMNA, CANT_DE_FILAS_Y_COLUMNA, 0, 0)); //defino la cantidad de filas y colum que va a tener el layout
		cargarCasilleros();
	}

	private void cargarCasilleros() {
		for(int  [] fila: this.matrizTablero) {
			for(int  elem : fila) {
				JLabel elemento; //defino el label nuevo
				elemento = new JLabel("");
				elemento.setOpaque(true); //le permito ser opaco asi le puedo poner color
				if(Integer.toString(elem).toString().equals("0")) {
					elemento.setIcon(this.fondo);
				}
				if(Integer.toString(elem).toString().equals("2")) {
					elemento.setIcon(this.n2);
				}
				if(Integer.toString(elem).toString().equals("4")) {
					elemento.setIcon(this.n4);
				}
				elemento.setHorizontalAlignment(SwingConstants.CENTER); //Centramos los numeros, en este caso centra las imagenes
				elemento.setBorder(new LineBorder(this.colorBorde, 4)); //Borde
				add(elemento); //agrego el elem al panel
				this.listLabel.add(elemento); //lo agrego al arraylist
			}
		}
	}

	private void cargarImagenesFondoYCasilleros() {
		this.fondo = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/fondo.png "));
		this.n2 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num2.png "));
		this.n4 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num4.png "));
		this.n8 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num8.png "));
		this.n16 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num16.png "));
		this.n32 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num32.png "));
		this.n64 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num64.png "));
		this.n128 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num128.png "));
		this.n256 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num256.png "));
		this.n512 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num512.png "));
		this.n1024 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num1024.png "));
		this.n2048 = new ImageIcon(TableroGrafico.class.getResource("/multimedia/imagenes/num2048.png "));
	}
	
	public void moverIzquierda() {
		this.tablero.moverIzquierda();
		actualizar();
	}
	
	public void moverDerecha() {
		this.tablero.moverDerecha();
		actualizar();
	}
	
	public void moverArriba() {
		this.tablero.moverArriba();
		actualizar();
	}
	
	public void moverAbajo() {
		this.tablero.moverAbajo();
		actualizar();
	}
	
	private void actualizar() {
		this.tablero.puedeSumar();//va a actualizar el game over del tablero logico
		ArrayList<Integer> tableroArray= this.tablero.matrizToArray();
	    int indice= 0;
		for(JLabel elem: this.listLabel) {
			if(tableroArray.get(indice).toString().equals("0")) {
				elem.setIcon(this.fondo);
			}
			if(tableroArray.get(indice).toString().equals("2")) {
				elem.setIcon(this.n2);
			}
			if(tableroArray.get(indice).toString().equals("4")) {
				elem.setIcon(this.n4);
			}
			if(tableroArray.get(indice).toString().equals("8")) {
				elem.setIcon(this.n8);
			}
			if(tableroArray.get(indice).toString().equals("16")) {
				elem.setIcon(this.n16);
			}
			if(tableroArray.get(indice).toString().equals("32")) {
				elem.setIcon(this.n32);
			}
			if(tableroArray.get(indice).toString().equals("64")) {
				elem.setIcon(this.n64);
			}
			if(tableroArray.get(indice).toString().equals("128")) {
				elem.setIcon(this.n128);
			}
			if(tableroArray.get(indice).toString().equals("256")) {
				elem.setIcon(this.n256);
			}
			if(tableroArray.get(indice).toString().equals("512")) {
				elem.setIcon(this.n512);
			}
			if(tableroArray.get(indice).toString().equals("1024")) {
				elem.setIcon(this.n1024);
			}
			if(tableroArray.get(indice).toString().equals("2048")) {
				elem.setIcon(this.n2048);
			}
			indice++;
		}
	}
	
	public int getPuntosDelTablero() {
		return this.tablero.getPuntos();
	}
	public boolean perdioElJuego() {
		return this.tablero.getGameOver();
	}

	
}


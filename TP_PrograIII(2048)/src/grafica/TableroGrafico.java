package grafica;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import logica.Tablero;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TableroGrafico extends JPanel {
	Tablero tablero;
	private final int CANT_DE_FILAS_Y_COLUMNA;
	//private Color colorTablero;
	//private final Color colorN2,colorN4,colorN8,colorN16,colorN32,colorN64,colorN128,colorN256,colorN512,colorN1024,colorN2048;
	ArrayList<JLabel> listLabel;
	private ImageIcon fondo, n2, n4, n8, n16,n32,n64,n128,n256,n512,n1024,n2048;
	/**
	 * Create the panel.
	 */
	

	public TableroGrafico(int cantDeFila) {
		
		this.tablero= new Tablero(cantDeFila);
		int[][] matrizTablero= this.tablero.getTablero(); //la voy a usar solo para inicializar los JLabel
		this.CANT_DE_FILAS_Y_COLUMNA= matrizTablero.length;/*
		this.colorTablero= new Color(252,181,255);
		this.colorN2=new Color(248,91,255);
		this.colorN4=new Color(181,67,187);
		this.colorN8=new Color(187,67,123);
		this.colorN16=new Color(215,39,121);
		this.colorN32=new Color(173,0,32);
		this.colorN64=new Color(140,5,32);
		this.colorN128=new Color(184,58,81);
		this.colorN256=new Color(77,60,187);
		this.colorN512=new Color(115,100,216);
		this.colorN1024=new Color(100,161,216);
		this.colorN2048=new Color(52,150,183);*/
		this.listLabel= new ArrayList<JLabel>();
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
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLayout(new GridLayout(CANT_DE_FILAS_Y_COLUMNA, CANT_DE_FILAS_Y_COLUMNA, 0, 0)); //defino la cantidad de filas y colum que va a tener el layout
		
		for(int  [] fila: matrizTablero) {
			for(int  elem : fila) {
				JLabel elemento; //defino el label nuevo
				elemento = new JLabel("");
				/*if(Integer.toString(elem).toString().equals("0")) {
					elemento = new JLabel("");//si es 0, lo creo sin texto
				}
				else {
					elemento = new JLabel(Integer.toString(elem));//sino con el elem
				}*/
				elemento.setOpaque(true); //le permito ser opaco asi le puedo poner color
				if(Integer.toString(elem).toString().equals("0")) {
					//elemento.setBackground(this.colorTablero);	
					elemento.setIcon(this.fondo);
				}
				if(Integer.toString(elem).toString().equals("2")) {
				//	elemento.setBackground(this.colorN2);
					elemento.setIcon(this.n2);
				}
				if(Integer.toString(elem).toString().equals("4")) {
				//	elemento.setBackground(this.colorN4);
					elemento.setIcon(this.n4);
				}
				elemento.setFont(new Font("Tahoma", Font.PLAIN, 80)); //Forma 
				elemento.setHorizontalAlignment(SwingConstants.CENTER); //Centramos los numeros 
				elemento.setBorder(new LineBorder(Color.PINK, 4)); //Borde
				add(elemento); //agrego el elem al panel
				this.listLabel.add(elemento); //lo agrego al arraylist
			}
		}
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
	
	public void actualizar() {
		this.tablero.puedeSumar();//va a actualizar el game over del tablero logico
		ArrayList<Integer> tableroArray= this.tablero.matrizToArray();
	    int indice= 0;
		for(JLabel elem: this.listLabel) {
			if(tableroArray.get(indice).toString().equals("0")) {
				//elem.setBackground(this.colorTablero);
				elem.setIcon(this.fondo);
			}
			if(tableroArray.get(indice).toString().equals("2")) {
				//elem.setBackground(this.colorN2);
				elem.setIcon(this.n2);
			}
			if(tableroArray.get(indice).toString().equals("4")) {
				//elem.setBackground(this.colorN4);
				elem.setIcon(this.n4);
			}
			if(tableroArray.get(indice).toString().equals("8")) {
				//elem.setBackground(this.colorN8);
				elem.setIcon(this.n8);
			}
			if(tableroArray.get(indice).toString().equals("16")) {
				//elem.setBackground(this.colorN16);	
				elem.setIcon(this.n16);
			}
			if(tableroArray.get(indice).toString().equals("32")) {
				//elem.setBackground(this.colorN32);
				elem.setIcon(this.n32);
			}
			if(tableroArray.get(indice).toString().equals("64")) {
				//elem.setBackground(this.colorN64);
				elem.setIcon(this.n64);
			}
			if(tableroArray.get(indice).toString().equals("128")) {
				//elem.setBackground(this.colorN128);
				elem.setIcon(this.n128);
			}
			if(tableroArray.get(indice).toString().equals("256")) {
				//elem.setBackground(this.colorN256);
				elem.setIcon(this.n256);
			}
			if(tableroArray.get(indice).toString().equals("512")) {
				//elem.setBackground(this.colorN512);
				elem.setIcon(this.n512);
			}
			if(tableroArray.get(indice).toString().equals("1024")) {
				//elem.setBackground(this.colorN1024);
				elem.setIcon(this.n1024);
			}
			if(tableroArray.get(indice).toString().equals("2048")) {
				//elem.setBackground(this.colorN2048);
				elem.setIcon(this.n2048);
			}
			/*
			if(tableroArray.get(indice).toString().equals("0")) {
				elem.setText("");
			}
			else {
				elem.setText(tableroArray.get(indice).toString());
			}*/
			indice++;
		}
	}
	
	public boolean perdioElJuego() {
		return this.tablero.getGameOver();
	}
}


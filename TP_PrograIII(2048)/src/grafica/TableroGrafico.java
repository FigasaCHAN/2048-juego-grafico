package grafica;

import javax.swing.JPanel;

import logica.Tablero;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

public class TableroGrafico extends JPanel {
	Tablero tablero;
	final int CANT_DE_FILAS_Y_COLUMNA;
	final Color colorTablero,colorN2,colorN4;
	/**
	 * Create the panel.
	 */
	public TableroGrafico() {
		int[][] matrizTablero= new int [][]{  //creo la matriz provisoria aca
			{2,0,0,2},
			{0,0,0,2},
			{0,0,0,0},
			{0,0,0,0},
		};
		this.CANT_DE_FILAS_Y_COLUMNA= matrizTablero.length;
		this.tablero= new Tablero(matrizTablero);
		this.colorTablero= new Color(252,181,255);
		this.colorN2=new Color(248,91,255);
		this.colorN4=new Color(181,67,187);


		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLayout(new GridLayout(CANT_DE_FILAS_Y_COLUMNA, CANT_DE_FILAS_Y_COLUMNA, 0, 0)); //defino la cantidad de filas y colum que va a tener el layout


		for(int  [] fila: matrizTablero) {
			for(int  elem : fila) {
				JLabel elemento; //defino el label nuevo
				if(Integer.toString(elem).toString().equals("0")) {
					elemento = new JLabel("");//si es 0, lo creo sin texto
				}
				else {
					elemento = new JLabel(Integer.toString(elem));//sino con el elem
				}
				elemento.setOpaque(true); //le permito ser opaco asi le puedo poner color
				if(Integer.toString(elem).toString().equals("0")) {
					elemento.setBackground(this.colorTablero);	
				}
				if(Integer.toString(elem).toString().equals("2")) {
					elemento.setBackground(this.colorN2);
				}
				if(Integer.toString(elem).toString().equals("4")) {
					elemento.setBackground(this.colorN4);
				}
				elemento.setFont(new Font("Tahoma", Font.PLAIN, 80));

				add(elemento); //agrego el elem al panel

			}
		}
	}
}

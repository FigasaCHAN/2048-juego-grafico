package multimedia;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Fuente {
	private Font forn; 
	public String pixel= "Pixel.ttf"; //nombre del archivo de la fuente
	
	public Font generarFuente(String nombreFuente, int tamanio) { //recibe el nombre de la fuente y el tamanio
		InputStream is= getClass().getResourceAsStream(nombreFuente); //busca el archivo en el paquete 
		try {//pruba si esta
			this.forn= Font.createFont(Font.TRUETYPE_FONT, is); //crea la fuente
		} catch (Exception ex ) { //si no la encuentra 
			System.err.println(nombreFuente + "no se pudo cargar la fuente");
			this.forn = new Font("Tahoma", Font.PLAIN,(int)tamanio); //devuelve una predeterminada 
		}
		Font tFuente= this.forn.deriveFont(Font.PLAIN, tamanio); //modifica la fuente y le asigna el tamanio y su estilo
		return tFuente;
	}
}

package logica;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Menu {
	
	private static boolean contieneNumeros(String nombre) {
		
		for(char caracter:nombre.toCharArray()) {
		   if( Character.isDigit(caracter)) {
			   return true;
		   }	
		}
		return false;
	}
	
	public static boolean validarNombreJugador(String nombre) {
		
		if(nombre.contains(" ") || contieneNumeros(nombre) || nombre.isEmpty()) {
			return false;
		}else {
			
			return true;
		}
	}

}

package logica;

public class Menu {

	public static boolean validarNombreJugador(String nombre) {
		
		if(nombre.contains(" ") || tieneCaracteresNoValidos(nombre) || nombre.isEmpty()) {
			return false;
		}else {		
			return true;
		}
	}

	private static boolean tieneCaracteresNoValidos(String nombre) {
		
		for(char caracter:nombre.toCharArray()) {
		   if(!Character.isLetter(caracter) || Character.isDigit(caracter)) {
			   return true;
		   }	
		}
		return false;
	}

}

package logica;

public class Main {

	public void empezarJuego(Tablero tablero) {
		
	}
	
	
	public static void main(String[] args) {
		Tablero tablero=new Tablero();
		
//		empezarJuego(tablero);
		
		System.out.println(tablero.toString());
		tablero.movimientoUsuario("izquierda");
		System.out.println(tablero.toString());
	}

}

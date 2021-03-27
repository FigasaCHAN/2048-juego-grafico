package logica;

public class Main {

	public void empezarJuego(Tablero tablero) {
		
	}
	
	
	public static void main(String[] args) {
		int[][] mat= { {0,2,2,4},
				{2,4,8,4},
				{32,32,32,2},
				{8,4,4,8}
		};

		Tablero tablero=new Tablero(mat);
		
//		empezarJuego(tablero);
		
		System.out.println(tablero.toString());
		//tablero.moverArriba();
//		tablero.moverDerecha();
//		//tablero.movimientoUsuario("derecha");
////		System.out.println(tablero.toString());
////		tablero.moverDerecha();
////		System.out.println(tablero.toString());
////		tablero.moverAbajo();
////		System.out.println(tablero.toString());
			tablero.movimientoUsuario("izquierda");
			System.out.println(tablero.toString());
			tablero.movimientoUsuario("derecha");
			System.out.println(tablero.toString());
			
	}
	

}

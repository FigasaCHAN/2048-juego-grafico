package logica;

public class Main {

	public void empezarJuego(Tablero tablero) {
		
	}
	
	
	public static void main(String[] args) {
		int[][] mat= { {4,4,2,0},
				{2,4,4,2},
				{64,64,64,2},
				{8,0,8,16}
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
		tablero.movimientoUsuario("derecha");
		System.out.println(tablero.toString());
			tablero.movimientoUsuario("izquierda");
			System.out.println(tablero.toString());
			
	}
	

}

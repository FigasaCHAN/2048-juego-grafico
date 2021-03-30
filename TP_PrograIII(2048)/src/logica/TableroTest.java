package logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TableroTest {
	private Tablero tablero,tableroAComparar;
	
	@Before
	public void test() {
		/*para hacer el test no hay que insertar el random*/
		int[][] matriz= { {0,2,2,4},
				{2,4,8,4},
				{32,32,32,2},
				{8,4,4,8}
		};
		//tablero=new Tablero(matriz);
	}
	
	@Test
	public void moverDerechaTest() {
		 tableroAComparar=new Tablero(new int[][]{ 
			{0,0,4,4},
			{2,4,8,4},
			{0,32,64,2},
			{0,8,8,8}
		});
		
		//tablero.moverDerecha();
		

		//assertEquals(tableroAComparar.toString(),tablero.toString());
	}
	
	@Test
	public void moverIzquierdaTest() {
		 tableroAComparar=new Tablero(new int[][]{ 
			{4,4,0,0},
			{2,4,8,4},
			{64,32,2,0},
			{8,8,8,0}
		});
		
		//tablero.moverIzquierda();
		

		//assertEquals(tableroAComparar.toString(),tablero.toString());
	}

}

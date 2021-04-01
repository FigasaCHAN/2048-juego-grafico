package logica;

import static org.junit.Assert.*;
import logica.Menu;
import org.junit.Test;

public class MenuTest {

	@Test
	public void nombreVacioTest() {
		
		assertFalse(Menu.validarNombreJugador(""));
	}
	
	@Test
	public void nombreConNumerosTest() {
		
		assertFalse(Menu.validarNombreJugador("Pepito1"));
	}
	
	@Test
	public void nombreConEspacioVacioTest() {
		
		assertFalse(Menu.validarNombreJugador(" "));
	}
	
	@Test
	public void nombreValidoTest() {	
		assertTrue(Menu.validarNombreJugador("Ejemplo"));
	}

}

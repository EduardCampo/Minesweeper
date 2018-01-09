package minesweeper;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

class ExploratoryTesting {
	
	// Test exploratori
	// Hi ha comentaris de tot el que s'ha anat pensant
	// i trobant durant el test per facilitar el seguiment
	@Test
	void test() {
		// Nova instància board per testejar
		Board board = new Board();
		
		// Nova instància utilities per testejar
		Utilities util = new Utilities();
		
		// Iniciem la simulació de inputs
		ByteArrayInputStream in;
		
		// Només entrar es demana el nombre de mines que volem posar
		// Si escric algo que no sigui un nombre, hauria de controlar-se
		in = new ByteArrayInputStream("error!error!".getBytes());
		System.setIn(in);
		assertEquals(0,util.getNumberOfMines());
		
		// Perfecte, em torna demanar un altre input
		// I si intento posar més mines de les que hi caben?
		in = new ByteArrayInputStream("100".getBytes());
		System.setIn(in);
		assertEquals(0,util.getNumberOfMines());
		
		// També m'ho torna a demanar, fantàstic
		// Li direm doncs que volem 6 mines
		in = new ByteArrayInputStream("6".getBytes());
		System.setIn(in);
		assertEquals(6,util.getNumberOfMines());
	}

}

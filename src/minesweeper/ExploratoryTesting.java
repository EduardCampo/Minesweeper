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
		// Nova inst�ncia board per testejar
		Board board = new Board();
		
		// Nova inst�ncia utilities per testejar
		Utilities util = new Utilities();
		
		// Iniciem la simulaci� de inputs
		ByteArrayInputStream in;
		
		// Nom�s entrar es demana el nombre de mines que volem posar
		// Si escric algo que no sigui un nombre, hauria de controlar-se
		in = new ByteArrayInputStream("error!error!".getBytes());
		System.setIn(in);
		assertEquals(0,util.getNumberOfMines());
		
		// Perfecte, em torna demanar un altre input
		// I si intento posar m�s mines de les que hi caben?
		in = new ByteArrayInputStream("100".getBytes());
		System.setIn(in);
		assertEquals(0,util.getNumberOfMines());
		
		// Altre cop em demana un altre input
		// I si vull posar mines negatives? 
		in = new ByteArrayInputStream("-5".getBytes());
		System.setIn(in);
		assertEquals(0,util.getNumberOfMines());
		
		// Tamb� m'ho torna a demanar, funciona correctament
		// Li direm doncs que volem 6 mines
		in = new ByteArrayInputStream("6".getBytes());
		System.setIn(in);
		assertEquals(6,util.getNumberOfMines());
		
		// Cap problema fins aqui
		// Em demana la posici� x i y de la primera mina
		// I si poso coordenades fora dels l�mits?
		assertFalse(board.placeMine(-3, 10));
		
		// Altre cop em demana que intenti posar la mina 1
		// La posar� a la ubicaci� 1 1
		assertTrue(board.placeMine(1, 1));
		
		// A veure si s'ha posat b�
		assertEquals('M',board.getChar(1, 1));
		
		// Doncs s�, hi ha una mina a la casella 1 1
		
		
	}

}

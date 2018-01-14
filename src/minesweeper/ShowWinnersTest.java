package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShowWinnersTest {
	
	// Test amb el que comprobem que la funcio showWinners escriu els valors correctes
	// (també testeja les funcions que crida showWinners: toString i sortByValue)
	// Com que l'acces a la base de dades no esta implementada, getWinners obté els valors
	// de un mock object de l'objecte que tindria accés a aquesta DB
	@Test
	public void testShowWinners1() {
		
		Utilities util = new Utilities();
		GetWinnersDBMock mock = new GetWinnersDBMock();
		System.out.println("[Expected output]");
		System.out.println("Winner-Wins:");
		System.out.println("Eduard=7");
		System.out.println("Javi=5");
		System.out.println("Robert=4");
		System.out.println("     ");
		System.out.println("[Recieved output]");
		assertEquals(util.showWinners(),3);
	}
}
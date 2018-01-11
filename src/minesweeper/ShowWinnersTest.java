package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShowWinnersTest {
	
	// Test amb el que comprobem que la funcio getWinners escriu els valors correctes
	// Com que l'acces a la base de dades no esta implementar, getWinners obté els valors
	// de un mock object de l'objecte que tindria accés a aquesta DB
	@Test
	public void testShowWinners1() {
		
		Utilities util = new Utilities();
		GetWinnersDBMock mock = new GetWinnersDBMock();
		System.out.println("[Expected output]");
		System.out.println("Winners:");
		System.out.println("Javi");
		System.out.println("Eduard");
		System.out.println("Doctor Cebolla");
		System.out.println("     ");
		System.out.println("[Recieved output]");
		assertEquals(util.showWinners(mock.getWinners()),3);
		String [] winners2 =  {};
		assertEquals(util.showWinners(winners2),0);
		String [] winners3 =  {"Javi"};
		assertEquals(util.showWinners(winners3),1);
		String [] winners4 =  {"Javi","Eduard"};
		assertEquals(util.showWinners(winners4),2);
	}
}
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
		util.showWinners(mock.getWinners());
	}
}
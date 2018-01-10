package minesweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShowWinnersTest {

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
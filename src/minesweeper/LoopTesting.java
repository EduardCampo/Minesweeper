package minesweeper;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class LoopTesting {

	@Test
	public void ShowWinnersTest() {
		Utilities util = new Utilities();
		String [] winners =  {"Javi","Eduard","Doctor Cebolla"};
		assertEquals(util.showWinners(winners),3);
		String [] winners2 =  {"Javi"};
		assertEquals(util.showWinners(winners2),1);
		String [] winners3 =  {"Javi","Eduard"};
		assertEquals(util.showWinners(winners3),2);
		String [] winners4 =  {};
		assertEquals(util.showWinners(winners4),0);
	}



}

package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTestCaixaBlanca {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	// Decision testing a la classe placeMine
	// Les decisions 1 i 2 estan especificades a la classe
	// Comprovem a més que s'ha fet el que toca amb ajuda
	// de la classe getChar 
	@Test
	void placeMineDecisonTest() {
		Board board = new Board();
		// 1 - True
		assertFalse(board.placeMine(-1,0));
		// 1 - False
		// 2 - True
		board.placeMine(1,1);
		assertEquals(board.getChar(1,1),'M');
		assertFalse(board.placeMine(1,1));
		assertEquals(board.getChar(1,1),'M');
		// 1 - False
		// 2 - False
		// Else
		assertTrue(board.placeMine(0,0));
		assertEquals(board.getChar(0,0),'M');
	}
	
	// Decision testing a la classe flagLogic
	// Les decisions 1, 2, 3 i 4 estan especificades a la classe
	@Test
	void flagLogicDecisonTest() {
		Board board = new Board();
		board.setChar(0, 0, 'M');
		// 1 - True
		assertEquals('F',board.flagLogic(0,0));
		// 1 - False
		// 2 - True
		board.setChar(0, 0, 'O');
		assertEquals('I',board.flagLogic(0,0));
		// 1,2 - False
		// 3 - True
		board.setChar(0, 0, 'F');
		assertEquals('M',board.flagLogic(0,0));
		// 1,2,3 - False
		// 4 - True
		board.setChar(0, 0, 'I');
		assertEquals('O',board.flagLogic(0,0));
		// 1,2,3,4 - False
		// Else
		board.setChar(0, 0, '7');
		assertEquals('*',board.flagLogic(0,0));
	}
	
	// Condition testing a la classe gameWon
	// Les condicions són:
	// M - Troba una M al taulell
	// I - Troba una I al taulell
	@Test
	void gameWonConditionTest() {
		Board board = new Board();
		// M - False
		// I - False
		assertTrue(board.gameWon());
		board.setChar(1, 1, '8'); board.setChar(6, 7, 'U');
		board.setChar(4, 9, 'S'); board.setChar(4, 4, 'O');
		assertTrue(board.gameWon());
		// M - True
		board.setChar(7, 7, 'M');
		assertFalse(board.gameWon());
		// I - True
		board.setChar(7, 7, 'I');
		assertFalse(board.gameWon());
	}
	
	// Condition testing a la classe wrongPosition de utils
	// Les condicions son:
	// 1 - x < 0
	// 2 - y < 0
	// 3 - x > 9
	// 4 - y > 9
	@Test
	void wrongPositionConditionTest() {
		Utilities util = new Utilities();
		// 1 - True
		// 2,3,4 - False
		assertTrue(util.wrongPosition(-1, 5));
		// 2 - True
		// 1,3,4 - False
		assertTrue(util.wrongPosition(5, -1));
		// 3 - True
		// 1,2,4 - False
		assertTrue(util.wrongPosition(10, 5));
		// 4 - True
		// 1,2,3 - False
		assertTrue(util.wrongPosition(5, 10));
		// 1,2 - True
		// 3,4 - False
		assertTrue(util.wrongPosition(-2, -2));
		// 3,4 - True
		// 1,2 - False
		assertTrue(util.wrongPosition(11, 11));
		// 1,2,3,4 - False
		assertFalse(util.wrongPosition(7, 4));
		
	}

}

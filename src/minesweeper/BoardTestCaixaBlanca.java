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
		// 2 - False  (anem al else)
		assertTrue(board.placeMine(0,0));
		assertEquals(board.getChar(0,0),'M');
	}

}

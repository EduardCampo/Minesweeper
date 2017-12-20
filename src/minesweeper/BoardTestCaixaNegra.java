package minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTestCaixaNegra {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	// Tests de valors límit a la classe placeMine
	// També testeja getChar que retorna el valor 
	// de la casella indicada o * en cas d'error
	@Test
	void placeMineBorderTest() {
		Board board = new Board();
		//mine set correctly
		assertTrue(board.placeMine(0,0)); assertEquals(board.getChar(0,0),'M');
		assertTrue(board.placeMine(1,0)); assertEquals(board.getChar(1,0),'M');
		assertTrue(board.placeMine(0,1)); assertEquals(board.getChar(0,1),'M');
		assertTrue(board.placeMine(9,9)); assertEquals(board.getChar(9,9),'M');
		assertTrue(board.placeMine(9,8)); assertEquals(board.getChar(9,8),'M');
		assertTrue(board.placeMine(8,9)); assertEquals(board.getChar(8,9),'M');
		//mine already there
		assertFalse(board.placeMine(0,0)); assertEquals(board.getChar(0,0),'M');
		assertFalse(board.placeMine(1,0)); assertEquals(board.getChar(1,0),'M');
		assertFalse(board.placeMine(9,9)); assertEquals(board.getChar(9,9),'M');
		assertFalse(board.placeMine(8,9)); assertEquals(board.getChar(8,9),'M');
		//index error
		assertFalse(board.placeMine(0,-1));  assertEquals(board.getChar(0,-1),'*');
		assertFalse(board.placeMine(-1,0));  assertEquals(board.getChar(-1,0),'*');
		assertFalse(board.placeMine(-1,-1)); assertEquals(board.getChar(-1,-1),'*');
		assertFalse(board.placeMine(10,9));  assertEquals(board.getChar(10,9),'*');
		assertFalse(board.placeMine(9,10));  assertEquals(board.getChar(9,10),'*');
		assertFalse(board.placeMine(10,10)); assertEquals(board.getChar(10,10),'*');
	}
	
	
	
	

}




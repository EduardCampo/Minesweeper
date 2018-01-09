package minesweeper;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class BoardTestCaixaNegra {

	//@Before
	//public void setUp() throws Exception {}
	
	// Tests de valors límit a la classe placeMine
	// També testeja getChar que retorna el valor 
	// de la casella indicada o * en cas d'error
	@Test
	public void placeMineBorderTest() {
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
	
	// Tests de valors límit a la classe setFlag
	// També testeja getChar que retorna el valor 
	// de la casella indicada o * en cas d'error
	@Test
	public void placeFlagBorderTest() {
		Board board = new Board();
		
		//flag set correctly
		assertTrue(board.setFlag(0,0)); assertEquals(board.getChar(0,0),'I');
		assertTrue(board.setFlag(1,0)); assertEquals(board.getChar(1,0),'I');
		assertTrue(board.setFlag(0,1)); assertEquals(board.getChar(0,1),'I');
		assertTrue(board.setFlag(9,9)); assertEquals(board.getChar(9,9),'I');
		assertTrue(board.setFlag(9,8)); assertEquals(board.getChar(9,8),'I');
		assertTrue(board.setFlag(8,9)); assertEquals(board.getChar(8,9),'I');
		
		//flag already there
		assertTrue(board.setFlag(0,0)); assertEquals(board.getChar(0,0),'·');
		assertTrue(board.setFlag(1,0)); assertEquals(board.getChar(1,0),'·');
		assertTrue(board.setFlag(9,9)); assertEquals(board.getChar(9,9),'·');
		assertTrue(board.setFlag(8,9)); assertEquals(board.getChar(8,9),'·');
		
		//mine under flag
		board = new Board();
		assertTrue(board.placeMine(0,0));
		assertTrue(board.setFlag(0,0)); assertEquals(board.getChar(0,0),'F');
		assertTrue(board.placeMine(1,0));
		assertTrue(board.setFlag(1,0)); assertEquals(board.getChar(1,0),'F');
		assertTrue(board.placeMine(0,1));
		assertTrue(board.setFlag(0,1)); assertEquals(board.getChar(0,1),'F');
		assertTrue(board.placeMine(9,9));
		assertTrue(board.setFlag(9,9)); assertEquals(board.getChar(9,9),'F');
		assertTrue(board.placeMine(9,8));
		assertTrue(board.setFlag(9,8)); assertEquals(board.getChar(9,8),'F');
		assertTrue(board.placeMine(8,9));
		assertTrue(board.setFlag(8,9)); assertEquals(board.getChar(8,9),'F');
		
		//index error
		board = new Board();
		assertFalse(board.setFlag(0,-1));  assertEquals(board.getChar(0,-1),'*');
		assertFalse(board.setFlag(-1,0));  assertEquals(board.getChar(-1,0),'*');
		assertFalse(board.setFlag(-1,-1)); assertEquals(board.getChar(-1,-1),'*');
		assertFalse(board.setFlag(10,9));  assertEquals(board.getChar(10,9),'*');
		assertFalse(board.setFlag(9,10));  assertEquals(board.getChar(9,10),'*');
		assertFalse(board.setFlag(10,10)); assertEquals(board.getChar(10,10),'*');
		
	}
	
	// Varis tests per mirar quantes mines hi ha al
	// voltant d'una casella específica
	@Test
	public void checkMinesAroundTest() {
		Board board = new Board();
		// Test del cuadrant 4,4
		assertEquals(0,board.checkMinesAround(4, 4));
		board.setChar(3, 3, 'F');
		assertEquals(1,board.checkMinesAround(4, 4));
		board.setChar(3, 4, 'F');
		assertEquals(2,board.checkMinesAround(4, 4));
		board.setChar(3, 5, 'M');
		assertEquals(3,board.checkMinesAround(4, 4));
		board.setChar(4, 3, 'M');
		assertEquals(4,board.checkMinesAround(4, 4));
		board.setChar(4, 5, 'F');
		assertEquals(5,board.checkMinesAround(4, 4));
		board.setChar(5, 3, 'F');
		assertEquals(6,board.checkMinesAround(4, 4));
		board.setChar(5, 4, 'F');
		assertEquals(7,board.checkMinesAround(4, 4));
		board.setChar(5, 5, 'M');
		assertEquals(8,board.checkMinesAround(4, 4));
		// Test de la punta 0,0
		assertEquals(0,board.checkMinesAround(0, 0));
		board.setChar(1, 0, 'F');
		assertEquals(1,board.checkMinesAround(0, 0));
		board.setChar(1, 1, 'M');
		assertEquals(2,board.checkMinesAround(0, 0));
		board.setChar(0, 1, 'F');
		assertEquals(3,board.checkMinesAround(0, 0));
		board.setChar(-1, 0, 'F');
		assertEquals(3,board.checkMinesAround(0, 0));
	}
	
	// Comprova que es retornin els valors que toquen
	// a la classe flagLogic
	@Test
	public void flagLogicTest() {
		Board board = new Board();
		board.gameBoard[0][0] = 'M';
		assertEquals(board.flagLogic(0,0),'F');
		board.gameBoard[1][0] = '·';
		assertEquals(board.flagLogic(1,0),'I');
		board.gameBoard[2][0] = 'F';
		assertEquals(board.flagLogic(2,0),'M');
		board.gameBoard[3][0] = 'I';
		assertEquals(board.flagLogic(3,0),'·');
		board.gameBoard[4][0] = '7';
		assertEquals(board.flagLogic(4,0),'*');
	}
	
	
	// Test per veure si s'ha guanyat o no el joc
	// amb la classe gameWon
	@Test
	public void gameWonTest() {
		Board board = new Board();
		assertTrue(board.gameWon());
		board.gameBoard[0][0] = 'M';
		assertFalse(board.gameWon());
		board.gameBoard[0][0] = '·';
		board.gameBoard[1][0] = 'I';
		assertFalse(board.gameWon());
		
	}
	
	@Test
	public void getCharTest() {
		Board board = new Board();
		char[][] gameBoardTest = new char[10][10];
		
		assertEquals(board.getChar(0, -1),'*');
		assertEquals(board.getChar(10, -1),'*');
		assertEquals(board.getChar(10, 0),'*');
		assertEquals(board.getChar(0, -1),'*');
		assertEquals(board.getChar(0, -1),'*');
		assertEquals(board.getChar(0, -1),'*');
		for(int i=0; i<10;i++) {
			for (int j=0; j<10; j++) {
				gameBoardTest[i][j] = '·';
			}
		}
		assertArrayEquals(board.gameBoard,gameBoardTest);
		
	}
	
	@Test
	public void openSquareTest() {
		Board board = new Board();
		assertFalse(board.openSquare(0, -1));
		assertFalse(board.openSquare(-1, 0));
		assertFalse(board.openSquare(0, 10));
		assertFalse(board.openSquare(10, 0));
		assertFalse(board.openSquare(10, -1));
		assertTrue(board.openSquare(9, 9));
		assertTrue(board.openSquare(0, 0));
		assertTrue(board.openSquare(5, 5));
		assertTrue(board.openSquare(0, 9));
		
	}
	
	@Test
	public void setCharTest() {
		Board board = new Board();
		assertFalse(board.setChar(0, -1,'F'));
		assertFalse(board.setChar(-1, 0,'F'));
		assertFalse(board.setChar(0, 10,'F'));
		assertFalse(board.setChar(10, 0,'F'));
		assertFalse(board.setChar(10, -1,'F'));
		assertTrue(board.setChar(9, 9,'F'));
		assertTrue(board.setChar(0, 0,'F'));
		assertTrue(board.setChar(5, 5,'F'));
		assertTrue(board.setChar(0, 9,'F'));
		char[][] gameBoardTest = new char[10][10];
		gameBoardTest[9][9] = 'F';
		gameBoardTest[0][0] = 'F';
		gameBoardTest[5][5] = 'F';
		gameBoardTest[0][9] = 'F';
		assertEquals(board.gameBoard[9][9],gameBoardTest[9][9]);
		assertEquals(board.gameBoard[0][0],gameBoardTest[0][0]);
		assertEquals(board.gameBoard[5][5],gameBoardTest[5][5]);
		assertEquals(board.gameBoard[0][9],gameBoardTest[0][9]);
		
	}
	
	@Test
	public void wrongPositionTest() {
		Utilities util = new Utilities();
		assertTrue(util.wrongPosition(0, -1));
		assertTrue(util.wrongPosition(-1, 0));
		assertTrue(util.wrongPosition(0, 10));
		assertTrue(util.wrongPosition(10, 0));
		assertTrue(util.wrongPosition(10, -1));
		assertFalse(util.wrongPosition(9, 9));
		assertFalse(util.wrongPosition(0, 0));
		assertFalse(util.wrongPosition(5, 5));
		assertFalse(util.wrongPosition(0, 9));
	}	
	
	@Test
	public void getNumberOfMinesTest() {
		
		int guess;
		ByteArrayInputStream in;
		Utilities util = new Utilities();
		
		in = new ByteArrayInputStream("1".getBytes());
	    System.setIn(in);
		guess = util.getNumberOfMines();
		assertEquals(guess,1);
		
		in = new ByteArrayInputStream("99".getBytes());
	    System.setIn(in);
		guess = util.getNumberOfMines();
		assertEquals(guess,99);
		
		in = new ByteArrayInputStream("11".getBytes());
	    System.setIn(in);
		guess = util.getNumberOfMines();
		assertEquals(guess,11);
		
		in = new ByteArrayInputStream("0".getBytes());
	    System.setIn(in);
		guess = util.getNumberOfMines();
		assertEquals(guess,0);
		
		in = new ByteArrayInputStream("100".getBytes());
	    System.setIn(in);
		guess = util.getNumberOfMines();
		assertEquals(guess,0);
		
		in = new ByteArrayInputStream("-1".getBytes());
	    System.setIn(in);
		guess = util.getNumberOfMines();
		assertEquals(guess,0);
		
		in = new ByteArrayInputStream("hey".getBytes());
	    System.setIn(in);
		guess = util.getNumberOfMines();
		assertEquals(guess,0);
		
	}
	
	@Test
	public void getPositionInputTest() {
		
		int check[];
		ByteArrayInputStream in;
		Utilities util = new Utilities();
		
		in = new ByteArrayInputStream("0 0".getBytes());
	    System.setIn(in);
		check = new int[] {0,0};
		assertArrayEquals(check,util.getPositionInput());
		
		in = new ByteArrayInputStream("9 9".getBytes());
	    System.setIn(in);
		check = new int[] {9,9};
		assertArrayEquals(check,util.getPositionInput());
		
		in = new ByteArrayInputStream("hey".getBytes());
	    System.setIn(in);
		check = new int[] {-1,-1};
		assertArrayEquals(check,util.getPositionInput());
		
	}
	
	@Test
	public void getOptionTest() {
		
		ByteArrayInputStream in;
		Utilities util = new Utilities();
		
		in = new ByteArrayInputStream("1".getBytes());
	    System.setIn(in);
		assertEquals(util.getOption(),1);
		
		in = new ByteArrayInputStream("2".getBytes());
	    System.setIn(in);
		assertEquals(util.getOption(),2);
		
		in = new ByteArrayInputStream("3".getBytes());
	    System.setIn(in);
		assertEquals(util.getOption(),0);
		
		in = new ByteArrayInputStream("-1".getBytes());
	    System.setIn(in);
		assertEquals(util.getOption(),0);
		
		in = new ByteArrayInputStream("hey".getBytes());
	    System.setIn(in);
		assertEquals(util.getOption(),0);
		
	}

}




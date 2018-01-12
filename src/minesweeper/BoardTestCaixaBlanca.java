package minesweeper;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class BoardTestCaixaBlanca {

	// 1
	// Decision testing a la classe placeMine
	// Les decisions 1 i 2 estan especificades a la classe
	// Comprovem a més que s'ha fet el que toca amb ajuda
	// de la classe getChar 
	@Test
	public void placeMineDecisonTest() {
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
	
	// 2
	// Decision testing a la classe flagLogic
	// Les decisions 1, 2, 3 i 4 estan especificades a la classe
	@Test
	public void flagLogicDecisonTest() {
		Board board = new Board();
		board.setChar(0, 0, 'M');
		// 1 - True
		assertEquals('F',board.flagLogic(0,0));
		// 1 - False
		// 2 - True
		board.setChar(0, 0, '·');
		assertEquals('I',board.flagLogic(0,0));
		// 1,2 - False
		// 3 - True
		board.setChar(0, 0, 'F');
		assertEquals('M',board.flagLogic(0,0));
		// 1,2,3 - False
		// 4 - True
		board.setChar(0, 0, 'I');
		assertEquals('·',board.flagLogic(0,0));
		// 1,2,3,4 - False
		// Else
		board.setChar(0, 0, '7');
		assertEquals('*',board.flagLogic(0,0));
	}
	
	// 3
	// Decision testing a la classe getRoundSquare
	// Les decisions són del 0 al 7 com es veu a la classe
	// S'assumeix que si un és True, els anteriors són False
	@Test
	public void getRoundSquareDecisonTest() {
		Utilities util = new Utilities();
		int[] xy = new int[2];
		// 0 - True;
		xy[0] = 3; xy[1] = 5;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 0));
		// 1 - True;
		xy[0] = 4; xy[1] = 5;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 1));
		// 2 - True;
		xy[0] = 5; xy[1] = 5;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 2));
		// 3 - True;
		xy[0] = 3; xy[1] = 4;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 3));
		// 4 - True;
		xy[0] = 5; xy[1] = 4;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 4));
		// 5 - True;
		xy[0] = 3; xy[1] = 3;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 5));
		// 6 - True;
		xy[0] = 4; xy[1] = 3;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 6));
		// 7 - True;
		xy[0] = 5; xy[1] = 3;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 7));
		// Else (ERROR)
		xy[0] = -2; xy[1] = -2;
		assertArrayEquals(xy, util.getRoundSquare(4, 4, 85));
	}
	
	// 4
	// Decision testing a la classe checkMinesAround
	// Les decisions i el seu nom es veuen a la classe
	// La entrada està controlada abans de cridar la funció,
	// per tant no es poden entrar valors xy incorrectes 
	@Test
	public void checkMinesAroundDecisionTest() {
		Board board = new Board();
		// 1,2 - False
		// 3 - True
		assertEquals(0,board.checkMinesAround(0, 0));
		// 1 - False
		// 2,3 - True
		board.setChar(0, 0, 'M');
		assertEquals(1,board.checkMinesAround(1, 1));
		// 1,2 - True
		// 3 - False
		board.setChar(0, 1, 'F');
		board.setChar(2, 2, 'F');
		assertEquals(3,board.checkMinesAround(1, 1));
		
	}
	
	// 5
	// Condition testing a la classe gameWon
	// Les condicions són:
	// M - Troba una M al taulell
	// I - Troba una I al taulell
	@Test
	public void gameWonConditionTest() {
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
	
	// 6
	// Condition testing a la classe wrongPosition de utils
	// Les condicions son:
	// 1 - x < 0
	// 2 - y < 0
	// 3 - x > 9
	// 4 - y > 9
	@Test
	public void wrongPositionConditionTest() {
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

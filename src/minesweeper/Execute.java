package minesweeper;

import java.util.Scanner;

public class Execute {
	
	private static Utilities util = new Utilities();
	
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		board.printBoard();		
		board.setMines(util.getNumberOfMines());
		board.printBoard();
	}
	
}

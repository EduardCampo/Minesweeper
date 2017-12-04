package minesweeper;

import java.util.Collections;

public class Board {
	
	private char[][] gameBoard = new char[10][10];
	
	public Board() {
		for(int i=0; i<10;i++) {
			for (int j=0; i<10; i++) {
				gameBoard[i][j] = '0';
			}
		}
	}

	
	public void printBoard(){
		System.out.print("  ");
		System.out.println();
		for (int i = -1; i < gameBoard.length; i++) {
			if (i == -1){System.out.print("   ");}
			if (i >= 0){System.out.println();System.out.print(i + "  ");}
		    for (int j = 0; j < gameBoard[0].length; j++) {
		    	if (i == -1) { System.out.print(j + "  ");}
		    	else {System.out.print(gameBoard[i][j] + " ");}
		    }
		    System.out.println();
		}
		System.out.println();
	}
}

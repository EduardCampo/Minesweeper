package minesweeper;

public class Board {
	
	private char[][] gameBoard = new char[10][10];
	private static Utilities util = new Utilities();
	
	public Board() {
		for(int i=0; i<10;i++) {
			for (int j=0; j<10; j++) {
				gameBoard[i][j] = '0';
			}
		}
		
	}
	
	public char getChar(int x,int y) {
		if (util.wrongPosition(x, y)) {
			return '*';
		}
		return gameBoard[x][y];
	}

	
	public void printBoard() {
		System.out.print("  ");
		System.out.println();
		for (int i = -1; i < gameBoard.length; i++) {
			if (i == -1){System.out.print("   ");}
			if (i == 0){System.out.println();}
			if (i >= 0){System.out.print(i + "  ");}
		    for (int j = 0; j < gameBoard.length; j++) {
		    	if (i == -1) { System.out.print(j + " ");}
		    	else {System.out.print(gameBoard[i][j] + " ");}
		    } 
		    System.out.println();
		}
		System.out.println();
	}
	
	public void setMines(int nMines) {
		int[] xy = new int[2];
		boolean check;
		for (int i = 0; i < nMines; i++) {
			check = false;
			while (!check) {
				check = true;
				System.out.println("Set the mine " + (i+1) + " position: x y");
				xy = util.getPositionInput();
				check = placeMine(xy[0],xy[1]);			
			}
		}
	}
	
	public boolean placeMine(int x, int y) {
		if (util.wrongPosition(x, y)) {
			System.out.println("Index Error");
			return false;
		} else if (gameBoard[x][y] == 'M') { 
			System.out.println("Mine there already");
			return false;
		} else {
			gameBoard[x][y] = 'M';
			System.out.println("Mine set correctly");
			return true;
		}
	}
	
}

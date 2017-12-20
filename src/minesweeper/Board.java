package minesweeper;

public class Board {
	
	
	// Codis del taulell
	// O - Sense mines al voltant
	// 1-8 - Amb X mines al voltant
	// M - Mina
	// F - Bandera sobre una Mina
	// I - Bandera on no hi ha Mina
	// X - Mina explotada
	
	private char[][] gameBoard = new char[10][10];
	private static Utilities util = new Utilities();
	
	/**
	 * Constructor per defecte que inicia la matriu
	 * sencera al car�cter 'O'
	 */
	public Board() {
		for(int i=0; i<10;i++) {
			for (int j=0; j<10; j++) {
				gameBoard[i][j] = 'O';
			}
		}
		
	}
	
	/**
	 * Retorna el car�cter de la posici� x, y de la
	 * matriu especificat
	 * @param x
	 * @param y
	 * @return caracter del taulell o * si index error
	 */
	public char getChar(int x,int y) {
		if (util.wrongPosition(x, y)) {
			return '*';
		}
		return gameBoard[x][y];
	}

	/**
	 *  Mostra la matriu de car�cters tal com est�
	 */
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
	
	/**
	 *  M�tode final per jugar de veritat, s'amaguen les
	 *  mines i tampoc s'indica si les banderes estan ben
	 *  posades al taulell
	 */
	public void printBoardFINAL() {
		System.out.print("  ");
		System.out.println();
		for (int i = -1; i < gameBoard.length; i++) {
			if (i == -1){System.out.print("   ");}
			if (i == 0){System.out.println();}
			if (i >= 0){System.out.print(i + "  ");}
		    for (int j = 0; j < gameBoard.length; j++) {
		    	if (i == -1) { System.out.print(j + " ");}
		    	else {
		    		if (gameBoard[i][j] == 'M') {
		    			
		    		}
		    		System.out.print(gameBoard[i][j] + " ");
		    	}
		    } 
		    System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Funci� que itera per posar nMines al taulell
	 * @param nMines nombre de mines a posar
	 */
	public void setMines(int nMines) {
		int[] xy = new int[2];
		boolean check;
		for (int i = 0; i < nMines; i++) {
			check = false;
			while (!check) {
				System.out.println("Set the mine " + (i+1) + " position: x y");
				xy = util.getPositionInput();
				check = placeMine(xy[0],xy[1]);			
			}
		}
	}
	
	/**
	 * Funci� que posa una mina al taulell, dona error si
	 * els �ndex son incorrectes o si ja hi ha una mina all�
	 * @param x
	 * @param y
	 * @return true si s'ha posat la mina, false si no
	 */
	public boolean placeMine(int x, int y) {
		if (util.wrongPosition(x, y)) { // Decision 1
			return false;
		} else if (gameBoard[x][y] == 'M') { // Decision 2
			System.out.println("Mine there already");
			return false;
		} else { 
			gameBoard[x][y] = 'M';
			System.out.println("Mine set correctly");
			return true;
		}
	}
	
	/**
	 * Posa una bandera al taulell, dona error si no s'hi pot
	 * posar una bandera 
	 * Crida flagLogic per saber com ha de quedar la casella
	 */
	public void setFlag() {
		int[] xy = new int[2];
		int x = 0; int y = 0;
		char ch = '*';
		do {
			System.out.println("Where do you want to set/remove a flag?");
			xy = util.getPositionInput();
			x = xy[0]; y = xy[1];
			if (!util.wrongPosition(x, y)){
				ch = flagLogic(x, y);
			} 
		} while (ch == '*');
		gameBoard[x][y] = flagLogic(x, y);
	} 
	
	/**
	 * Mira com ha de quedar una casella despr�s de que es
	 * vulgui posar o treure una bandera. Retorna * si no 
	 * es pot posar una bandera en aquella casella
	 * @param x
	 * @param y
	 * @return car�cter a posar a la funci� setFlag
	 */
	public char flagLogic(int x, int y) {
		if (gameBoard[x][y] == 'M') {
			return 'F';
		} else if (gameBoard[x][y] == 'O'){
			return 'I';
		} else if (gameBoard[x][y] == 'F'){
			return 'M';
		} else if (gameBoard[x][y] == 'I'){
			return 'O';
		} else {
			System.out.println("Can't flag this square");
			return '*';
		}
	}
	
	/**
	 * Mira si totes les banderes estan ben posades, o sigui:
	 * No hi ha cap M ni cap I
	 * @return
	 */
	public boolean gameWon() {
		return true;
	}
}

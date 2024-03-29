package minesweeper;

import java.io.IOException;

public class Board {
	
	
	// Codis del taulell
	// � - Sense obrir
	// - - Sense mines al voltant
	// 1-8 - Amb X mines al voltant
	// M - Mina
	// F - Bandera sobre una Mina
	// I - Bandera on no hi ha Mina
	// X - Mina explotada
	
	char[][] gameBoard = new char[10][10];
	private static Utilities util = new Utilities();
	boolean gameLost = false;
	
	/**
	 * Constructor per defecte que inicia la matriu
	 * sencera al car�cter 'O'
	 */
	public Board() {
		for(int i=0; i<10;i++) {
			for (int j=0; j<10; j++) {
				gameBoard[i][j] = '�';
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
	 * Introdueix el car�cter c a les posicions x i y
	 * de la gameboard
	 * @param x
	 * @param y
	 * @param c
	 * @return true si l'ha posat, false si no ha pogut
	 */
	public boolean setChar(int x,int y, char c) {
		if (util.wrongPosition(x, y)) {
			return false;
		}
		gameBoard[x][y] = c;
		return true;
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
	public void printBoardPlayer() {
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
		    			System.out.print("� ");
		    		} else if (gameBoard[i][j] == 'I') {
		    			System.out.print("F ");
		    		} else {
		    			System.out.print(gameBoard[i][j] + " ");
		    		}
		    	}
		    } 
		    System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Funci� que itera per posar nMines al taulell
	 * @param nMines nombre de mines a posar
	 * @throws IOException 
	 */
	public void setMines(int nMines) throws IOException {
		int[] xy = new int[2];
		boolean check;
		for (int i = 0; i < nMines; i++) {
			check = false;
			while (!check) {
				System.out.println("Set the mine " + (i+1) + " position: x y");
				AutomaticTesting.nextIn(); // COMENTAR
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
			System.out.println("Not a valid position");
			return false;
		} else if (gameBoard[x][y] == 'M') { // Decision 2
			System.out.println("Mine there already");
			return false;
		} else { // Else
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
	public boolean setFlag(int x, int y) {	
		if (util.wrongPosition(x, y)){
			System.out.println("Not a valid position");
			return false;
		}
		gameBoard[x][y] = flagLogic(x, y);
		return true;
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
		if (gameBoard[x][y] == 'M') { // Decision 1
			return 'F';
		} else if (gameBoard[x][y] == '�'){ // Decision 2
			return 'I';
		} else if (gameBoard[x][y] == 'F'){ // Decision 3
			return 'M';
		} else if (gameBoard[x][y] == 'I'){ // Decision 4
			return '�';
		} else { // Else
			System.out.println("Can't flag this square");
			return getChar(x,y);
		}
	}
	
	/**
	 * Mira si totes les banderes estan ben posades, o sigui:
	 * No hi ha cap M ni cap I
	 * @return
	 */
	public boolean gameWon() {
		for (int i = 0; i < gameBoard.length; i++) {
		    for (int j = 0; j < gameBoard.length; j++) {
		    	if (gameBoard[i][j] == 'M' || gameBoard[i][j] == 'I') {
		    		return false;
		    	}
		    }
		}
		return true;
	}

	/**
	 * Obre una casella del taulell, si es troba una mina crida
	 * la funci� GameOver
	 * @return
	 */
	public boolean openSquare(int x, int y) {
		if (!util.wrongPosition(x, y)){
			if (gameBoard[x][y] == 'M' || gameBoard[x][y] == 'F') {
				gameLost = true;
				return true;
			}
			checkMinesAround(x, y);
			return true;
		} else {
			System.out.println("Not a valid position");
			return false;
		}
	}
	
	/**
	 * Funci� cridada per openSquare que conta les mines que hi ha
	 * al voltant per posar tal nombre a la casella corresponent
	 * Si no hi ha cap mina al voltant es passa a realitzar una
	 * execuci� recursiva de la funci� openSquare mitjan�ant una
	 * crida pr�via a la funci� setupRecursive
	 * @param x
	 * @param y
	 * @return
	 */
	public int checkMinesAround(int x, int y) {
		int[] xy = new int[2];
		int x2; int y2;
		int minesAround = 0;
		for (int i = 0; i < 8; i++) {
			xy = util.getRoundSquare(x, y, i);
			x2 = xy[0]; y2 = xy[1];
			if (!util.wrongPosition(x2, y2)){ // Decision 1
				if (gameBoard[x2][y2] == 'M' || gameBoard[x2][y2] == 'F') { // Decision 2
					minesAround++;
				}
			}
		}
		if (minesAround == 0) { // Decision 3
			gameBoard[x][y] = '-';
			setupRecursive(x, y);
		} else {
			gameBoard[x][y] = (char)(minesAround + 48);
		}
		return minesAround;
	}
	
	/**
	 * Recursiu per a les caselles buides, perque s'obrin les
	 * del seu voltant fins a acabar amb un nombre
	 * @param x
	 * @param y
	 */
	public void setupRecursive(int x, int y) {
		int[] xy = new int[2];
		int x2; int y2;
		for (int i = 0; i < 8; i++) {
			xy = util.getRoundSquare(x, y, i);
			x2 = xy[0]; y2 = xy[1];
			if (!util.wrongPosition(x2, y2)){
				if (gameBoard[x2][y2] != '-') {
					checkMinesAround(x2, y2);
				}
			}
		}
	}
	
	/**
	 * Acaba el joc mostrant totes les mines i parant l'execuci�
	 * del programa abruptament
	 */

}

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
	 * sencera al caràcter 'O'
	 */
	public Board() {
		for(int i=0; i<10;i++) {
			for (int j=0; j<10; j++) {
				gameBoard[i][j] = 'O';
			}
		}
		
	}
	
	/**
	 * Retorna el caràcter de la posició x, y de la
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
	 *  Mostra la matriu de caràcters tal com està
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
	 *  Métode final per jugar de veritat, s'amaguen les
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
	 * Funció que itera per posar nMines al taulell
	 * @param nMines nombre de mines a posar
	 */
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
	
	/**
	 * Funció que posa una mina al taulell, dona error si
	 * els índex son incorrectes o si ja hi ha una mina allà
	 * @param x
	 * @param y
	 * @return true si s'ha posat la mina, false si no
	 */
	public boolean placeMine(int x, int y) {
		if (util.wrongPosition(x, y)) { // Decision 1
			System.out.println("Index Error");
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
	 * Posa F si hi ha una mina allà o I en cas contrari
	 */
	public void setFlag() {
		int[] xy = new int[2];
		int x; int y;
		boolean check = false;
		while (!check) {
			xy = util.getPositionInput();
			x = xy[0]; y = xy[1];
			if (!util.wrongPosition(x, y)){
				if (gameBoard[x][y] == 'M') {
					gameBoard[x][y] = 'F';
					check = true;
				} else if (gameBoard[x][y] == 'O'){
					gameBoard[x][y] = 'I';
					check = true;
				} else {
					System.out.println("Can't flag this square");
				}
			}
		}
	}
}

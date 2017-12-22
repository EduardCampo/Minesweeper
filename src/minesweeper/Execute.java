package minesweeper;

public class Execute {
	
	private static Utilities util = new Utilities();
	
	/**
	 * Classe principal de la execució del joc
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		boolean gameOver = false;
		Board board = new Board();
		board.printBoard();		
		board.setMines(util.getNumberOfMines());
		while (!gameOver) {
			menu(board);
			gameOver = board.gameWon();
		}
		System.out.println("YOU WIN");
	}
	
	/**
	 * Escriu i demana una input al usuari mitjançant la
	 * funció getOption de utils
	 * Repeteix el menú fins que l'usuari escriu una opció
	 * correcta, i aleshores crida la funció corresponent
	 * @param board
	 */
	public static void menu(Board board) {
		boolean check = false;
		int option;
		do {
			// THIS IS THE DEBUG PRINT BOARD
			//board.printBoard();
			// THIS IS THE REAL PLAYER PRINT BOARD
			board.printBoardPlayer();
			option = util.getOption();
			if (option == 1) {
				check = true;
				board.openSquare();
			} else if (option == 2) {
				check = true;
				board.setFlag();
			} 
		} while (!check);
	}
	
}

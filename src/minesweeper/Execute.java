package minesweeper;

public class Execute {
	
	private static Utilities util = new Utilities();
	
	/**
	 * Classe principal de la execuci� del joc
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		int checkm = 0;
		boolean gameOver = false;
		Board board = new Board();
		board.printBoard();	
		while (checkm==0) {
			checkm = util.getNumberOfMines();			
		}
		board.setMines(checkm);
		while (!gameOver) {
			menu(board);
			gameOver = board.gameWon();
		}
		System.out.println("YOU WIN");
	}
	
	/**
	 * Escriu i demana una input al usuari mitjan�ant la
	 * funci� getOption de utils
	 * Repeteix el men� fins que l'usuari escriu una opci�
	 * correcta, i aleshores crida la funci� corresponent
	 * @param board
	 */
	public static void menu(Board board) {
		boolean check = false;
		int option;
		int[] xy = new int[2];
		int x; 
		int y;
		boolean error = false;
		do {
			// THIS IS THE DEBUG PRINT BOARD
			//board.printBoard();
			// THIS IS THE REAL PLAYER PRINT BOARD
			board.printBoardPlayer();
			option = util.getOption();
			
			if (option == 1) {
				check = true;
				error = false;
				
				do {
					System.out.println("What square do you want to open?");
					xy = util.getPositionInput();
					x = xy[0]; y = xy[1];
					error = board.openSquare(x,y);
				} while (error == false);
				
			} else if (option == 2) {
				check = true;
				error = false;
				
				do {
					System.out.println("Where do you want to set/remove a flag?");								
					xy = util.getPositionInput();
					x = xy[0]; y = xy[1];
					error = board.setFlag(x,y);
				} while (error == false);
			}
		} while (!check);
	}
	
}

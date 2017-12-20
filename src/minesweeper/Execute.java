package minesweeper;

public class Execute {
	
	private static Utilities util = new Utilities();
	
	public static void main(String[] args) throws Exception{
		boolean gameOver = false;
		Board board = new Board();
		board.printBoard();		
		board.setMines(util.getNumberOfMines());
		while (!gameOver) {
			menu(board);
		}
	}
	
	public static void menu(Board board) {
		boolean check = false;
		int option;
		do {
			board.printBoard();
			option = util.getOption();
			if (option == 1) {
				check = true;
			} else if (option == 2) {
				check = true;
				board.setFlag();
			} 
		} while (!check);
	}
	
}

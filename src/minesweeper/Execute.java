package minesweeper;

import java.util.Scanner;

public class Execute {

	public static void main(String[] args) throws Exception{
		Board board = new Board();
		Scanner key; int nMines = 1;
		boolean check = false;
		board.printBoard();
		
		while (!check) {
			try {
				System.out.println("How many mines do you want?");
				key = new Scanner(System.in);
				nMines = key.nextInt();
				if (nMines > 0 && nMines < 100) {
					check = true;
				} else {
					System.out.println("Please enter a number between 1 and 99");
				}
			} catch(Exception e) {
				System.out.println("Char error");
			}
		}
		board.setMines(nMines);
		
		board.printBoard();
	}
	
}

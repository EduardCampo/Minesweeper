package minesweeper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Execute {
	
	private static Utilities util = new Utilities();
	private static AutomaticTesting aTest = new AutomaticTesting();
	/**
	 * Classe principal de la execució del joc
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		
		//AutomaticTesting.setupTest(1); //Sets up the first test
		//AutomaticTesting.setupTest(2); //Sets up the second test
		//AutomaticTesting.setupTest(3); //Sets up the third test
		//AutomaticTesting.setupTest(4); //Sets up the fourth test
		
		int checkm = 0;
		boolean gameWon = false; boolean gameLost = false;
		Board board = new Board();
		board.printBoard();	
		while (checkm==0) {
			AutomaticTesting.nextIn();
			checkm = util.getNumberOfMines();			
		}
		board.setMines(checkm);
		while (!gameWon && !gameLost) {
			AutomaticTesting.nextIn();
			menu(board);
			gameWon = board.gameWon();
			gameLost = board.gameLost;
		}
		if (gameWon) {
			System.out.println("YOU WIN");
		} else if (gameLost) {
			System.out.println("YOU LOST");
		}
		
	}
	
	/**
	 * Escriu i demana una input al usuari mitjançant la
	 * funció getOption de utils
	 * Repeteix el menú fins que l'usuari escriu una opció
	 * correcta, i aleshores crida la funció corresponent
	 * @param board
	 * @throws IOException 
	 */
	public static void menu(Board board) throws IOException {
		boolean check = false;
		int option;
		int[] xy = new int[2];
		int x; 
		int y;
		boolean error = false;
		do {

			board.printBoard(); // THIS IS THE DEBUG PRINT BOARD
			//board.printBoardPlayer(); // THIS IS THE REAL PLAYER PRINT BOARD
			option = util.getOption();
			
			if (option == 1) {
				check = true;
				error = false;
				
				do {
					System.out.println("What square do you want to open?");
					AutomaticTesting.nextIn(); // COMENTAR
					xy = util.getPositionInput();
					x = xy[0]; y = xy[1];
					error = board.openSquare(x,y);
				} while (error == false);
				
			} else if (option == 2) {
				check = true;
				error = false;
				
				do {
					System.out.println("Where do you want to set/remove a flag?");	
					AutomaticTesting.nextIn(); // COMENTAR
					xy = util.getPositionInput();
					x = xy[0]; y = xy[1];
					error = board.setFlag(x,y);
				} while (error == false);
			}
		} while (!check);
	}
	
}

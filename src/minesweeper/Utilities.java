package minesweeper;

import java.util.Scanner;

public class Utilities {
	
	/**
	 * Comprova si els índex són fora dels límits del taulell
	 * @param x
	 * @param y
	 * @return true si index error, flase si són correctes
	 */
	public boolean wrongPosition(int x, int y) {
		if (x < 0 || y < 0 || x > 9 || y > 9) {
			System.out.println("Index Error");
			return true;
		}
		return false;
	}
	
	/**
	 * Funció per demanar al usuari el nombre de mines que vol
	 * introduïr al taulell
	 * @return nombre de mines a col·locar
	 */
	public int getNumberOfMines() {
		Scanner key;
		int nMines = 1;
		boolean check = false;
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
		return nMines;
	}
	
	/**
	 * Demana al usuari les posicions x i y d'una casella del taulell
	 * Es fa servir sempre que es necessita aquest input
	 * del usuari (posar una mina, bandera o obrir casella)
	 * @return array de int on (0 -> x) i (1 -> y)
	 */
	public int[] getPositionInput() {
		int[] xy = new int[2];
		int x; int y;
		Scanner key = new Scanner(System.in);
		try {
			xy[0] = key.nextInt();
			xy[1] = key.nextInt();
		} catch(Exception e) {
			System.out.println("Char Error");
			xy[0] = -1;
			return xy;
		}
		return xy;	
	}
	
	/**
	 * Demana al usuari quina opció que vol triar
	 * @return 1 si vol revelar una casella
	 * 		   2 si vol posar o treure una bandera
	 */
	public int getOption() {
		int option = 0;
		System.out.println("Select what you want to do:");
		System.out.println("1 - Open square");
		System.out.println("2 - Set/Remove flag");
		Scanner k = new Scanner(System.in);
		try {
			option = k.nextInt();
		} catch(Exception e) {
			System.out.println("Option error");
		}
		if (option != 1 && option != 2) {
			System.out.println("Invalid Option");
			option = 0;
		}
		return option;
	}
	
}

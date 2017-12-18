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
		if (x < 0 || y < 0 || x > 9 || y > 9) return true;
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
	 * Funció per demanar al usuari les posicions x i y
	 * d'una casella del taulell
	 * Es fa servir sempre que es necessita aquest input
	 * del usuari (posar una mina, bandera o obrir casella)
	 * @return array de int on (0 -> x) i (1 -> y)
	 */
	public int[] getPositionInput() {
		int[] xy = new int[2];
		Scanner key = new Scanner(System.in);
		try {
			xy[0] = key.nextInt() - 1;
			xy[1] = key.nextInt() - 1;
		} catch(Exception e) {
			System.out.println("Char Error");
			xy[0] = -1;
			key.close();
			return xy;
		}
		key.close();
		return xy;	
	}
}

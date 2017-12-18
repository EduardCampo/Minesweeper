package minesweeper;

import java.util.Scanner;

public class Utilities {
	
	public boolean wrongPosition(int x, int y) {
		if (x < 0 || y < 0 || x > 9 || y > 9) return true;
		return false;
	}
	
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

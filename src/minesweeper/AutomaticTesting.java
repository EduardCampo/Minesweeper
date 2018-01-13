package minesweeper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AutomaticTesting {
	
	
	private static File file;
	private static FileReader f; 
	private static BufferedReader b;
	
	public static void setupTest(int test) throws Exception{
		if (test == 1) {
			file = new File("winGameTest1.txt");
		} else if (test == 2) {
			file = new File("winGameTest2.txt");
		} else if (test == 3) {
			file = new File("loseGameTest1.txt");
		} else if (test == 4) {
			file = new File("loseGameTest2.txt");
		}
		f = new FileReader(file);
		b = new BufferedReader(f);
	}
	
	public static void nextIn() throws IOException {
		if (b != null) {
			String input = b.readLine();
			ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
		}
	}
}

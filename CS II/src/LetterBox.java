// Iris T
// CS 2 Summer 2022-2023
// LetterBox and FailPass Exercises
// Prints boxes of letters, using information from a separate file
// LetterBox
// 6/30/22

import java.util.*;
import java.io.*;

public class LetterBox {
	
	/*
	 * Scans LetterBox.txt and prints out the specified letter boxes
	 */
	public static void main(String[] args) {
		Scanner scan= null;
		try {
			scan = new Scanner(new File("C:\\Users\\irist\\eclipse-workspace\\CS II\\src\\LetterBox.txt"));
			int lines = scan.nextInt();
			for (int i = 0; i < lines; i++) {
				String str = scan.next();
				int times = scan.nextInt();
				for (int r = 0; r < times; r++) {
					for (int c = 0; c < times; c++) {
						System.out.print(str);
					}
					System.out.println();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}

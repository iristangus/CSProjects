// Iris T
// CS 2 Summer 2022-2023
// 2-D Array Assignment
// Prints words from another file in an hourglass shape
// FancyWord
// 6/30/22

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class FancyWord {
	
	/*
	 * Scans FancyWord.txt for the words, then uses an array and nested loops to print them in an hourglass shape
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("C:\\Users\\irist\\eclipse-workspace\\CS II\\src\\FancyWord.txt"));
			int numData = scan.nextInt();
			String[][] word = new String[numData][];
			
			for (int r = 0; r < numData; r++) {
				String str = scan.next();
				word[r] = new String[str.length()];
				for (int c = 0; c < str.length(); c++) {
					word[r][c] = str.substring(c, c+1);
				}
			}
			
			for (String[] ray: word) {
				for (int i = 0; i < Array.getLength(ray); i++) {
					System.out.print(ray[i]);
				}
			
				if (Array.getLength(ray) > 1) {
					System.out.println();
					for (int i = 1; i < Array.getLength(ray) - 1; i++) {
						for (int j = 0; j < Array.getLength(ray); j++) {
							if (i == j || i + j == Array.getLength(ray) - 1) {
								System.out.print(ray[j]);
							} else {
								System.out.print(" ");
							}
						
						}
					System.out.println();
					
					}
				
				for (int i = 0; i < Array.getLength(ray); i++) {
					System.out.print(ray[i]);
				}
				
			}
			System.out.println("\n\n");
		}
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}

}
}

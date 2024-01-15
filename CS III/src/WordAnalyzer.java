// Iris T
// CS 3 Summer 2022-2023
// SortByLength Exercise
// Sorts an array of Word objects
// WordAnalyzer
// 7/12/22

import java.io.*;
import java.util.*;

public class WordAnalyzer {
	
	/*
	 * Scans the file
	 * Creates a Word array and adds new Word objects to it
	 * Sorts the Word array
	 * Prints the sorted array
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		Scanner scan = null;	
		try {
			// Scans file and finds number of words
			scan = new Scanner(new File("wordlist.txt"));
			int numWords = scan.nextInt();
			scan.nextLine();
			
			// New Word array
			Word[] wArray = new Word[numWords];
			
			// Scans file and adds new Words to the array
			for (int i = 0; i < numWords; i++) {
				wArray[i] = new Word(scan.nextLine());
			}
			
			// Sorts array
			Arrays.sort(wArray);
			
			// Prints each Word object in the array
			for (Word w: wArray) {
				System.out.println(w.toString());
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("Error reading the file."); 
		} finally {
			scan.close();
		}
	}

}

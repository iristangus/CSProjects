// Iris T
// CS 3 Summer 2022-2023
// Weird Sorting Lab
// Sorts words based on their 2nd and 4th letters
// WeirdSort
// 7/18/22

import java.io.*;
import java.util.*;

public class WeirdSort {

	/*
	 * Scans weirdSort.dat for the strings, then puts them in a string array
	 * Sorts the array using insertion sort, based on the words' 2nd and 4th letters
	 * Prints the sorted string array
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			// Scans the file
			scan = new Scanner(new File("weirdSort.dat"));
			int numWords = scan.nextInt();
			scan.nextLine();
			
			// String array to hold the words
			String[] words = new String[numWords];
			
			// Scans file input into the array
			for(int i = 0; i < numWords; i++) {
				words[i] = scan.nextLine();
			}
			
			// Insertion sort
			// Goes from index 1 to the end (unsorted area)
			for (int i = 1; i < numWords; i++) {
				// Word to be sorted
				String key = words[i];
				// Compares it to every word before it (sorted area)
				for (int j = i - 1; j >= 0; j--) {
					String compared = words[j];
					int difference2 = key.substring(1,2).compareTo(compared.substring(1,2));
					int difference4 = key.substring(3,4).compareTo(compared.substring(3,4));
					// If the key's second letter is before the other word's second letter
					if (difference2 < 0) {
						// The other word is moved up
						words[j+1] = words[j];
						// The key is placed where the other word used to be
						words[j] = key;
					// If the second letters are the same
					} else if(difference2 == 0){
						// The fourth letters are compared
						if (difference4 < 0) {
							words[j+1] = words[j];
							words[j] = key;
						}
					}
				}
				
			}
			
			// Prints the array
			for (int i = 0; i < numWords; i++) {
				System.out.println(words[i]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}

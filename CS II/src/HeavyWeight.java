// Iris T
// CS 2 Summer 2022-2023
// OddNames and HeavyWeight Exercises
// Prints the number of people who are over the weight limit, using information from another file
// HeavyWeight
// 6/30/22

import java.util.*;
import java.io.*;

public class HeavyWeight {
	
	/*
	 * Scans HeavyWeight.txt and prints how many people are over the weight limit
	 */
	public static void main(String[] args) {
		Scanner scan= null;
		try {
			scan = new Scanner(new File("C:\\Users\\irist\\eclipse-workspace\\CS II\\src\\HeavyWeight.txt"));
			int weightLimit = scan.nextInt();
			int numPeople = 0;
			while(scan.hasNextLine()) {
				if (scan.nextInt() > weightLimit) {
					numPeople++;
				}
			}
			System.out.println("The number of people whose weights exceed the limit is:  " + numPeople);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}

// Iris T
// CS 3 Summer 2022-2023
// EvenOdd Exercise
// Sorts a list of numbers into odd and even
// EvenOdd
// 7/19/22

import java.util.*;
import java.io.*;

public class EvenOdd {
	
	/*
	 * Scans oddeven.dat
	 * If a number is odd, adds it to the odd set (same for evens)
	 * Displays the sets of odd and even numbers for each list of numbers
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("oddeven.dat"));
			
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] numAsStr = line.split(" ");
				
				Set<Integer> even = new TreeSet<Integer>();
				Set<Integer> odd = new TreeSet<Integer>();
				
				
				for (String str: numAsStr) {
					int num = Integer.parseInt(str);
					if (num%2 == 0) {
						even.add(num);
					} else {
						odd.add(num);
					}
				}
				
				System.out.println("ODDS : " + odd);
				System.out.println("EVENS : " + even);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}

// Iris T
// CS 3 Summer 2022-2023
// Merge Grade Results
// Using a TreeMap, calculates how many of each grade there are across the classes
// MergeGrade
// 7/19/22

import java.util.*;
import java.io.*;

public class MergeGrade {
	
	/*
	 * Scans each line of merge.txt
	 * If a key isn't in the map yet, adds it
	 * If it already exists, sets the value to the old value + new value
	 * Prints the updated map
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("merge.txt"));
			
			scan.nextInt();
			
			Map<String, Integer> gradebook = new TreeMap<String, Integer>();
			
			while (scan.hasNext()) {
				String grade = scan.next();
				int numStudents = scan.nextInt();
				
				if (!gradebook.containsKey(grade)) {
					gradebook.put(grade, numStudents);
				} else {
					int oldSum = gradebook.get(grade);
					gradebook.put(grade,  numStudents + oldSum);
				}
			}
			
			for (String key : gradebook.keySet()) {
				System.out.println(key + " " + gradebook.get(key));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}

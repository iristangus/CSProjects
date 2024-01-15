// Iris T
// CS 3 Summer 2022-2023
// ClassesList Exercise
// Creates a set of classes offered
// Classes
// 7/19/22

import java.util.*;
import java.io.*;

public class Classes {
	
	/*
	 * Scans classes.txt
	 * Finds the name of the class using string methods
	 * Adds it to the set (no repeats built in)
	 * Displays the set of classes
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("classes.txt"));
			
			Set<String> classesList = new HashSet<String>();
			
			while (scan.hasNext()) {
				String line = scan.nextLine();
				int space = line.indexOf(' ');
				String course = line.substring(space + 1);
				classesList.add(course);
			}
			
			System.out.println(classesList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

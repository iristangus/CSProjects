// Iris T
// CS 2 Summer 2022-2023
// Assignment 2
// Prints a rocket using for loops, whose size can be changed depending on a constant number
// Rocket
// 6/26/22

public class Rocket {
	
	/*
	 * Prints the whole rocket by calling on the other methods
	 */
	public static void main(String[] args) {
		int constant = 3;
		ends(constant);
		separator(constant);
		middleTop(constant);
		middleBottom(constant);
		separator(constant);
		middleBottom(constant);
		middleTop(constant);
		separator(constant);
		ends(constant);
	}
	
	/*
	 * Prints the large triangle at the top and bottom of the rocket
	 */
	public static void ends(int constant) {
		String line = "";
		for (int i = 1; i < constant * 2; i++) {
			
			for (int j = constant * 2 - i; j > 0; j--) {
				line = line + " ";
			}
			
			for (int j = 0; j < i; j++) {
				line = line + "/";
			}
			
			line = line + "**";
			
			for (int j = 0; j < i; j++) {
				line = line + "\\";
			}
			
			System.out.println(line);
			line = "";
		}
	}
	
	/*
	 * Prints the line of symbols between sections of the rocket
	 */
	public static void separator(int constant) {
		String line = "+";
		for (int i = 0; i < constant * 2; i++) {
			line = line + "=*";
		}
		line = line + "+";
		System.out.println(line);
	}
	
	/*
	 * Prints the pattern on the top of the first middle section 
	 * and the bottom of the second middle section of the rocket
	 */
	public static void middleTop(int constant) {
		for (int i = 0; i < constant; i++) {
			String line = "|";
			
			for (int j = constant - 1 - i; j > 0; j--) {
				line = line + ".";
			}
			
			for (int j = i + 1; j > 0; j--) {
				line = line + "/\\";
			}
			
			for (int j = 2 * (constant - 1 - i); j > 0; j--) {
				line = line + ".";
			}
			
			for (int j = i + 1; j > 0; j--) {
				line = line + "/\\";
			}
			
			for (int j = constant - 1 - i; j > 0; j--) {
				line = line + ".";
			}
			
			line = line + "|";
			System.out.println(line);
			line = "";
		}
		
	}
	
	/*
	 * Prints the pattern on the bottom of the first middle section
	 * and the tops of the second middle section of the rocket
	 */
	public static void middleBottom(int constant) {
		for (int i = constant -1; i >= 0; i--) {
			String line = "|";
			
			for (int j = constant - 1 - i; j > 0; j--) {
				line = line + ".";
			}
			
			for (int j = i + 1; j > 0; j--) {
				line = line + "\\/";
			}
			
			for (int j = 2 * (constant - 1 - i); j > 0; j--) {
				line = line + ".";
			}
			
			for (int j = i + 1; j > 0; j--) {
				line = line + "\\/";
			}
			
			for (int j = constant - 1 - i; j > 0; j--) {
				line = line + ".";
			}
			
			line = line + "|";
			System.out.println(line);
			line = "";
		}
	}

}

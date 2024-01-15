// Iris T
// CS 3 Summer 2022-2023
// Check Expressions
// Checks if an expression has valid opening and closing symbols
// Expressions
// 7/19/22

import java.io.*;
import java.util.*;

public class Expressions {
	
	// The opening symbols
	private static ArrayList<String> opening = new ArrayList<String>(Arrays.asList("<", "(", "[", "{"));
	
	// The closing symbols
	private static ArrayList<String> closing = new ArrayList<String>(Arrays.asList(">", ")", "]", "}"));
	
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			// Scans expressions.txt
			scan = new Scanner(new File("expressions.txt"));
			
			int numLines = scan.nextInt();
			scan.nextLine();
			
			// For each line in the file
			for (int i = 0; i < numLines; i++) {
				String line = scan.nextLine();
				
				// Stack to store characters in
				Stack<String> charStack = new Stack<String>();
				
				// For each character in the line
				for (int j = 0; j < line.length(); j++) {
					String character = String.valueOf(line.charAt(j));
					
					// If the character is an opening or closing symbol, does the following:
					// If not, gets ignored
					if (opening.contains(character) || closing.contains(character)) {
						// If the character at the top of the stack is opposite to the character being checked, 
						// it gets removed from the stack
						// If not, it's added to the stack
						if (!charStack.isEmpty() && getOpposite(character).equals(charStack.peek())) {
							charStack.pop();
						} else {
							charStack.push(character);
						}
					}
				}
				
				// If everything in the stack cancelled out, it's a valid expression
				if (charStack.isEmpty()) {
					System.out.println("valid expression");
				} else {
					System.out.println("Invalid expression");
				}

			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		
	}
	
	/*
	 * Returns the corresponding opening symbol to a closing symbol
	 * When a valid pair is being checked, the opening symbol will always be placed in the stack first,
	 * and the closing symbol is the one being checked
	 * 
	 * @param character	a closing symbol
	 * @return its corresponding opening symbol
	 */
	public static String getOpposite(String character) {
		if(closing.contains(character)) {
			int index = closing.indexOf(character);
			return opening.get(index);
		}
		return "null";
	}

}

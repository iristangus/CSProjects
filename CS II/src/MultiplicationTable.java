//Iris T
//CS 2 Summer 2022-2023
//Nested Loops Exercises
//Prints a multiplication table using nested for loops
//MultiplicationTable
//6/28/22

public class MultiplicationTable {
	
	/*
	 * Prints a multiplication table from 3-9 using nested for loops
	 */
	public static void main(String[] args) {
		
		//top row of numbers
		System.out.print("     ");
		for (int h = 3; h <= 9; h++) {
			System.out.print(h + "  ");
		}
		System.out.println();
		
		//divider of hyphens
		System.out.println("------------------------");
		
		//multiplication table
		for (int i = 3; i <= 9; i++) {
			System.out.print(i + "|  ");
			//fixes spacing for first row
			if (i==3) {
				System.out.print(" ");
			}
			for (int j = 3; j <= 9; j++) {
				System.out.print(j*i + " ");
			}
			System.out.println();
		}
	}

}

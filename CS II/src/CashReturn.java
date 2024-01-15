// Iris T
// CS 2 Summer 2022-2023
// Math Class Exercises
// Takes user input for purchase amount, then prints number & type of coins needed for change
// CashReturn
// 6/23/22

import java.util.Scanner;

public class CashReturn {
	
	/*
	 * Receives user input for purchase amount and goes through each coin type 
	 * to determine the number needed for change
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the amount of purchase: ");
		float purchase = scan.nextFloat();
		
		int change = Math.round((1 - purchase % 1) * 100) % 100;
		
		int numQ = change / 25;
		change = change - 25 * numQ;
		
		int numD = change/10;
		change = change - 10 * numD;
		
		int numN = change/5;
		change = change - 5 * numN;
		
		int numP = change;
		
		System.out.println("Your change is: Q: " + numQ + "  D: " + numD + 
				"  N: " + numN + "  P: " + numP);
	}

}

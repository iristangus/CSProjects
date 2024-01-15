// Iris T
// CS 2 Summer 2022-2023
// If else if statement exercises
// Given the number of CDs purchased, calculates discount and final price
// CDDiscount
// 6/24/22

import java.util.Scanner;

public class CDDiscout {
	
	/*
	 * Takes user input for number of CDs, then calculates discount and final price
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of CDs bought: ");
		int numCD = scan.nextInt();
				
		double discount = 0;
		
		if (numCD >= 15 && numCD <= 49) {
			discount = numCD * 0.01;
		}else if (numCD >= 50 && numCD <= 119) {
			discount = numCD * 0.05;
		}else if (numCD >= 120) {
			discount = numCD * 0.1;
		}
		
		double price = numCD - discount;
		
		System.out.println("Your discount is $" + discount + " and your final price is: $" + price);
		
	}

}

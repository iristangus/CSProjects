// Iris T
// CS 2 Summer 2022-2023
// If else if statement exercises
// Given the quantity purchased, calculates the discounted price
// SoftwareDiscount
// 6/24/22

import java.util.Scanner;

public class SoftwareDiscount {

	/*
	 * Takes user input for quantity purchased and calculates the discounted price
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the quantity: ");
		int numPackages = scan.nextInt();
		
		double price = numPackages * 99;
		
		if (numPackages >= 10 && numPackages <= 19) {
			price = price * 0.8;
		}else if (numPackages >= 20 && numPackages <= 49) {
			price = price * 0.7;
		}else if (numPackages >= 50 && numPackages <= 99) {
			price = price * 0.6;
		}else if (numPackages >= 100) {
			price = price * 0.5;
		}
		
		System.out.println("Your discounted price is: $" + price);
	}

}

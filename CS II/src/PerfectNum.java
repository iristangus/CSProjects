//Iris T
//CS 2 Summer 2022-2023
//Perfect Number Lab
//Determines whether a number is perfect or not
//PerfectNum
//6/28/22

import java.util.Scanner;

public class PerfectNum {

	/*
	 * Finds the factors of the number and sums them, then determines whether the sum is equal to the number
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number: ");
		int num = scan.nextInt();
		
		int i = 1, sum = 0;
		
		while (i < num) {
			if (num%i == 0) {
				sum = sum + i;
			}
			i++;
		}
		
		if (sum == num) {
			System.out.println(num + " is perfect.");
		} else {
			System.out.println(num + " is not perfect.");
		}

	}

}

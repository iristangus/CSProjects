//Iris T
//CS 2 Summer 2022-2023
//Nested Loops Exercises
//Prints all the prime numbers between two given numbers
//PrimeNumbers
//6/28/22

import java.util.Scanner;

public class PrimeNumbers {
	
	/*
	 * Given two numbers, prints all primes between them using nested for loops
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//user input
		System.out.println("Enter the starting number: ");
		int num1 = scan.nextInt();
		
		System.out.println("Enter the ending number: ");
		int num2 = scan.nextInt();
		
		//printing
		System.out.print("The prime numbers between " + num1 + " and " + num2 + " are: ");
		
		//finds primes using nested for loops
		for (int i = num1; i <= num2; i++) {
			//prevents 1 from being counted as a prime
			if (i == 1) {
				continue;
			}
			boolean isPrime = true;
			//tests divisibility
			for (int j = 2; j < i; j++) {
				if (i%j == 0) {
					isPrime = false;
				}
			}
			if (isPrime == true) {
				System.out.print(i + " ");
			}
		}
	}

}

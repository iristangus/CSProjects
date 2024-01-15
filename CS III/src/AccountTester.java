// Iris T
// CS 3 Summer 2022-2023
// SortByBalance Exercise
// Sorts an array of Account objects by balance
// AccountTester
// 7/12/22

import java.util.*;
import java.io.*;

public class AccountTester {
	
	/*
	 * Scans the file
	 * Creates an Account array and adds new Account objects to it
	 * Sorts the Account array
	 * Prints the sorted array
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			// Scans the file and finds how many customers there are
			scan = new Scanner(new File("customers.txt"));
			int numCustomers = scan.nextInt();
			scan.nextLine();
			
			// Creates an Account array
			Account[] accountArray = new Account[numCustomers];
			
			// Scans file and adds new Account objects to the array
			for (int i = 0; i < numCustomers; i++) {
				String f = scan.next();
				String l = scan.next();
				int b = (int) scan.nextDouble();
				scan.nextLine();
				
				accountArray[i] = new Account(f, l, b);
			}
			
			// Sorts the array
			Arrays.sort(accountArray);
			
			// Prints the sorted array
			for (Account a: accountArray) {
				System.out.printf("%-10s", a.getFirstName());
				System.out.printf("%-10s", a.getLastName());
				System.out.printf("%10s", a.getBalance());
				System.out.println();
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("Error reading the file."); 
		} finally {
			scan.close();
		}
	}

}

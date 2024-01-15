// Iris T
// CS 2 Summer 2022-2023
// Social Security Lab
// Given a Social Security number with two hyphens, separates and sums the numeric pieces
// SocialSecurity
// 6/24/22

import java.util.Scanner;

public class SocialSecurity {
	
	/*
	 * Depending on the number of hyphens, returns either the sum of the pieces or -1
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Social Security Number: ");
		String ssn = scan.nextLine();
		
		int hyphen1 = ssn.indexOf('-');
		int hyphen2 = ssn.lastIndexOf('-');
		
		if(hyphen1 == -1 || hyphen1 == hyphen2) {
			
			System.out.println("SS# " + ssn + " has a total of -1");		
			
		} else {
			
			int piece1 = Integer.parseInt(ssn.substring(0, hyphen1));
			int piece2 = Integer.parseInt(ssn.substring(hyphen1 + 1, hyphen2));
			int piece3 = Integer.parseInt(ssn.substring(hyphen2 + 1));
		
			int total = piece1 + piece2 + piece3;
		
			System.out.println("SS# " + ssn + " has a total of " + total);
		}
	}

}

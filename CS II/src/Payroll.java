// Iris T
// CS 2 Summer 2022-2023
// Payroll Assignment
// Receives input from user and calculates weekly pay
// Payroll
// 6/22/22

import java.util.Scanner;

public class Payroll {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the name: ");
		String name = scan.nextLine();
		
		System.out.println("Enter the number of hours worked: ");
		int numHours = scan.nextInt();
		
		System.out.println("Enter the payrate per hour: ");
		int payrate = scan.nextInt();
		
		double weeklyPay = numHours * payrate;
		
		System.out.println("The weekly pay for " + name + " is: $ "
				+ weeklyPay);
	}

}

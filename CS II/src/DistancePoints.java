// Iris T
// CS 2 Summer 2022-2023
// Math Class Exercises
// Takes user input for the coordinates of two points, then calculates the distance between them
// DistancePoints
// 6/23/22

import java.util.Scanner;

public class DistancePoints {
	
	/*
	 * Takes user input for coordinates and returns distance between points
	 * using the distance formula
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the value of x1: ");
		int x1 = scan.nextInt();
		
		System.out.println("Enter the value of y1: ");
		int y1 = scan.nextInt();
		
		System.out.println("Enter the value of x2: ");
		int x2 = scan.nextInt();
		
		System.out.println("Enter the value of y2: ");
		int y2 = scan.nextInt();
		
		double xDistance = Math.abs(x1 - x2);
		double yDistance = Math.abs(y1 - y2);
		
		double totalDistance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		
		System.out.println("The distance between these two points is: " + totalDistance);
	}

}

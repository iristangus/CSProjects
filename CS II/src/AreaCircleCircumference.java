// Iris T
// CS 2 Summer 2022-2023
// Math Class Exercises
// Takes user input for the radius of a circle, then calculates its circumference and area
// AreaCircleCircumference
// 6/23/22

import java.util.Scanner;

public class AreaCircleCircumference {
	
	/*
	 * Takes user input for radius and returns circumference and area
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double pi = Math.PI;
		
		System.out.println("Enter the radius: ");
		double radius = scan.nextDouble();
		
		double circumference = 2 * pi * radius;
		double area = pi * Math.pow(radius, 2);
		
		System.out.println("The circumference of the circle is: " + circumference);
		System.out.println("The area of the circle is: " + area);
	}

}

// Iris T
// CS 2 Summer 2022-2023
// Scanner and Input Exercises
// Receives base and height from the user and calculates area of a triangle
// AreaTriangle
// 6/22/22

import java.util.Scanner;

public class AreaTriangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the base of the triangle: ");
		int base = scan.nextInt();
		
		System.out.println("Enter the height of the triangle: ");
		int height = scan.nextInt();
		
		double area = base * height * 0.5;
				
		System.out.println("The area of the triangle is: " + area);
	}


}

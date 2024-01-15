//Iris T
//CS 2 Summer 2022-2023
//Class Practice
//Creates objects from the Circle class and prints them out
//CircleTester
//6/29/22

public class CircleTester {
	
	/*
	 * Creates objects and prints their string representations
	 */
	public static void main(String[] args) {
		Circle circle1 = new Circle(5);
		Circle circle2 = new Circle(9);
		Circle circle3 = new Circle(20);
		
		System.out.println(circle1.toString());
		System.out.println(circle2.toString());
		System.out.println(circle3.toString());
	}

}

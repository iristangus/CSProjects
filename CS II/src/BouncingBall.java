// Iris T
// CS 2 Summer 2022-2023
// Assignment 3
// Computes the heights of a certain number of ball bounces
// BouncingBall
// 6/29/22

import java.util.Scanner;

public class BouncingBall {
	
	/*
	 * Calls all the other methods together
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		header();
		double height = height(scan);
		double bounceFactor = bounceFactor(scan);
		int bounceNum = bounceNum(scan);
		System.out.println();
		String totalHeightAndFinalHeight = table(height, bounceFactor, bounceNum);
		totals(totalHeightAndFinalHeight, height);
		
	}
	
	/*
	 * Prints the header
	 */
	public static void header() {
		System.out.println("+-------+");
		System.out.println("|   o   |  This program computes the trajectory");
		System.out.println("|   ^   |  of a vertically bouncing ball.");
		System.out.println("|   |   |");
		System.out.println("+---o---+");
		System.out.println("");
	}
	
	/*
	 * Takes user input for the initial height of the ball
	 * @params: scanner
	 * @return: double of initial height
	 */
	public static double height(Scanner scan) {
		System.out.print("What is the initial height of the ball? ");
		return scan.nextDouble();		
	}
	
	/*
	 * Takes user input for the bounce factor of the ball
	 * @params: scanner
	 * @return: double of bounce factor
	 */
	public static double bounceFactor(Scanner scan) {
		System.out.print("What is the bounce factor of this ball? ");
		return scan.nextDouble();
	}
	
	/*
	 * Takes user input for the number of bounces
	 * @params: scanner
	 * @return: int of number of bounces
	 */
	public static int bounceNum(Scanner scan) {
		System.out.print("How many times should the ball bounce? ");
		return scan.nextInt();
	}
	
	/*
	 * Prints a table with height and height change of each bounce
	 * @params: height, bounce factor, and number of bounces
	 * @return: concatenated string of the total height and the final height
	 */
	public static String table(double h, double bF, int bN) {
		System.out.println("Iteration	Height	Height Change");
		System.out.println("---------	------	-------------");
		double height = h;
		double heightChange = 0;
		//the first height is only counted once, so the -1 prevents overcounting
		double totalHeight = height * -1;
		double nextHeight = 1;
		double finalHeight = 0;
		for (int i = 0; i <= bN; i++) {
			System.out.println(i + "\t\t" + Math.round(height*1000)/1000.0 + "\t" + Math.round(heightChange*1000)/1000.0);
			// calculates height of the ball in the next iteration
			nextHeight = height * bF;
			// if it's the last iteration, the ball never comes down, and the height is only counted once
			// otherwise, each height is added twice
			if (i != bN) {
				totalHeight += 2 * height;
			} else {
				totalHeight += height;
			}
			// calculates heightchange for the next iteration
			heightChange = height - nextHeight;
			// gets final height, which is needed to calculate the total height lost later
			if (i ==bN) {
				finalHeight = height;
			}
			// turns nextHeight into the new height
			height = nextHeight;			
		}
		// concatenating the string and returning it so I can use both the total height and final height
		// in another method
		return totalHeight + " " + finalHeight;
		
	}
	
	/*
	 * Parses the total height and final height, then calculates total height lost and prints them
	 * @params: concatenated string of the total height and final height, double of initial height
	 */
	public static void totals(String str, double height) {
		int space = str.indexOf(' ');
		// parses substring where the totalheight was stored back into a double
		double totalHeight = Double.parseDouble(str.substring(0,space));
		// parses substring where the finalheight was stored back into a double
		double finalHeight = Double.parseDouble(str.substring(space + 1));
		System.out.println("Total distance traveled: " + Math.round(totalHeight*1000)/1000.0);
		//calculates total height lost by subtracting final height from initial height
		System.out.println("Total height lost: " + Math.round((height - finalHeight)*1000)/1000.0);
	}
	
	

}

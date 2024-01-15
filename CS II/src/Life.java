// Iris T
// CS 2 Summer 2022-2023
// Assignment 5
// Simulates Conway's Game of Life
// Life
// 7/6/22

import java.util.*;
import java.awt.*;
import java.io.*;

public class Life {
	
	// Size of pixels on Drawing Panel
	private static final int PIXEL = 5;
	
	
	/*
	 *  Coordinates other methods
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("This program runs Conway's Game of Life");
		
		// User inputs
		String inputFile = userInputFile(scan, "Input file name? ");
		String outputFile = userOutputFile(scan, "Output file name? ");
		int frames = userFrames(scan, "Number of frames to run the simulation (0-5000): ");
		int stepTime = userSteps(scan, "Time between steps in ms (1-5000): ");
		
		scan.close();
		
		
		try {
			// If the simulation works without error
			String[][] world = fileToMatrix(inputFile);
			String[][] newWorld;
			
			DrawingPanel panel = new DrawingPanel(PIXEL * world[0].length, PIXEL * world.length);
			Graphics g = panel.getGraphics();
			
			// Animates simulation
			for (int i = 0; i < frames; i++) {
				// "Erases" Drawing Panel
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, PIXEL * world[0].length, PIXEL * world.length);
				drawFrame(world, panel, g);
				newWorld = nextStep(world);
				// Prevents world from being one frame too far when the loop ends
				if (i != frames-1) {
					world = newWorld;
				}
							
				panel.sleep(stepTime);
			}
			
			output(world, outputFile);
			
			System.out.println("Simulation successful!");
			
		} catch(Exception e) {
			// If there's an error
			System.out.println("Error found in the input file. Halting simulation.");
		}
		
	}
	
	/*
	 * Takes user input for the input file
	 * @param scan	System.in Scanner
	 * @param str	string of user prompt
	 * @return string of name of input file
	 */
	public static String userInputFile(Scanner scan, String str) {
		System.out.print(str);
		// Indefinite loop until something is returned
		for (int i = 1; i > 0; i++) {
			String response = scan.next();
			String[] files = new String[] {"world1.txt", "world2.txt", "world3.txt", "world4.txt", "world5.txt"};
			for (String s: files) {
				// Checks if input file name is valid
				if(s.equals(response)) {
					return response;
				}
			}
			System.out.print("File not found. Try again: ");
		}
		return null;		
	}
	
	/*
	 * Takes user input for the output file
	 * @param scan	System.in Scanner
	 * @param str	string of user prompt
	 * @return string of name of output file
	 */
	public static String userOutputFile(Scanner scan, String str) {
		System.out.print(str);
		String response = scan.next();
		return response;
	}
	
	/*
	 * Takes user input for number of frames
	 * @param scan	System.in Scanner
	 * @param str	string of user prompt
	 * @return number of frames
	 */
	public static int userFrames(Scanner scan, String str) {	
		// Indefinite loop until something is returned
			for (int i = 1; i > 0; i++) {
				System.out.print(str);
				try {
					// If it can scan an integer
					int response = scan.nextInt();
					if (response >= 0 && response<= 5000) {
						return response;
					}
					System.out.println("Your number needs to be between 0 and 5000.");
				} catch (Exception e){
					// If the response isn't an integer
					System.out.println("You must enter an *integer* between 0 and 5000.");
					scan.nextLine();
				} 
					
			}
		return -1;
	}
	
	/*
	 * Takes user input for the number of steps
	 * @param scan	System.in Scanner
	 * @param str	string of user prompt
	 * @return number of steps
	 */
	public static int userSteps(Scanner scan, String str) {
		// Indefinite loop until something is returned
		for (int i = 1; i > 0; i++) {
			System.out.print(str);
			try {
				// If response is a valid int
				int response = scan.nextInt();
				if (response >= 1 && response<= 5000) {
					return response;
				}
				System.out.println("Your number needs to be between 1 and 5000.");
			} catch (Exception e){
				// If response wasn't an int
				System.out.println("You must enter an *integer* between 1 and 5000.");
				scan.nextLine();
			} 
			
		}
		return -1;
	}
	
	/*
	 * Scans input file and converts data to a 2D array
	 * @param str	name of input file
	 * @return 2D array with starting world information
	 */
	public static String[][] fileToMatrix(String str){
		Scanner scan = null;
		try {
			scan = new Scanner(new File(str));
			int rows = scan.nextInt();
			int columns = scan.nextInt();
			// Creates a 2D array with size info from the beginning
			String[][] ray = new String[rows][columns];
			// Scanner moves onto next line, with actual game data
			scan.nextLine();
			for (int i = 0; i < rows; i++) {
				// Scans each line
				String line = scan.nextLine();
				for (int j = 0; j < columns; j++) {
					// Assigns each character to the 2D array
					ray[i][j] = String.valueOf(line.charAt(j));
				}
			}
			return ray;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		return null;
	}
	
	/*
	 * Counts how many live neighbors a cell has
	 * @param ray	2D array with world data
	 * @param r		index of the cell's row
	 * @param c		index of the cell's column
	 * @return number of live neighbors
	 */
	public static int neighbors(String[][] ray, int r, int c) {
		int count = 0;
		// Goes through the three rows around the cell
		for (int i = r-1; i < r+2; i++) {
			// Skips if index is out of bounds
			if (i < 0 || i > ray.length-1) {
				continue;
			}
			// Goes through the three columns around the cell
			for (int j = c-1; j < c+2; j++) {
				// Skips if index is out of bounds
				if (j < 0 || j > ray[r].length-1) {
					continue;
				}
				// Skips if row = column (the cell we are finding the neighbors of)
				if (i == r && j == c) {
					continue;
				}
				if (ray[i][j].equals("x")) {
					count++;
				}
			}
		}	
		return count;
	}
	
	/*
	 * Returns the world after one generation
	 * @param ray	2D array with world data
	 * @return 2D array of the next world
	 */
	public static String[][] nextStep(String[][] ray) {
		// New 2D array the same size as the original
		String[][] newRay = new String[ray.length][ray[0].length];
		// Goes through all the cells, applies game rules
		for (int r = 0; r < ray.length; r++) {
			for (int c = 0; c < ray[0].length; c++) {
				int n = neighbors(ray, r, c);
				if (ray[r][c].equals("x")) {
					if (n < 2 || n > 3) {
						newRay[r][c] = ".";
					} else {
						newRay[r][c] = "x";
					}
				} else {
					if (n == 3) {
						newRay[r][c] = "x";
					} else {
						newRay[r][c] = ".";
					}
				}
			}
		}
		return newRay;
	}
	
	/*
	 * Displays the world on the Drawing Panel
	 * @param ray		2D array with world data
	 * @param panel		DrawingPanl
	 * @param g			Graphics
	 */
	public static void drawFrame(String[][] ray, DrawingPanel panel, Graphics g) {
		g.setColor(Color.BLACK);
		// Goes through each cell and checks if it's alive
		for (int r = 0; r < ray.length; r++) {
			for (int c = 0; c < ray[0].length; c++) {
				if (ray[r][c].equals("x")) {
					// Size is based on class constant PIXEL
					g.fillRect(PIXEL*c, PIXEL*r, PIXEL, PIXEL);
				}
			}
		}
	}
	
	/*
	 * Outputs the final world to a file
	 * @param ray	2D array with world data
	 * @param str	name of the output file
	 */
	public static void output(String[][] ray, String str) {
		// Creates new file
		File outputFile = new File(str);
		try {
			FileWriter w = new FileWriter(outputFile);
			for (int r = 0; r < ray.length; r++) {
				// Goes through all cells and prints them
				for (int c = 0; c < ray[r].length; c++) {
					w.write(ray[r][c]);
				}
				// Linebreak between rows
				w.write("\n");
			}
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
}

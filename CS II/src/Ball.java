// Iris T
// CS 2 Summer 2022-2023
// Assignment 4
// Animates a ball using the drawing panel
// Ball
// 7/4/22

import java.util.*;
import java.awt.*;

public class Ball {
	
	private static final int RADIUS = 10;
	private static final int FRAMERATE = 40;
	private static final int STEPS = 500;
	
	/*
	 * Takes user input for panel width, height, initial x position, y position, x velocity, and y velocity
	 * Creates a new drawing panel and graphics object
	 * Calls upon the animation method with the initial values
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("This program will simulate a ball bouncing in a window");
		int panelW = scannerReturn(scan, "How wide would you like the panel (in pixels)? ");
		int panelH = scannerReturn(scan, "How tall would you like the panel (in pixels)? ");
		int posX = scannerReturn(scan, "What is the initial X position of the ball? ");
		int posY = scannerReturn(scan, "What is the initial Y position of the ball? ");
		int velX = scannerReturn(scan, "What is the initial X velocity of the ball? ");
		int velY = scannerReturn(scan, "What is the initial Y velocity of the ball? ");
		
		DrawingPanel panel = new DrawingPanel(panelW, panelH);
		Graphics g = panel.getGraphics();

		animation(panelW, panelH, posX, posY, velX, velY, g, panel);
	}
	
	/*
	 * Takes user input for an int
	 * @param scanner
	 * @param string description
	 * @return integer
	 */
	public static int scannerReturn(Scanner scan, String str) {
		System.out.print(str);
		return scan.nextInt();
	}
	
	/*
	 * Draws the ball in black, using the class constant radius
	 * @param x position of the ball
	 * @param y position of the ball
	 * @param graphics
	 */
	public static void drawBall(int x, int y, Graphics g) {
		g.setColor(Color.BLACK);
		int d = 2 * RADIUS;
		g.fillOval(x, y, d, d);
	}
	
	/*
	 * "Erases" the ball by filling it in with white
	 * @param x position of the ball
	 * @param y position of the ball
	 * @param graphics
	 */
	public static void eraseBall(int x, int y, Graphics g) {
		g.setColor(Color.WHITE);
		//the circle is one pixel bigger on all sides to prevent a trail
		int d = 2 * RADIUS + 2;
		g.fillOval(x-1, y-1, d, d);
	}
	
	/*
	 * Animates the ball using a for loop
	 * @param panel width
	 * @param panel height
	 * @param initial x position of the ball
	 * @param initial y position of the ball
	 * @param initial x velocity of the ball
	 * @param initial y velocity of the ball
	 * @param graphics
	 * @param drawing panel
	 */
	public static void animation(int panelW, int panelH, int posX, int posY, int velX, int velY, Graphics g, DrawingPanel panel) {
		for (int i = 0; i < STEPS; i++) {
			eraseBall(posX, posY, g);
			// if the ball is at the boundary
			if (posX + 2*RADIUS > panelW || posX < 0) {
				// goes in opposite direction
				velX *= -1;
			}
			if (posY + 2*RADIUS > panelH || posY < 0) {
				velY *= -1;
			}
			// updates positions using velocities
			posX += velX;
			posY += velY;
			drawBall(posX, posY, g);
			panel.sleep(1000/FRAMERATE);
		}
	}

}

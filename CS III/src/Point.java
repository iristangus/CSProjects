// Iris T
// CS 3 Summer 2022-2023
// Point Class Assignment
// Creates Point objects
// Point
// 7/11/22

public class Point {
	
	// x-coord of the point
	private int x;
	
	// y-coord of the point
	private int y;
	
	/*
	 * Default constructor
	 * Sets x and y to 0
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	/*
	 * Constructor that accepts input
	 * 
	 * @param x	x-coord of the point
	 * @param y	y-coord of the point
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Accessor method for the x-coord
	 * 
	 * @return x
	 */
	public int getX() {
		return this.x;
	}
	
	/*
	 * Accessor method for the y-coord
	 * 
	 * @return y
	 */
	public int getY() {
		return this.y;
	}
	
	/*
	 * Modifier method for the x-coord
	 * 
	 * @param x	new x-coord
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/*
	 * Modifier method for the y-coord
	 * 
	 * @param y	new y-coord
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/*
	 * Returns a text representation of the point
	 * 
	 * @return string containing x and y coords
	 */
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

}

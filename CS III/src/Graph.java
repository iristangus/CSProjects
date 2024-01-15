// Iris T
// CS 3 Summer 2022-2023
// Point Class Assignment
// Tests Point objects
// Graph
// 7/11/22

public class Graph {
	
	/*
	 * Creates Point objects and stores them in an array
	 * Calls the other methods to test them
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		
		Point p1 = new Point(4, 0);
		Point p2 = new Point(0, 3);
		Point p3 = new Point(6, 0);
		Point p4 = new Point(6, 10);
		
		Point[] pArray = new Point[] {p1, p2, p3, p4};
		
		System.out.println("distance between (4,0) and (0,3): " + distanceBetween(p1, p2));
		System.out.println("slope between (4,0) and (0,3): " + slope(p1, p2));
		System.out.println("are (4,0) and (0,3) horizontal?: " + isHorizontal(p1, p2));
		System.out.println("are (4,0) and (6,0) horizontal?: " + isHorizontal(p1, p3));
		System.out.println("how far is the furthest point from the origin?: " + highestDistance(pArray));
	}
	
	/*
	 * Calculates the distance between two Point objects
	 * 
	 * @param a	first point
	 * @param b	second point
	 * @return double of the distance between the points
	 */
	public static double distanceBetween(Point a, Point b) {
		int xDistance = a.getX() - b.getX();
		int yDistance = a.getY() - b.getY();
		double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		return distance;
	}
	
	/*
	 * Calculates the slope between two points
	 * 
	 * @param a	first point
	 * @param b	second point
	 * @return double of the slope between the points
	 */
	public static double slope(Point a, Point b) {
		double rise = a.getY() - b.getY();
		double run = a.getX() - b.getX();
		return rise/run;
	}
	
	/*
	 * Determines if a line between the two points is horizontal
	 * 
	 * @param a	first point
	 * @param b	second point
	 * @return boolean of if they're horizontal
	 */
	public static boolean isHorizontal(Point a, Point b) {
		double slope = slope(a, b);
		if (slope == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * In a Point array, finds the greatest distance from the origin
	 * 
	 * @param ray	Point array to compare
	 * @return double of the greatest distance from the origin
	 */
	public static double highestDistance(Point[] ray) {
		double highest = 0;
		Point origin = new Point();
		for(Point p: ray) {
			double distance = distanceBetween(origin, p);
			if (distance > highest) {
				highest = distance;
			}
		}
		return highest;
	}

}

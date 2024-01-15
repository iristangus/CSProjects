//Iris T
//CS 2 Summer 2022-2023
//Class Practice
//Various methods to practice creating a class
//Circle
//6/29/22

public class Circle {
	
	private int radius;
	
	/*
	 * default constructor that sets radius to 1
	 */
	public Circle() {
		this.radius = 1;
	}
	
	/*
	 * constructor that includes radius
	 * @params: int radius
	 */
	public Circle(int radius) {
		this.radius = radius;
	}
	
	/*
	 * returns the radius
	 * @return: int radius
	 */
	public int getRadius() {
		return this.radius;
	}
	
	/*
	 * modifies the radius
	 * @params: int radius
	 * @return: int radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/*
	 * calculates the diameter
	 * @return: int diameter
	 */
	public int diameter() {
		return this.radius * 2;
	}
	
	/*
	 * calculates the circumference
	 * @return: double circumference
	 */
	public double circumference() {
		return diameter() * Math.PI;
	}
	
	/*
	 * calculates the area
	 * @return: double area
	 */
	public double area() {
		return Math.pow(radius, 2) * Math.PI;
	}
	
	/*
	 * returns a text representation of the object
	 * @return: string
	 */
	public String toString() {
		return "Radius: " + getRadius() + "\tCircumference: " + circumference() + "\tArea: " + area();
	}
	
	

}

// Iris T
// CS 3 Summer 2022-2023
// Assignment 1
// Displayed by a red %, move diagonally and always scratch
// Ant
// 7/18/22

import java.awt.*;

public class Ant extends Critter{
	
	// Whether the ant will walk south diagonally or north diagonally
	private boolean walkSouth;
	
	// How many turns have passed
	private int turns = 0;

	/*
	 * Constructor for the Ant
	 * 
	 * @param walkSouth	boolean if the Ant will walk south
	 */
	public Ant (boolean walkSouth) {
		this.walkSouth = walkSouth;
	}
	
	/*
	 * Whether the Ant eats or not
	 * Ants always eat
	 * 
	 * @return if the Ant eats
	 */
	@Override
	public boolean eat() {
		return true;
	}
	
	/*
	 * Decides how to attack the opponent
	 * Ants always scratch
	 * 
	 * @param opponent	toString of the opposing critter
	 * @return which attack the Ant uses
	 */
	@Override
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}
	
	/*
	 * Gets the color
	 * Ants are red
	 * 
	 * @return color of the ant
	 */
	@Override
	public Color getColor() {
		return Color.RED;
	}
	
	/*
	 * Decides where the Ant will move next
	 * Ants move in a zig zag
	 * 
	 * @return which direction the Ant will move
	 */
	@Override
	public Direction getMove() {
		// Counts another turn
		turns++;
		// Every other turn:
		if (turns % 2 == 1) {
			// Checks walkSouth
			if (walkSouth) {
				return Direction.SOUTH;
			} else {
				return Direction.NORTH;
			}
		}	
		return Direction.EAST;
	}
	
	/*
	 * String representation of the Ant
	 * 
	 * @return Ant as a string
	 */
	@Override
	public String toString() {
		return "%";
	}
}

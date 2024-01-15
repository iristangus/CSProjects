// Iris T
// CS 3 Summer 2022-2023
// Assignment 1
// Eats, fights, and looks based on how much it's eaten
// Hippo
// 7/18/22

import java.awt.Color;

public class Hippo extends Critter{
	 
		// How much food the Hippo will eat in its life
		private int hunger;
		
		// How much food the Hippo has eaten so far
		private int food = 0;
		
		// How many moves the Hippo has made
		private int moves = 0;
		
		// The last direction the Hippo went
		private Direction lastDirection;

		/*
		 * Constructor for the Hippo
		 * 
		 * @param hunger	how many times the Hippo will eat
		 */
		public Hippo(int hunger) {
			this.hunger = hunger;
		}
		
		/*
		 * Whether the Hippo eats or not
		 * Depends on its hunger
		 * 
		 * @return if the Hippo eats
		 */
		@Override
		public boolean eat() {
			if (food < hunger) {
				food++;
				return true;
			}
			return false;
		}
		
		/*
		 * Decides how to attack the opponent
		 * Depends on hunger
		 * 
		 * @param opponent	toString of the opposing critter
		 * @return which attack the Hippo uses
		 */
		@Override
		public Attack fight(String opponent) {
			if (this.eat()) {
				return Attack.SCRATCH;
			}
			return Attack.POUNCE;
		}
		
		/*
		 * Gets the color
		 * Gray if hungry, white otherwise
		 * 
		 * @return color of the Hippo
		 */
		@Override
		public Color getColor() {
			if (this.eat()) {
				return Color.gray;
			}
			return Color.white;
		}
		
		/*
		 * Decides where the Hippo will move next
		 * Hippos move randomly for 5 turns each
		 * 
		 * @return which direction the Hippo will move
		 */
		@Override
		public Direction getMove() {
			// Counts another turn
			moves++;
			
			// Finds a new random direction every 5th turn
			if (moves % 5 == 1) {
				int rand = (int)(Math.random() * 4) + 1;
				
				if (rand == 1) {
					lastDirection = Direction.NORTH;
					return Direction.NORTH;
				} else if (rand == 2) {
					lastDirection = Direction.EAST;
					return Direction.EAST;
				} else if (rand == 3) {
					lastDirection = Direction.SOUTH;
					return Direction.SOUTH;
				} else {
					lastDirection = Direction.WEST;
					return Direction.WEST;
				}
			}
			
			// Otherwise just uses last direction
			return lastDirection;		
			
		}
		
		/*
		 * String representation of the Hippo
		 * 
		 * @return Hippo as a string
		 */
		@Override
		public String toString() {
			int want = hunger - food;
			return String.valueOf(want);
		}

}

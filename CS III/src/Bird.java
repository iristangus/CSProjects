// Iris T
// CS 3 Summer 2022-2023
// Assignment 1
// Displayed by blue spikes, move in a square and never eat
// Bird
// 7/18/22

import java.awt.Color;

public class Bird extends Critter{
	
		// How many turns have passed
		private int turns = 0;
		
		// The last direction the Bird went
		// Set to North at first since the Bird hasn't moved yet, and unmoving looks the same as North
		private Direction lastDirection = Direction.NORTH;

		/*
		 * Constructor for the Bird
		 */
		public Bird () {
		}
		
		/*
		 * Whether the Bird eats or not
		 * Birds always eat
		 * 
		 * @return if the Bird eats
		 */
		@Override
		public boolean eat() {
			return false;
		}
		
		/*
		 * Decides how to attack the opponent
		 * Birds roar at Ants, pounce otherwise
		 * 
		 * @param opponent	toString of the opposing critter
		 * @return which attack the Bird uses
		 */
		@Override
		public Attack fight(String opponent) {
			if (opponent.equals("%")){
				return Attack.ROAR;
			}
			return Attack.POUNCE;
		}
		
		/*
		 * Gets the color
		 * Birds are blue
		 * 
		 * @return color of the Bird
		 */
		@Override
		public Color getColor() {
			return Color.BLUE;
		}
		
		/*
		 * Decides where the Bird will move next
		 * Birds move in a clockwise square
		 * 
		 * @return which direction the Bird will move
		 */
		@Override
		public Direction getMove() {
			// Counts another turn
			turns++;
			
			// Calculates an integer for which direction the Bird should go using mod 12 and integer division by 3
			int mod12 = turns % 12;
			int dir = (mod12 - 1)/3;
			
			// Sets lastDirection and returns that direction
			// Formula above doesn't work for multiples of 12, needed to be rerouted to West
			if (dir == 0 && mod12 != 0) {
				lastDirection = Direction.NORTH;
				return Direction.NORTH;
			} else if (dir == 1) {
				lastDirection = Direction.EAST;
				return Direction.EAST;
			} else if (dir == 2) {
				lastDirection = Direction.SOUTH;
				return Direction.SOUTH;
			} else {
				lastDirection = Direction.WEST;
				return Direction.WEST;
			}
		}
		
		/*
		 * String representation of the Bird
		 * Depends on the last direction it moved
		 * 
		 * @return Bird as a string
		 */
		@Override
		public String toString() {
			if (lastDirection.equals(Direction.NORTH)) {
				return "^";
			} else if (lastDirection.equals(Direction.EAST)) {
				return ">";
			} else if (lastDirection.equals(Direction.SOUTH)) {
				return "V";
			} else {
				return "<";
			}
		}
}

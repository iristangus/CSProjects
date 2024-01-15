// Iris T
// CS 3 Summer 2022-2023
// Assignment 1
// Fights other animals based on appearance
// Lion
// 7/18/22

import java.awt.Color;
import java.util.Arrays;

public class Lion extends Critter{
		 
		// Counts how many turns the Lion has moved so far
		private int turn = 0;
		
		// Determines if the Lion should change directions
		private int changeDirection = 1;
		
		// Keeps track of the last direction the Lion went
		private Direction lastDirection;


		/*
		 * Constructor for the Lion
		 */
		public Lion () {
		}
		
		/*
		 * Whether the Lion eats or not
		 * Lions always eat
		 * 
		 * @return if the Lion eats
		 */
		@Override
		public boolean eat() {
			return true;
		}
		
		/*
		 * Decides how to attack the opponent
		 * Depends on the opponent
		 * 
		 * @param opponent	toString of the opposing critter
		 * @return which attack the Lion uses
		 */
		@Override
		public Attack fight(String opponent) {
			// Possible toStrings of birds/vultures
			String[] bird = new String[] {"^", "<", ">", "V"};
			// Possible toStrings of hippos
			String[] hippo = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			
			if (opponent.equals("%")) {
				// Ants always scratch, so the Lion will roar
				return Attack.ROAR;
			} else if (Arrays.asList(bird).contains(opponent)) {
				// Birds see the Lion as an Ant and will always roar, so the Lion will pounce
				return Attack.POUNCE;
			} else if (Arrays.asList(hippo).contains(opponent)) {
				// Hippos either scratch or pounce, and scratch is the most likely to work
				return Attack.SCRATCH;
			}
			// Stones always roar, so the Lion will pounce
			// This also attacks other lions
			return Attack.POUNCE;
		}
		
		/*
		 * Gets the color
		 * Lions are pink
		 * 
		 * @return color of the Lion
		 */
		@Override
		public Color getColor() {
			return Color.PINK;
		}
		
		/*
		 * Decides where the Lion will move next
		 * For most of the game, Lions choose a random direction after incrementally longer periods of following the same direction
		 * Once most of the food runs out(~800 turns in), the Lions will huddle together at the center
		 * 
		 * @return which direction the Lion will move
		 */
		@Override
		public Direction getMove() {
			turn++;
			
			// A random direction for that turn
			Direction r = ranDirection();
			
			// While there is still food
			if (turn <= 800) {
				// Changes direction if the turn # is a perfect square
				if (turn == Math.pow(changeDirection, 2)) {
					changeDirection++;
					// Sets the lastDirection
					lastDirection = r;
					return r;
				} else {
					// Otherwise, follows the lastDirection
					return lastDirection;
				}
			}

			// No more food, huddle
			// Gets x and y coords
			int x = this.getX();
			int y = this.getY();
			
			// If the lion is outside the center 10x10 square, move towards the center
			if (y > 30) {
				return Direction.NORTH;
			} else if (x > 35) {
				return Direction.WEST;
			} else if (y < 20) {
				return Direction.SOUTH;
			} else if (x < 25) {
				return Direction.EAST;
			}
			
			// If it's already inside, move randomly
			return ranDirection();
			
		}
		
		/*
		 * Returns a random direction (N, E, S, or W)
		 * 
		 * @return a random direction
		 */
		public Direction ranDirection() {
			// Random number from 1 - 4
			int rand = (int)(Math.random()*4 + 1);
			if (rand == 1) {
				return Direction.EAST;
			} else if (rand == 2) {
				return Direction.SOUTH;
			} else if (rand==3) {
				return Direction.WEST;
			} else{
				return Direction.NORTH;
			}
		}

		
		/*
		 * String representation of the Lion
		 * Disguises it as an ant to fool other types of lions
		 * 
		 * @return Lion as a string
		 */
		@Override
		public String toString() {
			return "%";
		}
}

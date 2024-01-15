// Iris T
// CS 3 Summer 2022-2023
// Assignment 1
// Like a bird, but changes its hunger based on eating and fighting
// Vulture
// 7/18/22

import java.awt.Color;

public class Vulture extends Bird{
	
	// Whether the Vulture is hungry or not
	// Starts out hungry
	private boolean isHungry = true;
	
	/*
	 * Constructor for the Vulture
	 */
	public Vulture () {
	}
	
	/*
	 * Whether the Vulture eats or not
	 * Will eat if hungry
	 * 
	 * @return if the Vulture eats
	 */
	@Override
	public boolean eat() {
		if (isHungry) {
			isHungry = false;
			return true;
		}
		return false;
	}
	
	/*
	 * Decides how to attack the opponent
	 * All Birds/Vultures roar at Ants, pounce otherwise
	 * 
	 * @param opponent	toString of the opposing critter
	 * @return which attack the Vulture uses
	 */
	@Override
	public Attack fight(String opponent) {
		// Fighting makes the Vulture hungry
		isHungry = true;
		if (opponent.equals("%")){
			return Attack.ROAR;
		}
		return Attack.POUNCE;
	}
	
	/*
	 * Gets the color
	 * Vultures are black
	 * 
	 * @return color of the Vulture
	 */
	@Override
	public Color getColor() {
		return Color.BLACK;
	}
	
	

}

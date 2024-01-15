// Iris T
// CS 2 Summer 2022-2023
// Final Project
// Methods to use with objects of the Recipe Class
// Recipe
// 7/8/22

import java.util.*;

public class Recipe {
	
	// Name of the recipe
	private String name;
	// ArrayList of ingredients
	private ArrayList<String> ingredients;
	
	/*
	 * Default constructor for a Recipe object
	 */
	public Recipe() {
		this.name = "name";
		this.ingredients = new ArrayList<>();
	}
	
	/*
	 * Constructor for Recipe that takes input
	 * @ param n	name of recipe
	 * @ param i	ingredients in recipe
	 */
	public Recipe(String n, String i) {
		this.name = n;
		// String -> String array
		String[] ray = i.split(", ");
		this.ingredients = new ArrayList<String>(Arrays.asList(ray));
	}
	
	/*
	 * Accessor method for a Recipe's name
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Accessor method for a Recipe's ingredients
	 */
	public ArrayList<String> getIngredients() {
		return this.ingredients;
	}
	
	/*
	 * Modifier method for a Recipe's name
	 * @param n	String of new name
	 */
	public void setName(String n) {
		this.name = n;
	}
	
	/*
	 * Modifier method for a Recipe's ingredients
	 * @param i	String of new ingredients
	 */
	public void setIngredients(String i) {
		// String -> String array
		String[] ray = i.split(", ");
		// Replaces ingredients arraylist with this array
		this.ingredients = new ArrayList<String>(Arrays.asList(ray));
	}
	
	/*
	 * Adds ingredients to the Recipe
	 * @param i	String of new ingredients
	 */
	public void addIngredients(String i) {
		// String -> String array
		String[] ray = i.split(", ");
		for (String s: ray) {
			this.ingredients.add(s);
		}
	}
	
	/*
	 * Removes ingredients from the Recipe
	 * @param i	String of ingredients to be removed
	 */
	public void deleteIngredients(String i) {
		// String -> String array
		String[] ray = i.split(", ");
		// Checks every ingredient in the String array
		for (String s: ray) {
			if (this.ingredients.contains(s) == true) {
				// If ingredient exists, removes it
				int index = this.ingredients.indexOf(s);
				this.ingredients.remove(index);
			} else {
				// Ingredient not found message
				System.out.println("The ingredient " + s + " was not found.");
			}
		}
	}
	
	/*
	 * Returns a textual representation of the Recipe object
	 * @return String with a Recipe's name and ingredients
	 */
	public String toString() {
		String i = ingredients.get(0);
		for (int j = 1; j < ingredients.size(); j++) {
			i += ", " + ingredients.get(j);
		}
		// Makes sure spacing is consistent
		int n = name.length();
		if (n < 8) {
			return name + "\t\t\t" + i;
		} else if (n >= 8 && n < 16) {
			return name + "\t\t" + i;
		} else {
			return name + "\t" + i;
		}
		
	}

}

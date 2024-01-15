// Iris T
// CS 2 Summer 2022-2023
// Final Project
// A Recipe Manager using the Recipe Class and ArrayLists
// RecipeManager
// 7/8/22


import java.io.*;
import java.util.*;

public class RecipeManager {
	
	// ArrayList of Recipe objects
	private static ArrayList<Recipe> recipeBook = new ArrayList<Recipe>();
	// User  input scanner
	private static Scanner scan = new Scanner(System.in);
	
	/*
	 * Starts the program by calling on the options method
	 * After this, the methods call upon each other
	 */
	public static void main(String[] args) {	
		options();	
	}
	
	/*
	 * Lets user decide which action to take
	 * Calls on other methods depending on user input
	 */
	public static void options() {
		System.out.println("What would you like to do?");
		System.out.println("[a] - add a recipe");
		System.out.println("[d] - delete a recipe");
		System.out.println("[u] - update a recipe");
		System.out.println("[v] - view all recipes");
		System.out.println("[f] - find a recipe using ingredients");
		System.out.println("[s] - save current recipe book to a txt file");
		System.out.println("[l] - load recipe book from a txt file");
		String response = scan.nextLine();
		boolean validResponse = false;
		String[] letters = new String[] {"a", "d", "u", "v", "f", "s", "l"};
		// Checks if the user response is one of the valid letters
		for (String s:letters) {
			if (response.equalsIgnoreCase(s)) {
				validResponse = true;
			}
		}
		if (validResponse == true) {
			// Calls on other methods depending on input
			if (response.equalsIgnoreCase("a")) {
				addRecipe();
			} else if (response.equalsIgnoreCase("d")) {
				deleteRecipe();
			} else if (response.equalsIgnoreCase("u")) {
				updateRecipe();
			} else if (response.equalsIgnoreCase("v")) {
				viewRecipes();
			} else if (response.equalsIgnoreCase("f")) {
				findRecipe();
			} else if (response.equalsIgnoreCase("s")) {
				saveToFile();
			} else if (response.equalsIgnoreCase("l")) {
				loadFromFile();
			}
		} else {
			// Reruns options
			System.out.println("\nPlease input one of the following letters: \n");
			options();
		}

	}
	
	/*
	 * Adds a recipe to the arraylist of Recipe objects
	 * If a recipe with the same name already exists, nothing is added
	 */
	public static void addRecipe() {
		System.out.print("\n");
		System.out.println("What is the name of your recipe?");
		String name = scan.nextLine();
		System.out.println("What ingredients does it use? [separate using commas]");
		String ingredients = scan.nextLine();
		boolean recipeFound = false;
		// Searches the arraylist for a recipe object with that name
		for (int i = recipeBook.size()-1;  i >= 0; i--) {
			if (recipeBook.get(i).getName().equalsIgnoreCase(name)) {
				recipeFound = true;
			}
		}
		if (recipeFound == true) {
			// There is already a recipe with that name
			System.out.println("The recipe for " + name + " already exists.");
		} else {
			// The name is not taken yet
			recipeBook.add(new Recipe(name, ingredients));
			System.out.println("The recipe for " + name + " has been added.");
		}
		System.out.println("\n\n");
		// Goes back to options
		options();
	}
	
	/*
	 * Deletes a recipe from the arraylist
	 */
	public static void deleteRecipe() {
		System.out.println("\n");
		System.out.println("Which recipe do you want to delete?");
		String name = scan.nextLine();
		boolean recipeFound = false;
		// Searches arraylist for a recipe with that name and removes it
		for (int i = recipeBook.size()-1;  i >= 0; i--) {
			if (recipeBook.get(i).getName().equalsIgnoreCase(name)) {
				recipeBook.remove(i);
				recipeFound = true;
			}
		}
		if (recipeFound == true) {
			// Successfully deleted
			System.out.println("The recipe for " + name + " has been deleted.");
		} else {
			// Recipe not found
			System.out.println("The recipe for " + name + " was not found.");
		}
		System.out.println("\n\n");
		// Back to options
		options();
	}
	
	/*
	 * A mini options panel for how the user wants to update a recipe
	 * Calls other methods depending on user input
	 */
	public static void updateRecipe() {
		System.out.println("\n");
		System.out.println("How would you like to update it?");
		System.out.println("[n] - update name");
		System.out.println("[a] - add ingredients");
		System.out.println("[r] - remove ingredients");
		System.out.println("[s] - reset ingredients");
		System.out.println("[b] - back to options");
		String response = scan.nextLine();
		boolean validResponse = false;
		// Checks if user input is a valid letter
		String[] letters = new String[] {"n", "a", "r", "s", "b"};
		for (String s:letters) {
			if (response.equals(s)) {
				validResponse = true;
			}
		}
		if (validResponse == true) {
			// Calls on other methods depending on input
			if (response.equalsIgnoreCase("n")) {
				updateName();
			} else if (response.equalsIgnoreCase("a")) {
				addIngredients();
			} else if (response.equalsIgnoreCase("r")) {
				removeIngredients();
			} else if (response.equalsIgnoreCase("s")) {
				resetIngredients();
			} else if (response.equalsIgnoreCase("b")) {
				System.out.println("\n\n");
				options();
			}
		} else {
			// Calls on updateRecipe again until a valid letter is input
			System.out.println("\nPlease input one of the following letters: \n");
			updateRecipe();
		}
	}
	
	/*
	 * Changes the name of a recipe object
	 */
	public static void updateName() {
		System.out.println("\n");
		System.out.println("Which recipe do you want to change the name of?");
		String nameOld = scan.nextLine();
		System.out.println("What is the new name?");
		String nameNew = scan.nextLine();
		boolean recipeFound = false;
		// Searches the arraylist for a Recipe with the old name
		for (int i = recipeBook.size()-1;  i >= 0; i--) {
			if (recipeBook.get(i).getName().equalsIgnoreCase(nameOld)) {
				// Sets name to new name
				recipeBook.get(i).setName(nameNew);
				recipeFound = true;
			}
		}
		if (recipeFound == true) {
			// Confirmation message
			System.out.println("The name " + nameOld + " has been changed to " + nameNew + ".");
		} else {
			// Recipe not found message
			System.out.println("The recipe for " + nameOld + " was not found.");
		}
		System.out.println("\n\n");
		// Back to options
		options();
	}
	
	/*
	 * Adds ingredients to a recipe object
	 */
	public static void addIngredients() {
		System.out.println("\n");
		System.out.println("Which recipe do you want to add ingredients to?");
		String name = scan.nextLine();
		System.out.println("Which ingredients do you want to add? [separate using commas]");
		String ingredients = scan.nextLine();
		boolean recipeFound = false;
		// Searches arraylist for a Recipe object with that name
		for (int i = recipeBook.size()-1;  i >= 0; i--) {
			if (recipeBook.get(i).getName().equalsIgnoreCase(name)) {
				// ingredients are added
				recipeBook.get(i).addIngredients(ingredients);
				recipeFound = true;
			}
		}
		if (recipeFound == true) {
			// Confirmation message
			System.out.println("The ingredients have been added to " + name + ".");
		} else {
			// Recipe not found message
			System.out.println("The recipe for " + name + " was not found.");
		}
		System.out.println("\n\n");
		// Back to options
		options();
	}
	
	/*
	 * Removes ingredients from a Recipe object
	 */
	public static void removeIngredients() {
		System.out.println("\n");
		System.out.println("Which recipe do you want to remove ingredients from?");
		String name = scan.nextLine();
		System.out.println("Which ingredients do you want to remove? [separate using commas]");
		String ingredients = scan.nextLine();
		boolean recipeFound = false;
		// Searches arraylist for a Recipe object with the same name
		for (int i = recipeBook.size()-1;  i >= 0; i--) {
			if (recipeBook.get(i).getName().equalsIgnoreCase(name)) {
				// removes ingredients
				recipeBook.get(i).deleteIngredients(ingredients);
				recipeFound = true;
			}
		}
		if (recipeFound == true) {
			// Confirmation message
			System.out.println("The existing ingredients have been removed from " + name + ".");
		} else {
			// Recipe not found message
			System.out.println("The recipe for " + name + " was not found.");
		}
		System.out.println("\n\n");
		// Back to options
		options();
	}
	
	/*
	 * Completely replaces the ingredients arraylist of a Recipe object with a new ingredients arraylist
	 */
	public static void resetIngredients() {
		System.out.println("\n");
		System.out.println("Which recipe do you want to reset the ingredients for?");
		String name = scan.nextLine();
		System.out.println("What are your new ingredients? [separate using commas]");
		String ingredients = scan.nextLine();
		boolean recipeFound = false;
		// Searches arraylist for a Recipe object with the same name
		for (int i = recipeBook.size()-1;  i >= 0; i--) {
			if (recipeBook.get(i).getName().equalsIgnoreCase(name)) {
				// Sets ingredients for the Recipe object
				recipeBook.get(i).setIngredients(ingredients);
				recipeFound = true;
			}
		}
		if (recipeFound == true) {
			// Confirmation message
			System.out.println("The ingredients for " + name + " have been reset.");
		} else {
			// Recipe not found message
			System.out.println("The recipe for " + name + " was not found.");
		}
		System.out.println("\n\n");
		// Back to options
		options();
	}
	
	/*
	 * Prints all Recipe objects with their names and ingredients
	 */
	public static void viewRecipes() {
		System.out.println("\n");
		System.out.println("Recipes\t\t\tIngredients");
		System.out.println("------------------------------------------------------");
		for (Recipe recipe: recipeBook) {
			System.out.println(recipe.toString());
		}
		System.out.println("\n\n");
		// Back to options
		options();
	}
	
	/*
	 * Finds a recipe that contains the given ingredients
	 */
	public static void findRecipe() {
		System.out.println("\n");
		System.out.println("What ingredients do you want to use? [separate using commas]");
		String ingredients = scan.nextLine();
		// String -> String array
		String[] ingRay = ingredients.split(", ");
		// Number of ingredients to find
		int ingNum = ingRay.length;
		// Number of valid recipes
		int numRecipes = 0;
		// Array of strings of valid recipes
		ArrayList<String> validRecipes = new ArrayList<String>();
		// Checks every Recipe object in the arraylist
		for (Recipe r: recipeBook) {
			// Number of matching ingredients that recipe has
			int count = 0;
			// Checks each ingredient in the recipe's arraylist
			for (String i: r.getIngredients()) {
				// Checks each given ingredient in the array
				for (String s: ingRay) {
					// If they match, count goes up
					if (s.equals(i) == true) {
						count++;

					}
				}
			}
			// If the number of matching ingredients equals the number of given ingredients
			// (All are matching)
			if (count == ingNum) {
				// Adds a string of the Recipe Object to the arraylist of valid recipes
				validRecipes.add(r.toString());
				// Count of valid recipes goes up
				numRecipes++;

			}
		}
		// If no valid recipes are found
		if (numRecipes == 0) {
			System.out.println("No recipes containing " + Arrays.toString(ingRay) + " were found.");
		} else {
			// Prints valid recipes
			System.out.println("The following recipes include " + Arrays.toString(ingRay) + ":");
			for (String s: validRecipes) {
				System.out.println(s);
			}
		}
		System.out.println("\n\n");
		// Back to options
		options();
	}
	
	/*
	 * Saves Recipe arraylist to a txt file
	 * Info can be loaded in later during a different run
	 */
	public static void saveToFile() {
		System.out.println("\n");
		// New file
		File outputFile = new File("recipeBook.txt");
		try {
			FileWriter w = new FileWriter(outputFile);
			// For every Recipe object
			for (Recipe r: recipeBook) {
				// Writes name
				w.write(r.getName());
				// New line for the ingredients
				w.write("\n");
				// For every ingredient in the Recipe's ingredient arraylist
				for (int i = 0; i < r.getIngredients().size(); i++) {
					// Writes ingredient String and a ", "
					w.write(r.getIngredients().get(i));
					// After the last ingredient, skips the ", "
					if (i == r.getIngredients().size()-1) {
						continue;
					}
					w.write(", ");
				}
				// New line for the next Recipe object
				w.write("\n");
			}
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		// Confirmation message
		System.out.println("The recipe book has been saved to recipeBook.txt");
		System.out.println("\n\n");
		// Back to options
		options();
	}
	
	/*
	 * Loads Recipe arraylist from a txt file
	 * Allows info from a past run to be used
	 */
	public static void loadFromFile() {
		System.out.println("\n");
		// Temporary Recipe arraylist
		ArrayList<Recipe> tempRBook = new ArrayList<Recipe>();
		try {
			// Scans txt file
			Scanner scanFile = new Scanner(new File("recipeBook.txt"));
			// Keeps going through the txt file while there is more to scan
			while (scanFile.hasNext() == true) {
				String name = scanFile.nextLine();
				String ingredients = scanFile.nextLine();
				// Adds a Recipe object with those details to the temporary Recipe arraylist
				tempRBook.add(new Recipe(name, ingredients));
			}
			// Replaces current Recipe arraylist with the updated one
			recipeBook = tempRBook;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Confirmation message
		System.out.println("The recipe book has been loaded from recipeBook.txt");
		System.out.println("\n\n");
		// Back to options
		options();
	}

}

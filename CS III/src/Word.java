// Iris T
// CS 3 Summer 2022-2023
// SortByLength Exercise
// A Word class that stores a string for the name
// Word
// 7/12/22

public class Word implements Comparable{
	
	// Name of word
	private String name;
	
	/*
	 * Default constructor that sets name to a blank string
	 */
	public Word() {
		this.name = "";
	}
	
	/*
	 * Constructor that takes input for name
	 * 
	 * @param n	the word's name
	 */
	public Word(String n) {
		this.name = n;
	}
	
	/*
	 * Accessor method for a word's name
	 * 
	 * @return string of the word's name
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Modifier method for a word's name
	 * 
	 * @param n	new name for the word
	 */
	public void setName(String n) {
		this.name = n;
	}
	
	/*
	 * Returns the length of the word's name
	 * 
	 * @return length of the word
	 */
	public int getLength() {
		return name.length();
	}
	
	/*
	 * Overrides the compareTo method from the Comparable interface
	 * Sorts Word objects based on length
	 * 
	 * @param o	object to compare it to
	 * @return int for whether the Word object comes before or after the object it's compared to
	 */
	@Override
	public int compareTo(Object o) {
		Word w = (Word) o;
		if(this.getLength() > w.getLength()) {
			return 1;
		} else if(this.getLength() < w.getLength()) {
			return -1;
		} else {
			return this.name.compareTo(w.name);
		}
	}
	
	/*
	 * Returns a text representation of the Word object
	 * 
	 * @return String of the word's name
	 */
	public String toString() {
		return this.name;
	}


}

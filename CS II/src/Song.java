// Iris T
// CS 2 Summer 2022-2023
// Assignment 1
// Prints a cumulative song without redundancy using methods
// Song
// 6/22/22

public class Song {
	/*
	 * Prints all 6 verses by calling the verse methods
	 */
	public static void main(String[] args) {
		verse1();
		verse2();
		verse3();
		verse4();
		verse5();
		verse6();
	}
	
	/*
	 * The last two lines, which repeat in every verse
	 */
	public static void line1() {
		System.out.println("I don't know why it wouldn't compile,");
		System.out.println("My TA just smiled.\n");
	}
	
	/*
	 * The first verse, calling upon line1 to avoid repetition
	 */
	public static void verse1() {
		System.out.println("I once wrote a program that wouldn't compile");
		line1();
	}
	
	/*
	 * The last three repeating lines, built upon the last two lines in line1
	 */
	public static void line2() {
		System.out.println("I added System.out.println(\"I <3 coding\"),");
		line1();
	}
	
	/*
	 * The second verse, calling upon line2 for its end
	 */
	public static void verse2() {
		System.out.println("My program did nothing");
		System.out.println("So I started typing.");
		line2();
	}
	
	/*
	 * The last four repeating lines, built upon line2
	 */
	public static void line3() {
		System.out.println("I added a backslash to escape the quotes,");
		line2();
	}
	
	/*
	 * The third verse, with line3 as its end
	 */
	public static void verse3() {
		System.out.println("\"Parse error,\" cried the compiler");
		System.out.println("Luckily I'm such a code baller.");
		line3();
	}
	
	/*
	 * The last five repeating lines, building off of line3
	 */
	public static void line4() {
		System.out.println("I added a main method with its String[] args,");
		line3();
	}
	
	/*
	 * The fourth verse, with line4 as its end
	 */
	public static void verse4() {
		System.out.println("Now the compiler wanted an identifier");
		System.out.println("And I thought the situation was getting dire.");
		line4();
	}
	
	/*
	 * The last six repeating lines, building off of line4
	 */
	public static void line5() {
		System.out.println("I added a public class and called it Scum,");
		line4();
	}
	
	/*
	 * The fifth verse, with line5 as its end
	 */
	public static void verse5() {
		System.out.println("Java complained it expected an enum");
		System.out.println("Boy, these computers really are dumb!");
		line5();
	}
	
	/*
	 * The sixth verse, with line5 as its end
	 */
	public static void verse6() {
		System.out.println("I checked the semicolons and what did I find?");
		System.out.println("The symbol missing at the end of a line!");
		line5();
	}

}

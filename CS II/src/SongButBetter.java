// Iris T
// CS 2 Summer 2022-2023
// Assignment 1
// description
// Song
// 6/22/22

public class SongButBetter {
	public static void main(String[] args) {
		
		System.out.println("I once wrote a program that wouldn't compile");
		lineFinal();
		
		System.out.println("My program did nothing");
		System.out.println("So I started typing.");
		line3();
		
		System.out.println("\"Parse error,\" cried the compiler");
		System.out.println("Luckily I'm such a code baller.");
		line2();
		
		System.out.println("Now the compiler wanted an identifier");
		System.out.println("And I thought the situation was getting dire.");
		line1();
		
		System.out.println("Java complained it expected an enum");
		System.out.println("Boy, these computers really are dumb!");
		line0();
		
		System.out.println("I checked the semicolons and what did I find?");
		System.out.println("The symbol missing at the end of a line!");
		line0();
	}
	
	public static void lineFinal() {
		System.out.println("I don't know why it wouldn't compile,");
		System.out.println("My TA just smiled.\n");
	}
	
	public static void line3() {
		System.out.println("I added System.out.println(\"I <3 coding\"),");
		lineFinal();
	}
	
	public static void line2() {
		System.out.println("I added a backslash to escape the quotes,");
		line3();
	}
	
	public static void line1() {
		System.out.println("I added a main method with its String[] args,");
		line2();
	}
	
	public static void line0() {
		System.out.println("I added a public class and called it Scum,");
		line1();
	}

}

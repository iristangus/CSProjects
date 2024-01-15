// Iris T
// CS 2 Summer 2022-2023
// CoolWord Assignment
// Displays a word in various shapes
// CoolWord
// 7/6/22


public class CoolWord {
	
	/*
	 * calls the other methods
	 */
	public static void main(String[] args) {
		shape1("computer");
		System.out.println();
		shape2("computer");
		System.out.println();
		shape3("computer");
	}
	
	/*
	 * prints the string in a diagonal line
	 * @param str string to be displayed
	 */
	public static void shape1(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println(str.charAt(i));
			
		}
	}
	
	/*
	 * prints the string in a box
	 * @param str string to be displayed
	 */
	public static void shape2(String str) {
		System.out.println(str);
		for (int i = 0; i < str.length()-2; i++) {
			System.out.print(str.charAt(0));
			for (int j = 0; j < str.length()-2; j++) {
				System.out.print(" ");
			}
			System.out.println(str.charAt(str.length()-1));
		}
		System.out.println(str);
	}
	
	/*
	 * prints the string in a cross
	 * @param str string to be displayed
	 */
	public static void shape3(String str) {
		for (int i = 0; i < str.length()/2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.print(str.charAt(i));
			for (int j = 0; j < str.length()-2*i-2; j++) {
				System.out.print(" ");
			}
			System.out.println(str.charAt(str.length()-i-1));
		}
		for (int i = str.length()/2-1; i >=0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.print(str.charAt(i));
			for (int j = 0; j < str.length()-2*i-2; j++) {
				System.out.print(" ");
			}
			System.out.println(str.charAt(str.length()-i-1));
		}
	}

}

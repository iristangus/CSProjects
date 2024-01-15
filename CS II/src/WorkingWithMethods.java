// Iris T
// CS 2 Summer 2022-2023
// Working with Methods
// Various methods
// WorkingWithMethods
// 6/27/22

public class WorkingWithMethods {

	/*
	 * calls on all the other methods to test them
	 */
	public static void main(String[] args) {
		System.out.println(lenStr("computer"));
		System.out.println(evenNum(57));
		System.out.println(highNum(32, 99));
		System.out.println(evenStr("computer"));
		increment(41);
		System.out.println(concatenatStr("hey", " there"));
		System.out.println(highThree(32, 99, 176));
		welcome("Iris");
		System.out.println(firstLast("computer"));
		System.out.println(switchHalf("computer"));

	}
	
	/*
	 * returns the number of characters in a string
	 * @param the string
	 * @return the number of characters in it
	 */
	public static int lenStr(String str) {
		return str.length();
	}
	
	/*
	 * returns true if the integer is even, false if it is odd
	 * @param the integer
	 * @return a boolean
	 */
	public static boolean evenNum(int num) {
		if (num%2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * returns the highest of two integers
	 * @param the two integers
	 * @return the higher integer
	 */
	public static int highNum(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	/*
	 * returns true if the string has an even number of characters, false if it is odd
	 * @param the string
	 * @return a boolean
	 */
	public static boolean evenStr(String str) {
		int numChar = str.length();
		if (numChar%2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * takes an integer and prints the integer one bigger
	 * @param the integer
	 */
	public static void increment(int val) {
		System.out.println(++val);
	}
	
	/*
	 * concatenates two strings
	 * @param the two original strings
	 * @return the concatenated string
	 */
	public static String concatenatStr(String str1, String str2) {
		String str3 = str1 + str2;
		return str3;
	}
	
	/*
	 * returns the highest of three integers
	 * @param three integers
	 * @return the highest integer
	 */
	public static int highThree(int n1, int n2, int n3) {
		int highest = n1;
		if (n2 > highest) {
			highest = n2;
		}
		if (n3 > highest) {
			highest = n3;
		}
		return highest;
	}
	
	/*
	 * prints a welcome, given a name
	 * @param string of a name
	 */
	public static void welcome (String name) {
		System.out.println("Welcome " + name);
	}
	
	/*
	 * returns a string of the first and last characters of a given string
	 * @param original string
	 * @return string of first and last characters
	 */
	public static String firstLast(String str) {
		String newStr = str.substring(0,1);
		newStr += str.substring(str.length()-1);
		return newStr;
	}
	
	/*
	 * returns a string with the first and last halves of the original string switched
	 * @param original string
	 * @return switched string
	 */
	public static String switchHalf(String str) {
		String firstHalf = str.substring(0,str.length()/2);
		String lastHalf = str.substring(str.length()/2);
		return lastHalf + firstHalf;
	}

}

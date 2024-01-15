// Iris T
// CS 2 Summer 2022-2023
// Methods using loops
// Various methods, written using loops
// MethodsUsingLoops
// 6/27/22


public class MethodsUsingLoops {
	
	/*
	 * calls all the other methods to test them
	 */
	public static void main(String[] args) {
		System.out.println(reverse("hi"));
		System.out.println(isPalindrome("racear"));
		factors(24);
		System.out.println(numDigits(23984));
		System.out.println(repeated("banana", 'a'));
		System.out.println(doubleLetters("princes"));
	}
	
	/*
	 * returns the string reversed
	 */
	public static String reverse(String str) {
		String newStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			newStr = newStr + str.charAt(i);
		}
		return newStr;
	}
	/*
	 * returns whether the string is a palindrome
	 */
	public static boolean isPalindrome(String str) {
		if (str.equals(reverse(str))) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * displays all factors of an integer
	 */
	public static void factors(int num) {
		String allFactors = "1";
		for (int i = 2; i < num; i++) {
			if(num%i==0) {
				allFactors = allFactors + " " + i;
			}
		}
		System.out.println(allFactors);
	}
	
	/*
	 * returns number of digits in an integer
	 */
	public static int numDigits(int val) {
		String str = String.valueOf(val);
		return str.length();
	}
	
	/*
	 * returns how many times a given character appears in a string
	 */
	public static int repeated(String str, char ch) {
		int numTimes = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				numTimes++;
			}
		}
		return numTimes;
	}
	
	/*
	 * returns whether a string has double letters in it
	 */
	public static boolean doubleLetters(String str) {
		boolean isDoubleLetters = false;
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				isDoubleLetters = true;
			}
		}
		return isDoubleLetters;
		
	}

}

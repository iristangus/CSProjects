// Iris T
// CS 3 Summer 2022-2023
// Fraction Class Exercise
// Tests methods for Fraction objects
// FractionTest
// 7/11/22

public class FractionTest {
	
	/*
	 * Creates some Fraction objects and an array to hold them
	 * Calls on the other methods to test them
	 * 
	 * @param args	console input
	 */
	public static void main(String[] args) {
		
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(1, 5);
		Fraction f3 = new Fraction(2, 7);
		Fraction f4 = new Fraction(6, 9);
		
		Fraction[] fArray = new Fraction[] {f1, f2, f3, f4};
		
		// Methods from FractionTest.java
		System.out.println("sum: " + sumFraction(fArray).toString());
		System.out.println("highest: " + highestFraction(fArray).toString());
		
		System.out.println();
		// Methods from Fraction.java
		System.out.println("numerator of 1/3: " + f1.getNum());
		System.out.println("denominator of 1/3: " + f1.getDen());
		System.out.println("1/3 + 1/5: " + f1.add(f2).toString());
		System.out.println("1/3 - 1/5: " + f1.subtract(f2).toString());
		System.out.println("1/3 * 1/5: " + f1.multiply(f2).toString());
		System.out.println("1/3 / 1/5: " + f1.divide(f2).toString());
		f4.reduce();
		System.out.println("6/9 reduced: " + f4.toString());
		System.out.println("reciprocal of 2/7: " + f3.reciprocal().toString());
	}
	
	/*
	 * Returns the sum of all fractions
	 * 
	 * @param ray	array of fractions to add up
	 * @return fraction of the sum
	 */
	public static Fraction sumFraction(Fraction[] ray) {
		Fraction sum = new Fraction(0, 1);
		for (Fraction f: ray) {
			sum = sum.add(f);
			sum.reduce();
		}
		return sum;
	}
	
	/*
	 * Returns the highest fraction in the array
	 * 
	 * @param ray	array of fractions to compare
	 * @return highest fraction
	 */
	public static Fraction highestFraction(Fraction[] ray) {
		Fraction highest = ray[0];
		for (Fraction f: ray) {
			if (f.toDecimal() > highest.toDecimal()) {
				highest = f;
			}
		}
		highest.reduce();
		return highest;
	}

}

// Iris T
// CS 3 Summer 2022-2023
// Fraction Class Exercise
// Methods to use for Fraction objects
// Fraction
// 7/11/22

public class Fraction {
	
	// Numerator of the fraction
	private int num;
	
	// Denominator of the fraction
	private int den;
	
	/*
	 * Default constructor for a Fraction object
	 */
	public Fraction() {
		this.num = 1;
		this.den = 1;
	}
	
	/*
	 * Constructor for a Fraction object that takes input for num and den
	 * 
	 * @param n	numerator of the fraction
	 * @param d	denominator of the fraction
	 */
	public Fraction(int n, int d) {
		this.num = n;
		this.den = d;
	}
	
	/*
	 * Accessor method for the numerator of the fraction object
	 * 
	 * @return num
	 */
	public int getNum() {
		return num;
	}
	
	/*
	 * Accessor method for the denominator of the fraction object
	 * 
	 * @return den
	 */
	public int getDen() {
		return den;
	}
	
	/*
	 * Adds two fractions together
	 * 
	 * @param other	fraction to add to the current fraction
	 * @return fraction of the sum
	 */
	public Fraction add(Fraction other) {
		int newNum = this.num * other.den + other.num * this.den;
		int newDen = this.den * other.den;
		return new Fraction(newNum, newDen);
	}
	
	/*
	 * Subtracts two fractions
	 * 
	 * @param other	fraction to subtract from the current fraction
	 * @return fraction of the difference
	 */
	public Fraction subtract(Fraction other) {
		int newNum = Math.abs(this.num * other.den - other.num * this.den);
		int newDen = this.den * other.den;
		return new Fraction(newNum, newDen);
	}
	
	/*
	 * Multiplies two fractions
	 * 
	 * @param other	fraction to multiply to the current fraction
	 * @return fraction of the product
	 */
	public Fraction multiply(Fraction other) {
		int newNum = this.getNum() * other.getNum();
		int newDen = this.getDen() * other.getDen();
		return new Fraction(newNum, newDen);
	}
	
	/*
	 * Divides two fractions
	 * 
	 * @param other	fraction to divide from the current fraction
	 * @return fraction of the quotient
	 */
	public Fraction divide(Fraction other) {
		int newNum = this.getNum() * other.getDen();
		int newDen = this.getDen() * other.getNum();
		return new Fraction(newNum, newDen);
	}
	
	/*
	 * Reduces a fraction to its simplest form
	 */
	public void reduce() {
		for (int i = 2; i < Math.min(this.num, this.den); i++) {
			if (this.num % i == 0 && this.den % i == 0) {
				this.num /= i;
				this.den /= i;
			}
		}
	}
	
	/*
	 * Returns the reciprocal of a fraction
	 * 
	 * @return fraction of the reciprocal
	 */
	public Fraction reciprocal() {
		return new Fraction(this.den, this.num);
	}
	
	/*
	 * Returns the fraction in decimal form
	 * 
	 * @return double of the fraction in decimal form
	 */
	public double toDecimal() {
		return (double)this.num/this.den;
	}
	
	/*
	 * Returns a textual representation of the fraction
	 * 
	 * @return string that displays the numerator and denominator
	 */
	public String toString() {
		return this.num + "/" + this.den;
	}

}

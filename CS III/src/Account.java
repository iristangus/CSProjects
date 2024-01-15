// Iris T
// CS 3 Summer 2022-2023
// SortByBalance Exercise
// An Account class that stores a first name, last name, and balance
// Account
// 7/12/22

public class Account implements Comparable{
	
	// String for first name
	private String fName;
	
	// String for last name
	private String lName;
	
	// The account's balance
	private int balance;
	
	/*
	 * Default constructor that sets the names to a blank string and the balance to 0
	 */
	public Account() {
		this.fName = "";
		this.lName = "";
		this.balance = 0;
	}
	
	/*
	 * Constructor that takes input
	 * 
	 * @param f	first name
	 * @param l	last name
	 * @param b	balance
	 */
	public Account(String f, String l, int b) {
		this.fName = f;
		this.lName = l;
		this.balance = b;
	}
	
	/*
	 * Accessor method for the first name
	 * 
	 * @return the account's first name
	 */
	public String getFirstName() {
		return this.fName;
	}
	
	/*
	 * Accessor method for the last name
	 * 
	 * @return the account's last name
	 */
	public String getLastName() {
		return this.lName;
	}
	
	/*
	 * Accessor method for the balance
	 * 
	 * @return the account's balance
	 */
	public int getBalance() {
		return this.balance;
	}

	/*
	 * Overrides the compareTo method from the Comparable interface
	 * Sorts Accounts by balance, then alphabetically by last name
	 * 
	 * @param o	object to compare it to
	 * @return int for whether the Account comes before or after the object it's compared to
	 */
	@Override
	public int compareTo(Object o) {
		Account a = (Account) o;
		if (this.balance > a.balance) {
			return 1;
		} else if (this.balance < a.balance) {
			return -1;
		} else {
			return this.lName.compareTo(a.lName);
		}
	}
	
	

}

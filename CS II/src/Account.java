// Iris T
// CS 2 Summer 2022-2023
// Bank Account Class Assignment
// Various methods for the Account class
// Account
// 6/30/22

public class Account {
	
	private double balance;
	private String name;
	private String accountID;
	
	/*
	 * default constructor, gives instance variables default values
	 */
	public Account() {
		this.balance = 0;
		this.name = "name";
		this.accountID = "0000";
	}
	
	/*
	 * constructor that sets the instance variables
	 * @params: balance, name, accountID
	 */
	public Account(double balance, String name, String accountID) {
		this.balance = balance;
		this.name = name;
		this.accountID = accountID;
	}
	
	/*
	 * accessor method for balance
	 * @return: double balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/*
	 * accessor method for name
	 * @return: String name
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * accessor method for accountID
	 * @return: String accountID
	 */
	public String getAccountID() {
		return this.accountID;
	}
	
	/*
	 * modifier method for name
	 * @params: String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * modifier method for accountID
	 * @params: String accountID
	 */
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	/*
	 * adds money to the account's balance
	 * @params: double moneyDeposit
	 */
	public void deposit(double moneyDeposit) {
		this.balance += moneyDeposit;
	}
	
	/*
	 * subtracts money from the account's balance
	 * @params: double moneyWithdrew
	 */
	public void withdraw(double moneyWithdrew) {
		this.balance -= moneyWithdrew;
	}
	
	/*
	 * gives account object a textual representation
	 * @return: String representation of account
	 */
	public String toString() {
		return getName() + " " + getAccountID() + " " + getBalance();
	}

}

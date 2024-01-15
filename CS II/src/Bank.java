// Iris T
// CS 2 Summer 2022-2023
// Bank Account Class Assignment
// Uses methods from the Account Class to work with an Account array
// Bank
// 6/30/22


public class Bank {
	
	/*
	 * creates Account objects and calls the other methods
	 */
	public static void main(String[] args) {
		Account account1 = new Account(100, "Aaa", "1234");
		Account account2 = new Account(200, "Bbb", "2345");
		Account account3 = new Account(300, "Ccc", "3456");
		Account account4 = new Account(400, "Ddd", "4567");
		Account account5 = new Account(500, "Eee", "5678");
		
		account1.deposit(500);
		account2.deposit(740);
		account3.withdraw(400);
		account4.withdraw(350);
		
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		System.out.println(account3.toString());
		System.out.println(account4.toString());
		System.out.println(account5.toString());
		
		Account[] accountArray = new Account[] {account1, account2, account3, account4, account5};
		
		System.out.println(highestBalance(accountArray));
		System.out.println(highestName(accountArray));
		System.out.println(numExceed1500(accountArray));
		System.out.println(lowestBalance(accountArray));
		System.out.println(totalBalance(accountArray));
	}
	
	/*
	 * finds the highest balance
	 * @params: Account array
	 * @return: double of the highest balance
	 */
	public static double highestBalance(Account[] ray) {
		double highest = ray[0].getBalance();
		for (int i = 1; i < 5; i++) {
			if (ray[i].getBalance() > highest) {
				highest = ray[i].getBalance();
			}
		}
		return highest;
	}
	
	/*
	 * finds the name of the account with the highest balance
	 * @params: Account array
	 * @return: String of the name
	 */
	public static String highestName(Account[] ray) {
		double balance = highestBalance(ray);
		String name = "";
		for (int i = 0; i < 5; i++) {
			if (ray[i].getBalance() == balance) {
				name = ray[i].getName();
			}
		}
		return name;
	}
	
	/*
	 * finds the number of accounts with balance higher than 1500
	 * @params: Account array
	 * @return: int of number of accounts
	 */
	public static int numExceed1500(Account[] ray) {
		int numAccounts = 0;
		for (int i = 0; i < 5; i++) {
			if (ray[i].getBalance() > 1500) {
				numAccounts++;
			}
		}
		return numAccounts;
	}
	
	/*
	 * finds the object with the lowest balance
	 * @params: Account array
	 * @return: Account object
	 */
	public static Account lowestBalance(Account[] ray) {
		double lowest = ray[0].getBalance();
		int index = 0;
		for (int i = 1; i < 5; i++) {
			if (ray[i].getBalance() < lowest) {
				lowest = ray[i].getBalance();
				index = i;
			}
		}
		return ray[index];
	}
	
	/*
	 * finds the sum of all balances in the Account array
	 * @params: Account array
	 * @return: double sum
	 */
	public static double totalBalance(Account[] ray) {
		double total = 0;
		for (Account a:ray) {
			total += a.getBalance();
		}
		return total;
	}

}

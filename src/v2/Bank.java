package v2;

import java.util.ArrayList;

/**
 * This is the Bank class. This class represents a bank, with the fields name as a String,
 * and an ArrayList of type Bank Account, which stores the bank accounts for each specific 
 * bank in their proper ArrayList. 
 * @author Steven Orsini
 * @version 6/22/2020
 */
public class Bank {
	
	String name;
	ArrayList<BankAccount> accounts;
	
	/**
	 * This is the Bank Object constructor. It only takes in one parameter, sets the one 
	 * parameter equal to the name of the bank, and then instantiates a new ArrayList named
	 * accounts, which stores the bank accounts belonging to that bank.
	 * @param name the name of the bank
	 */
	public Bank(String name) {
		this.name = name;
		accounts = new ArrayList<BankAccount>();
	}
	
	/**
	 * This is an accessor method which returns the name of the bank. 
	 * @return name of the bank as a String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This is a mutator method which will set the name parameter equal to the name of the
	 * bank.
	 * @param name the name of the bank
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This is an accessor method which will get the amount of bank accounts in the accounts
	 * ArrayList accounts.
	 * @return the integer value representing the amount of accounts in the bank
	 */
	public int numberOfAccounts() {
		return accounts.size();
	}
	
	/**
	 * This method will print the account number, account owners name, and the account type
	 * of the Bank Account object within the console.
	 */
	public void getAccounts(){
		for(BankAccount acct: accounts) {
			System.out.println("Account #: " + acct.getAccountNumber());
			System.out.println("Account Owner: " + acct.getOwner().getName());
			System.out.println("Type of account: " + acct.getAccountType());
		}
	}
	
	/**
	 * This method will take a bank account and add it into the ArrayList of the bank.
	 * @param account the Bank Account being added to the ArrayList of type Bank Account
	 */
	public void addAccount(BankAccount account) {
		accounts.add(account);
	}
	
	/**
	 * This method will remove the specific account from the banks ArrayList.
	 * @param account the Bank Account being removed from the ArrayList of type Bank Account
	 */
	public void removeAccount(BankAccount account) {
		accounts.remove(account);
	}
	
	/**
	 * This method will search through the accounts ArrayList using a for each loop,
	 * and will make sure the username and password equal the account within that bank, 
	 * and then returns the specfic found account.
	 * @param username the username of the account being found
	 * @param password the password of the account being found
	 * @return the account that matches the username and password description
	 */
	public BankAccount getSpecificAcct(String username, String password) {
		BankAccount act1 = null;
		for(BankAccount act: accounts) {
			if(act.getUserName().equals(username) && act.getPassword().equals(password)) {
				return act;
			}
		}
		return act1;
	}
}

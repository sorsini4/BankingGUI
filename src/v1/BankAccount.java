package v1;

/**
 * This is an abstract class resembelling a Bank Account. It has everything necessary
 * to establish specific bank account credentials, account number, type, the owner
 * who the Bank Account belongs too, and the Bank which the Bank Account belongs too.
 * @author Steven Orsini
 * @version 06/10/2020
 *
 */
public abstract class BankAccount {
	
	private int accountNumber;
	private Person owner;
	private Bank bank;
	private double balance;
	private String pin;
	private String userName;
	private String password;
	private String accountType;

	/**
	 * This is the constructor for the Bank Account class. In order to create a bank account
	 * the user must establish an owner of type Person, which bank the account belongs too of
	 * type bank, along with the username and password of the account.
	 * @param owner Person object representing owner
	 * @param bank Bank object representing the bank
	 * @param userName the username of the bank account 
	 * @param password the password of the bank account
	 */
	public BankAccount(Person owner, Bank bank, String userName, String password) {
		this.owner = owner;
		this.bank = bank;
		this.userName = userName;
		this.password = password;
		setUpAccount();
	}
	
	/**
	 * This is an abstract method withdraw. It will take the parameter and subtract (withdraw)
	 * it from the current balance of the users account. 
	 * @param amt the amount the user would like to withdraw
	 */
	public abstract void withdraw(double amt);
	
	/**
	 * This is an abstract method deposit. It will take the parameter and add (deposit) it to
	 * the current balance of the users account.
	 * @param amt the amount the user would like to deposit
	 */
	public abstract void deposit(double amt);
	
	/**
	 * This is an abstract method to check balance. It will return the balance of the account.
	 * @return the balance of the account
	 */
	public abstract double checkBalance();
	
	/**
	 * This is a method that sets the account number of the account, as well as setting the
	 * account type.
	 */
	public void setUpAccount() {
		this.setAccountNumber();
		
		if(isChecking()) {
			setAccountType("Checking");
		}
		else {
			setAccountType("Savings");
		}	
		bank.addAccount(this);
	}
	
	/**
	 * This method returns the account number of type integer.
	 * @return the account number of the account
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * This method sets up the account number by adding the integer 5687 to the number of 
	 * accounts the specific bank has.
	 */
	public void setAccountNumber() {
		this.accountNumber = bank.numberOfAccounts() + 5687;
	}
	
	/**
	 * This method returns the owner of type Person for the Bank Account.
	 * @return the owner (Person object)
	 */
	public Person getOwner() {
		return owner;
	}

	/**
	 * This method takes in the owner of type Person for which you want to set the account
	 * owner too.
	 * @param owner the Person object you would like to set as the owner
	 */
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	/**
	 * This method returns the bank object of the bank account.
	 * @return the bank object
	 */
	public Bank getBank() {
		return bank;
	}
	
	/**
	 * The bank object which you would like to set the bank account too.
	 * @param bank the bank object you would like to set the account too
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	/**
	 * This method will return the balance of the bank account.
	 * @return the balance of the account
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * This method will set the balance of the account.
	 * @param balance the amount in the bank account
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * This method will get the PIN of the account.
	 * @return pin of the account
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * This method will set the PIN of the account.
	 * @param pin the pin of the account
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * This method will return the username of the account.
	 * @return username of the account
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method will set the username of the account.
	 * @param userName the username of the account
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method will get the password of the account.
	 * @return password of account
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method will set the password of the account.
	 * @param password the password of the account
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This method will check whether or not the account calling the method is a checking
	 * account or not. 
	 * @return true if it is an instance of checking account class, false otherwise
	 */
	public boolean isChecking() {
		if(this instanceof CheckingAcct) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method will return the account type of the account.
	 * @return either "Checking" or "Savings" as a String value.
	 */
	public String getAccountType() {
		return accountType;
	}
	
	/**
	 * This method will set the account type of the account.
	 * @param accountType the type of account in a string value
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	/**
	 * This method will call the getName of both the Bank and Person object returning the 
	 * names.
	 * @return name of the owner and bank seperated by a comma
	 */
	public String toString() {
		return owner.getName() + ", " + bank.getName() + " ";
	}
}

package v2;

/**
 * This class is used to represent a person object. This object is allowed to have two 
 * Bank Account objects which are respectively a Checking and Savings Account objects, each 
 * extending the Bank Account class. The person as well will have a name.
 * @author Steven Orsini
 * @version 6/10/2020
 */
public class Person {
	
	String name;
	CheckingAcct checking;
	SavingsAcct savings;
	
	/**
	 * This is the constructor for the Person class and it sets the name within the parameters
	 * to the name field of the Person object.
	 * @param name String representation of the persons name
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * This accessor method will return the value of the name field.
	 * @return the name of the Person object
	 */
	public String getName() {
		return name;
	}

	/**
	 * This mutator method will set the name within the parameters to the name field for the
	 * specified Person object.
	 * @param name String representation of the Person object
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This accessor method will return the instance of the Checking Account field.
	 * @return Checking Account object
	 */
	public CheckingAcct getChecking() {
		return checking;
	}
	
	/**
	 * This mutator method will add the specified Checking Account object to the Person 
	 * object.
	 * @param checking Checking Account object 
	 */
	public void addChecking(CheckingAcct checking) {
		this.checking = checking;
	}
	
	/**
	 * This accessor method will check if the person object has a Checking Account.
	 * @return false if the person object does not have a Checking Account, true otherwise.
	 */
	public boolean hasChecking() {
		if(this.checking == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * This method will remove the current Checking Account associated with the Person object.
	 */
	public void removeChecking() {
		this.checking = null;
	}
	
	/**
	 * This accessor method will return the instance of the Savings Account object associated
	 * with the Person object.
	 * @return Savings Account object
	 */
	public SavingsAcct getSavings() {
		return savings;
	}
	
	/**
	 * This mutator method will add the specified Savings Account object to the Person 
	 * object.
	 * @param savings Savings Account object 
	 */
	public void addSavings(SavingsAcct savings) {
		this.savings = savings;
	}
	
	/**
	 * This accessor method will check if the person object has a Savings Account.
	 * @return false if the person object does not have a Savings Account, true otherwise.
	 */
	public boolean hasSavings() {
		if(this.savings == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * This mutator method will remove the Savings Account associated with the Person object.
	 */
	public void removeSavings() {
		this.savings = null;
	}
	
	/**
	 * This method will use both the hasChecking and hasSavings methods to see whether they
	 * (Person object) has two accounts.
	 * @return integer value of the amount of accounts
	 */
	public int amtOfAccounts() {
		int i = 0;
		
		if(hasChecking()) {
			i++;
		}
		if(hasSavings()) {
			i++;
		}
		return i;
	}
	
	/**
	 * This method will return the getName method of the Person class.
	 * @return the name of the Person object
	 */
	public String toString() {
		return getName();
	}
}

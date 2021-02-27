package v1;

/**
 * 
 * @author Steven Orsini
 * @version 6/10/2020
 */
public class Person {
	
	String name;
	CheckingAcct checking;
	SavingsAcct savings;
	double cash;
	
	/**
	 * 
	 * @param name
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public CheckingAcct getChecking() {
		return checking;
	}
	
	/**
	 * 
	 * @param checking
	 */
	public void addChecking(CheckingAcct checking) {
		this.checking = checking;
	}
	
	/**
	 * 
	 * @return
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
	 * 
	 */
	public void removeChecking() {
		this.checking = null;
	}
	
	/**
	 * 
	 * @return
	 */
	public SavingsAcct getSavings() {
		return savings;
	}
	
	/**
	 * 
	 * @param savings
	 */
	public void addSavings(SavingsAcct savings) {
		this.savings = savings;
	}
	
	/**
	 * 
	 * @return
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
	 * 
	 */
	public void removeSavings() {
		this.savings = null;
	}
	
	/**
	 * 
	 * @return
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
	 * 
	 * @param amt
	 */
	public void setCash(double amt) {
		this.cash = amt;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getCash() {
		return cash;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return getName();
	}
}

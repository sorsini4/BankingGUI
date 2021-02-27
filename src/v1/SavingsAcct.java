package v1;

/**
 * This class extends the BankAccount class, and only needs to implement the three abstracts
 * methods. 
 * @author Steven Orsini
 * @version 6/10/2020
 */
public class SavingsAcct extends BankAccount {

	/**
	 * This is the constructor for the SavingsAcct class, which extends BankAccount. There 
	 * are four parameters needed within the constructor and within the super call. 
	 * @param owner Person object which is the owner of the Savings Account
	 * @param bank Bank object which the account belongs to
	 * @param userName the username of the account
	 * @param pass the password of the account
	 */
	public SavingsAcct(Person owner, Bank bank, String userName, String pass) {
		super(owner, bank, userName, pass);
	}
	
	/**
	 * {@inheritDoc}
	 * This method also does not allow you to withdraw money from your account if you do not
	 * have at least $1,000 in the account.
	 */
	@Override
	public void withdraw(double amt) {
		if(getBalance() <= 999) {
			System.out.println("Sorry, not enough funds.");
		}
		else {
			double balance = getBalance() - amt; 
			this.setBalance(balance);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deposit(double amt) {
		double balance = getBalance() + amt;
		setBalance(balance);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double checkBalance() {
		return getBalance();
	}

}

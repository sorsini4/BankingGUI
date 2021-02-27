package v2;

/**
 * This class extends the BankAccount class, and only needs to implement the three abstracts
 * methods. 
 * @author Steven Orsini
 * @version 6/10/2020
 */
public class CheckingAcct extends BankAccount {
	
	/**
	 * This is the constructor for the CheckingAcct class, which extends BankAccount. There 
	 * are four parameters needed within the constructor and within the super call. 
	 * @param owner Person object which is the owner of the Checking Account
	 * @param bank Bank object which the account belongs to
	 * @param userName the username of the account
	 * @param pass the password of the account
	 */
	public CheckingAcct(Person owner, Bank bank, String userName, String pass) {
		super(owner, bank, userName, pass);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void withdraw(double amt) {
		if(amt < this.getBalance()) {
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

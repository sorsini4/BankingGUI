package v2;

import java.util.ArrayList;
import javafx.scene.control.ComboBox;

/**
 * This class is the BankList class, and it has a single field of type ArrayList called banks.
 * The intention of the class is to hold Bank objects within the ArrayList so the banks can be
 * easily accessed and easily add BankAccounts into the Bank object.
 * @author Steven Orsini 
 * @version 6/10/2020
 *
 */
public class BankList {
	ArrayList<Bank> banks = new ArrayList<Bank>();
	
	/**
	 * This is the constructor of the bank list class. 
	 * @param bank
	 * @param bank2
	 * @param bank3
	 */
	public BankList(Bank bank, Bank bank2, Bank bank3) {
		banks = new ArrayList<Bank>();
	}

	/**
	 * This is a method that will add a bank into the banks ArrayList.
	 * @param bank the Bank object
	 */
	public void addBank(Bank bank) {
		banks.add(bank);
	}
	
	/**
	 * This method will check if the specific bank picked within the combo box (which are all
	 * only within the ArrayList already) is actually there.
	 * @param userBank the value of the chosen bank within the combo box
	 * @return true if the bank name is there, false if the bank name is not there
	 */
	public boolean isBankThere(ComboBox<String> userBank) {
		boolean bankThere = false;
		
		for(Bank bank: banks) {
			if(bank.getName().equals(userBank.getValue())) {
				bankThere = true;
			}
			else {
				bankThere = false;
			}
		}
		return bankThere;
	}
	
	/**
	 * This method will get the specific bank with the help of the parameter, using a for
	 * each loop. 
	 * @param theBank String representation of the bank name being looked up 
	 * @return the bank object of the found bank
	 */
	public Bank getBank(String theBank) {
		Bank bank1 = new Bank("");
		for(Bank bank: banks) {
			if(bank.getName().equals(theBank)) {
				 return bank;
			}
		}
		return bank1;
	}
}

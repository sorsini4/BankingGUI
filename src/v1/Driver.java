package v1;

public class Driver {
	
	public static void main(String args[]) {
		
		Bank tdbank = new Bank("TD Bank");
		Person myself = new Person("Steven");
		Person dad = new Person("Mark");
		CheckingAcct checking = new CheckingAcct(myself, tdbank, "sorsini29", "Maverick1120");
		SavingsAcct savings = new SavingsAcct(dad, tdbank, "mrkso928", "poop");
		checking.setPassword("Kayla324");
		checking.setUserName("orsini29");
		savings.setPassword("steve");
		System.out.println(checking.getUserName());
		System.out.println(checking.getPassword());
		System.out.println(tdbank.numberOfAccounts());
		System.out.println(checking.getAccountNumber());
		tdbank.getAccounts();
		System.out.println(checking.checkBalance());
		checking.deposit(900);
		checking.withdraw(100.95);
		System.out.println(checking.checkBalance());
		System.out.println(checking.toString());
		System.out.println(tdbank.numberOfAccounts());
		
		Person person = new Person("Steve");
		person.addChecking(checking);
		person.addSavings(savings);
		System.out.println(person.hasChecking());
		System.out.println(person.hasSavings());
		System.out.println(person.checking.toString());
		System.out.println(person.savings.toString());
		System.out.println(person.amtOfAccounts());
		
	}
	
}

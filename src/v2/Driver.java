package v2;

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
		
		String str = "poO1dhu";

		System.out.println(poop(str));

		
//		boolean hasNumber = false;
//		boolean hasUppercase = false;
//		boolean longEnough = false;
//		int i = 0;
//		
//		while(!hasNumber || !hasUppercase || !longEnough) {
//			
//			for(i = 0; i < str.length(); i++) {
//				char currentLetter = str.charAt(i);
//				
//				if(str.length() >= 7) {
//					longEnough = true;
//				}
//				if(Character.isDigit(currentLetter)) {
//					hasNumber = true;
//				}
//				if(Character.isUpperCase(currentLetter)) {
//					hasUppercase = true;
//				}
//			}
//		}
//		
	}
	
	public static boolean poop(String user) {
		boolean hasDigit = false;
		boolean hasUppercase = false;
		boolean longEnough = false;

		for(int i = 0; i < user.length(); i++) {
			char currentLetter = user.charAt(i);

			if(Character.isDigit(currentLetter)) {
				hasDigit = true;
			}
			if(Character.isUpperCase(currentLetter)) {
				hasUppercase = true;
			}
			if(user.length() >= 7) {
				longEnough = true;
			}
		}
		
		if(hasDigit && hasUppercase && longEnough) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}

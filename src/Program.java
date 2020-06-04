public class Program {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		bank.createAccount(100.00);
		bank.createAccount(250.00);
		bank.createAccount(200.00);
		bank.createAccount(300.00);
		
		for(Account a : bank.getAccounts()) {
			System.out.println(a.toString());	
			System.out.println("\n");
		}
		
		bank.doTransfer(bank.getAccounts().get(0), bank.getAccounts().get(1), 50.00);

		for(Account a : bank.getAccounts()) {
			System.out.println(a.toString());	
			System.out.println("\n");
		}
	}

}

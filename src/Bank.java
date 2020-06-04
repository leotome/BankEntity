import java.util.ArrayList;

//https://gist.github.com/rodrigovilar/fb67b220302ffe5af323388bb45f46e4

public class Bank {
	private ArrayList<Account> accounts;
	
	public Bank() {
		this.accounts = new ArrayList<Account>();
	}
	
	public ArrayList<Account> getAccounts(){
		return this.accounts;
	}

	public void createAccount(double initialBalance) {
		Account account = new Account(initialBalance);	//Create account with Id = formatted and a provided initial balance
		this.accounts.add(account);						//Add this account to accountList
	}
	
	public void doTransfer(Account source, Account destination, double amount) {
		Transfer transfer = new Transfer();
		transfer.setParameters(source, destination, amount);
		transfer.run();
	}
	
}

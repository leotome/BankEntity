import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts;
	
	//Bank controller constructor
	public Bank() {
		this.accounts = new ArrayList<Account>();
	}
	
	//Return specific account by Id
	public Account createAccount(double initialBalance) {
		//Create account with Id = formatted and a provided initial balance
		Account account = new Account(initialBalance);
		//Add this account to accountList
		this.accounts.add(account);
		return account;
	}	
	
	//Return accounts
	public ArrayList<Account> getAccounts(){
		return this.accounts;
	}
	
	//Return specific account by Id
	public Account getAccountById(long Id) {
		Account account = null;
		for(Account a : this.getAccounts()) {
			if(a.getId() == Id) {
				account = a;
			}
		}
		return account;
	}
	
	//Request transfer
	public void requestTransfer(Account source, Account destination, double amount) {
		//Instantiate a transfer object 
		Transfer transfer = new Transfer();
		//Set parameters
		transfer.setParams(source, destination, amount);
		//Run the transaction in a thread, out of main thread
        new Thread(new Runnable() {
			public void run() {
				transfer.run();
			}
        }).start();
	}
}

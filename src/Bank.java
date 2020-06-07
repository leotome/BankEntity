import java.util.ArrayList;
import java.util.Random;

public class Bank {
	private ArrayList<Account> accounts;
	
	public Bank() {
		this.accounts = new ArrayList<Account>();
	}
	
	public ArrayList<Account> getAccounts(){
		return this.accounts;
	}
	
	public Account getRandomAccount() {
		Random random = new Random();
		Integer randomIndex = random.nextInt(this.getAccounts().size());
		Account account = this.getAccounts().get(randomIndex);
		return account;
	}
	
	public Account getAccountById(long Id) {
		Account account = null;
		for(Account a : this.getAccounts()) {
			if(a.getId() == Id) {
				account = a;
			}
		}
		return account;
	}

	public Account createAccount(double initialBalance) {
		Account account = new Account(initialBalance);	//Create account with Id = formatted and a provided initial balance
		this.accounts.add(account);						//Add this account to accountList
		return account;
	}
	
	public void requestTransfer(Account source, Account destination, double amount) {
		Transfer transfer = new Transfer();
		transfer.setParams(source, destination, amount);
		transfer.run();
	}
	
}

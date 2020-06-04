import java.util.concurrent.atomic.AtomicInteger;

public class Account {
	//Thread-safe integer increment
	private static AtomicInteger atomicInteger = new AtomicInteger(1000);
	//Account Id
	private long Id;
	//Account Balance
	private double balance;
	
	public Account(double initialBalance) {
		//Increment and get and Id
		this.Id = atomicInteger.incrementAndGet();
		//Set Initial Balance
		this.balance = initialBalance;
	}
	
	public long getId() {
		return this.Id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		String result = "Id = " + this.Id + "\n" + "Balance = €" + this.getBalance();
		return result;
	}
}

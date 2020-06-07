import java.util.concurrent.locks.ReentrantLock;

public class Transfer implements Runnable {
	private final ReentrantLock lock = new ReentrantLock();
	private Account source;
	private Account destination;
	private double amount;
	
	public void setParameters(Account source, Account destination, double amount) {
		this.source = source;
		this.destination = destination;
		this.amount = amount;		
	}

	public void run() {
		this.lock.lock();
		try {
			if(this.source.getBalance() >= this.amount) {
				this.source.setBalance(this.source.getBalance() - amount);
				this.destination.setBalance(this.destination.getBalance() + amount);
				System.out.println("€" + this.amount + " was sucessfully transfered from " + this.source.getId() + " to " + this.destination.getId());
			}
		} finally {
			lock.unlock();
		}
	}
}

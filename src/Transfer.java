import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Transfer implements Runnable{
	private Account source;
	private Account destination;
	private double amount;
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void setParams(Account source, Account destination, double amount) {
		this.source = source;
		this.destination = destination;
		this.amount = amount;		
	}
	
	public void run(){
		lock.lock();
		try {
			if(this.source.getBalance() >= this.amount) {
				this.source.setBalance(this.source.getBalance() - amount);
				this.destination.setBalance(this.destination.getBalance() + amount);
				System.out.println("€" + this.amount + " was sucessfully transfered from " + this.source.getId() + " to " + this.destination.getId());
				this.condition.signal();
			} else {
				System.out.println("Transaction denied. Insufficient balance on " + this.source.getId() + ". Waiting for sufficient amount. (" + this.source.getId() + "-" + this.destination.getId() + "-" + this.amount + ")");
				this.condition.await();
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
}

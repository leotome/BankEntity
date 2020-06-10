import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws FileNotFoundException {
		Bank bank = new Bank();
		
		
		//Calls in the System.in to receive user input
		Scanner in = new Scanner(System.in);
		System.out.println("===== BANK ENTITY SIMULATOR =====");
		System.out.print("Amount of accounts to be created (n) = ");
		Integer noOfAccounts = Integer.parseInt(in.nextLine());
		System.out.print("Initial balance for each account (a) = ");
		double amountBalance = Double.valueOf(in.nextLine());
		in.close();
		
		//Creates the number of accounts from given input, with initial balance
		for(Integer i = 1; i <= noOfAccounts; i++) {
			bank.createAccount(amountBalance);
		}
		
		//Dumps recently created accounts to a *.csv
		try(PrintStream out = new PrintStream(new FileOutputStream("Grupo4_BeforeTransactions.csv"))){
			out.println("Id,Balance");
			for(Account a : bank.getAccounts()) {
				out.println(a.getId()+","+a.getBalance());
			}
			out.close();
		}
		

		Random random = new Random();
		
		for(Integer t = 0; t<bank.getAccounts().size()-2; t++) {
			//Get t account, set as "source"
			Account source = bank.getAccounts().get(t);
			//Get t+2 account, set as "destination"
			Account destination = bank.getAccounts().get(t+2);
			//Generate the random transaction amount
			double transactionAmount = new BigDecimal((random.nextDouble() * (int) source.getBalance() )).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
			//Request transfer for bank controller
			bank.requestTransfer(source, destination, transactionAmount);
		}		
		
		//Dumps account information to a *.csv, so we can compare with the status before transactions
		try(PrintStream out = new PrintStream(new FileOutputStream("Grupo4_AfterTransactions.csv"))){
			out.println("Id,Balance");
			for(Account a : bank.getAccounts()) {
				out.println(a.getId()+","+a.getBalance());
			}
			out.close();
		}
		
	}

}

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
		Integer transactions = random.nextInt(noOfAccounts)*10;		
		//Integer transactions = random.nextInt(random.nextInt(noOfAccounts));
		
		for(Integer t = 1; t<=transactions; t++) {
			System.out.println("+++ SOURCE ACCOUNT +++");
			Account source = bank.getRandomAccount();
			System.out.println(source.toString());
			System.out.println("+++ DESTINATION ACCOUNT +++");
			Account destination = bank.getRandomAccount();
			System.out.println(destination.toString());
			double transactionAmount = new BigDecimal((random.nextDouble() * 150.0)).setScale(2, RoundingMode.HALF_EVEN).doubleValue();			
			System.out.println("+++ TRANSACTION AMOUNT = "+transactionAmount+" +++");
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

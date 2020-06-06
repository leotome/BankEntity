import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Scanner in = new Scanner(System.in);
		System.out.println("== BANK ENTITY SIMULATOR ==");
		System.out.print("Amount of accounts to be created (n) = ");
		Integer noOfAccounts = Integer.parseInt(in.nextLine());
		System.out.print("Initial balance for each account (a) = ");
		double amountBalance = Double.valueOf(in.nextLine());
		in.close();
		
		for(Integer i = 1; i <= noOfAccounts; i++) {
			bank.createAccount(amountBalance);
		}
		
		
		/*	O PROFESSOR RESPONDEU QUE AS SEGUINTES INFORMAÇÕES DEVEM SER
		    GERADAS AUTOMATICAMENTE PELO PROGRAMA:
			- quantidade de transferências //TODO
			- valor da transferência 	   //TODO
			- conta origem                 //TODO
			- conta destino                //TODO
		*/
		
		
		
		System.out.println("== ANTES DAS TRANSFERÊNCIAS ==");
		for(Account a : bank.getAccounts()) {
			System.out.println(a.toString());	
		}
		
		System.out.println("");
		

	    
	    for(int i = 0; i < 29; i++) {
		    int x = (int)(Math.random()*((29-0)+0))+0;
		    int y = (int)(Math.random()*((29-0)+0))+0;
		    while(x==y) {
		    	y = (int)(Math.random()*((29-0)+0))+0;
		    }	  
		    bank.doTransfer(bank.getAccounts().get(x), bank.getAccounts().get(y), 10.00);
		    //if(i + 1 == 29) {
		    //	bank.doTransfer(bank.getAccounts().get(bank.getAccounts().size()-1), bank.getAccounts().get(0), 10.00);		    	
		    //}
	    }
		
		System.out.println("== DEPOIS DAS TRANSFERÊNCIAS ==");
		for(Account a : bank.getAccounts()) {
			System.out.println(a.toString());	
		}
		
	}

}

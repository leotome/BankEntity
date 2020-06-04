public class Program {
	public static void main(String[] args) {
		Bank bank = new Bank();
		

		
		for(int i = 1; i < 31; i++) {
			double baseValue = 50.00;
			bank.createAccount(baseValue + (baseValue * i/100));
		}

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

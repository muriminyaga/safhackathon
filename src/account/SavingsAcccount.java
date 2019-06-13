package account;

import customer.Customer;

public class SavingsAcccount extends BankAccount {
	 
	  public SavingsAcccount(int id, String name, double balance,Customer accountCustomer) {
	 	 super(id, name, balance,accountCustomer);
		// TODO Auto-generated constructor stub
	   }

	   public void withdraw(double amount)	     
       {	    
        accountBalance = accountBalance - amount;	     
       }
     
	   //test
       public static void main(String[] args) {
		  // SavingsAcccount bankAccount= new SavingsAcccount(1122,"John Murimi",600);
		 //   bankAccount.deposit(4500.00);
		 //  bankAccount.displayAccountTransaction();
       }
	

}

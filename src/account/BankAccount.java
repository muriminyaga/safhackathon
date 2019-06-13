package account;

import java.math.BigDecimal;

import customer.Customer;
/**
 * Customer
 */
public class BankAccount {
	    int accountID;	   
	    String accountName;
	    double accountBalance;
	    Customer customer;

	      public BankAccount(int id,String name,double balance,Customer customer) {
	    	  this.accountID=id;	   
	    	  this.accountName=name;
	    	  this.accountBalance=balance; 
	    	  this.customer=customer; 
	      }
	      
	      public Customer getCustomer()
	        {
	    	return this.customer;      
	        }
	      
	       public void deposit(Double amount)
	     
	        {
	    	accountBalance=accountBalance+amount;
	        
	        }
	    	       
	        public void withdraw(double amount)	     
	        {	    
	         accountBalance = accountBalance - amount;	     
	        }
	     
	
	        public void setBalance(double amount)  
	        {
	        	 accountBalance= amount;
	        }
	        public double getBalance()  
	        {
	        	 return accountBalance;
	        }
	     
	    
	        public void displayAccountTransaction()
	        {    
	        System.out.println("Name: " + accountName + "\n" + "Account ID: " + accountID + "\n" + "Account Balance Kes" +  accountBalance + "\n");
	   
	        }
	       
	        public void displayAccountBalance()
	        {    
	        System.out.println( "Current Balance Kes" +  accountBalance + "\n");
	        }
	        
	        //test
	        public static void main(String[] args) {
	        	 Customer customer = new Customer(001,"John Murimi",4.0,65220,2,1);
	        	
	        	 BankAccount bankAccount= new BankAccount(1122,"John Murimi",200,customer);
	        	 bankAccount.displayAccountTransaction();
	        	 
	        	 System.out.println( "Customer day deposits amount Kes" +  customer.getTotalDayDepositAmount() + "\n");  
	        }
}

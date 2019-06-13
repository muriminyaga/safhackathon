package customer;

import account.BankAccount;

public class Customer {
	
	int id;
	   String name;
	   double totalDayWithdrawalAmount;
	   double totalDayDepositAmount;
	   int totalDayWithdrawals;
	   int totalDayDeposits;
	  
	   public Customer(int id,String name,double totalDayWithdrawal,double totalDayDeposit,int totalDayWithdrawalsFrequency,int totalDayDepositsFrequency) {
		    this.id=id;
		    this.name=name;
		    this.totalDayWithdrawalAmount=totalDayWithdrawal;
		    this.totalDayDepositAmount=totalDayWithdrawal;
		    this.totalDayWithdrawals=totalDayWithdrawalsFrequency;
		    this.totalDayDeposits=totalDayDepositsFrequency;
	      }

   public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalDayWithdrawalAmount() {
		return totalDayWithdrawalAmount;
	}

	public void setTotalDayWithdrawalAmount(double totalDayWithdrawalAmount) {
		this.totalDayWithdrawalAmount = this.totalDayWithdrawalAmount + totalDayWithdrawalAmount;
	}

	public double getTotalDayDepositAmount() {
		return this.totalDayDepositAmount;
	}

	public void setTotalDayDepositAmount(double totalDayDepositAmount) {
		this.totalDayDepositAmount = this.totalDayDepositAmount + totalDayDepositAmount;
	}

	public int getTotalDayWithdrawals() {
		return this.totalDayWithdrawals;
	}

	public void setTotalDayWithdrawals(int totalDayWithdrawals) {
		this.totalDayWithdrawals =this.totalDayWithdrawals + totalDayWithdrawals;
	}

	public int getTotalDayDeposits() {
		return this.totalDayDeposits;
	}

	public void setTotalDayDeposits(int totalDayDeposits) {
		this.totalDayDeposits = this.totalDayDeposits + totalDayDeposits;
	}
	
	public void displayDepositStatus() {
		 System.out.print( "Total Deposited Amount Today Kes" + this.totalDayDepositAmount + "\n"); 
		 System.out.print( "Total Number Of Deposits Today " + this.totalDayDeposits + "\n"); 
	}
	
	public void displayWithdrawalStatus() {
		 System.out.print( "Total Withdrawal Amount Today  Kes" + this.totalDayWithdrawalAmount + "\n"); 
		 System.out.print( "Total Number Of Withdrawals Today " + this.totalDayWithdrawals + "\n"); 
	}
	

	//simple test
	 public static void main(String[] args) {
    	 Customer customer = new Customer(001,"John Murimi",4.0,65220,0,0);
    	 System.out.println( "Customer getTotalDayWithdrawalAmount  Kes" +  customer.getTotalDayWithdrawalAmount() + "\n");  
    }
	
	


}

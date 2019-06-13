package bank;
import java.util.*;

import account.SavingsAcccount;
import customer.Customer;
/**
 * Atm Program - Safaricom Hackathon - john murimi nyaga
 */ 
public class Atm implements AtmInterface{
    //scanner to read keyboard entry in the console
    public static Scanner inputScanner = new Scanner(System.in);
    public static SavingsAcccount savingsAccount;
    public Customer customer;
    
    public static final  int maxTotalDayDepositAmount=150000;
    public  static  final  int maxSingleDepositAmount=40000;
    public  static  final  int maxDayDepositsFrequency=4;
    
    public static  final  int maxTotalDayWithdrawalAmount=50000;
    public static  final  int maxSingleWithdrawalAmount=20000;
    public  static final  int maxDayWithdrawalsFrequency=3;
     
    public Atm(int accountId,String accountName,double accountBalance,int customerId,String customerName,double totalDayWithdrawal,double totalDayDeposit,int totalDayWithdrawalsFrequency,int totalDayDepositsFrequency) {
    	
    	 Customer customer =  new Customer(customerId,
    			 customerName,
    			 totalDayWithdrawal,
    			 totalDayDeposit,
    			 totalDayWithdrawalsFrequency,
    			 totalDayDepositsFrequency);
    	 savingsAccount = new SavingsAcccount(accountId,accountName,accountBalance,customer);
      }
   
    
    public static int menu()
    {
        int menuChoice;
        do
        { 
        System.out.print("\nEnter Menu Option:"
                    + "\n 1. Display Balance \n 2. Deposit"
                    + "\n 3. Withdraw\n 4. Log Out\n\n");

        menuChoice = inputScanner.nextInt();

          if (menuChoice < 1 || menuChoice > 4){
                System.out.println("Invalid Option");
            }

        }while (menuChoice < 1 || menuChoice > 4);

        return menuChoice;
    }
    
    
    

    public void displayBalance()
    {
    	savingsAccount.displayAccountBalance();
    	 
    }
    
    public void displayWithdrawalStatus()
    {
    	savingsAccount.getCustomer().displayWithdrawalStatus();
    	 
    }
    
    public void displayDepositStatus()
    {
    	savingsAccount.getCustomer().displayDepositStatus();
    	 
    }
    
    public double getBalance()
    {
    	return savingsAccount.getBalance();
    }

    public void deposit(double amount)
    {
    	savingsAccount.deposit(amount);
    	savingsAccount.getCustomer().setTotalDayDepositAmount(amount);
    	savingsAccount.getCustomer().setTotalDayDeposits(1); //increase deposits counter for customer
    }
    
    public void withdraw(double amount)
    {
    	savingsAccount.withdraw(amount);
    	savingsAccount.getCustomer().setTotalDayWithdrawalAmount(amount);
    	savingsAccount.getCustomer().setTotalDayWithdrawals(1);  //increase withdrawals counter for customer
    	savingsAccount.displayAccountTransaction();
    }
    
     

    public static void main(String[] args) {

    	//create a customer saving account with 0 balance, 0 total withdrawals and Deposits
    	
    	Atm atm = new Atm(001,"Savings Account",0.0,001,"Customer Name",0.0,0.0,0,0);

        String origBal = "0";
        int  menuOption = 0;
        double depositAmount = 0, withdrawAmount = 0, currentBal=0; 
        
        currentBal=Double.parseDouble(origBal);
        
        
        
        //a loop to give the user repeated options to Deposit/Withdraw/Check Balance until the user exits
       while (menuOption != -1)
        { 
            menuOption=menu();
            switch (menuOption)
            {
            case 1:
            	atm.displayBalance();
            	atm.displayDepositStatus();
            	atm.displayWithdrawalStatus();
                break;
            case 2:
                System.out.print("\nEnter Amount You Wish to Deposit: Kes :");
                 depositAmount=inputScanner.nextDouble();
                  
                 if(depositAmount>Atm.maxSingleDepositAmount){
                     System.out.print("You cannot deposit more than. Kes : " + Atm.maxSingleDepositAmount
                             + "Enter another amount Kes:");
                    // depositAmount = inputScanner.nextDouble();
                 }
                 
                 else if(depositAmount + savingsAccount.getCustomer().getTotalDayDepositAmount() >Atm.maxTotalDayDepositAmount){
                     System.out.print("You cannot deposit more than. Kes : " + Atm.maxTotalDayDepositAmount + "In One Day"
                             + "Enter another amount Kes:");
                   //  depositAmount = inputScanner.nextDouble();
                 }
                 
                 else if(savingsAccount.getCustomer().getTotalDayDeposits()  >= Atm.maxDayDepositsFrequency){
                     System.out.print("You cannot deposit more than: " + Atm.maxDayDepositsFrequency + "Times In One Day");
                    // withdrawAmount = kbd.nextDouble();
                     System.exit(0);
                     break;
                 }
                 else { 
                  atm.deposit(depositAmount);
                  atm.displayBalance();
                 }
                break;
            case 3:
                 System.out.print("\nEnter Amount You Wish to Withdrawl: Kes :");
                 withdrawAmount =inputScanner.nextDouble();
                 currentBal=atm.getBalance();
                if(withdrawAmount>currentBal){
                    System.out.print("Your Account Has Insufficient Funds "
                            + "Enter another amount Kes:");
                   // withdrawAmount= inputScanner.nextDouble();
                }
                
                else if(withdrawAmount>Atm.maxSingleWithdrawalAmount){
                    System.out.print("You cannot withdrawal more than. Kes : " + Atm.maxSingleWithdrawalAmount
                            + "Enter another amount Kes:");
                   // withdrawAmount = inputScanner.nextDouble();
                }
                
                else  if(withdrawAmount + savingsAccount.getCustomer().getTotalDayWithdrawalAmount()  >Atm.maxTotalDayWithdrawalAmount){
                    System.out.print("You cannot withdrawal more than. Kes : " + Atm.maxTotalDayWithdrawalAmount + "In One Day"
                            + "Enter another amount Kes:");
                   // withdrawAmount = inputScanner.nextDouble();
                }
                
                else  if(savingsAccount.getCustomer().getTotalDayWithdrawals()  >= Atm.maxDayWithdrawalsFrequency){
                    System.out.print("You cannot withdrawal more than: " + Atm.maxDayWithdrawalsFrequency + "Times In One Day");
                  //  inputScanner.nextDouble();
                }
                
                else { atm.withdraw(withdrawAmount);
                atm.displayBalance();
                }
                break;
            case 4:
            	 System.out.print("\nAre you sure you want to quit? (1/0).");
            	 int exit = inputScanner.nextInt(); 
            	 if(exit==1) {
            		 System.out.print("\nThank For Using Our Services.");
                     System.exit(0);
            	 }
            	 
            	 break;
            	 
            }
        }
    }
    
    
}
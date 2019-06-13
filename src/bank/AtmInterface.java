package bank;

public interface AtmInterface {
	
	public void displayBalance();
	
	public void displayDepositStatus();
	
	public void displayWithdrawalStatus();
	
	public double getBalance();
	
	public void deposit(double amount);
	
	public void withdraw(double amount);

}

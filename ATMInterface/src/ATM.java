import java.util.Scanner;

class BankAccount
{
	private double balance;
	
	public BankAccount(double balance)
	{
		this.balance=balance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount)
	{
		if(amount>0)
		{
			balance += amount;
			System.out.println("Deposit successful.....");
			
		}
		else
		{
			System.out.println("Invalid amount for deposit.....");
		}
	}
	
	public void withdraw(double amount)
	{
		if(amount > 0 && amount <= balance)
		{
			balance -= amount;
			System.out.println("Withdrawl successful....");
		}
		else if(amount>balance)
		{
			System.out.println("Insufficient balance.....");
		}
		else
		{
			System.out.println("Invalid amount for withdrawl....");
		}
	}
	
	
}


public class ATM {

	private BankAccount bankAccount;
	private Scanner scan;
	
	public ATM(BankAccount bankAccount, Scanner scan)
	{
		this.bankAccount=bankAccount;
		this.scan=scan;
	}
	
	public void displayMenu()
	{
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Check balance");
		System.out.println("4. Exit....");
	}
	
	public void operate()
	{
		while(true)
		{
			displayMenu();
			System.out.println("Enter your choice:");
			int ch = scan.nextInt();
			
			switch(ch) 
			{
			
			case 1:  
				System.out.println("Enter amount to withdraw:");
				double withdrawAmount = scan.nextDouble();
				bankAccount.withdraw(withdrawAmount);
				break;
				
			case 2:
				System.out.println("Enter amount to deposit:");
				double depositAmount=scan.nextDouble();
				bankAccount.deposit(depositAmount);
				break;
				
			case 3:
				System.out.println("Your balance is:" +bankAccount.getBalance());
				break;
			
			case 4:
				System.out.println("Exit...");
				scan.close();
				System.exit(0);
				
			default:
				System.out.println("Invalid choice... Enter the no between 1 to 4  ");
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		BankAccount bankAccount=new BankAccount(1000.0);
		Scanner scan=new Scanner(System.in);
		ATM atm= new ATM(bankAccount, scan);
		atm.operate();
	}

}

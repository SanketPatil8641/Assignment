package edu.e2e.coll.ui;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import edu.e2e.coll.model.Account;
import edu.e2e.coll.service.BankServer;
import edu.e2e.coll.db.AccountDb;

public class BankApp {

	Scanner sc = new Scanner(System.in);
	BankServer server ;
	
	Scanner scan = new Scanner(System.in);
	
	public BankApp() {
		server = new BankServer();
	}
	
	public static void main(String[] args) {
		
		
		BankApp app = new BankApp();
		while(true)
		{
			System.out.println(" ----- OPERATIONS ----");
			System.out.println("1. Open Account ");
			System.out.println("2.Deposit Amount to Acount");
			System.out.println("3.Withdraw Amount from Account ");
			System.out.println("4.Transfer Amount to Account");
			System.out.println("5.Search Account By Balance Range");
			System.out.println("6.Search Account By Account Number ");
			System.out.println("7.Search Account By Location ");
			System.out.println("8.Display All Accounts ");

			
			System.out.println("0. Exit");
			System.out.println("Enter Option :- ");
			
			switch (new Scanner(System.in).nextInt()) {
			case 1:
				app.fillBankForm();
				break;
			case 2:
				app.depositAmount();
				break;
			
			case 3:
				app.withdrawAmount();
				break;
			case 4:
				app.transferAmount();
				break;
			case 5:
				app.getAccountByBalanceRange();
				break;
			case 6:
				app.searchAccountByAccountNumber();
				
				break;
			case 7:
				app.getAccountByUsingLocation();
				break;
			case 8:
				app.getAllAccounts();
				break;
			
			case 0:
				System.exit(0);
			}// end switch
		}
	}//  End of main
	public void getAllAccounts() {
		List<Account> allAccounts = server.getAllAccounts();
		for (Account a : allAccounts) {
			displayAccounts(a);
		}	
	}

	

	public void fillBankForm()
	{
		System.out.println("Enter Account Holder Name : - ");
		String name = scan.nextLine();
		
		System.out.println("Enter Balance : - ");
		int balance = sc.nextInt();
		
		System.out.println("Enter Location: - ");
		String location = scan.nextLine();
		
		int accountNumber = new Random().nextInt(100);
		
		
		Account a = new Account(accountNumber, name, balance, location);
		String notification = server.openNewAccount(a);
		System.out.println("Notification :- "+notification);
	}
	
	public void searchAccountByAccountNumber()
	{
		System.out.println("Enter Account No to be Searched  : - ");
		int searchaccountNumber = Integer.parseInt(scan.nextLine());
		
		Account a = server.searchAccountByAccountNumber(searchaccountNumber);
		
		if(a != null) 
		{
			displayAccounts(a);
		}	
		else System.out.println(" Employee Not Found For ID : "+searchaccountNumber);
	
	}
	
	public  void getAccountByBalanceRange() {
		System.out.println("Enter Balance Start Range - ");
		int source = sc.nextInt();

		System.out.println("Enter Balance End Range - ");
		int target = sc.nextInt();

		List<Account> lst = server.getAccountByBalanceRange(source, target);
		for(Account a : lst) 
		{
			displayAccounts(a);
		}
	}
	public void getAccountByUsingLocation() {
		System.out.println("Enter Location To Search Accounts - ");
		String loc = scan.nextLine();

		List<Account> lst = server.getAccountByLocation(loc);
		for(Account a : lst) {
			displayAccounts( a);
		}
	}
	public void depositAmount () {
		System.out.println("Enter Account Number - ");
		int accountNum = sc.nextInt();

		System.out.println("Enter Amount to Deposit - ");
		int amount1 = sc.nextInt();

		Account a = server.depositAmount(accountNum, amount1);

		if (a != null) {
			System.out.println("Amount Deposited to - "+a.getAccountNumber()+" Current Balance is - "+a.getBalance());
		} else {
			System.out.println("Account Number Not Found");
		}
		}
		
	public void withdrawAmount () {
		System.out.println("Enter Account Number - ");
		int accountNum = sc.nextInt();

		System.out.println("Enter Amount to Withdraw - ");
		int amount1 = sc.nextInt();

		try {
			Account a = server.withdrawAmount(accountNum, amount1);
			if (a != null) {
				System.out.println("Amount Withdrawal Successful To - "+a.getAccountNumber()+" Current Balance Is - "+a.getBalance());
			} else {
				System.out.println("Account Number Not Found.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void transferAmount () {
		System.out.println("Enter Source Account Number - ");
		int source = sc.nextInt();

		System.out.println("Enter Target Account Number - ");
		int target = sc.nextInt();

		System.out.println("Enter Amount to Transfer - ");
		int amount = sc.nextInt();
		try {
			Account a = server.transferAmount(source, target, amount);
			if (a != null) {
				System.out.println("Amount Transferred To - "+a.getAccountNumber()+" Current Balance Is - "+a.getBalance());
			} else {
				System.out.println("Account Number Not Found");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

	public void displayAccounts(Account a) {
		System.out.println("Account Number = " + a.getAccountNumber() + ", Account Holder Name = " + a.getAccountHolderName() + ", Balance = "
				+ a.getBalance() + ", Location = " + a.getLocation());
	}

	
	
}

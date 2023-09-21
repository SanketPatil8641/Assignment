package map.collectiona.assignments_2;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BankApp {
	
	Scanner scan = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);
	AccountDb db;

 

	public BankApp() {
		db = new AccountDb();
	}

	public static void main(String[] args) {
		BankApp app = new BankApp ();
		
		while(true) {
			System.out.println("------------- Operations To Perform --------------------");
			System.out.println("1. Insert New Account in Map ");
			System.out.println("2. Get All Accounts Based on Location ");
			System.out.println("3. Get All Accounts By Balance range ");
			System.out.println("4. Get All Accounts By Account Number ");
			System.out.println("0. Exit \n");
			System.out.println("------------- Enter Option -----------------------------");

			switch (new Scanner(System.in).nextInt()) {
			case 1:
				app.fillAccountForm();;
				break;
			case 2:
				app.getAllAccountsByLocation();
				break;

			case 3:
				app.getAccountByBalanceRange();
				break;

			case 4:
				app.getAccountByNumber();
				break;

			case 0:
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	public void fillAccountForm() {
		int accountNumber = new Random().nextInt(1000);

		System.out.println("Enter Account Holder Name - ");
		String accountHolderName = sc.nextLine();

		System.out.println("Enter Account Balance - ");
		int accountBalance = scan.nextInt();

		System.out.println("Enter Location - ");
		String accountLocation = sc.nextLine();

		Account a = new Account(accountNumber, accountHolderName, accountBalance, accountLocation);
		int noti = db.openNewAccount(a);
		System.out.println(noti);
	} 

	public void getAllAccountsByLocation() {
		System.out.println("Enter Location To Search Accounts - ");
		String loc = scan.nextLine();

		db.getAccountsByLocation(loc);
	}

	public void getAccountByBalanceRange() {
		System.out.println("Enter Balance Start Range - ");
		int source = scan.nextInt();

		System.out.println("Enter Balance End Range - ");
		int target = scan.nextInt();

		List<Account> lst = db.getAccountBasedOnBalanceRange(source, target);
		for(Account a : lst) {
			displayAccounts(a);
		}
	}

 

	public void getAccountByNumber() {
		System.out.println("Enter Account Number To Search - ");
		int num = scan.nextInt();

		Account acc = db.getAccountByNumber(num);
		if (acc != null) {
			displayAccounts(acc);
		} else {
			System.out.println("Account Not Found For Number - "+num);
		}
	}

 

	private void displayAccounts(Account a) {
		System.out.println("Account Number = " + a.getAccountNumber() + ", Account Holder Name = " + a.getAccountHolderName() + ", Balance = "
				+ a.getBalance() + ", Location = " + a.getLocation());
	}
}


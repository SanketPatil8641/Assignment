package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class BankApp {

	public static void main(String[] args) {

		TreeSet<Account> allAccounts = new TreeSet<>();

		Account a1 = new Account(1, "Sanket",50000, "Islampur");
		Account a2 = new Account(2, "Pranay",30000, "Nagpur");
		Account a3 = new Account(3, "Shekhar",70000, "Satara");
		Account a4 = new Account(4, "Pratyush",40000, "Sangli");
		Account a5 = new Account(5, "Aditya",60000, "Kolhapur");


		allAccounts.add(a1);
		allAccounts.add(a2);
		allAccounts.add(a3);
		allAccounts.add(a4);
		allAccounts.add(a5);
		
		System.out.println(allAccounts);
		
		System.out.println("---  Account Class in Treeset  ----------");
		for (Account a : allAccounts) {
			System.out.println(a);
		}

		System.out.println("\n----- Account Balance (High to Low)----------");
		getAccountBalanceHighToLow(allAccounts);

		System.out.println("\n-----Account Balance (Low to High)----------");
		getAccountBalanceLowToHigh(allAccounts);


		System.out.println("\n---  Account Location  ----------");
		getAccountSortByLocation(allAccounts);
		
	}

	public static void getAccountBalanceHighToLow(TreeSet<Account> allAccounts)
	{
		List<Account> tempList = new ArrayList<>();
		tempList.addAll(allAccounts);

		AccountBalanceHighToLow sortCode = new AccountBalanceHighToLow();

		Collections.sort(tempList, sortCode);

		for (Account a : tempList) {
			System.out.println(a);
		}

	}

	public static void getAccountBalanceLowToHigh(TreeSet<Account> allAccounts)
	{
		List<Account> tempList = new ArrayList<>();
		tempList.addAll(allAccounts);

		AccountBalanceLowToHigh sortCode = new AccountBalanceLowToHigh();

		Collections.sort(tempList, sortCode);

		for (Account a : tempList) {
			System.out.println(a);
		}

	}

	public static void getAccountSortByLocation(TreeSet<Account> allAccounts)
	{
		List<Account> tempList1 = new ArrayList<>();
		tempList1.addAll(allAccounts);

		Collections.sort(tempList1);

		for (Account a : tempList1) {
			System.out.println(a);
		}

	}


}


package edu.e2e.coll.db;

import edu.e2e.coll.exception.*;

import java.util.ArrayList;
import java.util.List;


import edu.e2e.coll.model.Account;
public class AccountDb {
	
	List<Account> allAccounts=new ArrayList<>();
	
	public int openNewAccount(Account a)
	{
		boolean status = allAccounts.add(a);
		return status ? a.getAccountNumber():-1;
		
	}
	
	public Account searchAccountByAccountNumber(int searchAccountNumber)
	{
		for (Account account : allAccounts) {
			if(account.getAccountNumber()==(searchAccountNumber))
			{
				return account;
			}
		}
		return null;
	}
	
	public List<Account> getAccountByLocation(String searchLocation)
	{
		List<Account> tempList = new ArrayList<>();
		for (Account account : allAccounts) {
			if(account.getLocation().equals(searchLocation))
			{
				tempList.add(account);
			}
		}
		
		return tempList;
	}
	
	public List<Account> getAccountByBalanceRange(int r1,int r2)
	{
		List<Account> tempList = new ArrayList<>();
		for (Account account : allAccounts) {
			if(account.getBalance()>=r1 && account.getBalance()<=r2)
			{
				tempList.add(account);
			}
		}
		
		return tempList;
	}
	
	public Account depositAmount(int accNum, int amt) {
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNum) {
				a.setBalance(a.getBalance()+amt);
				return a;
			}
		}
		return null;
	}
	
	public Account withdrawAmount(int accNum, int amt) throws LowBalanceException {
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNum) {
				if (a.getBalance() >= 5000) {
					a.setBalance(a.getBalance()-amt);
					return a;
				} else {
					throw new LowBalanceException();
				}
			}
		}
		return null;
	}
	
	public Account transferAmount(int accNumSource,int accNumTarget, int amt) throws LowBalanceException {
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNumSource) {
				if (a.getBalance() >= 5000) {
					a.setBalance(a.getBalance()- amt);
					return a;
				} else {
					throw new LowBalanceException();
				}
			}
		}
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNumTarget) {
				a.setBalance(a.getBalance()+ amt);
				return a;
			}
		}
		return null;
	}
	
	public List<Account> getAllAccounts()
	{
		return allAccounts;
	}
}

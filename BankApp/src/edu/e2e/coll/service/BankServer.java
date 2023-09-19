package edu.e2e.coll.service;

import edu.e2e.coll.model.Account;

import java.util.List;

import edu.e2e.coll.db.AccountDb;
import edu.e2e.coll.exception.LowBalanceException;


public class BankServer {
			
	private AccountDb db;
	
	public BankServer()
	{
		db = new AccountDb();
	}
	public String openNewAccount(Account a)
	{
		int fromDBAccountNo = db.openNewAccount(a);
		if(fromDBAccountNo != -1)
		{
			return " New Account No "+fromDBAccountNo;
		}
		else 
		{
			return "ERROR !!! Contact to ";
		}
	}
	
	public Account searchAccountByAccountNumber(int searchAccountNumber)
	{
		return db.searchAccountByAccountNumber(searchAccountNumber);
		
	}

	public List<Account> getAccountByLocation(String searchLocation)
	{
		return db.getAccountByLocation(searchLocation);
		
	}
	
	public List<Account> getAccountByBalanceRange(int r1,int r2)
	{
		return db.getAccountByBalanceRange(r1, r2);
		
	}
	public Account depositAmount(int accNum, int amt) {
		return db.depositAmount(accNum, amt);
	}
	public Account withdrawAmount(int accNum, int amt) throws LowBalanceException
	{
		return db.withdrawAmount(accNum, amt);
	}
	public Account transferAmount(int accNumSource,int accNumTarget, int amt) throws LowBalanceException 
		{
			return db.transferAmount(accNumSource, accNumTarget, amt);
		}
		
	public List<Account> getAllAccounts()
	{
		return db.getAllAccounts();
	}
	
	
}

package p1;

import java.util.Comparator;

public class AccountBalanceLowToHigh implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		return o1.getBalance()-o2.getBalance();
	}
	
}

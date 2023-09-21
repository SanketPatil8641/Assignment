package map.collectiona.assignments_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer , Account> accountMap = new HashMap<>();
		List<Account> list=new ArrayList<>();
		String city ="Islampur";
		Account a1 = new Account(100,"Sanket",2000,"Islampur");
		Account a2 = new Account(101,"Shekhar",3000,"Satara");
		Account a3 = new Account(102,"Pranay",4000,"Islampur");		
		Account a4 = new Account(104,"Shubham",5000,"Mumbai");
		
		accountMap.put(a1.getAccountNumber(), a1);
		accountMap.put(a2.getAccountNumber(), a2);
		accountMap.put(a3.getAccountNumber(), a3);
		accountMap.put(a4.getAccountNumber(), a4);
		
		for(Map.Entry<Integer, Account> entry:accountMap.entrySet())
		{
			int key = entry.getKey();
			Account a =entry.getValue();
			
			System.out.println(key+"  "+a.getAccountNumber()+"   "+a.getAccountHolderName()+"  "+a.getBalance()+" "+a.getLocation());

			if(a.getLocation().equals(city))
			{
				list.add(a);
			}
			
		}
		System.out.println("-----Account based On Location----");
		System.out.println(list);
	}

}

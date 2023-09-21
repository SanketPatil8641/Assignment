package map.collectiona.assignments_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BasicMap1 {

	Map<Integer , String> domainNames=new HashMap<>();
	Scanner sc=new Scanner(System.in);
	
	
	public static void main(String[] args) {
		BasicMap1 bm=new BasicMap1();
		
		while(true)
		{
			System.out.println("--------enter Option--------");
			System.out.println("1. Insert key  and value in Map ");
			System.out.println("2.Get value by key ");
			System.out.println("3.Display all Entities in Map");
			System.out.println("0.Exit ");
			System.out.println("----------------------------");
			
			switch (new Scanner(System.in).nextInt())
			{
			case 1: 
				
				bm.insertInMap();
				break;
			case 2: 
				
				bm.getValueByKey();
				break;
			case 3: 
				
				bm.getAllEntity();
				break;
			case 0: 
				
				System.exit(0);
				break;
			
			default:
				break;
			}
		}
	}
		
	public void insertInMap(){

		System.out.println("Enter Integer Key to add in map - ");
		int key = Integer.parseInt(sc.nextLine());

		System.out.println("Enter String Value to add in map - ");
		String val = sc.nextLine();

		
		domainNames.put(key,val);
		System.out.println(" Value Inserted  Succesfully in Map.");

	}
	
	public void getValueByKey() {
		System.out.println("Enter Integer Key to search in map - ");
		int key = Integer.parseInt(sc.nextLine());

		System.out.println("Value is - "+domainNames.get(key));
	}

	public void getAllEntity(){
		for (Map.Entry<Integer, String> entry : domainNames.entrySet()) {
			int key = entry.getKey();
			String val = entry.getValue();
			System.out.println("Key - "+key+" Value - "+val);
		}
		
	}
	
}	


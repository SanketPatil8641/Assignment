package foodapp.treeset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class FoodApp {
	
	public static void main(String[] args) {
		
		TreeSet<Food> allFoodItems = new TreeSet<>();
		
		Food f1 = new Food("Modak", 20, "Veg");
		Food f2 = new Food("Kheer", 100, "Veg");
		Food f3 = new Food("Momos", 40, "NonVeg");
		Food f4 = new Food("Biryani", 20, "NonVeg");
		Food f5 = new Food("Rice", 50, "Veg");
		
		allFoodItems.add(f1);
		allFoodItems.add(f2);
		allFoodItems.add(f3);
		allFoodItems.add(f4);
		allFoodItems.add(f5);
		
		System.out.println("---------Sort By Food Name ----------");

		for (Food food : allFoodItems) {
			System.out.println(food);
		}
		System.out.println("---  Food Price (Low to High)  ----------");
		getFoodBasedOnPriceHighToLow(allFoodItems);
		
		System.out.println("---  Sort By Food Categeory(Veg/Nonveg)  ----------");
		getFoodBasedOnCategeory(allFoodItems);
		
	}
	
	public static void getFoodBasedOnPriceHighToLow(TreeSet<Food> allFoodItems)
	{
		// Step1 -> convert set to List
				List<Food>tempList  = new ArrayList<>();// or pass as constructor argument
				tempList.addAll(allFoodItems);
				
				// Step 2-> create Comprator class Object
				SortFoodBasedOnCostHighToLow sortCode = new SortFoodBasedOnCostHighToLow();
				
				Collections.sort(tempList, sortCode);
				
				for (Food food : tempList) {
					System.out.println(food);
				}	
	}
	
	public static void getFoodBasedOnCategeory(TreeSet<Food> allFoodItems)
	{
		List<Food>tempList  = new ArrayList<>();
		tempList.addAll(allFoodItems);
		
		SortFoodBasedOnCategeory sort =new SortFoodBasedOnCategeory();
		Collections.sort(tempList, sort);
		
		for (Food food : tempList) {
			System.out.println(food);
		}
		
	}

	
	
	
}

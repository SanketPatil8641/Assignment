package foodapp.treeset;

import java.util.Comparator;

public class SortFoodBasedOnCostHighToLow implements Comparator<Food> {

	@Override
	public int compare(Food f1, Food f2) {
		// TODO Auto-generated method stub
		return f2.getPrice() - f1.getPrice();
	}

}

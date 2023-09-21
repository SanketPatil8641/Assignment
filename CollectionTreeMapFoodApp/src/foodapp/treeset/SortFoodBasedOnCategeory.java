package foodapp.treeset;

import java.util.Comparator;

public class SortFoodBasedOnCategeory implements Comparator<Food>{

	@Override
	public int compare(Food f1, Food f2) {
		// TODO Auto-generated method stub
		return (f1.getCategeory()).compareTo(f2.getCategeory());
	}

}

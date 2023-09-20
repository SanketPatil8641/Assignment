package level_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Problem1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-------Problem 1 => Consumer interface-----");
		List<String> strings = new ArrayList<>();
		strings.add("Sanket");
		strings.add("Shekhar");
		strings.add("Pranay");
		
		Consumer<String> consumer = (str) -> 
			System.out.println(str+" add on");
			strings.forEach(consumer);
			
		System.out.println("--------Problem 2 => Predicate interface------");
		
		//String s = "S";
		Predicate<String> pred = (str) -> {
			if (str.startsWith("S")){
				return true;
			}
			return false;
		};
		for (String t : strings) {
			if (pred.test(t)) {
				System.out.println(t);
			}
		}
		System.out.println("---------Problem 3 => Comparator Interface -----");
		List<Integer> num = new ArrayList<>();
		num.add(200);
		num.add(400);
		num.add(8000);
		num.add(700);

		Comparator<Integer> com = (num1, num2) -> num1.compareTo(num2);
		num.sort(com);
		System.out.println(num);

    
	}
}


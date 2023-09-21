package reviews.treemap;

import java.util.Objects;

public class Food implements Comparable<Food>{

	private String itemname;
	private int price;
	private String Categeory;
	

	

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String itemname, int price, String categeory) {
		super();
		this.itemname = itemname;
		this.price = price;
		Categeory = categeory;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCategeory() {
		return Categeory;
	}


	public void setCategeory(String categeory) {
		Categeory = categeory;
	}


	@Override
	public String toString() {
		return "Food [itemname=" + itemname + ", price=" + price + ", Categeory=" + Categeory + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(Categeory, itemname, price);
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Food)
		{
			Food f = (Food)obj;
			boolean a = f.Categeory.equals(this.getCategeory());
			boolean b = f.itemname.equals(this.getItemname());
			boolean c = f.price ==this.getPrice();

			return a && b && c;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int compareTo(Food f) {
		// TODO Auto-generated method stub
		return this.getItemname().compareTo(f.getItemname());
		
	}
	
}

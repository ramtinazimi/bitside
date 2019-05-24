import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		
		Product[] inventory= new Product[]{
				new Product("A0001", 12.99), 
				new Product("A0002", 3.99)};
		
		//Add all the items with a "buy1get1free"-sale to this list.
		ArrayList<Product> buy1get1freeItems = new ArrayList<Product>();
		//Example: buy1get1freeItems.add(inventory[1]);
		
		//Add all the items with a "10%PercentOff"-sale to this list.
		ArrayList<Product> percentOffItems = new ArrayList<Product>();
		//Example: percentOffItems.add(inventory[0]);
				
		Basket b = new Basket(buy1get1freeItems, percentOffItems);
		
		b.scan(inventory[0]);
		b.scan(inventory[1]);
		b.scan(inventory[1]);
		System.out.println(b.total());
	
	}


}

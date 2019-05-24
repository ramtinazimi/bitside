import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {

	private ArrayList<Product> items = new ArrayList<Product>();
	private ArrayList<Product> buy1get1freeItems;
	private ArrayList<Product> percentOffItems;
	
	public Basket(ArrayList<Product> buy1get1freeItems, ArrayList<Product> percentOffItems){
		
		this.buy1get1freeItems = buy1get1freeItems;
		
		this.percentOffItems = percentOffItems;
	}
	
	public Basket(){
		this.items = new ArrayList<Product>();
		this.buy1get1freeItems = new ArrayList<Product>();
		this.percentOffItems = new ArrayList<Product>();
	}
	
	
	public void scan(Product item){
		items.add(item);
		
	}
	
			
	public void removeItem(Product item){
		items.add(item);
	}
	
		
	public HashMap<Product, Integer> createHashMap(){
		
		HashMap<Product, Integer> countMap = new HashMap<>();
		
		for (Product item: items) {

		      if (countMap.containsKey(item)){
		    	  countMap.put(item, countMap.get(item) + 1);
		      }
		      else{
		    	  countMap.put(item, 1);
		      }
			          
		}
		
		return countMap;
	}
	
	
	public double total(){
		
		
		double sum = 0;
		
		//Create Map with products and the number of occurrences.
		Map<Product, Integer> productOverview = createHashMap();
		
		//Calculate the total sum of the products.
		for (Map.Entry<Product, Integer> entry : productOverview.entrySet()) {
			
			
			//A product which is both part of a "buy1get1free"- & a "10%percentoff"-sale.
			if(buy1get1freeItems.contains(entry.getKey()) && percentOffItems.contains(entry.getKey())){
				
				System.out.println("Product in both sales");
				//Buy1Get1Free Discount
				sum += (entry.getValue()/2 + entry.getValue()%2) * entry.getKey().getPrice()*0.1;
								
			}
			//A product which is only part of a "buy1get1free"-sale.
			else if(buy1get1freeItems.contains(entry.getKey())){
				System.out.println("Product in buy1get1free");
				sum += (entry.getValue()/2 + entry.getValue()%2) * entry.getKey().getPrice();
			}
			//A product which is only part of a "10%percentoff"-sale.
			else if(percentOffItems.contains(entry.getKey())){
				System.out.println("Product in 10%Off");
				sum += entry.getValue() * entry.getKey().getPrice() * 0.9;
			}
			//A product which has no sale.
			else{
				System.out.println("Product in no sale");
				sum += entry.getValue() * entry.getKey().getPrice();
			}
			
		}

				
		double roundSum = (double)Math.round(sum * 100d) / 100d;		
		return roundSum;
	}
	
}


public class Product {

	
	private String id;
	private double price;
	
	public Product(String id, double price){
		this.id = id;
		this.price = price;
	}
	
	public String getId(){
		return id;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}
		 
}

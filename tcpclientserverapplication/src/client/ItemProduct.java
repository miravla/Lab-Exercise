package client;

public class ItemProduct {

	private int itemProductid;
	private String name;
	private float price;
	
	//setter
	public void setItemProductid(int itemProductid) {
		this.itemProductid = itemProductid;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	//getter
	public String getName() {
		return name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public int getItemProductid() {
		return itemProductid;
	}
	
}

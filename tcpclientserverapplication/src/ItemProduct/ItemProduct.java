package ItemProduct;

import java.io.Serializable;

public class ItemProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1373449955289313933L;
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

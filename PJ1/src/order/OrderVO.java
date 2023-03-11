package order;


public class OrderVO {
	
	// Count에서 사용
	
	private String productName;
	private int choice;
	private int price;
	
	
	
	public OrderVO() {}
	
	public OrderVO(String productName,int choice ,int price) {
		
		this.productName = productName;
		this.choice = choice;
		this.price = price;
		
	}

	
	// getter, setter
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	
	

}

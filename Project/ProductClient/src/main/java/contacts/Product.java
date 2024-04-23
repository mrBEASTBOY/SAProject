package contacts;

public class Product {
	private String name;
	private String productNumber;
	private double price;

	private int quantity;
	
	public Product(String name, String productNumber, double price, int quantity) {
		super();
		this.name = name;
		this.productNumber = productNumber;
		this.price = price;
		this.quantity = quantity;
	}
	public Product() {

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product{" +
				", name='" + name + '\'' +
				", productNumber='" + productNumber + '\'' +
				", price=" + price +
				'}';
	}
}

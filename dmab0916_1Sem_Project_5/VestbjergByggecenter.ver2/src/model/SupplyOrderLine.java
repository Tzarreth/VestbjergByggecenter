package model;

public class SupplyOrderLine {
	private Product product;
	private int amount;
	private boolean isRecieved;

	public SupplyOrderLine(Product product, int amount){
		setProduct(product);
		setAmount(amount);
		isRecieved = false;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isRecieved(){
		return isRecieved;
	}

	public void setRecieved(boolean b){
		this.isRecieved = b;
	}
}

package model;

public class StockProduct {
	
	private Product product;
	private int qty;
	private String location;
	private String placement;
	
	public StockProduct(Product product, String placement, String location){
		this.product = product;
		qty = product.getQuantity();
		this.location = location;
		this.placement = placement;
	}

	public String getPlacement() {
		return placement;
	}

	public void setPlacement(String placement) {
		this.placement = placement;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

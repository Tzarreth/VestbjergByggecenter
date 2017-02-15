package controller;

import java.util.ArrayList;

import model.*;

public class StockCtrl {

	private StockProductContainer stock;
	
	public StockCtrl(){
		stock = StockProductContainer.getInstance();
	}
	
	public ArrayList<StockProduct> getAllStockProducts(){
		return stock.getAllStockProducts();
	}
	
	public void updateStock(Product p, int amountSold){
		for (StockProduct sp : stock.getAllStockProducts()){
			if (sp.getProduct().getProductNumber().equals(p.getProductNumber())){
				sp.setQty(sp.getQty() - amountSold);
				p.setQuantity(p.getQuantity() - amountSold);
			}
		}
	}
	
	public void updateStockRecieved(Product p, int amountRecieved){
		for (StockProduct sp : stock.getAllStockProducts()){
			if (sp.getProduct().getProductNumber().equals(p.getProductNumber())){
				sp.setQty(sp.getQty() + amountRecieved);
				p.setQuantity(p.getQuantity() + amountRecieved);
			}
		}
	}
	
	public void createStockProduct(Product p, String placement, String location){
		StockProduct sp = new StockProduct(p, placement,location);
		stock.addStockProduct(sp);
	}
	
	public void removeStockProduct(StockProduct stockProduct){
		stock.removeStockProduct(stockProduct);
	}
	
}

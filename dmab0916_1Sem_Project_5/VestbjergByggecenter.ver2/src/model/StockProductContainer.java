package model;

import java.util.ArrayList;

public class StockProductContainer {

	private ArrayList<StockProduct> stockProducts;
	private static StockProductContainer instance;
	
	private StockProductContainer(){
		stockProducts = new ArrayList<>();
	}
	
	public static StockProductContainer getInstance(){
		if (instance == null){
			instance = new StockProductContainer();
		}
		
		return instance;
	}
	
	public void addStockProduct(StockProduct stockProduct){
		stockProducts.add(stockProduct);
	}
	
	public void removeStockProduct(StockProduct stockProduct){
		Product product = stockProduct.getProduct();
		stockProducts.remove(stockProduct);
		ProductContainer pCont = ProductContainer.getInstance();
		pCont.removeProduct(product);
		
	}
	
	public ArrayList<StockProduct> getAllStockProducts(){
		return stockProducts;
	}

	public void restoreFromFile(StockProductContainer stockProductContainer) {
		instance = stockProductContainer;
		
	}
}

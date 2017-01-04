package model;

import java.util.ArrayList;

public class Stock {

	private ArrayList<StockProduct> stockProducts;
	private static Stock instance;
	
	private Stock(){
		stockProducts = new ArrayList<>();
	}
	
	public static Stock getInstance(){
		if (instance == null){
			instance = new Stock();
		}
		
		return instance;
	}
	
	public void addStockProduct(StockProduct stockProduct){
		stockProducts.add(stockProduct);
	}
	
	public ArrayList<StockProduct> getAllStockProducts(){
		return stockProducts;
	}
}

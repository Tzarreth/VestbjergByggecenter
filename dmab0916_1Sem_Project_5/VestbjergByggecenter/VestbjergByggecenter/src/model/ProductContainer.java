package model;

import java.util.ArrayList;

public class ProductContainer {
	private static ProductContainer instance;
	private ArrayList<Product> products;

	private ProductContainer(){
		products = new ArrayList<>();
	}

	public static ProductContainer getInstance(){
		if(instance == null){
			instance = new ProductContainer();
		}
		return instance;
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public ArrayList<Product> getAll() {
		ArrayList<Product> tempProductArray = products;
		return tempProductArray;
	}

	public void clear(){
		products.clear();
	}
}

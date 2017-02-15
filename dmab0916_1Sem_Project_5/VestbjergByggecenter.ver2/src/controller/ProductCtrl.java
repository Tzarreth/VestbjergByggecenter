package controller;

import java.util.ArrayList;

import model.*;

public class ProductCtrl {
	private ProductContainer productCont;
	
	public ProductCtrl(){
		productCont = ProductContainer.getInstance();
	}
	
	/** 
	 * Finds a Product based on its productNumber, which is given when the Product is created.
	 * @return a Product or null if the Product does not exist.
	 */
	public Product findProduct(String productNumber) {
		ArrayList<Product> temp = productCont.getAll();
		for(Product p : temp){
			if(p.getProductNumber().equalsIgnoreCase(productNumber))
				return p;
		}
		return null;
	}
	
	/**
	 * Creates an ArrayList which holds all of the products which quantity is below minimum.
	 * Returns a List which hold all of these products
	 * @return a list of products that are under minimum inventory amount.
	 */
	public ArrayList<Product> findRestockProducts() {
		ArrayList<Product> temp =  productCont.getAll();
		ArrayList<Product> tempRestockArray = new ArrayList<>();
		for(Product p : temp){
			if(p.getQuantity() < p.getMinAmount()){
				tempRestockArray.add(p);
			}
		}
		return tempRestockArray;
	}
	
	/**
	 * adds a product to the ArrayList of products, in our container.
	 * @param p is the Product.
	 */
	public void addProductToCont(Product p){
		productCont.addProduct(p);
	}
	
	public ArrayList<Product> getAll(){
		ArrayList<Product> cpy = productCont.getAll();
		return cpy;
	}
	
	public Product createProduct(double purchasePrice, double salePrice, String productNumber, String description,
				String productGroup, String location, int quantity, int minAmount, int maxAmount, Supplier supplier){
		Product p = new Product(purchasePrice, salePrice, productNumber, description, productGroup, location, quantity, minAmount, maxAmount, supplier);
		productCont.addProduct(p);
		return p;
	}
	
	public Supplier findSupplierByName(String supplierName){
		ArrayList<Product> products = productCont.getAll();
		for(Product p : products){
			if (p.getSupplier().getName().equals(supplierName)){
				return p.getSupplier();
			}
		}
		return null;
	}
	
	public ArrayList<Supplier> getAllSuppliers(){
		ArrayList<Supplier> suppliers = new ArrayList<>();
		for(Product p : getAll()){
			if(!suppliers.contains(p.getSupplier())){
				suppliers.add(p.getSupplier());
			}
		}
		return suppliers;
	}



}

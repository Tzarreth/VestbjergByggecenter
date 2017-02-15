package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.CustomerContainer;
import model.OrderContainer;
import model.Product;
import model.ProductContainer;
import model.StockProduct;
import model.StockProductContainer;
import model.SupplyOrder;
import model.SupplyOrderContainer;
import model.SupplyOrderLine;

import com.google.gson.Gson;

public class SaveAndLoadFromFile {
	private final String orderPath = "orders.txt";
	private Gson gson;
	private String json;
	private final String customerPath ="customers.txt";
	private final String stockProductPath = "stockProducts.txt";
	private final String productPath = "products.txt";
	private final String supplyOrderPath = "supplyOrders.txt";

	public void saveAll() {
		saveOrders();
		saveCustomers();
		saveProducts();
		saveStockProducts();
		saveSupplyOrders();
		
	}

	public void loadAll() {
		loadOrders();
		loadCustomers();
		loadProducts();
		loadStockProducts();
		loadSupplyOrders();
		
	}

	/**
	 * Using extern library GSON to save a java object to GSON object.
	 * Will create a file in default directory called "orders.txt".
	 * If file already exist the file will be overwritten.
	 */
	private void saveOrders() {
		gson = new Gson();
		String jsonString = gson.toJson(OrderContainer.getInstance());
		try {
			FileWriter fw = new FileWriter(new File(orderPath), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jsonString);
			bw.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * Using extern library GSON to load a GSON object to java object.
	 * Will load a file, if it exist, in default directory called "orders.txt".
	 * If file does not exist an exception is thrown.
	 */
	public void loadOrders(){
		gson = new Gson();
		String res;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(orderPath));
			String input = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator"); 
			while((input = reader.readLine()) != null){
				stringBuilder.append(input);
				stringBuilder.append(ls);
			}
			res = stringBuilder.toString();
			reader.close();

			OrderContainer orderContainer = gson.fromJson(res, OrderContainer.class);
			orderContainer.restoreFromFile(orderContainer);
	
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	private void saveCustomers() {
		gson = new Gson();
		String jsonString = gson.toJson(CustomerContainer.getInstance());
		try {
			FileWriter fw = new FileWriter(new File(customerPath), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jsonString);
			bw.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void loadCustomers(){
		gson = new Gson();
		String res;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(customerPath));
			String input = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator"); 
			while((input = reader.readLine()) != null){
				stringBuilder.append(input);
				stringBuilder.append(ls);
			}
			res = stringBuilder.toString();
			reader.close();

			CustomerContainer customerContainer = gson.fromJson(res, CustomerContainer.class);
			customerContainer.restoreFromFile(customerContainer);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	private void saveStockProducts() {
		gson = new Gson();
		String jsonString = gson.toJson(StockProductContainer.getInstance());
		try {
			FileWriter fw = new FileWriter(new File(stockProductPath), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jsonString);
			bw.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void loadStockProducts(){
		gson = new Gson();
		String res;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(stockProductPath));
			String input = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator"); 
			while((input = reader.readLine()) != null){
				stringBuilder.append(input);
				stringBuilder.append(ls);
			}
			res = stringBuilder.toString();
			reader.close();

			StockProductContainer stockProductContainer = gson.fromJson(res, StockProductContainer.class);
			stockProductContainer.restoreFromFile(stockProductContainer);
			
			ProductContainer productContainer = ProductContainer.getInstance();
			ArrayList<StockProduct> stockProducts = stockProductContainer.getAllStockProducts();
			ArrayList<Product> products = productContainer.getAll();
			for(int i = 0; i <stockProducts.size(); i++){
				StockProduct sp = stockProducts.get(i);
				for(Product p : products){
					if(sp.getProduct().getDescription().equals(p.getDescription())){
						sp.setProduct(p);
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void saveProducts() {
		gson = new Gson();
		String jsonString = gson.toJson(ProductContainer.getInstance());
		try {
			FileWriter fw = new FileWriter(new File(productPath), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jsonString);
			bw.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void loadProducts(){
		gson = new Gson();
		String res;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(productPath));
			String input = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator"); 
			while((input = reader.readLine()) != null){
				stringBuilder.append(input);
				stringBuilder.append(ls);
			}
			res = stringBuilder.toString();
			reader.close();

			ProductContainer productContainer = gson.fromJson(res, ProductContainer.class);
			productContainer.restoreFromFile(productContainer);
			
			ArrayList<Product> products = productContainer.getAll();
			for(int i = 0; i <products.size(); i++){
				Product p = products.get(i);
				for(Product product : products){
					if(product.getSupplier().getName().equals(p.getSupplier().getName())){
						product.setSupplier(p.getSupplier());
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	private void saveSupplyOrders() {
		gson = new Gson();
		String jsonString = gson.toJson(SupplyOrderContainer.getInstance());
		try {
			FileWriter fw = new FileWriter(new File(supplyOrderPath), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(jsonString);
			bw.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void loadSupplyOrders(){
		gson = new Gson();
		String res;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(supplyOrderPath));
			String input = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator"); 
			while((input = reader.readLine()) != null){
				stringBuilder.append(input);
				stringBuilder.append(ls);
			}
			res = stringBuilder.toString();
			reader.close();

			SupplyOrderContainer supplyOrderContainer = gson.fromJson(res, SupplyOrderContainer.class);
			supplyOrderContainer.restoreFromFile(supplyOrderContainer);
			
			
			ProductContainer productContainer = ProductContainer.getInstance();
			ArrayList<SupplyOrder> supplyOrders = supplyOrderContainer.getAll();
			ArrayList<Product> products = productContainer.getAll();
			for(int i = 0; i <supplyOrders.size(); i++){
				SupplyOrder so = supplyOrders.get(i);
				ArrayList<SupplyOrderLine> supplyOrderLines = so.getSupplyOrderLines();
				for(SupplyOrderLine sol : supplyOrderLines){
					for(Product p : products){
					if(sol.getProduct().getDescription().equals(p.getDescription())){
						sol.setProduct(p);
					}
					}
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	

}


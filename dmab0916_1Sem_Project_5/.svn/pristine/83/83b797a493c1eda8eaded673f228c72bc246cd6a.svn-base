package model;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderContainer implements Serializable {
	private static OrderContainer instance;
	private ArrayList<Order> orders;

	private OrderContainer(){
		orders = new ArrayList<Order>();
	}

	public static OrderContainer getInstance(){
		if(instance == null){
			instance = new OrderContainer();
		}
		return instance;
	}

	public void restoreFromFile(OrderContainer orderContainer) {
		instance = orderContainer;
	}

	public void addOrder(Order o){
		orders.add(o);	
	}

	public int ordersListSize(){
		return orders.size();
	}

	public void clear(){
		orders.clear();
	}

	public ArrayList<Order> getAll() {
		return new ArrayList<>(orders);
	}
}

package model;

import java.util.ArrayList;

import exceptions.model.CustomerAlreadyExistsException;

public class CustomerContainer {
	private static CustomerContainer instance;
	private ArrayList<Customer> customers;
	
	private CustomerContainer(){
		customers = new ArrayList<>();
	}
	
	public static CustomerContainer getInstance(){
		if(instance == null){
			instance = new CustomerContainer();
			Customer.clearIDs();	
		}
		return instance;
	}
	
	public void restoreFromFile(CustomerContainer customerContainer) {
		instance = customerContainer;
	}
	
	/**
	 * Adds a new customer to the list. 
	 * @param c is Customer
	 * @throws CustomerAlreadyExistsException
	 */
	public void addCustomer(Customer c) {
		if(findCustomer(c.getPhone()) == null) {
			customers.add(c);
		}
	}

	/**
	 * Finds an existing customer using their phone number.
	 * @param phone is String
	 * @return returns the found customer.
	 */
	public Customer findCustomer(String phone){
		Customer res = null;
		
		for(Customer c : customers){
			if(c.getPhone().equals(phone)){
				res = c;
			}		
		}
		return res;
	}

	/**
	 * Used for testing. Clearing list of objects.
	 */
	public void clear() {
		customers.clear();
	}
	
	/**
	 * Used for testing. Gets size of list.
	 */
	public int size() {
		return customers.size();
	}
	
	public ArrayList<Customer> getAll(){
		return customers;
	}
}

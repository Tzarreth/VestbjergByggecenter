package controller;

import java.util.ArrayList;

import exceptions.model.CustomerAlreadyExistsException;
import model.*;

public class CustomerCtrl {
	private CustomerContainer customerCont = CustomerContainer.getInstance();
	
	public CustomerCtrl(){
		
	}
	
	/**
	 * finds an existing customer using a phone 
	 * @param phone is String
	 * @return returns the found customer
	 */
	public Customer findCustomer(String phone) {
		Customer c = customerCont.findCustomer(phone);
		return c;
	}
	
	/**
	 * adds a customer to the CustomerContainer
	 * @param c is Customer
	 * @throws CustomerAlreadyExistsException
	 */
	public void addCustomer(Customer c) {
		customerCont.addCustomer(c);
	}	
	public ArrayList<Customer> getAll(){
		return customerCont.getAll();
	}
	
	public void createCustomer(String name, String address, String email, String phone, String type) {
		Customer c = new Customer(name, address, email, phone, type);
		addCustomer(c);
	}
}

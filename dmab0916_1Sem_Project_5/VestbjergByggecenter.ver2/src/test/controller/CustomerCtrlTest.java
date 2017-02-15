package test.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.CustomerCtrl;
import exceptions.model.CustomerAlreadyExistsException;
import model.Customer;
import model.CustomerContainer;

public class CustomerCtrlTest {
	CustomerCtrl cCtrl;
	CustomerContainer cCon;
	Customer c1, c2, c3;

	@Before
	public void setUp() throws Exception {
		cCtrl = new CustomerCtrl();
		cCon = cCon.getInstance();
		c1 = new Customer("Joe", "Ananas Street", "Ananas@pineapple.com", "12121212", "Privat");
		c2 = new Customer("Bob", "Banana Street", "Banana@pineapple.com", "21212121", "Privat");
		c3 = new Customer("Jane", "Citrus Street", "Citrus@pineapple.com", "22222222", "Erhverv");
		cCtrl.addCustomer(c1);
		cCtrl.addCustomer(c2);
		cCtrl.addCustomer(c3);
	}

	@After
	public void tearDown() throws Exception {
		cCon.clear();
	}

	@Test
	public void testAddCustomer() throws CustomerAlreadyExistsException {
		assertTrue(cCon.size() == 3);
		assertFalse(cCon.size() == 4);
		assertFalse(cCon.size() == 2);
	}

	@Test
	public void testFindCustomer(){
		assertEquals(cCtrl.findCustomer("12121212"), c1);
		assertEquals(cCtrl.findCustomer("21212121"), c2);
		assertEquals(cCtrl.findCustomer("22222222"), c3);

		assertNotEquals(cCtrl.findCustomer("12121212121212"), c1);
		assertNotEquals(cCtrl.findCustomer("22222222"), c2);
		assertNotEquals(cCtrl.findCustomer(""), c3);
	}
}

package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Customer;

public class CustomerTest {
	Customer c1, c2, c3;

	@Before
	public void setUp() throws Exception {
		c1 = new Customer("Joe", "Ananas Street", "Ananas@pineapple.com", "12121212", "Privat");
		c2 = new Customer("Bob", "Banana Street", "Banana@pineapple.com", "21212121", "Privat");
		c3 = new Customer("Jane", "Citrus Street", "Citrus@pineapple.com", "22222222", "Erhverv");
	}

	@Test
	public void testGetName(){
		assertEquals(c1.getName(), "Joe");
		assertEquals(c2.getName(), "Bob");
		assertEquals(c3.getName(), "Jane");
		assertNotEquals(c1.getName(), "Jane");
		assertNotEquals(c3.getName(), "Joe");
	}

	@Test
	public void testGetAddress(){
		assertEquals(c1.getAddress(), "Ananas Street");
		assertEquals(c2.getAddress(), "Banana Street");
		assertEquals(c3.getAddress(), "Citrus Street");
		assertNotEquals(c1.getAddress(), "Banana Street");
		assertNotEquals(c3.getAddress(), "Ananas Street");
	}

	@Test
	public void testGetEmail(){
		assertEquals(c1.getEmail(), "Ananas@pineapple.com");
		assertEquals(c2.getEmail(), "Banana@pineapple.com");
		assertEquals(c3.getEmail(), "Citrus@pineapple.com");
		assertNotEquals(c1.getEmail(), "Banana@pineapple.com");
		assertNotEquals(c3.getEmail(), "Ananas@pineapple.com");
	}

	@Test
	public void testGetPhone() {
		assertEquals(c1.getPhone(), "12121212");
		assertEquals(c2.getPhone(), "21212121");
		assertEquals(c3.getPhone(), "22222222");
		assertNotEquals(c1.getPhone(), "22222222");
		assertNotEquals(c3.getPhone(), "21212121");
	}

	@Test
	public void testGetType() {
		assertEquals(c1.getType(), "Privat");
		assertEquals(c2.getType(), "Privat");
		assertEquals(c3.getType(), "Erhverv");
		assertNotEquals(c1.getType(), "Erhverv");
		assertNotEquals(c3.getType(), "Privat");
	}
}

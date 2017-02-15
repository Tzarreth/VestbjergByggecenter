package test.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Order;
import model.OrderContainer;

public class OrderContainerTest {

	private Order o1,o2;
	OrderContainer oCon;
	@Before
	public void setUp() throws Exception {
		o1 = new Order();
		o2 = new Order();
		oCon = OrderContainer.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		oCon.clear();
	}

	/**
	 * Testing that the list is not null when orders have been added.
	 */
	@Test
	public void addOrderNotNullTest() {
		oCon.addOrder(o1);
		oCon.addOrder(o2);

		assertNotNull(oCon.ordersListSize());
	}

	/**
	 * Testing that the list is null when nothing is added.
	 */
	@Test
	public void addOrderIsNullTest(){
		assertEquals(0, oCon.ordersListSize());
	}
}

package test.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Supplier;
import model.SupplyOrder;
import model.SupplyOrderContainer;

public class SupplyOrderContainerTest {
	SupplyOrderContainer soCon;
	SupplyOrder so1, so2, so3;
	Supplier s1, s2, s3;

	@Before
	public void setUp() throws Exception {
		soCon = SupplyOrderContainer.getInstance();

		so1 = new SupplyOrder(s1);
		so1 = new SupplyOrder(s2);
		so1 = new SupplyOrder(s3);

		soCon.addSupplyOrder(so1);
		soCon.addSupplyOrder(so2);
		soCon.addSupplyOrder(so3);
	}

	@After
	public void tearDown() throws Exception {
		soCon.clear();
	}

	@Test
	public void testGetInstanceOf() {
		assertNotNull(SupplyOrderContainer.getInstance());
	}

	@Test
	public void testGetAll(){
		assertTrue(soCon.getAll().size() == 3);
	}

	@Test
	public void testAddSupplyOrder(){
		SupplyOrder so4 = new SupplyOrder(s2);
		soCon.addSupplyOrder(so4);
		assertTrue(soCon.getAll().size() == 4);
	}

	@Test
	public void testClear(){
		soCon.clear();
		assertTrue(soCon.getAll().size() == 0);
	}
}

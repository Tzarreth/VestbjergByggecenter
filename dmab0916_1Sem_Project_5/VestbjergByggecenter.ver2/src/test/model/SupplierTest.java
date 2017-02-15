package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Supplier;

public class SupplierTest {
	Supplier s1, s2, s3, s4, s5;

	@Before
	public void setUp() {
		s1 = new Supplier("Bauhaus");
		s2 = new Supplier("Silvan");
		s3 = new Supplier("Jem og Fix");
		s4 = new Supplier("Trælast A/S");
		s5 = new Supplier("Maersk");
	}

	@Test
	public void test() {
		assertEquals("Bauhaus", s1.getName());
		assertEquals("Silvan", s2.getName());
		assertEquals("Jem og Fix", s3.getName());
		assertEquals("Trælast A/S", s4.getName());
		assertEquals("Maersk", s5.getName());
		assertNotEquals("Jem og Fix", s1.getName());
		assertNotEquals("Maersk", s4.getName());
		assertNotEquals("Silvan A/S", s2.getName());
		assertNotEquals("Tobias", s3.getName());
	}
}

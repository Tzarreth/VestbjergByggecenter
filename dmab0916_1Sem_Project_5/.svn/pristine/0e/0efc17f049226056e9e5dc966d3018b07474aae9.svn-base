package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Product;
import model.Supplier;

public class ProductTest {
	Product p1, p2, p3, p4, p5;
	Supplier s1, s2, s3;

	@Before
	public void setUp(){
		s1 = new Supplier("Bauhaus");
		s2 = new Supplier("Silvan");
		s3 = new Supplier("Jem og Fix");
		p1 = new Product(800, 1000, "5", "kælk", "vinter", "hylde4", 25, 5, 30, s3);
		p2 = new Product(1000, 1200, "6", "hurtig kælk", "vinter", "hylde 5", 18, 4, 25, s1);
		p3 = new Product(100, 300, "17", "kaffemaskine", "hvidevarer", "hylde 17", 5, 6, 10, s2);
		p4 = new Product(1300, 1500, "19", "vaskemaskine", "hårdeHvidevarer", "hylde 19", 4, 4, 5, s1);
		p5 = new Product(3000, 3200, "52", "den slår hårdt", "værktøj", "Hylde 52", 10, 2, 15, s3);
	}

	@Test
	public void getPurchasePrise() {
		assertTrue(800  == p1.getPurchasePrice());
		assertTrue(1000 == p2.getPurchasePrice());
		assertTrue(100  == p3.getPurchasePrice());
		assertTrue(1300 == p4.getPurchasePrice());
		assertTrue(3000 == p5.getPurchasePrice());
		assertFalse(1000 == p1.getPurchasePrice());
		assertFalse(1300 == p2.getPurchasePrice());
		assertFalse(800 == p3.getPurchasePrice());
	}

	@Test
	public void getSalePrise() {
		assertTrue(1000  == p1.getSalePrice());
		assertTrue(1200 == p2.getSalePrice());
		assertTrue(300  == p3.getSalePrice());
		assertTrue(1500 == p4.getSalePrice());
		assertTrue(3200 == p5.getSalePrice());
		assertFalse(300 == p1.getSalePrice());
		assertFalse(1500 == p2.getSalePrice());
		assertFalse(1000 == p3.getSalePrice());
	}

	@Test
	public void getProductNo() {
		assertEquals("5", p1.getProductNumber());
		assertEquals("6", p2.getProductNumber());
		assertEquals("17", p3.getProductNumber());
		assertEquals("19", p4.getProductNumber());
		assertEquals("52", p5.getProductNumber());
		assertNotEquals("17", p1.getProductNumber());
		assertNotEquals("6", p4.getProductNumber());
		assertNotEquals("52", p2.getProductNumber());
		assertNotEquals("5", p3.getProductNumber());
	}

	@Test
	public void getDescription() {
		assertEquals("kælk", p1.getDescription());
		assertEquals("hurtig kælk", p2.getDescription());
		assertEquals("kaffemaskine", p3.getDescription());
		assertEquals("vaskemaskine", p4.getDescription());
		assertEquals("den slår hårdt", p5.getDescription());
		assertNotEquals("kaffemaskine", p1.getDescription());
		assertNotEquals("den slår hårdt", p4.getDescription());
		assertNotEquals("vaskemaskine", p2.getDescription());
		assertNotEquals("hurtig kælk", p3.getDescription());
	}

	@Test
	public void getProductGroup() {
		assertEquals("vinter", p1.getProductGroup());
		assertEquals("vinter", p2.getProductGroup());
		assertEquals("hvidevarer", p3.getProductGroup());
		assertEquals("hårdeHvidevarer", p4.getProductGroup());
		assertEquals("værktøj", p5.getProductGroup());
		assertNotEquals("værktøj", p1.getProductGroup());
		assertNotEquals("vinter", p4.getProductGroup());
		assertNotEquals("hvidevarer", p2.getProductGroup());
		assertNotEquals("vinter", p3.getProductGroup());
	}

	@Test
	public void getLocation() {
		assertEquals("hylde4", p1.getLocation());
		assertEquals("hylde 5", p2.getLocation());
		assertEquals("hylde 17", p3.getLocation());
		assertEquals("hylde 19", p4.getLocation());
		assertEquals("Hylde 52", p5.getLocation());
		assertNotEquals("hylde 17", p1.getLocation());
		assertNotEquals("Hylde 52", p4.getLocation());
		assertNotEquals("hylde4", p2.getLocation());
		assertNotEquals("hylde 19", p3.getLocation());
	}

	@Test
	public void getQuantity() {
		assertTrue(25 == p1.getQuantity());
		assertTrue(18 == p2.getQuantity());
		assertTrue(5  == p3.getQuantity());
		assertTrue(4  == p4.getQuantity());
		assertTrue(10 == p5.getQuantity());
		assertFalse(18 == p1.getQuantity());
		assertFalse(4  == p2.getQuantity());
		assertFalse(25 == p3.getQuantity());
	}

	@Test
	public void getMinAmount() {
		assertTrue(5 == p1.getMinAmount());
		assertTrue(4 == p2.getMinAmount());
		assertTrue(6 == p3.getMinAmount());
		assertTrue(4  == p4.getMinAmount());
		assertTrue(2 == p5.getMinAmount());
		assertFalse(4 == p1.getMinAmount());
		assertFalse(2  == p2.getMinAmount());
		assertFalse(4 == p3.getMinAmount());
	}

	@Test
	public void getMaxAmount() {
		assertTrue(30 == p1.getMaxAmount());
		assertTrue(25 == p2.getMaxAmount());
		assertTrue(10 == p3.getMaxAmount());
		assertTrue(5  == p4.getMaxAmount());
		assertTrue(15 == p5.getMaxAmount());
		assertFalse(15 == p1.getMaxAmount());
		assertFalse(30 == p2.getMaxAmount());
		assertFalse(25 == p3.getMaxAmount());
	}

	@Test
	public void getSupplier() {
		assertEquals(s3, p1.getSupplier());
		assertEquals(s1, p2.getSupplier());
		assertEquals(s2, p3.getSupplier());
		assertEquals(s1, p4.getSupplier());
		assertEquals(s3, p5.getSupplier());
		assertNotEquals(s1, p1.getSupplier());
		assertNotEquals(s3, p4.getSupplier());
		assertNotEquals(s2, p2.getSupplier());
		assertNotEquals(s1, p3.getSupplier());
	}
}

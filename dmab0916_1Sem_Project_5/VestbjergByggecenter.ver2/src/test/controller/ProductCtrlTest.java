package test.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.ProductCtrl;
import model.Product;
import model.ProductContainer;
import model.Supplier;

public class ProductCtrlTest {
	private ProductCtrl pCtrl;
	private Supplier s1, s2, s3;
	private Product p1, p2, p3, p4, p5;
	ProductContainer pCon;

	@Before
	public void setUp(){
		pCtrl = new ProductCtrl();
		pCon = ProductContainer.getInstance();

		s1 = new Supplier("Bauhaus");
		s2 = new Supplier("Silvan");
		s3 = new Supplier("Jem og Fix");
		p1 = new Product(800, 1000, "5", "kælk", "vinter", "hylde4", 25, 5, 30, s3);
		p2 = new Product(1000, 1200, "6", "hurtig kælk", "vinter", "hylde 5", 18, 4, 25, s1);
		p3 = new Product(100, 300, "17", "kaffemaskine", "hvidevarer", "hylde 17", 5, 6, 10, s2);
		p4 = new Product(1300, 1500, "19", "vaskemaskine", "hårdeHvidevarer", "hylde 19", 4, 4, 5, s1);
		p5 = new Product(3000, 3200, "52", "den slår hårdt", "værktøj", "Hylde 52", 10, 2, 15, s3);

		pCtrl.addProductToCont(p1);
		pCtrl.addProductToCont(p2);
		pCtrl.addProductToCont(p3);
		pCtrl.addProductToCont(p4);
		pCtrl.addProductToCont(p5);
	}

	@After
	public void tearDown(){
		pCon.clear();
	}

	@Test
	public void testAddProduct(){
		ArrayList<Product> productsTest = pCon.getAll();
		System.out.println(productsTest.size());
		assertTrue(productsTest.size() == 5);
		assertFalse(false);
	}

	@Test
	public void testFindRestockProducts(){
		ProductCtrl pCtrl = new ProductCtrl();
		ArrayList<Product> productsTest = pCtrl.findRestockProducts();
		assertNotNull(productsTest);
		System.out.println(productsTest.size());
		assertTrue(productsTest.size() == 1);
		assertFalse(productsTest.size() == 5);
	}

	@Test
	public void testFindProduct(){
		assertEquals(p1, pCtrl.findProduct("5"));
		assertEquals(p2, pCtrl.findProduct("6"));
		assertEquals(p3, pCtrl.findProduct("17"));
		assertEquals(p4, pCtrl.findProduct("19"));
		assertEquals(p5, pCtrl.findProduct("52"));
		assertNotEquals(p1, pCtrl.findProduct("17"));
		assertNotEquals(p2, pCtrl.findProduct("25"));
		assertNotEquals(p3, pCtrl.findProduct("26"));
	}
}

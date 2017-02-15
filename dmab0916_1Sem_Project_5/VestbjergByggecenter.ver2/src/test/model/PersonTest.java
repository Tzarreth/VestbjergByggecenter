package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Person;

public class PersonTest {
	Person p1, p2, p3, p4, p5;

	@Before
	public void setUp(){
		p1 = new Person("01", "Arne", "Sonjavej 10", "arne@gmail.com", "18451298");
		p2 = new Person("02", "Christoffer", "havensvej 14", "christoffer@gmail.com", "26451298");
		p3 = new Person("03", "Mikkel", "Brombærsvej 5", "mikkel@gmail.com", "32451298");
		p4 = new Person("04", "Tobias", "Aalborgvej 21", "tobias@gmail.com", "48451298");
		p5 = new Person("05", "Stefan", "Vesterbro 8", "stefan@gmail.com", "58651298");
	}

	@Test
	public void getID() {
		assertEquals("01", p1.getID());
		assertEquals("02", p2.getID());
		assertEquals("03", p3.getID());
		assertEquals("04", p4.getID());
		assertEquals("05", p5.getID());
		assertNotEquals("04", p1.getID());
		assertNotEquals("02", p4.getID());
		assertNotEquals("03", p2.getID());
		assertNotEquals("05", p3.getID());
	}

	@Test
	public void getName() {
		assertEquals("Arne", p1.getName());
		assertEquals("Christoffer", p2.getName());
		assertEquals("Mikkel", p3.getName());
		assertEquals("Tobias", p4.getName());
		assertEquals("Stefan", p5.getName());
		assertNotEquals("Christoffer", p1.getName());
		assertNotEquals("Stefan", p4.getName());
		assertNotEquals("Mikkel", p2.getName());
		assertNotEquals("Tobias", p3.getName());
	}

	@Test
	public void getAddres() {
		assertEquals("Sonjavej 10", p1.getAddress());
		assertEquals("havensvej 14", p2.getAddress());
		assertEquals("Brombærsvej 5", p3.getAddress());
		assertEquals("Aalborgvej 21", p4.getAddress());
		assertEquals("Vesterbro 8", p5.getAddress());
		assertNotEquals("Aalborgvej 21", p1.getAddress());
		assertNotEquals("havensvej 14", p4.getAddress());
		assertNotEquals("Vesterbro 8", p2.getAddress());
		assertNotEquals("Sonjavej 10", p3.getAddress());
	}

	@Test
	public void getEmail() {
		assertEquals("arne@gmail.com", p1.getEmail());
		assertEquals("christoffer@gmail.com", p2.getEmail());
		assertEquals("mikkel@gmail.com", p3.getEmail());
		assertEquals("tobias@gmail.com", p4.getEmail());
		assertEquals("stefan@gmail.com", p5.getEmail());
		assertNotEquals("christoffer@gmail.com", p1.getEmail());
		assertNotEquals("stefan@gmail.com", p4.getEmail());
		assertNotEquals("mikkel@gmail.com", p2.getEmail());
		assertNotEquals("tobias@gmail.com", p3.getEmail());
	}

	@Test
	public void getPhone() {
		assertEquals("18451298", p1.getPhone());
		assertEquals("26451298", p2.getPhone());
		assertEquals("32451298", p3.getPhone());
		assertEquals("48451298", p4.getPhone());
		assertEquals("58651298", p5.getPhone());
		assertNotEquals("26451298", p1.getPhone());
		assertNotEquals("58651298", p4.getPhone());
		assertNotEquals("32451298", p2.getPhone());
		assertNotEquals("18451298", p3.getPhone());
	}
}

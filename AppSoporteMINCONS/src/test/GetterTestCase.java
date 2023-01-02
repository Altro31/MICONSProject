package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.Vivienda;

public class GetterTestCase {

	private Vivienda vivienda;

	@Before
	public void setUp() {
		vivienda = new Vivienda();
	}

	@After
	public void tearDown() {
		vivienda = null;
	}

	@Test
	public void testInt() {

		int a = vivienda.getTotalPersonas();

		a++;

		int b = vivienda.getTotalPersonas();

		assertEquals(1, a);
		assertEquals(0, b);
	}

	@Test
	public void testString() {

		String a = vivienda.getDireccion();

		a = "a";

		String b = vivienda.getDireccion();

		assertEquals("a", a);
		assertEquals(null, b);
	}

}

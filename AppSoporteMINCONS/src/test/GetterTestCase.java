package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.Vivienda;

public class GetterTestCase {

	private Vivienda vivienda;
	
	@Before
	public void setUp() throws Exception {
		vivienda = new Vivienda();
	}

	@After
	public void tearDown() throws Exception {
		vivienda = null;
	}

	@Test
	public void testInt() {
		
		@SuppressWarnings("unused")
		int a = vivienda.getTotalPersonas();
		
		a++;
		
		int b = vivienda.getTotalPersonas();
		
		
		assertEquals(0, b);
	}
	
	@Test
	public void testString() {
		
		@SuppressWarnings("unused")
		String a = vivienda.getDireccion();
		
		a="a";
		
		String b = vivienda.getDireccion();
		
		
		assertEquals(null, b);
	}

}

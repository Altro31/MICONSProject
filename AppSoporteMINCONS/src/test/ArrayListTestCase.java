package test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTestCase {

	private ArrayList<String> lista;

	@Before
	public void setUp() {
		lista = new ArrayList<String>();
	}

	@After
	public void tearDown() {
		lista = null;
	}

	public ArrayList<String> test() {
		return lista;

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testClone() {

		ArrayList<String> lista2 = (ArrayList<String>) test().clone();

		lista2.add("Alberto");

		test();

	}

}

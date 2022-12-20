package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.Auxiliary;

public class CalcularAreaTestCase {

	@Test
	public void test1CalcularArea() {
		assertEquals(6F, Auxiliary.calcularArea(2F, 3F), 0);
	}

	@Test
	public void test2CalcularArea() {
		assertEquals(9F, Auxiliary.calcularArea(3F, 3F), 0);
	}

	@Test
	public void test3CalcularArea() {
		assertEquals(42F, Auxiliary.calcularArea(7F, 6F), 0);
	}
}

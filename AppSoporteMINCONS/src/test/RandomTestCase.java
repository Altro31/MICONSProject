package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.Auxiliary;

public class RandomTestCase {

	@Test
	public void testRandomPara1() {
		assertEquals(1, Auxiliary.random(1).length());
	}

	@Test
	public void testRandomPara5() {
		assertEquals(5, Auxiliary.random(5).length());
	}

	@Test
	public void testRandomPara30() {
		assertEquals(30, Auxiliary.random(30).length());
	}

}

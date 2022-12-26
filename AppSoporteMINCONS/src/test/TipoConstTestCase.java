package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classifications.TipoConst;

public class TipoConstTestCase {

	@Test
	public void test() {
		assertEquals(TipoConst.II, TipoConst.valueOf("II"));
	}

}

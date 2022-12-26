package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.Validaciones;

public class ValidacionCITesCase {

	@Test
	public void test() {
		Validaciones.ci("0205316320");
		assertTrue(true);
	}

}

package de.cas.mse.exercise.diamond;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiamondTest {

	@Test
	public void diamond3_shouldPrint() {
		StringBuffer expected = new StringBuffer();
		expected.append(" *\n");
		expected.append("***\n");
		expected.append(" *\n");

		assertEquals(expected.toString(), new Diamond(3).buildDiamond());
	}

	@Test
	public void diamond5_shouldPrint() {
		StringBuffer expected = new StringBuffer();
		expected.append("  *\n");
		expected.append(" ***\n");
		expected.append("*****\n");
		expected.append(" ***\n");
		expected.append("  *\n");

		assertEquals(expected.toString(), new Diamond(5).buildDiamond());
	}

	@Test
	public void diamond0_shouldReturnNull() {
		assertEquals(null, new Diamond(0).buildDiamond());
	}

	@Test
	public void diamondNegative_shouldReturnNull() {
		assertEquals(null, new Diamond(-1).buildDiamond());
	}

	@Test
	public void diamondEven_shouldReturnNull() {
		assertEquals(null, new Diamond(10).buildDiamond());
	}
}

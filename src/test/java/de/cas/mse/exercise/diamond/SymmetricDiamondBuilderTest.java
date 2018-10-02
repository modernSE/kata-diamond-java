package de.cas.mse.exercise.diamond;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SymmetricDiamondBuilderTest {

	@Test
	public void diamond3_shouldPrint() {
		StringBuffer expected = new StringBuffer();
		expected.append(" *\n");
		expected.append("***\n");
		expected.append(" *\n");

		assertEquals(expected.toString(), new SymmetricDiamondBuilder().build(3));
	}

	@Test
	public void diamond5_shouldPrint() {
		StringBuffer expected = new StringBuffer();
		expected.append("  *\n");
		expected.append(" ***\n");
		expected.append("*****\n");
		expected.append(" ***\n");
		expected.append("  *\n");

		assertEquals(expected.toString(), new SymmetricDiamondBuilder().build(5));
	}

	@Test
	public void diamond0_shouldReturnNull() {
		assertEquals(null, new SymmetricDiamondBuilder().build(0));
	}

	@Test
	public void diamondNegative_shouldReturnNull() {
		assertEquals(null, new SymmetricDiamondBuilder().build(-1));
	}

	@Test
	public void diamondEven_shouldReturnNull() {
		assertEquals(null, new SymmetricDiamondBuilder().build(10));
	}
}

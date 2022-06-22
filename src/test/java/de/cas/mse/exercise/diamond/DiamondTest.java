package de.cas.mse.exercise.diamond;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiamondTest {

	@Test
	public void diamond3_shouldPrint() {
		StringBuffer expectedResult = new StringBuffer();
		expectedResult.append(" *\n");
		expectedResult.append("***\n");
		expectedResult.append(" *\n");

        String actualResult = new Diamond().renderDiamond(3);
        assertEquals(expectedResult.toString(),actualResult);
        System.out.println(actualResult);
	}

	@Test
	public void diamond5_shouldPrint() {
		StringBuffer expectedResult = new StringBuffer();
		expectedResult.append("  *\n");
		expectedResult.append(" ***\n");
		expectedResult.append("*****\n");
		expectedResult.append(" ***\n");
		expectedResult.append("  *\n");

		String actualResult = new Diamond().renderDiamond(5);
        assertEquals(expectedResult.toString(),actualResult);
        System.out.println(actualResult);
	}

	@Test
	public void diamond0_shouldReturnNull() {
		assertEquals(null, new Diamond().renderDiamond(0));
	}

	@Test
	public void diamondNegative_shouldReturnNull() {
		assertEquals(null, new Diamond().renderDiamond(-1));
	}

	@Test
	public void diamondEven_shouldReturnNull() {
		assertEquals(null, new Diamond().renderDiamond(10));
	}
}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private final char DIAMOND_CONTENT = '*';
	private final char WHITESPACE_CONTENT = ' ';
	private final char NEWLINE_CONTENT = '\n';

	public String printDiamond(int diamondSize) {
		if (diamondSize <= 0 || diamondSize % 2 == 0) {
			return null;
		}
		char[] constructedShape = constructShape(diamondSize, diamondSize);
		String initShape = String.valueOf(constructedShape);
		return mirroringDiamondShape(initShape, diamondSize);
	}
	private String mirroringDiamondShape(String constructedShape, int diamondSize) {
		StringBuilder shape = new StringBuilder(constructedShape);
		for (int i = diamondSize - 2; i > 0; i -= 2) {
			char[] chars = constructShape(diamondSize, i);
			shape.insert(0, chars);
			shape.append(chars);
		}
		return shape.toString();
	}

	private char[] constructShape(int column, int row) {
		int amount = ((column - row) / 2);
		char[] shape = new char[amount + row + 1];
		if (amount > 0) {
			Arrays.fill(shape, 0, amount, WHITESPACE_CONTENT);
		}
		Arrays.fill(shape, amount, amount + row, DIAMOND_CONTENT);
		shape[shape.length - 1] = NEWLINE_CONTENT;
		return shape;
	}

}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class DiamondBuilder {

	private static final char SPACE = ' ';
	private static final char SYMBOL = '*';
	private static final char NEWLINE = '\n';

	public String buildDiamond(int size) {
		if (size <= 0 || size % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(createRow(size, size)));
		for (int i = size - 2; i > 0; i -= 2) {
			char[] row = createRow(size, i);
			builder.insert(0, row);
			builder.append(row);
		}
		return builder.toString();
	}

	private char[] createRow(int height, int width) {
		int spaces = ((height - width) / 2);
		char[] row = new char[spaces + width + 1];
		if (spaces > 0) {
			Arrays.fill(row, 0, spaces, SPACE);
		}
		Arrays.fill(row, spaces, spaces + width, SYMBOL);
		row[row.length - 1] = NEWLINE;
		return row;
	}

}

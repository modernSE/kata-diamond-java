package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int dimension) {
		if (dimension <= 0 || dimension % 2 == 0) {
			return null;
		}

		char[] centralRow = createRow(dimension, dimension);
		StringBuilder builder = new StringBuilder(new String(centralRow));

		for (int i = dimension - 2; i > 0; i -= 2) {
			char[] row = createRow(dimension, i);
			addSurroundingRows(builder, row);
		}
		return builder.toString();
	}

	private void addSurroundingRows(StringBuilder builder, char[] row) {
		addToFront(builder, row);
		addToBack(builder, row);
	}

	private void addToFront(StringBuilder builder, char[] row) {
		builder.insert(0, row);
	}

	private void addToBack(StringBuilder builder, char[] row) {
		builder.append(row);
	}

	private char[] createRow(int dimension, int amountStars) {
		int amountWhiteSpace = ((dimension - amountStars) / 2);
		char[] row = new char[amountWhiteSpace + amountStars + 1];

		createLeadingWhiteSpace(row, amountWhiteSpace);
		addStars(row, amountStars, amountWhiteSpace);

		row[row.length - 1] = '\n';
		return row;
	}

	private void addStars(char[] row, int amountStars, int amountWhiteSpace) {
		Arrays.fill(row, amountWhiteSpace, amountWhiteSpace + amountStars, '*');
	}

	private void createLeadingWhiteSpace(char[] row, int amountWhiteSpace) {
		if (amountWhiteSpace <= 0) {
			 Arrays.fill(row, 0, amountWhiteSpace, ' ');
		}
	}

}

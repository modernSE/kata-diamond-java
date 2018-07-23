package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int maxWidth) { // Maybe "size" would be better because width is also the height
		if (isNegativeOrEven(maxWidth)) { // isEven(maxWidth) || isNegative(maxWidth) (one method should only do one thing)
			return null;
		}
		String middleRow = new String(createRow(maxWidth, maxWidth)); // sehr gut
		StringBuilder builder = new StringBuilder(middleRow);
		for (int amountOfStars = maxWidth - 2; amountOfStars > 0; amountOfStars -= 2) {
			char[] row = createRow(maxWidth, amountOfStars);
			builder.insert(0, row);
			builder.append(row);
		}
		return builder.toString();
	}

	private boolean isNegativeOrEven(int maxWidth) {
		return maxWidth <= 0 || maxWidth % 2 == 0;
	}

	private char[] createRow(int maxWidth, int amountOfStars) {
		int amountOfSpaces = ((maxWidth - amountOfStars) / 2);
		char[] row = new char[amountOfSpaces + amountOfStars + 1];
		if (amountOfSpaces > 0) {
			Arrays.fill(row, 0, amountOfSpaces, ' ');
		}
		Arrays.fill(row, amountOfSpaces, amountOfSpaces + amountOfStars, '*');
		row[row.length - 1] = '\n';
		return row;
	}

}

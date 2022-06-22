package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String parseLinePatternToString(int numberOfRows) {
		if (numberOfRows <= 0 || numberOfRows % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(makeLinePattern(numberOfRows, numberOfRows)));
		for (int i = numberOfRows - 2; i > 0; i -= 2) {
			char[] row = makeLinePattern(numberOfRows, i);
			builder.insert(0, row);
			builder.append(row);
		}
		return builder.toString();
	}

	private char[] makeLinePattern(int i, int j) {
		int amount = ((i - j) / 2);
		char[] chars = new char[amount + j + 1];
		if (amount > 0) {
			Arrays.fill(chars, 0, amount, ' ');
		}
		Arrays.fill(chars, amount, amount + j, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

}

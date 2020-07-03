package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int dimensions) {
		if (dimensions <= 0 || dimensions % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(GenerateRow(dimensions, dimensions)));
		for (int AmountOfChars = dimensions - 2; AmountOfChars > 0; AmountOfChars -= 2) {
			char[] chars = GenerateRow(dimensions, AmountOfChars);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] GenerateRow(int row, int amountStars) {
		int amountSpaces = ((row - amountStars) / 2);
		char[] chars = new char[amountSpaces + amountStars + 1];
		if (amountSpaces > 0) {
			Arrays.fill(chars, 0, amountSpaces, ' ');
		}
		Arrays.fill(chars, amountSpaces, amountSpaces + amountStars, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

}

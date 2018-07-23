package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int size) {
		// extract to method
		if (size <= 0 || size % 2 == 0) {
			return null;
		}
		// it helped to understand the code if the string param would be
		// stored in a var like middleLine/ middleRow
		StringBuilder builder = new StringBuilder(new String(makeLine(size, size)));
		// i = amountOfStars
		for (int i = size - 2; i > 0; i -= 2) {
			// chars -> line/row
			char[] chars = makeLine(size, i);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] makeLine(int maxAmountOfStars, int amountOfStars) {
		int amountOfSpaces = ((maxAmountOfStars - amountOfStars) / 2);
		char[] line = new char[amountOfSpaces + amountOfStars + 1];
		if (amountOfSpaces > 0) {
			Arrays.fill(line, 0, amountOfSpaces, ' ');
		}
		Arrays.fill(line, amountOfSpaces, amountOfSpaces + amountOfStars, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}

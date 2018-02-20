package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String createDiamond(int height) {
		if (height <= 0 || height % 2 == 0) {
			return null;
		}
		final StringBuilder result = new StringBuilder(new String(createLine(height, height)));
		for (int i = height - 2; i > 0; i -= 2) {
			char[] line = createLine(height, i);
			result.insert(0, line);
			result.append(line);
		}
		return result.toString();
	}

	private char[] createLine(int maxNumberOfStars, int numberOfStarsInLine) {
		int numberOfBlanks = ((maxNumberOfStars - numberOfStarsInLine) / 2);
		int numberOfVisibleCharacters = numberOfBlanks + numberOfStarsInLine;
		char[] line = new char[numberOfVisibleCharacters + 1];
		if (numberOfBlanks > 0) {
			Arrays.fill(line, 0, numberOfBlanks, ' ');
		}
		Arrays.fill(line, numberOfBlanks, numberOfVisibleCharacters, '*');
		line[numberOfVisibleCharacters] = '\n';
		return line;
	}

}

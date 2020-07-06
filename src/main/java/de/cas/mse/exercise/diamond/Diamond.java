package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int numerOfRows) {
		if (numerOfRows <= 0 || numerOfRows % 2 == 0) {
			return null;
		}
		StringBuilder diamondBuilder = new StringBuilder(new String(createLine(numerOfRows, numerOfRows)));
		for (int numberOfStarsInCurrentLine = numerOfRows - 2; numberOfStarsInCurrentLine > 0; numberOfStarsInCurrentLine -= 2) {
			char[] line = createLine(numerOfRows, numberOfStarsInCurrentLine);
			diamondBuilder.insert(0, line);
			diamondBuilder.append(line);
		}
		return diamondBuilder.toString();
	}

	private char[] createLine(int numerOfRows, int j) {
		int amountOfStars = ((numerOfRows - j) / 2); //calculate stars in line
		char[] chars = new char[amountOfStars + j + 1];
		if (amountOfStars > 0) {
			Arrays.fill(chars, 0, amountOfStars, ' ');
		}
		Arrays.fill(chars, amountOfStars, amountOfStars + j, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

}

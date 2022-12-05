package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private int diamondSize;

	public String print(int diamondSize) {
		this.diamondSize = diamondSize;

		if (diamondSize <= 0 || diamondSize % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(makeStarsLine(diamondSize)));
		for (int i = diamondSize - 2; i > 0; i -= 2) {
			char[] starsLine = makeStarsLine(i);
			builder.insert(0, starsLine);
			builder.append(starsLine);
		}
		return builder.toString();
	}

	private char[] makeStarsLine(int j) {
		int amountOfStars = ((diamondSize - j) / 2);
		char[] starsLine = new char[amountOfStars + j + 1];
		if (amountOfStars > 0) {
			Arrays.fill(starsLine, 0, amountOfStars, ' ');
		}
		int fromIndex = amountOfStars;
		int toIndex = amountOfStars +j;
		Arrays.fill(starsLine, fromIndex, toIndex, '*');
		starsLine[starsLine.length - 1] = '\n';
		return starsLine;
	}

}

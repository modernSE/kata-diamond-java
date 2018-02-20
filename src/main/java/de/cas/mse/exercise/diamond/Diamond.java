package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int diamondWidth) {
		if (diamondWidth <= 0 || diamondWidth % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(make(diamondWidth, diamondWidth)));
		for (int i = diamondWidth - 2; i > 0; i -= 2) {
			char[] chars = make(diamondWidth, i);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] make(int diamondWidth, int numberOfStars) {
		int starsStartIndex = ((diamondWidth - numberOfStars) / 2);
		int totalWidth = starsStartIndex + numberOfStars + 1;
		char[] chars = new char[totalWidth];
		if (starsStartIndex > 0) {
			Arrays.fill(chars, 0, starsStartIndex, ' ');
		}
		Arrays.fill(chars, starsStartIndex, starsStartIndex + numberOfStars, '*');
		chars[totalWidth-1] = '\n';
		return chars;
	}

}

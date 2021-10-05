package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class AsciiDiamond {

	public String create(int height) {
		if (height <= 0 || height % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(makeLineWithoutTrailingSpaces(height, height)));
		for (int i = height - 2; i > 0; i -= 2) {
			char[] currentLine = makeLineWithoutTrailingSpaces(height, i);
			builder.insert(0, currentLine);
			builder.append(currentLine);
		}
		return builder.toString();
	}

	private char[] makeLineWithoutTrailingSpaces(int widthIncludingLeadingAndTrailingSpaces, int numberOfStars) {
		int numberOfLeadingSpaces = ((widthIncludingLeadingAndTrailingSpaces - numberOfStars) / 2);
		char[] lineWithoutTrailingSpaces = new char[numberOfLeadingSpaces + numberOfStars + 1];
		if (numberOfLeadingSpaces > 0) {
			Arrays.fill(lineWithoutTrailingSpaces, 0, numberOfLeadingSpaces, ' ');
		}
		Arrays.fill(lineWithoutTrailingSpaces, numberOfLeadingSpaces, numberOfLeadingSpaces + numberOfStars, '*');
		lineWithoutTrailingSpaces[lineWithoutTrailingSpaces.length - 1] = '\n';
		return lineWithoutTrailingSpaces;
	}

}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int maxWidth) {
		if (maxWidth <= 0 || maxWidth % 2 == 0) {
			return null;
		}
		StringBuilder star = createStar(maxWidth);
		return star.toString();
	}

	private StringBuilder createStar(int maxWidth) {
		StringBuilder star = new StringBuilder();
		addCenterLine(star, maxWidth);
		addSurroundingLines(star, maxWidth);
		return star;
	}

	private void addSurroundingLines(StringBuilder star, int maxWidth) {
		int currentNumberOfStars = maxWidth - 2;
		while (currentNumberOfStars > 0) {
			addLine(star, maxWidth, currentNumberOfStars);
			currentNumberOfStars -= 2;
		}
	}
	
	private void addCenterLine(StringBuilder star, int maxWidth) {
		star.append(createLine(maxWidth, maxWidth));
	}

	private void addLine(StringBuilder star, int maxWidth, int numberOfStars) {
		String line = createLine(maxWidth, numberOfStars);
		star.insert(0, line);
		star.append(line);
	}

	private String createLine(int totalWidth, int numberOfStars) {
		int numberOfSpaces = ((totalWidth - numberOfStars) / 2);
		char[] chars = new char[numberOfSpaces + numberOfStars + 1];
		if (numberOfSpaces > 0) {
			Arrays.fill(chars, 0, numberOfSpaces, ' ');
		}
		Arrays.fill(chars, numberOfSpaces, numberOfSpaces + numberOfStars, '*');
		chars[chars.length - 1] = '\n';
		return new String(chars);
	}

}

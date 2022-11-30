package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String generate(int maxWidth) {
		if (maxWidth <= 0 || maxWidth % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(generateMiddleLine(maxWidth));
		for (int numberOfStars = maxWidth - 2; numberOfStars > 0; numberOfStars -= 2) {
			char[] line = generateLine(maxWidth, numberOfStars);
			addToStartAndEnd(builder, line);
		}
		return builder.toString();
	}

	private void addToStartAndEnd(StringBuilder builder, char[] line) {
		builder.insert(0, line);
		builder.append(line);
	}

	private String generateMiddleLine(int length) {
		return new String(generateLine(length, length));
	}

	private char[] generateLine(int width, int numberOfStars) {
		int numberOfSpaces = ((width - numberOfStars) / 2);
		char[] line = new char[numberOfSpaces + numberOfStars + 1]; 
		if (numberOfSpaces > 0) {
			Arrays.fill(line, 0, numberOfSpaces, ' ');
		}
		Arrays.fill(line, numberOfSpaces, numberOfSpaces + numberOfStars, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}

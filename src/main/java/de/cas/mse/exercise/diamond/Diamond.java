package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int width) {
		if (width <= 0 || width % 2 == 0) {
			return null;
		}
        StringBuilder builder = new StringBuilder();
        builder.append(generateLine(width, width));
		for (int currentWidth = width - 2; currentWidth > 0; currentWidth -= 2) {
			char[] line = generateLine(width, currentWidth);
			builder.insert(0, line);
			builder.append(line);
		}
		return builder.toString();
	}

	private char[] generateLine(int maxWidth, int currentWidth) {
		int leadingSpaces = ((maxWidth - currentWidth) / 2);
		char[] line = new char[leadingSpaces + currentWidth + 1];
		if (leadingSpaces > 0) {
			Arrays.fill(line, 0, leadingSpaces, ' ');
		}
		Arrays.fill(line, leadingSpaces, leadingSpaces + currentWidth, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}

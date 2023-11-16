package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private final char WHITESPACE = ' ';

	private final char STAR = '*';

	private final Character NEW_LINE = '\n';

	public String print(int width) {
		if (invalidInput(width)) return null;
		
		StringBuilder builder = new StringBuilder(new String(generateLine(width, width)));
		for (int currentHeight = width - 2; currentHeight > 0; currentHeight -= 2) {
			char[] chars = generateLine(width, currentHeight);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] generateLine(int maxWidth, int currentWidth) {
		int center = ((maxWidth - currentWidth) / 2);
		char[] line = new char[center + currentWidth + 1];
		if (center > 0) {
			Arrays.fill(line, 0, center, WHITESPACE);
		}
		Arrays.fill(line, center, center + currentWidth, STAR);
		line[line.length - 1] = NEW_LINE;

		return line;
	}

	private Boolean invalidInput(int width){
		return width <= 0 || width % 2 == 0;
	}

}

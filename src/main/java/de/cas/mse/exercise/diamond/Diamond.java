package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int size) {
		if (size <= 0 || size % 2 == 0) {
			return null;
		}
		StringBuilder diamond = new StringBuilder(new String(createLine(size, size)));
		for (int numberOfStars = size - 2; numberOfStars > 0; numberOfStars -= 2) {
			char[] line = createLine(size, numberOfStars);
			diamond.insert(0, line);
			diamond.append(line);
		}
		return diamond.toString();
	}

	private char[] createLine(int maxWidth, int width) {
		int padding = ((maxWidth - width) / 2);
		char[] line = new char[padding + width + 1];
		if (padding > 0) {
			Arrays.fill(line, 0, padding, ' ');
		}
		Arrays.fill(line, padding, padding + width, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}

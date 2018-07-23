package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	/*
	 * - size should be renamed to sizeOfDiamond (?)
	 * - i should be renamed to numOfStars
	 */
	public String print(int size) {
		// Extract to seperate method -> isNegati.....
		if (size <= 0 || size % 2 == 0) {
			return null;
		}
		// Could ve confusing to rename the builder
		// Extract new String(createLine...) to var -> middleLine
		StringBuilder lines = new StringBuilder(new String(createLine(size, size)));
		for (int i = size - 2; i > 0; i -= 2) {
			char[] line = createLine(size, i);
			lines.insert(0, line);
			lines.append(line);
		}
		return lines.toString();
	}
	
	/*
	 * - size should be renamed to sizeOfDiamond
	 */
	private char[] createLine(int size, int numberOfStars) {
		int numberOfSpaces = ((size - numberOfStars) / 2);
		char[] line = new char[numberOfSpaces + numberOfStars + 1];
		if (numberOfSpaces > 0) {
			Arrays.fill(line, 0, numberOfSpaces, ' ');
		}
		Arrays.fill(line, numberOfSpaces, numberOfSpaces + numberOfStars, '*');
		line[line.length - 1] = '\n';
		return line;
	}
}

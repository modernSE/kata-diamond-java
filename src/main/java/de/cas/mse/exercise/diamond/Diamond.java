package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String createDiamond(int diamondSize) {
		if (isInvalid(diamondSize)) {
			return null;
		}
		StringBuilder diamond = new StringBuilder(new String(buildLine(diamondSize, diamondSize)));
		for (int amountStarsOfLine = diamondSize - 2; amountStarsOfLine > 0; amountStarsOfLine -= 2) {
			char[] line = buildLine(diamondSize, amountStarsOfLine);
			diamond.insert(0, line);
			diamond.append(line);
		}
		return diamond.toString();
	}

	private boolean isInvalid(int diamondSize) {
		return diamondSize <= 0 || diamondSize % 2 == 0;
	}

	private char[] buildLine(int totalLength, int amountStars) {
		int amountLeadingWhitespaces = ((totalLength - amountStars) / 2);
		char[] line = new char[amountLeadingWhitespaces + amountStars + 1];
		if (amountLeadingWhitespaces > 0) {
			Arrays.fill(line, 0, amountLeadingWhitespaces, ' ');
		}
		Arrays.fill(line, amountLeadingWhitespaces, amountLeadingWhitespaces + amountStars, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}

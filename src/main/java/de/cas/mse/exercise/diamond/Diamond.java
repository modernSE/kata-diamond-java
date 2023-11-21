package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private static final char NEWLINE = '\n';
	private static final char STAR = '*';
	private static final char SPACE = ' ';

	public String print(int totalLineCount) {
		if (totalLineCount <= 0 || totalLineCount % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(buildLine(totalLineCount, totalLineCount));
		
		for (int starCount = totalLineCount - 2; starCount > 0; starCount -= 2) {
			String line = buildLine(totalLineCount, starCount);
			builder.insert(0, line);
			builder.append(line);
		}

		return builder.toString();
	}

	private String buildLine(int totalLineCount, int starCount) {
		final int blankAmount = ((totalLineCount - starCount) / 2);
		char[] lineChars = new char[blankAmount + starCount + 1];
		if (blankAmount > 0) {
			Arrays.fill(lineChars, 0, blankAmount, SPACE);
		}
		Arrays.fill(lineChars, blankAmount, blankAmount + starCount, STAR);
		
		final int lastIndex = lineChars.length - 1;
		lineChars[lastIndex] = NEWLINE;
		return new String(lineChars);
	}

}

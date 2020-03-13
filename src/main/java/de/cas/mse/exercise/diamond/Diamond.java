package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private static final int starsDecreaseStep = 2;

	public String print(int diamondWidth) {
		if (isValidDiamondWidth(diamondWidth)) {
			return null;
		}
		
		return createDiamond(diamondWidth);
	}
	
	private boolean isValidDiamondWidth(int maxDiamonWidth) {
		return maxDiamonWidth <= 0 || maxDiamonWidth % 2 == 0;
	}

	private String createDiamond(int maxDiamonWidth) {
		StringBuilder diamondBuilder = new StringBuilder(createMiddleRow(maxDiamonWidth));
		for (int starsInCurrentRow = maxDiamonWidth - starsDecreaseStep; starsInCurrentRow > 0; starsInCurrentRow -= starsDecreaseStep) {
			char[] row = createRow(maxDiamonWidth, starsInCurrentRow);
			addRowAbove(diamondBuilder, row);
			addRowBelow(diamondBuilder, row);
		}
		return diamondBuilder.toString();
	}

	private void addRowBelow(StringBuilder diamondBuilder, char[] row) {
		diamondBuilder.append(row);
	}

	private void addRowAbove(StringBuilder diamondBuilder, char[] row) {
		diamondBuilder.insert(0, row);
	}

	private String createMiddleRow(int maxDiamonWidth) {
		return new String(createRow(maxDiamonWidth, maxDiamonWidth));
	}

	private char[] createRow(int charsInRow, int starsInRow) {
		int spacesBeforeStars = ((charsInRow - starsInRow) / 2);
		char[] row = new char[spacesBeforeStars + starsInRow + 1];
		if (spacesBeforeStars > 0) {
			Arrays.fill(row, 0, spacesBeforeStars, ' ');
		}
		Arrays.fill(row, spacesBeforeStars, spacesBeforeStars + starsInRow, '*');
		row[row.length - 1] = '\n';
		return row;
	}

}

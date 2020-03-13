package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int diamondHeight) {
		if (isValidHeight(diamondHeight)) {
			return null;
		}
		String middleRow = buildMiddleRow(diamondHeight);
		StringBuilder builder = new StringBuilder(middleRow);
		
		for (int currentWidth = diamondHeight - 2; currentWidth > 0; currentWidth -= 2) {
			builder = addRowsSymetrically(diamondHeight, builder, currentWidth);
		}
		return builder.toString();
	}

	private StringBuilder addRowsSymetrically(int totalWidth, StringBuilder builder, int currentWidth) {
		String currentRow = buildRow(totalWidth, currentWidth);
		addRowAbove(builder, currentRow);
		addRowBelow(builder, currentRow);
		return builder;
	}

	private String buildMiddleRow(int diamondHeight) {
		return buildRow(diamondHeight, diamondHeight);
	}

	private StringBuilder addRowBelow(StringBuilder builder, String currentRow) {
		return builder.append(currentRow);
	}

	private void addRowAbove(StringBuilder builder, String currentRow) {
		builder.insert(0, currentRow);
	}

	private boolean isValidHeight(int diamondHeight) {
		return diamondHeight <= 0 || diamondHeight % 2 == 0;
	}

	private String buildRow(int totalDiamondWidth, int numberOfStars) {
		
		int whiteSpacesOnOneSide = (totalDiamondWidth-numberOfStars) / 2;
		char[] row = new char[calculateRowWidth(numberOfStars, whiteSpacesOnOneSide)];
		
		row = fillWhiteSpaces(whiteSpacesOnOneSide, row);
		
		row = fillStars(numberOfStars, whiteSpacesOnOneSide, row);
		row = appendLineBreak(row);
		
		return new String(row);
	}

	private char[] appendLineBreak(char[] row) {
		row[row.length - 1] = '\n';
		return row;
	}

	private char[] fillStars(int numberOfStars, int whiteSpacesOnOneSide, char[] row) {
		Arrays.fill(row, whiteSpacesOnOneSide, whiteSpacesOnOneSide + numberOfStars, '*');
		return row;
	}

	private char[] fillWhiteSpaces(int whiteSpacesOnOneSide, char[] row) {
		if (whiteSpacesOnOneSide > 0) {
			Arrays.fill(row, 0, whiteSpacesOnOneSide, ' ');
		}
		return row;
	}

	private int calculateRowWidth(int numberOfStars, int whiteSpacesOnOneSide) {
		return whiteSpacesOnOneSide + numberOfStars + 1;
	}

}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String printDiamond(int diamondHeight) {
		if (diamondHeight <= 0 || diamondHeight % 2 == 0) {
			return null;
		}
		StringBuilder diamondBuilder = new StringBuilder(new String(buildDiamondRow(diamondHeight, diamondHeight)));
		for (int diamondWidth = diamondHeight - 2; diamondWidth > 0; diamondWidth -= 2) {
			char[] diamondRow = buildDiamondRow(diamondHeight, diamondWidth);
			diamondBuilder.insert(0, diamondRow);
			diamondBuilder.append(diamondRow);
		}
		return diamondBuilder.toString();
	}

	private char[] buildDiamondRow(int diamondHeight, int diamondWidth) {
		int numberOfSpaces = ((diamondHeight - diamondWidth) / 2);
		char[] diamondRow = new char[numberOfSpaces + diamondWidth + 1];
		if (numberOfSpaces > 0) {
			Arrays.fill(diamondRow, 0, numberOfSpaces, ' ');
		}
		Arrays.fill(diamondRow, numberOfSpaces, numberOfSpaces + diamondWidth, '*');
		diamondRow[diamondRow.length - 1] = '\n';
		return diamondRow;
	}

}

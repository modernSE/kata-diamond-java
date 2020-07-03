package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String buildDiamond(int maxRowWidth) { 
		if (maxRowWidth <= 0 || maxRowWidth % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(buildDiamondRow(maxRowWidth, maxRowWidth)));
		for (int currentRowWidth = maxRowWidth - 2; currentRowWidth > 0; currentRowWidth -= 2) {
			char[] diamondRow = buildDiamondRow(maxRowWidth, currentRowWidth);
			builder.insert(0, diamondRow);
			builder.append(diamondRow);
		}
		return builder.toString();
	}

    private char[] buildDiamondRow(int maxRowWidth, int currentRowWidth) {
		int spacesWidth = ((maxRowWidth - currentRowWidth) / 2);
		char[] diamondRow = new char[spacesWidth + currentRowWidth + 1];
		if (spacesWidth > 0) {
			Arrays.fill(diamondRow, 0, spacesWidth, ' ');
		}
		Arrays.fill(diamondRow, spacesWidth, spacesWidth + currentRowWidth, '*');
		diamondRow[diamondRow.length - 1] = '\n';
		return diamondRow;
	}

}

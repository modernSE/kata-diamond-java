package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String constructDiamond(int diamondDiameter) {
		if (diamondDiameter <= 0 || diamondDiameter % 2 == 0) {
			return null;
		}
		StringBuilder diamondBuilder = new StringBuilder(new String(createDiamondRow(diamondDiameter, diamondDiameter)));
		for (int space = diamondDiameter - 2; space > 0; space -= 2) {
			char[] diamondRow = createDiamondRow(diamondDiameter, space);
			diamondBuilder.insert(0, diamondRow);
			diamondBuilder.append(diamondRow);
		}
		return diamondBuilder.toString();
	}

	private char[] createDiamondRow(int diameter, int space) {
		int rowPaddingLeft = ((diameter - space) / 2);
		char[] row = new char[rowPaddingLeft + space + 1];
		if (rowPaddingLeft > 0) {
			Arrays.fill(row, 0, rowPaddingLeft, ' ');
		}
		Arrays.fill(row, rowPaddingLeft, rowPaddingLeft + space, '*');
		row[row.length - 1] = '\n';
		return row;
	}

}

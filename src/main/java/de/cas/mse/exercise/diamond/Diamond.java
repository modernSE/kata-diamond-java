package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int diamondSize) {
		if (diamondSize <= 0 || diamondSize % 2 == 0) {
			return null;
		}

		StringBuilder diamond = new StringBuilder(new String(buildDiamondRow(diamondSize, diamondSize)));

		for (int i = diamondSize - 2; i > 0; i -= 2) {
			char[] diamondRow = buildDiamondRow(diamondSize, i);
			addRowOnTop(diamond, diamondRow);
			addRowOnBottom(diamond, diamondRow);
		}
		return diamond.toString();
	}

	private char[] buildDiamondRow(int diamondSize, int j) {
		int amount = ((diamondSize - j) / 2);
		char[] row = new char[amount + j + 1];
		if (amount > 0) {
			Arrays.fill(row, 0, amount, ' ');
		}
		Arrays.fill(row, amount, amount + j, '*');
		addLineBreakToRow(row);
		return row;
	}

	private void addRowOnTop(StringBuilder diamond, char[] diamondRow) {
		diamond.insert(0, diamondRow);
	}

	private void addRowOnBottom(StringBuilder diamond, char[] diamondRow) {
		diamond.append(diamondRow);
	}

	private void addLineBreakToRow(char[] chars) {
		chars[chars.length - 1] = '\n';
	}

}

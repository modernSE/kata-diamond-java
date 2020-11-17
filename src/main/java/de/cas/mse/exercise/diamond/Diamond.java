package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String createDiamond(int maximumDimension) {
		if (maximumDimension <= 0 || maximumDimension % 2 == 0) {
			return null;
		}
		StringBuilder diamondBuilder = new StringBuilder(new String(createDiamondRow(maximumDimension, maximumDimension)));
		for (int sizeToLower = maximumDimension - 2; sizeToLower > 0; sizeToLower -= 2) {
			char[] diamondRow = createDiamondRow(maximumDimension, sizeToLower);
			diamondBuilder.insert(0, diamondRow);
			diamondBuilder.append(diamondRow);
		}
		return diamondBuilder.toString();
	}

	private char[] createDiamondRow(int maximumDimension, int sizeToLower) {
		int amountOfStars = ((maximumDimension - sizeToLower) / 2);
		char[] diamondRow = new char[amountOfStars + sizeToLower + 1];
		if (amountOfStars > 0) {
			Arrays.fill(diamondRow, 0, amountOfStars, ' ');
		}
		Arrays.fill(diamondRow, amountOfStars, amountOfStars + sizeToLower, '*');
		diamondRow[diamondRow.length - 1] = '\n';
		return diamondRow;
	}

}

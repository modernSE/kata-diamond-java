package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String buildDiamondString(int maxWidth) {
		if (maxWidth <= 0 || maxWidth % 2 == 0) {
			return null;
		}
		StringBuilder diamondString = new StringBuilder(new String(fillDiamondLine(maxWidth, maxWidth)));
		for (int amountOfStarsInLine = maxWidth - 2; amountOfStarsInLine > 0; amountOfStarsInLine -= 2) {
			char[] singleLine = fillDiamondLine(maxWidth, amountOfStarsInLine);
			diamondString.insert(0, singleLine);
			diamondString.append(singleLine);
		}
		return diamondString.toString();
	}

	private char[] fillDiamondLine(int width, int starAmount) {
		int whiteSpaceCount = ((width - starAmount) / 2);
		char[] singleDiamondLineToReturn = new char[whiteSpaceCount + starAmount + 1];
		if (whiteSpaceCount > 0) {
			Arrays.fill(singleDiamondLineToReturn, 0, whiteSpaceCount, ' ');
		}
		Arrays.fill(singleDiamondLineToReturn, whiteSpaceCount, whiteSpaceCount + starAmount, '*');
		singleDiamondLineToReturn[singleDiamondLineToReturn.length - 1] = '\n';
		return singleDiamondLineToReturn;
	}

}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private static final char EMPTY_SYMBOL = ' ';
	private static final char DIAMOND_SYMBOL = '*';

	public String print(int diamondWidth) {
		
		if (diamondWidth <= 0 || diamondWidth % 2 == 0) {
			return null;
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(getDiamondLine(diamondWidth, diamondWidth));
		
		for (int leadingSpaces = diamondWidth - 2; leadingSpaces > 0; leadingSpaces -= 2) {
			char[] line = getDiamondLine(diamondWidth, leadingSpaces);
			builder.insert(0, line);
			builder.append(line);
		}
		return builder.toString();
	}

	private char[] getDiamondLine(int diamondWidth, int leadingSpaces) {
		int numberOfDiamondSymbols = ((diamondWidth - leadingSpaces) / 2);
		char[] line = new char[numberOfDiamondSymbols + leadingSpaces + 1];
		if (numberOfDiamondSymbols > 0) {
			Arrays.fill(line, 0, numberOfDiamondSymbols, EMPTY_SYMBOL);
		}
		Arrays.fill(line, numberOfDiamondSymbols, numberOfDiamondSymbols + leadingSpaces, DIAMOND_SYMBOL);
		line[line.length - 1] = '\n';
		return line;
	}

}

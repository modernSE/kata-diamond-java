package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class DiamondAsciiArtCreator {

	public String create(int size) {
		if (isInvalidDiamondSize(size)) {
			return null;
		}
		String startingMiddleRow = createRow(size, size);
		String diamond = createRows(size, startingMiddleRow);
		return diamond;
	}

	private String createRows(int maxDiamonds, String startingMiddleRow) {
		var builder = new StringBuilder(startingMiddleRow);
		for (int currentDiamonds = maxDiamonds - 2; currentDiamonds > 0; currentDiamonds -= 2) {
			var row = createRow(maxDiamonds, currentDiamonds);
			addRowToTopAndBottom(builder, row);
		}
		return builder.toString();
	}

	private String createRow(int maxDiamonds, int currentDiamonds) {
		int leadingSpaces = ((maxDiamonds - currentDiamonds) / 2);
		
		var row = new char[leadingSpaces + currentDiamonds];
		row = fillWithSpaces(leadingSpaces, row);
		row = fillWithDiamond(leadingSpaces, row, currentDiamonds);
		
		return new String(row) + '\n';
	}

	private void addRowToTopAndBottom(StringBuilder builder, String symetricRow) {
		builder.insert(0, symetricRow);
		builder.append(symetricRow);
	}

	private char[] fillWithDiamond(int leadingSpaces, char[] row, int currentDiamonds) {
		Arrays.fill(row, leadingSpaces, leadingSpaces + currentDiamonds, '*');
		return row;
	}

	private char[] fillWithSpaces(int leadingSpaces, char[] row) {
		Arrays.fill(row, 0, leadingSpaces, ' ');
		return row;
	}

	private boolean isInvalidDiamondSize(int size) {
		return size <= 0 || size % 2 == 0;
	}
}

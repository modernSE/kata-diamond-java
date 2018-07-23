package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int sizeOfDiamond) {
		// Könnte man auslagen
		if (sizeOfDiamond <= 0 || sizeOfDiamond % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(makeRow(sizeOfDiamond, sizeOfDiamond)));
		for (int rowIndex = sizeOfDiamond - 2; rowIndex > 0; rowIndex -= 2) {
			// rowIndex ist nicht klar, da Rows oben und unten angehängt werden
			// Vorschlag: hier schon numOfStars nennen

			char[] row = makeRow(sizeOfDiamond, rowIndex);
			builder.insert(0, row);
			builder.append(row);
		}
		return builder.toString();
	}

	private char[] makeRow(int totalNumOfStars, int numOfStars) {
		// totalNumOfStars ist nicht eindeutig, man könnte hier auch eine Summe vermuten
		// Vorschlag: maxNumOfStars
		// wieso nicht sizeOfDiamond wie in Line 12? 
		// unterschiedliche Benennung legitim, weil innerhalb der Methode am passendsten
		int numOfSpaces = ((totalNumOfStars - numOfStars) / 2);
		char[] row = new char[numOfSpaces + numOfStars + 1];
		if (numOfSpaces > 0) {
			Arrays.fill(row, 0, numOfSpaces, ' ');
		}
		Arrays.fill(row, numOfSpaces, numOfSpaces + numOfStars, '*');
		row[row.length - 1] = '\n';
		// Man könnte hier schon Row als String zurückgeben,
		// damit man sich das new String in Line 12 spart		
		return row;
	}

}

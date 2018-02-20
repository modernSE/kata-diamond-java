package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private static final char EMPTY_SYMBOL = ' ';
	private static final char DIAMOND_SYMBOL = '*';

	//nicht print, es wird ein String erzeugt
	public String print(int diamondWidth) {
		
		if (diamondWidth <= 0 || diamondWidth % 2 == 0) {
			return null;
		}
		
		//builder umbenennen?
		StringBuilder builder = new StringBuilder();
		builder.append(getDiamondLine(diamondWidth, diamondWidth));
		
		//nicht leadingSPACES, ihr habt explizit die Konstante EMPTY_SYMBOL definiert
		//-> leadingSymbols (leadingSpaces ist ja sowieso falsch, das sind die Sterne in der Zeile)
		for (int leadingSpaces = diamondWidth - 2; leadingSpaces > 0; leadingSpaces -= 2) {
			char[] line = getDiamondLine(diamondWidth, leadingSpaces);
			builder.insert(0, line);
			builder.append(line);
		}
		return builder.toString();
	}
	
	//leadingSpaces ist falsch, dieser Parameter entspricht die diamond_symbols
	private char[] getDiamondLine(int diamondWidth, int leadingSpaces) {
		
		//numberOfDiamondSymbols ist falsch, das ist numberOfLeadingSymbols / start index der diamond_symbols
		int numberOfDiamondSymbols = ((diamondWidth - leadingSpaces) / 2);
		char[] line = new char[numberOfDiamondSymbols + leadingSpaces + 1];
		if (numberOfDiamondSymbols > 0) {
			Arrays.fill(line, 0, numberOfDiamondSymbols, EMPTY_SYMBOL);
		}
		Arrays.fill(line, numberOfDiamondSymbols, numberOfDiamondSymbols + leadingSpaces, DIAMOND_SYMBOL);
		line[line.length - 1] = '\n'; //kann man auch als Konstante rausziehen
		return line;
	}

}

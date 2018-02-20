package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {
	
	// Idee: Statt StringBuilder LinkedList<String>, statt char[] komplett auf Strings umsteigen.

	public String createDiamond(int height) {
		if (height <= 0 || height % 2 == 0) {	// Funktion rausziehen, und sprechend bezeichnen: tooSmall() or notEven()
			return null;
		}
		// In der Zeile passieren zwei Sachen: Stringbuilder erstellen und mittlere Zeile einfügen. 
		// Trennen, und für letzteres
		// könnte man eine eigene Funktion machen.
		final StringBuilder result = new StringBuilder(new String(createLine(height, height))); 
		for (int i = height - 2; i > 0; i -= 2) {   	// i ist kein aussagender Bezeichner: numberOfStars?
			char[] line = createLine(height, i);	// line -> symmetricLine
			result.insert(0, line);			// Beide Zeilen in Funktion rausziehen: growDiamondVerticallyUpAndDown
			result.append(line);
		}
		return result.toString();
	}

	private char[] createLine(int maxNumberOfStars, int numberOfStarsInLine) {
		int numberOfBlanks = ((maxNumberOfStars - numberOfStarsInLine) / 2);  // 
		int numberOfVisibleCharacters = numberOfBlanks + numberOfStarsInLine; // Sehr GUt: +1 entfernt.
		char[] line = new char[numberOfVisibleCharacters + 1];
		if (numberOfBlanks > 0) { // if komplett entfernen
			Arrays.fill(line, 0, numberOfBlanks, ' ');	// String externalisieren, mit abstraktem Namen: OUTSIDE_SYMBOL
		}
		Arrays.fill(line, numberOfBlanks, numberOfVisibleCharacters, '*'); // String externalisieren: INSIDE_SYMBOL
		line[numberOfVisibleCharacters] = '\n';
		return line;
	}

}

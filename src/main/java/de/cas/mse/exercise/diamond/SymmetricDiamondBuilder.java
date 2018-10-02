package de.cas.mse.exercise.diamond;

import java.util.Arrays;

// Symmetric ist eher überflüssig,
// da das Resultat nur dann wie ein Diamant aussieht
public class SymmetricDiamondBuilder {

	public String build(int diamondSize) {
		//Extract method: isPrintable?
		if (diamondSize <= 0 || diamondSize % 2 == 0) {
			return null;
		}
		// Prefix diamond (diamondSize) notwendig?
		StringBuilder builder = new StringBuilder(new String(generateLine(diamondSize, diamondSize)));
		for (int i = diamondSize - 2; i > 0; i -= 2) {
			// previous line as well?
			char[] nextLine = generateLine(diamondSize, i);
			builder.insert(0, nextLine);
			builder.append(nextLine);
		}
		return builder.toString();
	}

	private char[] generateLine(int diamondSize, int asteriskCount) {
		//no abbreviations: num -> number
		// count or number? Decide
		int numSpaces = ((diamondSize - asteriskCount) / 2); 
		char[] lineChars = new char[numSpaces + asteriskCount + 1];
		if (numSpaces > 0) {
			Arrays.fill(lineChars, 0, numSpaces, ' ');
		}
		
		Arrays.fill(lineChars, numSpaces, numSpaces + asteriskCount, '*');
		
		// last index of the line = lastLineIndex
		int lastCharIndex = lineChars.length - 1; 
		lineChars[lastCharIndex] = '\n';
		
		return lineChars;
	}

}

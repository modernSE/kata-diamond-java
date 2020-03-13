package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String createDiamond(int diamondSize) {
		// GOOD
		if (isInvalid(diamondSize)) {
			return null;
		}
		
		// Line is too long, use interm. variable f. clarity
		// Missing abstraction e.g  buildCenterLine(..) to avoid confusion on double param usage
		StringBuilder diamond = new StringBuilder(new String(buildLine(diamondSize, diamondSize)));
		
		//prefix 'amount' not really necessary
		for (int amountStarsOfLine = diamondSize - 2; amountStarsOfLine > 0; amountStarsOfLine -= 2) {
			// Better to use strings for simplicity outside of buildLine(..)
			// Could be abstracted into a well named method e.g. expandDiamondUpAndDown
			char[] line = buildLine(diamondSize, amountStarsOfLine);
			diamond.insert(0, line);
			diamond.append(line);
		}
		return diamond.toString();
	}

	// GOOD
	private boolean isInvalid(int diamondSize) {
		return diamondSize <= 0 || diamondSize % 2 == 0;
	}

	
	private char[] buildLine(int totalLength, int amountStars) {
		//prefix 'amount' not really necessary
		int amountLeadingWhitespaces = ((totalLength - amountStars) / 2);
		char[] line = new char[amountLeadingWhitespaces + amountStars + 1];
		// Extract next 3 lines e.g.  addLeadingWhitespace(..) 
		if (amountLeadingWhitespaces > 0) {
			Arrays.fill(line, 0, amountLeadingWhitespaces, ' ');
		}
		// Extract next line for readability to method
		Arrays.fill(line, amountLeadingWhitespaces, amountLeadingWhitespaces + amountStars, '*');
		// Extract as well for consistency
		line[line.length - 1] = '\n';
		return line;
	}

}

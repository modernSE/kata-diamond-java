package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {
 
	// either make the print method static or create a private field for the diamondWidth and set it through the constructor
	// rename to create(), print suggests no return value
	public String print(int maxDiamondWidth) {
		if (maxDiamondWidth <= 0 || maxDiamondWidth % 2 == 0) {
			return null;
		}
		
		// rename to result
		// maybe split into two lines, see comment about the return value of createRow()
		StringBuilder builder = new StringBuilder(new String(createRow(maxDiamondWidth, maxDiamondWidth)));
		
		for (int rowWidth = maxDiamondWidth - 2; rowWidth > 0; rowWidth -= 2) {
			char[] chars = createRow(maxDiamondWidth, rowWidth);
			builder.insert(0, chars);
			builder.append(chars);
		}
		
		return builder.toString();
	}

	// change the return value to a String
	private char[] createRow(int maxDiamondWidth, int rowWidth) {
		int leadingSpaces = ((maxDiamondWidth - rowWidth) / 2);
		char[] chars = new char[leadingSpaces + rowWidth + 1];
		
		Arrays.fill(chars, 0, leadingSpaces, ' ');
		Arrays.fill(chars, leadingSpaces, leadingSpaces + rowWidth, '*');
		
		chars[chars.length - 1] = '\n';
		return chars;
	}

}

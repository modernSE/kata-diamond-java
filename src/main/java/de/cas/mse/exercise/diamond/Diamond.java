package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int size) { // vielleicht max width/size 
		if (size <= 0 || size % 2 == 0) { 
			return null;
		}
		
		StringBuilder builder = new StringBuilder(new String(buildRow(size, size))); 
		for (int amoundOfStars = size - 2; amoundOfStars > 0; amoundOfStars -= 2) { 
			char[] row = buildRow(size, amoundOfStars); // amount of stars per row
			builder.insert(0, row);
			builder.append(row);
		}
		return builder.toString();
	}
	// maybe some line breaks
	private char[] buildRow(int sizeOfDiamond, int amountOfStars) { //amount per row
		int whiteSpaceLeft = ((sizeOfDiamond - amountOfStars) / 2); 
		char[] row = new char[whiteSpaceLeft + amountOfStars + 1]; 
		if (whiteSpaceLeft > 0) {
			Arrays.fill(row, 0, whiteSpaceLeft, ' ');
		}
		Arrays.fill(row, whiteSpaceLeft, whiteSpaceLeft + amountOfStars, '*');
		row[row.length - 1] = '\n';
		return row;
	}
	


}

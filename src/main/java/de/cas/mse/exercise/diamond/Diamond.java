package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {
	
//ganz cool. Übers Aufgabenziel hinausgeschossen yay
//  *
// * * 
//  *
	
	private final int ROW_COUNT;
	public Diamond(int rowCount) {
		this.ROW_COUNT = rowCount;
	}


	
	
	public String buildDiamond() {
		if (ROW_COUNT <= 0 || ROW_COUNT % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(buildRow(ROW_COUNT));
		for (int i = ROW_COUNT - 2; i > 0; i -= 2) {
			String row = buildRow(i);
			builder.insert(0, row);
			builder.insert(builder.length(), row);
		}
		return builder.toString();
	}

	private String buildRow(int asteriskCount) {
		
		if (asteriskCount == 0) {
			return "";
		}
		
		int whiteSpaceCount = ((ROW_COUNT - asteriskCount) / 2);
		char[] rowChars = new char[whiteSpaceCount + asteriskCount + 1];
		
		Arrays.fill(rowChars, 0, whiteSpaceCount, ' ');		
		Arrays.fill(rowChars, whiteSpaceCount, whiteSpaceCount + asteriskCount, '*');
		rowChars[rowChars.length - 1] = '\n';
		return new String(rowChars);
	}

}

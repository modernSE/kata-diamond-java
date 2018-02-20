package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	
	public String printDiamond(int diamondSize) {
		if (diamondSize <= 0 || diamondSize % 2 == 0) {
			return null;
		}
		StringBuilder diamond = new StringBuilder();
		String maxStarsRow = new String(createDiamondRow(diamondSize, diamondSize));
		diamond.append(maxStarsRow);
		int starNumber = diamondSize - 2;
		while (starNumber > 0){
			char[] diamondRow = createDiamondRow(diamondSize, starNumber);
			diamond.insert(0, diamondRow);
			diamond.append(diamondRow);
			starNumber -= 2;
		}
		return diamond.toString();
	}

	private char[] createDiamondRow(int diamondSize, int starNumber) {
		int spaceNumber = ((diamondSize - starNumber) / 2);
		char[] diamondRow = new char[spaceNumber + starNumber + 1];
		if (spaceNumber > 0) {
			Arrays.fill(diamondRow, 0, spaceNumber, ' ');
		}
		Arrays.fill(diamondRow, spaceNumber, spaceNumber + starNumber, '*');
		diamondRow[diamondRow.length - 1] = '\n';
		return diamondRow;
	}

}

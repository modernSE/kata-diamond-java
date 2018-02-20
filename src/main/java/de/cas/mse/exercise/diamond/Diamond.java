package de.cas.mse.exercise.diamond;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class Diamond {

	
	public String printDiamond(int numberOfLines) {
		assertTrue ("Number of Lines in the Diamond must be positive", numberOfLines <= 0);
		assertFalse("Number of Lines in the Diamond must be odd", numberOfLines % 2 == 0);
		
		StringBuilder diamond = new StringBuilder();
		int middleLineNumber = numberOfLines / 2 + 1;
		int lineLength = 0;
		int numberOfWhitespaces = numberOfLines;
		for (int i=0; i<numberOfLines; i++) {
			if (i <middleLineNumber) {
				numberOfWhitespaces = numberOfLines / 2 - i;
				lineLength = middleLineNumber + i;
				
			} else {
				numberOfWhitespaces = i/2 ;
				lineLength = i;
			}

			diamond.append(printDiamondLine(lineLength, numberOfWhitespaces));
		}
		
		return diamond.toString();
		
	}
	
	private String printDiamondLine(int lineLength, int numberOfWhitespaces) {
		StringBuilder diamondline = new StringBuilder();
		int numberOfStars = lineLength - numberOfWhitespaces ;
		System.out.println("numberOfStars " + numberOfStars);
		for (int i=0; i< numberOfWhitespaces; i++) {
			diamondline.append(' ');
		}
		
		for (int i=0; i< numberOfStars; i++) {
			diamondline.append('*');
		}

		diamondline.append('\n');
		return diamondline.toString();
	}


}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String createDiamond(int diamondSize) {
		if (diamondSize <= 0 || diamondSize % 2 == 0) {
			return null;
        }
        
        StringBuilder diamondBuilder = new StringBuilder(new String(createLine(diamondSize, diamondSize)));
        
		for (int i = diamondSize - 2; i > 0; i -= 2) {
			char[] lineContent = createLine(diamondSize, i);
			diamondBuilder.insert(0, lineContent);
			diamondBuilder.append(lineContent);
        }
        
		return diamondBuilder.toString();
	}

	private char[] createLine(int maxStarCount, int currentStarCount) {

        int indexOfFirstStar = ((maxStarCount - currentStarCount) / 2);
        char[] lineContent = new char[indexOfFirstStar + currentStarCount + 1];
        
		lineContent = fillWhiteSpaceInLine(indexOfFirstStar, lineContent);
        
		return fillStarsInLine(currentStarCount, indexOfFirstStar, lineContent);
	}

    private char[] fillWhiteSpaceInLine(int indexOfFirstStar, char[] lineContent) {
        if (indexOfFirstStar > 0) {
            Arrays.fill(lineContent, 0, indexOfFirstStar, ' ');
        }

        return lineContent;
    }

    private char[] fillStarsInLine(int currentStarCount, int indexOfFirstStar, char[] lineContent) {
        Arrays.fill(lineContent, indexOfFirstStar, indexOfFirstStar + currentStarCount, '*');
		lineContent[lineContent.length - 1] = '\n';
		return lineContent;
    }

}

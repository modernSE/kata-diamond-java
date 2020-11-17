package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String generateDiamond(int height) {
		if (!isValidDiamondShape(height)) {
			return null;
        }
        String middleLine = new String(makeLine(height, height));
        StringBuilder diamond = new StringBuilder(middleLine);
        // iteratively expand diamond towards top and bottom
		for (int asterisks = height - 2; asterisks > 0; asterisks -= 2) {
			char[] line = makeLine(height, asterisks);
            diamond.insert(0, line);
			diamond.append(line);
		}
		return diamond.toString();
    }
    
    private boolean isValidDiamondShape(int height) {
        return height > 0 && height % 2 != 0;
    }

	private char[] makeLine(int diamondWidth, int numberOfAsterisks) {
		int padding = (diamondWidth - numberOfAsterisks) / 2;
		char[] line = new char[padding + numberOfAsterisks + 1 /* newline */];
		if (padding > 0) {
			Arrays.fill(line, 0, padding, ' ');
		}
		Arrays.fill(line, padding, padding + numberOfAsterisks, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int numberOfRows) {
		if (isInvalidDiamond(numberOfRows)) {
			return null;
        }
        String middleLine = new String(createLine(numberOfRows, numberOfRows));
		StringBuilder diamondBuilder = new StringBuilder(middleLine);
		for (int numberOfStars = numberOfRows - 2; numberOfStars > 0; numberOfStars -= 2) {
            char[] line = createLine(numberOfRows, numberOfStars);
            insertLineAbove(diamondBuilder, line); 
            insertLineBelow(diamondBuilder, line);
		}
		return diamondBuilder.toString();
    }
    
    private void insertLineAbove(StringBuilder builder, char[] line) {
        builder.insert(0, line);
    }

    private void insertLineBelow(StringBuilder builder, char[] line) {
        builder.append(line);
    }

	private char[] createLine(int numberOfRows, int numberOfStars) {
		int numberOfSpaces = ((numberOfRows - numberOfStars) / 2);
		char[] line = new char[numberOfSpaces + numberOfStars + 1];
		if (numberOfSpaces > 0) {
			Arrays.fill(line, 0, numberOfSpaces, ' ');
		}
		Arrays.fill(line, numberOfSpaces, numberOfSpaces + numberOfStars, '*');
		line[line.length - 1] = '\n';
		return line;
    }
    
    private boolean isInvalidDiamond(int numberOfRows) {
        return (numberOfRows <= 0 || numberOfRows % 2 == 0);
    }

}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	
	public String print(int diamondWidth) {
		if (isInputValid(diamondWidth)) {
			return null;
		}

		StringBuilder diamondBuilder = new StringBuilder(new String(makeLine(diamondWidth, diamondWidth)));

		for (int i = diamondWidth - 2; i > 0; i -= 2) {
			char[] line = makeLine(diamondWidth, i);
			diamondBuilder.insert(0, line);
			diamondBuilder.append(line);
		}
		
		return diamondBuilder.toString();
	}
	
	private Boolean isInputValid(int diamondWidth) {
		return diamondWidth <= 0 || diamondWidth % 2 == 0;
	}

	private char[] makeLine(int diamondWidth, int widthOfNextLine) {
		int indentation = ((diamondWidth - widthOfNextLine) / 2);
		char[] line = new char[indentation + widthOfNextLine + 1];
		if (indentation > 0) {
			addSpace(line, indentation);
		}
		addStar(line, indentation, widthOfNextLine);
		line[line.length - 1] = '\n';
		return line;
	}
	
	private void addSpace(char[] line,int amount) {
		Arrays.fill(line, 0, amount, ' ');
	}

	private void addStar(char[] line, int amount, int j) {
		Arrays.fill(line, amount, amount + j, '*');
	}

}

package de.cas.mse.exercise.diamond;

import java.util.ArrayList;
import java.util.Arrays;

public class Diamond {

	public String createDiamond(int lineCount) {
		if (lineCount <= 0 || lineCount % 2 == 0) {
			return null;
		}

		var lines = new ArrayList<String>();
		lines.add(buildLine(lineCount, lineCount));
		for (int i = lineCount - 2; i > 0; i -= 2) {
			String line = buildLine(lineCount, i);
			lines.add(0, line);
			lines.add(line);
		}
		return String.join("\n", lines) + "\n";
	}

	private String buildLine(int lineLenght, int stars) {
		int whiteSpaces = ((lineLenght - stars) / 2);
		return createFilledString(whiteSpaces, ' ') + createFilledString(stars, '*');
	}

	private String createFilledString(int lenght, char character) {
		char[] stringContent = new char[lenght];
		Arrays.fill(stringContent, character);
		return new String(stringContent);
	}

}

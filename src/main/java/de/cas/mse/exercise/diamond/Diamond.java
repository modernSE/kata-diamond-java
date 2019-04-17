package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String create(int width) { //maxDiamondWidth?
		
		if (width <= 0 || width % 2 == 0) {
			return null;
		}
		
		StringBuilder result = new StringBuilder(new String(drawLine(width, width)));
		
		for (int currentWidth = width - 2; currentWidth > 0; currentWidth -= 2) {
			char[] line = drawLine(width, currentWidth);
			result.insert(0, line);
			result.append(line); // Umwandeln in Insert
		}
		
		return result.toString(); // Variable mit Name result sollte bereits Returnwert entsprechen
	}

	private char[] drawLine(int maxWidth, int currentWidth) {
		
		int offset = ((maxWidth - currentWidth) / 2); // Offset von was?
		char[] line = new char[offset + currentWidth + 1];
		
		if (offset > 0) {
			Arrays.fill(line, 0, offset, ' ');
		}
		
		Arrays.fill(line, offset, offset + currentWidth, '*');
		line[line.length - 1] = '\n';
		
		return line;
	}

}

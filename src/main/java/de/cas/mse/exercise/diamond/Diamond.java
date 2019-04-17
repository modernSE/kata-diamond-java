package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public static void main(String[] args) {
		Diamond test = new Diamond();
		System.out.println(test.getDiamond(555));
	}
	
	// Review: Diamand im Methodennamen überflüssig
	// builder -> result z.B.
	// chars -> line oder currentLine
	
	public String getDiamond(int maxWidth) {
		if (maxWidth <= 0 || maxWidth % 2 == 0) {
			return "Wrong Number"; 
		}
		StringBuilder builder = new StringBuilder(new String(makeLine(maxWidth, maxWidth)));
		for (int currentWidth = maxWidth - 2; currentWidth > 0; currentWidth -= 2) {
			char[] chars = makeLine(maxWidth, currentWidth);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	// maxWidth -> width oder lineWidth 	currentWidth -> currentDiamondWidth oder amountStars
	// offsetFromMiddleLine -> offsetFromLeft oder einfach offset
	private char[] makeLine(int maxWidth, int currentWidth) {
		int offsetFromMiddleLine = ((maxWidth - currentWidth) / 2);
		char[] line = new char[offsetFromMiddleLine + currentWidth + 1];
		if (offsetFromMiddleLine > 0) {
			Arrays.fill(line, 0, offsetFromMiddleLine, ' ');
		}
		Arrays.fill(line, offsetFromMiddleLine, offsetFromMiddleLine + currentWidth, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}

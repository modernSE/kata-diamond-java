package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int maxWidth) {	//diamondSize would be more pregnant, since width and height are the same for diamonds
		if (maxWidth <= 0 || maxWidth % 2 == 0) { //extract method for validation check
			return null;
		}
		StringBuilder star = createStar(maxWidth);//is this a single * ? We print a diamond!
		return star.toString();
	}

	private StringBuilder createStar(int maxWidth) {
		StringBuilder star = new StringBuilder();
		addCenterLine(star, maxWidth); //sideeffect changes star
		addSurroundingLines(star, maxWidth);
		return star;
	}

	private void addSurroundingLines(StringBuilder star, int maxWidth) {
		int currentNumberOfStars = maxWidth - 2; 
		while (currentNumberOfStars > 0) { //nice change <3
			addLine(star, maxWidth, currentNumberOfStars);
			currentNumberOfStars -= 2;
		}
	}
	
	private void addCenterLine(StringBuilder star, int maxWidth) {
		star.append(createLine(maxWidth, maxWidth));
	}

	private void addLine(StringBuilder star, int maxWidth, int numberOfStars) {
		String line = createLine(maxWidth, numberOfStars);
		star.insert(0, line);
		star.append(line);
	}

	private String createLine(int totalWidth, int numberOfStars) { //this is the same as maxWidth
		int numberOfSpaces = ((totalWidth - numberOfStars) / 2);
		char[] chars = new char[numberOfSpaces + numberOfStars + 1]; //chars is a row
		if (numberOfSpaces > 0) { //own method to add whitespaces
			Arrays.fill(chars, 0, numberOfSpaces, ' ');
		}
		Arrays.fill(chars, numberOfSpaces, numberOfSpaces + numberOfStars, '*'); //own method to add stars
		chars[chars.length - 1] = '\n';
		return new String(chars);
	}

}

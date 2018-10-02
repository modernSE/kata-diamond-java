package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	private int maxStars; // passt gut zum Klassenname

	public Diamond(int maxStars) {
		// nicht so klar dass maxStars hat mit der Grösser vom Diamond zu tun
		this.maxStars = maxStars;
	}

	// NOT a printing method
	public String print() {
		// TODO Move to constructor ;)
		if (!isPrintable()) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(createLine(maxStars)));
		// either starCount or leave as i
		for (int stars = maxStars - 2; stars > 0; stars -= 2) {
			char[] line = createLine(stars);
			builder.insert(0, line);
			builder.append(line);
		}
		return builder.toString();
	}

	private boolean isPrintable() {
		return maxStars > 0 && maxStars % 2 != 0;
	}

	private char[] createLine(int stars) {
		// no spaces, but COUNT oder countWhitespaces
		int spaces = ((maxStars - stars) / 2); // lineStartPadding instead of spaces?
		char[] line = new char[spaces + stars + 1];
		if (spaces > 0) {
			Arrays.fill(line, 0, spaces, ' ');
		}
		Arrays.fill(line, spaces, spaces + stars, '*');
		line[line.length - 1] = '\n';
		return line;
	}

}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String createDiamond(int n) {
		if (n <= 0 || n % 2 == 0) {
			return null;
		}
		return createLines(n);
	}

	private String createLines(int diamondDiameter) {
		StringBuilder builder = new StringBuilder(new String(createLine(diamondDiameter, diamondDiameter)));
		for (int i = diamondDiameter - 2; i > 0; i -= 2) {
			char[] chars = createLine(diamondDiameter, i);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] createLine(int diamondDiameter, int j) {
		int amount = ((diamondDiameter - j) / 2);
		char[] chars = new char[amount + j + 1];
		if (amount > 0) {
			Arrays.fill(chars, 0, amount, ' ');
		}
		Arrays.fill(chars, amount, amount + j, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

}

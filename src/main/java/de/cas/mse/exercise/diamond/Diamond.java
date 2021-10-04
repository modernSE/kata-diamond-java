package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String printDiamond(int diamondHeight) {
		if (isInvalidDiamondHeight(diamondHeight)) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(make(diamondHeight, diamondHeight)));
		for (int i = diamondHeight - 2; i > 0; i -= 2) {
			char[] chars = make(diamondHeight, i);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] make(int i, int starCount) {
		int amount = ((i - j) / 2);
		char[] chars = new char[amount + j + 1];
		if (amount > 0) {
			Arrays.fill(chars, 0, amount, ' ');
		}
		Arrays.fill(chars, amount, amount + j, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

	private boolean isInvalidDiamondHeight(int diamondHeight) {
		return diamondHeight <= 0 || diamondHeight % 2 == 0;
	}

}

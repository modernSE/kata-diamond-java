package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int size) {
		if (size <= 0 || size % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(createLayer(size, size)));
		for (int i = size - 2; i > 0; i -= 2) {
			char[] chars = createLayer(size, i);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] createLayer(int height, int width) {
		int amount = ((height - width) / 2);
		char[] chars = new char[amount + width + 1];
		if (amount > 0) {
			Arrays.fill(chars, 0, amount, ' ');
		}
		Arrays.fill(chars, amount, amount + width, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

}

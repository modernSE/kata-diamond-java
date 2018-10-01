package de.cas.mse.exercise.diamond;

import java.util.Arrays;
//c
public class Diamond {

	public String print(int n) {
		if (n <= 0 || n % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(make(n, n)));
		for (int i = n - 2; i > 0; i -= 2) {
			char[] chars = make(n, i);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] make(int i, int j) {
		int amount = ((i - j) / 2);
		char[] chars = new char[amount + j + 1];
		if (amount > 0) {
			Arrays.fill(chars, 0, amount, ' ');
		}
		Arrays.fill(chars, amount, amount + j, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

}

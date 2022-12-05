package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int size) {
		if (size <= 0 || size % 2 == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(make(size, size)));
		for (int i = size - 2; i > 0; i -= 2) {
			char[] chars = make(size, i);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private char[] make(int zeilen_größe, int anzahl_sterne) {
		int stern_offset = ((zeilen_größe - anzahl_sterne) / 2);
		char[] chars = new char[stern_offset + anzahl_sterne + 1];
		if (stern_offset > 0) {
			Arrays.fill(chars, 0, stern_offset, ' ');
		}
		Arrays.fill(chars, stern_offset, stern_offset + anzahl_sterne, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}

}

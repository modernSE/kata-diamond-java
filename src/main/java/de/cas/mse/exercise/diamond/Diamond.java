package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String print(int diameter) {
		boolean isOddPositive = diameter <= 0 || diameter % 2 == 0;
		if (isOddPositive) {
			return null;
		}
		StringBuilder builder = new StringBuilder(new String(createRowWithCenteredStars(diameter, diameter)));
		for (int stars = diameter - 2; stars > 0; stars -= 2) {
			char[] rows = createRowWithCenteredStars(diameter, stars);
			builder.insert(0, rows);
			builder.append(rows);
		}
		return builder.toString();
	}

	private char[] createRowWithCenteredStars(int virtualRowLength, int starAmount) {
		int indent = ((virtualRowLength - starAmount) / 2);
		char[] row = new char[indent + starAmount + 1];
		if (indent > 0) {
			Arrays.fill(row, 0, indent, ' ');
		}
		Arrays.fill(row, indent, indent + starAmount, '*');
		row[row.length - 1] = '\n';
		return row;
	}

}

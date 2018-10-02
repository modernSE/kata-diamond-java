package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	// V+M: diamond prefix is unnecessary +1
	// V+M: can also be size or dimension
	// V+M: is not a print method. Can be called createDiamond or buildDiamond +1
	public String print(int diamonWidth) {
		// extract method: isPrintable?
		if (diamonWidth <= 0 || diamonWidth % 2 == 0) {
			return null;
		}
		StringBuilder diamondBuilder = new StringBuilder(new String(createDiamondLayer(diamonWidth, diamonWidth)));
		for (int i = diamonWidth - 2; i > 0; i -= 2) {
			char[] diamondLayer = createDiamondLayer(diamonWidth, i);
			diamondBuilder.insert(0, diamondLayer);
			diamondBuilder.append(diamondLayer);
		}
		
		// V+M: Remove test code +1
		System.out.println(diamondBuilder.toString());
		
		return diamondBuilder.toString();
	}

	private char[] createDiamondLayer(int diamondWidth, int amountOfStars) {
		// V+M: maybe numberOfSpaces
		// amountOfSpaces as amount was used in parameter as well
		int startIndex = ((diamondWidth - amountOfStars) / 2);
		
		// V+M: for consistency layer would be a better name
		char[] chars = new char[startIndex + amountOfStars + 1];
		if (startIndex > 0) {
			Arrays.fill(chars, 0, startIndex, ' ');
		}
		Arrays.fill(chars, startIndex, startIndex + amountOfStars, '*');
		chars[chars.length - 1] = '\n';
		return chars;
	}
	
	// Remove test code 
	public static void main(String[] args) {
		Diamond diamond = new Diamond();
		diamond.print(5);
	}

}

package de.cas.mse.exercise.diamond;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Applied object calisthenics:
 * 1 OK
 * 2 OK
 * 3 
 * 4 OK
 * 5 OK
 * 6 OK
 * 7 OK
 * 8 OK :)
 * 9
 * 
 * @author modernSE
 *
 */

public class Diamond {

	public String print(int size) {
		Map<String, Integer> isPrintableParanmeters = new HashMap<>();
		isPrintableParanmeters.put("size", size);
		if (isPrintable(isPrintableParanmeters)) {
			return null;
		}
		Map<String, Integer> makeLineParameters = new HashMap<>();
		makeLineParameters.put("maximumAmountOfAsterisks", size);
		makeLineParameters.put("amountOfAsterisks", size);
		String middleLine = new String(makeLine(makeLineParameters));
		StringBuilder builder = new StringBuilder(middleLine);
		for (int amountOfAsterisks = size - 2; amountOfAsterisks > 0; amountOfAsterisks -= 2) {
			makeLineParameters.put("amountOfAsterisks", amountOfAsterisks);
			char[] chars = makeLine(makeLineParameters);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private boolean isPrintable(Map<String, Integer> parameters) {
		int size = parameters.get("size");
		return size <= 0 || size % 2 == 0;
	}

	private char[] makeLine(Map<String, Integer> parameters) {
		int maximumAmountOfAsterisks = parameters.get("maximumAmountOfAsterisks");
		int amountOfAsterisks = parameters.get("amountOfAsterisks");
		int amount = ((maximumAmountOfAsterisks - amountOfAsterisks) / 2);
		char[] characters = new char[amount + amountOfAsterisks + 1];
		if (amount > 0) {
			
			Arrays.fill(characters, 0, amount, ' ');
		}
		Arrays.fill(characters, amount, amount + amountOfAsterisks, '*');
		characters[characters.length - 1] = '\n';
		return characters;
	}

}

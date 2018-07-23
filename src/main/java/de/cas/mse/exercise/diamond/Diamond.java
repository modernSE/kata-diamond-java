// We used object calisthenics 3. Wrapping primitive types and 8. Collections

package de.cas.mse.exercise.diamond;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Diamond {

		
	public String print(Integer n) {
		if (n <= 0 || n % 2 == 0) {
			return null;
		}
		StringWrapper stringwrapper = getStringRepresentation(make(n, n));
		StringBuilder builder = new StringBuilder(stringwrapper.getString());
		for (Integer i = n - 2; i > 0; i -= 2) {
			List <Character> chars = make(n, i);
			builder.insert(0, chars);
			builder.append(chars);
		}
		return builder.toString();
	}

	private List <Character> make(Integer i, Integer j) {
		int amount = ((i - j) / 2);
		List <Character> chars = new ArrayList<>();
		for (Integer k = 0; k < amount; k++) {
			chars.add(new Character (' '));
		}
		for (Integer l = amount; l < amount + j; l++) {
			chars.add(new Character ('*'));
		}
		chars.add(new Character('\n'));
		return chars;
	}
	
	private StringWrapper getStringRepresentation(List<Character> list)
	{    
	    StringBuilder builder = new StringBuilder(list.size());
	    for(Character ch: list)
	    {
	        builder.append(ch);
	    }
	    StringWrapper sw = new StringWrapper(builder.toString());
	    return sw;
	}

}

package de.cas.mse.exercise.diamond;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Diamond {

	
	// - Keine Abkürzungen
	// - Alle primitiven Datentypen und Strings wrappen
	// - Collections als ertklassiges Konzept
	public String print(Integer size) {
		if (size <= 0 || size % 2 == 0) {
			return null;
		}
		List<Character> middleLine = make(size, size);
		Deque<List<Character>> lines = new ArrayDeque<>();
		lines.add(middleLine);
		for (Integer index = size - 2; index > 0; index -= 2) {
			List<Character> line = make(size, index);
			lines.addFirst(line);
			lines.addLast(line);
		}

		StringBuilder sb = new StringBuilder();
		lines.stream().flatMap(line -> line.stream()).forEach(sb::append);
		return sb.toString();
	}

	private List<Character> make(int size, int numberOfStars) {
		int amount = ((size - numberOfStars) / 2);
		List<Character> characters = new ArrayList<>(amount + numberOfStars + 1);
		if (amount > 0) {
			for (int i = 0; i < amount; i++) {
				characters.add(' ');
			}
		}
		for(int i = 0; i < numberOfStars; i++) {
			characters.add('*');
		}
		characters.add('\n');
		return characters;
	}
}

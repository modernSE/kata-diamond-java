package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class DiamondLine {
	private final int numberEmptySymbols;
	private final int numberInsideSymbols;
	
	public DiamondLine(Integer numberEmptySymbols, Integer numberInsideSymbols) {
		this.numberEmptySymbols = numberEmptySymbols;
		this.numberInsideSymbols = numberInsideSymbols;
	}

	@Override
	public String toString() {
		char[] line = new char[numberEmptySymbols + numberInsideSymbols + 1];
		Arrays.fill(line, 0, numberEmptySymbols, ' ');
		Arrays.fill(line, numberEmptySymbols, numberEmptySymbols + numberInsideSymbols, '*');
		line[line.length - 1] = '\n';
		return new String(line);
	}
	
	public int getNumberEmptySymbols() {
		return numberEmptySymbols;
	}

	public int getNumberInsideSymbols() {
		return numberInsideSymbols;
	}
}

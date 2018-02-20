package de.cas.mse.exercise.diamond;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import static java.util.stream.Collectors.joining;

public class Diamond {

	
	public String printDiamond(Integer diamondSize) {
		if (lowerEqualZero(diamondSize) || isEven(diamondSize)) {
			return null;
		}
		List<DiamondLine> diamond = new LinkedList<>();
		DiamondLine maxStarsRow = createDiamondRow(diamondSize, diamondSize);
		diamond.add(maxStarsRow);
		Integer starNumber = diamondSize - new Integer(2);
		while (starNumber > 0){
			DiamondLine diamondRow = createDiamondRow(diamondSize, starNumber);
			diamond.add(0, diamondRow);
			diamond.add(diamondRow);
			starNumber -= 2;
		}
		return diamond.stream()//
				.map(DiamondLine::toString)//
				.collect(joining());
	}


	private DiamondLine createDiamondRow(Integer diamondSize, Integer starNumber) {
		Integer spaceNumber = ((diamondSize - starNumber) / 2);
		return new DiamondLine(spaceNumber, starNumber);
	}

	private Boolean isEven(Integer value) {
		return value % 2 == 0;
	}
	
	private Boolean lowerEqualZero(Integer value) {
		return value <= 0;
	}
}

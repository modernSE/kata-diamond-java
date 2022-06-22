package de.cas.mse.exercise.diamond;

import java.util.Arrays;

public class Diamond {

	public String renderDiamond(int maximumDiamondWidth) {
		if (maximumDiamondWidth <= 0 || maximumDiamondWidth % 2 == 0) {
			return null;
		}
		StringBuilder drawingCanvas = new StringBuilder(new String(renderDiamondLine(maximumDiamondWidth, maximumDiamondWidth)));
		for (int charsPerLine = maximumDiamondWidth - 2; charsPerLine > 0; charsPerLine -= 2) {
			char[] singleDiamondLine = renderDiamondLine(maximumDiamondWidth, charsPerLine);
			drawingCanvas.insert(0, singleDiamondLine);
			drawingCanvas.append(singleDiamondLine);
		}
		return drawingCanvas.toString();
	}

	private char[] renderDiamondLine(int maxiumLineWidth, int numberOfCharsPerLine) {
		int offset = ((maxiumLineWidth - numberOfCharsPerLine) / 2);
		char[] result = new char[offset + numberOfCharsPerLine + 1];
		if (offset > 0) {
			Arrays.fill(result, 0, offset, ' ');
		}
		Arrays.fill(result, offset, offset + numberOfCharsPerLine, '*');
		result[result.length - 1] = '\n';
		return result;
	}

}

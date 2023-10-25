package baseball.model;

import baseball.util.Constant;

public class Calculator {
	public static Score calculateScore(ListNumber userNumber, ListNumber computerNumber) {
		return new Score(strikeCount(userNumber, computerNumber), ballCount(userNumber, computerNumber));
	}

	private static int strikeCount(ListNumber userNumber, ListNumber computerNumber) {
		int strikeCount = 0;
		for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
			if (userNumber.getIndex(i) == computerNumber.getIndex(i)) {
				strikeCount++;
			}
		}
		return strikeCount;
	}

	private static int ballCount(ListNumber userNumber, ListNumber computerNumber) {
		int ballCount = 0;
		for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
			if (userNumber.getIndex(i) != computerNumber.getIndex(i) && userNumber.contains(computerNumber.getIndex(i))) {
				ballCount++;
			}
		}
		return ballCount;
	}
}

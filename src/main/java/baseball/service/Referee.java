package baseball.service;

import baseball.view.InputView;

public class Referee {
	public static final int SUCCESS_STRIKE = 3;

	public static TurnResult getTurnResult(String userNumber, String targetNumber) {
		return new TurnResult(calculateBall(userNumber, targetNumber), calculateStrike(userNumber, targetNumber));
	}

	public static boolean getGameResult(TurnResult turnResult) {
		if (turnResult.getStrike() == SUCCESS_STRIKE) {
			return true;
		}
		return false;
	}

	private static int calculateBall(String userNumber, String targetNumber) {
		int ballCount = 0;
		for (int i = 0; i < InputView.CORRECT_LENGTH; i++) {
			for (int j = 0; j < InputView.CORRECT_LENGTH; j++) {
				if (i == j) {
					continue;
				}
				if (userNumber.charAt(i) == targetNumber.charAt(j)) {
					ballCount += 1;
				}
			}
		}
		return ballCount;
	}

	private static int calculateStrike(String userNumber, String targetNumber) {
		int strikeCount = 0;
		for (int i = 0; i < InputView.CORRECT_LENGTH; i++) {
			if (userNumber.charAt(i) == targetNumber.charAt(i)) {
				strikeCount += 1;
			}
		}
		return strikeCount;
	}
}

package baseball.domain.rule;

import baseball.controller.ConsoleController;

public class Rule {
	private static int OFFSET = 3;

	private final ConsoleController consoleController;

	public Rule(ConsoleController consoleController) {
		this.consoleController = consoleController;
	}

	public boolean judgeGameOver(int[] userNumberArray, int[] computerNumberArray) {
		int ball = countBall(userNumberArray, computerNumberArray);
		int strike = countStrike(userNumberArray, computerNumberArray);
		consoleController.printResultMessage(ball, strike);
		if (strike == OFFSET) {
			consoleController.printFinishMessage();
			return true;
		}
		return false;
	}

	private int countStrike(int[] userNumberArray, int[] computerNumberArray) {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (userNumberArray[i]==computerNumberArray[j] && i == j) {
					cnt++;

				}
			}
		}
		return cnt;
	}

	private int countBall(int[] userNumberArray, int[] computerNumberArray) {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (userNumberArray[i] == computerNumberArray[j] && i != j) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}

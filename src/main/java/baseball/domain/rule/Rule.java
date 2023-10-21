package baseball.domain.rule;

import baseball.console.Console;

public class Rule {

	private static int ball;
	private static int strike;
	private static int OFFSET = 3;

	private static Console console;

	private Rule() {
	}


	public static boolean judgeGameOver(int[] userNumberArray, int[] computerNumberArray) {
		int ball = countBall(userNumberArray, computerNumberArray);
		int strike = countStrike(userNumberArray, computerNumberArray);
		Console.printResultMessage(ball, strike);
		if (strike == OFFSET) {
			Console.printFinishMessage();
			return true;
		}
		return false;
	}

	private static int countStrike(int[] userNumberArray, int[] computerNumberArray) {
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

	public static int countBall(int[] userNumberArray, int[] computerNumberArray) {
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

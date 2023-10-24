package baseball.model;

public class MakeHint {

	private final static int MAX_NUMBER_SIZE = 3;

	public static int getBall(String playerNumbers, String AnswerNumbers) {
		int countBall = 0;
		for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
			int playerNumberGet = playerNumbers.charAt(i);
			int answerNumberGet = AnswerNumbers.indexOf(playerNumberGet);
			if (answerNumberGet != -1 && answerNumberGet != i) {
				countBall += 1;
			}
		}
		return countBall;
	}

	public static int getStrike(String playerNumbers, String AnswerNumbers) {
		int countStrike = 0;
		for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
			if (playerNumbers.charAt(i) == AnswerNumbers.charAt(i)) {
				countStrike += 1;
			}
		}
		return countStrike;
	}
}

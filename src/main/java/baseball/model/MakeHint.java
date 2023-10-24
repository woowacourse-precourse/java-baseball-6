package baseball.model;

public class MakeHint {
	public static int getBall(String playerNumbers, String AnswerNumbers) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			int playerNumberGet = playerNumbers.charAt(i);
			int answerNumberGet = AnswerNumbers.indexOf(playerNumberGet);
			if (answerNumberGet != -1 && answerNumberGet != i) {
				count += 1;
			}
		}
		return count;
	}

	public static int getStrike(String playerNumbers, String AnswerNumbers) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (playerNumbers.charAt(i) == AnswerNumbers.charAt(i)) {
				count += 1;
			}
		}
		return count;
	}
}

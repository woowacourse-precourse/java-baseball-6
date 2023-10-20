package service;

public class Game {
	public Game() {

	}

	public boolean getGameResult(int inputNumber, int answerNumber) {
		boolean isAnswer = false;
		String input = Integer.toString(inputNumber);
		String answer = Integer.toString(answerNumber);

		int strikeCount = checkStrike(input, answer);
		int ballCount = checkBall(input, answer) - strikeCount;
		//결과 출력 부분
		if (strikeCount == 3) {
			isAnswer = true;W
		}
		return isAnswer;
	}

	private int checkStrike(String input, String answer) {
		int strikeCount = 0;
		for (int i = 0; i < 3; i++) {
			char inputDigit = input.charAt(i);
			char answerDigit = answer.charAt(i);
			if (inputDigit == answerDigit) {
				strikeCount++;
			}
		}
		return strikeCount;
	}

	private int checkBall(String input, String answer) {
		int ballCount = 0;
		for (int i = 0; i < 3; i++) {
			String inputDigit = Character.toString(input.charAt(i));
			if (answer.contains(inputDigit)) {
				ballCount++;
			}
		}
		return ballCount;
	}
}

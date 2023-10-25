package service;

import views.OutputView;

public class Game {
	private final OutputView outputView;
	public Game(OutputView outputView) {
		this.outputView = outputView;
	}
	public void printIntro() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}
	public boolean getGameResult(int inputNumber, int answerNumber) {
		boolean isAnswer = false;
		String input = Integer.toString(inputNumber);
		String answer = Integer.toString(answerNumber);

		int strikeCount = checkStrike(input, answer);
		int ballCount = checkBall(input, answer) - strikeCount;
		outputView.printCheckResult(strikeCount, ballCount);
		if (strikeCount == 3) {
			outputView.printEnd();
			isAnswer = true;
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

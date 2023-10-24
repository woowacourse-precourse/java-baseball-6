package baseball.controller;

import baseball.model.AnswerGenerator;
import baseball.model.MakeHint;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseball {

	String AnswerNumbers;

	public void getAnswerNumbers() {
		AnswerNumbers = AnswerGenerator.getRandomNumber();
	}

	public void printStart() {
		OutputView.printStartGame();
	}

	public void startGame() {
		boolean again = true;
		printStart();
		while (again) {
			getAnswerNumbers();
			again = playGame();
		}
	}

	private boolean playGame() {
		while (true) {
			String playerNumbers = InputView.insertNumber();
			int ballCount = MakeHint.getBall(playerNumbers, AnswerNumbers);
			int strikeCount = MakeHint.getStrike(playerNumbers, AnswerNumbers);
			OutputView.printHint(ballCount, strikeCount);
			if (strikeCount == 3) {
				OutputView.printEndGame();
				return InputView.restartGame();
			}
		}
	}
}

package baseball.controller;

import static baseball.model.MakeHint.getBall;
import static baseball.model.MakeHint.getStrike;
import static baseball.view.InputView.insertNumber;
import static baseball.view.InputView.restartGame;
import static baseball.view.OutputView.printEndGame;
import static baseball.view.OutputView.printHint;

import baseball.model.AnswerGenerator;
import baseball.view.OutputView;

public class NumberBaseball {
	String AnswerNumbers;

	public void printStart() {
		OutputView.printStartGame();
	}


	public void getAnswerNumbers() {
		AnswerNumbers = AnswerGenerator.getRandomNumber();
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
			String playerNumbers = insertNumber();
			int ballCount = getBall(playerNumbers, AnswerNumbers);
			int strikeCount = getStrike(playerNumbers, AnswerNumbers);
			printHint(ballCount, strikeCount);
			if (strikeCount == 3) {
				printEndGame();
				return restartGame();
			}
		}
	}
}

package baseball.controller;

import baseball.model.Calculator;
import baseball.model.NumberGenerator;
import baseball.model.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameManager {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final NumberGenerator numberGenerator = new NumberGenerator();

	public void initGame() {
		try {
			playGameUntilEnd();
		} catch (IllegalArgumentException e) {
			outputView.printInputErrorMessage();
			throw e;
		}
	}

	private void playGameUntilEnd() {
		int gameRestartFlag;
		do {
			outputView.printGameStartMessage();
			playGameUntilOver();
			gameRestartFlag = inputView.gameRestartFlag();
		} while (gameRestartFlag == 1);
	}

	private void playGameUntilOver() {
		Score userScore;
		do {
			String userInput = inputView.userInputNumber();
			userScore = Calculator.calculateScore(userInput, numberGenerator.generateNumber());
		} while (!userScore.isGameOver());
	}
}

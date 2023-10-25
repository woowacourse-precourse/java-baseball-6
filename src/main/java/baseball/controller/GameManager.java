package baseball.controller;

import baseball.model.Score;
import baseball.util.Constant;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameManager {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BaseballManager baseballManager = new BaseballManager();

	public void initGame() {
		playGameUntilExit();
	}

	private void playGameUntilExit() {
		int gameRestartFlag;
		do {
			outputView.printGameStartMessage();
			baseballManager.initComputerNumber();
			playGameUntilOver();
			outputView.printGameEndMessage();
			gameRestartFlag = inputView.gameRestartFlag();
		} while (gameRestartFlag == Constant.GAME_RESTART_FLAG);
	}

	private void playGameUntilOver() {
		Score userScore;
		do {
			int userInput = inputView.userInputNumber();
			userScore = baseballManager.userScore(userInput);
			outputView.printScore(userScore);
		} while (!userScore.isGameOver());
	}
}

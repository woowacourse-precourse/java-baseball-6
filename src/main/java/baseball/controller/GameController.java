package baseball.controller;

import baseball.service.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	public void start() {
		OutputView.printGameStart();
		BaseballGame baseballGame = new BaseballGame();
		do {
			baseballGame.start();
		} while (InputView.getProcessUserInput());
	}
}

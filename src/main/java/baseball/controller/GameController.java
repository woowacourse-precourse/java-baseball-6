package baseball.controller;

import baseball.model.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private static boolean isEndGame;
	private static final String BASEBALL_GAME_END_NUMBER_STRING = "2";
	ComputerController computerController = new ComputerController();
	OutputView outputView = new OutputView();
	InputView inputView = new InputView();

	public void initGame() {
		isEndGame = true;
	}

	public boolean isWantRestartGame(Game playerData) {
		if (computerController.isThreeStrike(playerData)) {
			outputView.printEndGame();
			String answer = inputView.enterAnswerReGame();

			if (answer.equals(BASEBALL_GAME_END_NUMBER_STRING)) {
				isEndGame = false;
			}
			return false;
		}
		return true;
	}

}

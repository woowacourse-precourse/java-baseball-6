package baseball.controller;

import baseball.model.Game;
import baseball.validation.GameRestartNumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private static boolean isEndGame;
	private static final String BASEBALL_GAME_END_NUMBER_STRING = "2";
	ComputerController computerController = new ComputerController();
	OutputView outputView = new OutputView();
	InputView inputView = new InputView();
	GameRestartNumberValidator gameRestartNumberValidator = new GameRestartNumberValidator();

	public void startGame() {
		outputView.printStartGame();
		initGame();
		proceedGame();
	}

	public void proceedGame() {
		while (isEndGame) {
			Game computerData = new Game();
			computerData.setGameNumbers(computerController.getComputerNumber());
			repeatGame(computerData);
		}
	}

	public void initGame() {
		isEndGame = true;
	}

	public boolean isWantRestartGame(Game playerData) {
		if (computerController.isThreeStrike(playerData)) {
			outputView.printEndGame();

			String answer = inputView.enterAnswerReGame();
			gameRestartNumberValidator.checkRestartNumberValidity(answer);

			updateEndGameStatus(answer);
			return false;
		}
		return true;
	}

	public void updateEndGameStatus(String answer) {
		if (answer.equals(BASEBALL_GAME_END_NUMBER_STRING)) {
			isEndGame = false;
		}
	}

	public void repeatGame(Game computerData) {
		Game playerData;

		do {
			playerData = computerController.getPlayerNumbers();

			playerData = computerController.compareNumber(computerData, playerData);

			String outputMessage = computerController.strikeAndBallMessage(playerData);
			outputView.printStrikeAndBallMessage(outputMessage);
		} while (isWantRestartGame(playerData));
	}

}

package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.GameResultMessage;
import baseball.domain.Player;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

	private final GameService gameService;

	public GameController() {
		this.gameService = new GameService();
	}

	public void run() {
		OutputView.printStartGuide();
		playBaseballGame();
	}

	private void playBaseballGame() {
		playBaseballGameOnce();
		replayOrExitGame();
	}

	private void playBaseballGameOnce() {
		final Computer computer = gameService.createComputer();
		repeatBaseballGamePlayingUntilEnding(computer);
	}

	private void repeatBaseballGamePlayingUntilEnding(final Computer computer) {
		GameResult gameResult = new GameResult();
		while (!gameService.isEnded(gameResult)) {
			final Player player = new Player(getNumbersInput());
			gameResult = gameService.requestJudgment(computer, player);
			OutputView.printGameResultMessage(GameResultMessage.createMessage(gameResult));
		}
	}

	private String getNumbersInput() {
		OutputView.printNumbersInputGuide();
		return InputView.getInput();
	}

	private void replayOrExitGame() {
		String replayCommandInput = getReplayCommandInput();
		if (gameService.isReplay(replayCommandInput)) {
			playBaseballGame();
		}
	}

	private String getReplayCommandInput() {
		OutputView.printGameEndGuide();
		return InputView.getInput();
	}

}

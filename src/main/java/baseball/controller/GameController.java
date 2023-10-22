package baseball.controller;

import baseball.domain.Computer;
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
		playBaseBallGame();
		replayOrExitGame();
	}

	private void playBaseBallGame() {
		final Computer computer = gameService.createComputer();
		repeatBaseBallGamePlaying(computer);
	}

	private void repeatBaseBallGamePlaying(final Computer computer) {
		String gameResultMessage = "";
		while (!gameService.isEnded(gameResultMessage)) {
			final Player player = new Player(getNumbersInput());
			gameResultMessage = gameService.requestJudgment(computer, player);
			OutputView.printGameResultMessage(gameResultMessage);
		}
	}

	private String getNumbersInput() {
		OutputView.printNumbersInputGuide();
		return InputView.getInput();
	}

	private void replayOrExitGame() {
		String replayCommandInput = getReplayCommandInput();
		if (gameService.isReplay(replayCommandInput)) {
			playBaseBallGame();
			replayOrExitGame();
		}
	}

	private String getReplayCommandInput() {
		OutputView.printGameEndGuide();
		return InputView.getInput();
	}

}

package baseball.controller;

import baseball.domain.player.ComputerPlayer;
import baseball.domain.player.UserPlayer;
import baseball.referee.Referee;


public class GameController {
	private UserPlayer userPlayer;
	private ComputerPlayer computerPlayer;
	private final ConsoleController consoleController;
	private final Referee referee;

	public GameController(ConsoleController consoleController) {
		this.consoleController = consoleController;
		referee = new Referee(consoleController);
	}

	public void start() {
		boolean resume = true;
		while (resume) {
			this.userPlayer = new UserPlayer();
			this.computerPlayer = new ComputerPlayer();
			play();
			resume = consoleController.getResumeOption();
		}
	}

	public void play() {
		boolean gameOver = false;
		consoleController.printGameStart();
		computerPlayer.setNumberArray(consoleController.getComputerNumberArray());
		while (!gameOver) {
			userPlayer.setNumberArray(consoleController.getUserNumberArray());
			gameOver = referee.judgeGameOver(userPlayer.getNumberArray(), computerPlayer.getNumberArray());
		}
	}
}

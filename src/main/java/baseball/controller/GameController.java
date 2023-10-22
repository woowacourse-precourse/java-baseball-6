package baseball.controller;

import baseball.console.ConsoleInput;
import baseball.console.ConsoleOutput;
import baseball.domain.player.ComputerPlayer;
import baseball.domain.player.UserPlayer;
import baseball.domain.rule.Rule;


public class GameController {
	private UserPlayer userPlayer;
	private ComputerPlayer computerPlayer;
	private final ConsoleController consoleController;
	private final Rule rule;

	public GameController(ConsoleController consoleController) {
		this.consoleController = consoleController;
		rule = new Rule(consoleController);
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
			gameOver = rule.judgeGameOver(userPlayer.getNumberArray(), computerPlayer.getNumberArray());
		}
	}
}

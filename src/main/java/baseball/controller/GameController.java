package baseball.controller;

import baseball.console.Console;
import baseball.domain.player.ComputerPlayer;
import baseball.domain.player.UserPlayer;
import baseball.domain.rule.Rule;

public class GameController {
	private UserPlayer userPlayer;
	private ComputerPlayer computerPlayer;

	public void start() {
		boolean resume = true;
		while (resume) {
			this.userPlayer = new UserPlayer();
			this.computerPlayer = new ComputerPlayer();
			play();
			resume = Console.getResumeOption();
		}
	}

	public void play() {
		boolean gameOver = false;
		Console.printGameStart();
		while (!gameOver) {
			Console.printInputMessage();
			userPlayer.setNumberArray(Console.getUserNumberArray());
			gameOver = Rule.judgeGameOver(userPlayer.getNumberArray(), computerPlayer.getNumberArray());
		}
	}
}

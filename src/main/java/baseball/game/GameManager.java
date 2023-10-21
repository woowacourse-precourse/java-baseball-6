package baseball.game;

import static baseball.game.GameMessages.GAME_OVER;
import static baseball.game.GameMessages.GAME_START;
import static baseball.game.GameMessages.INPUT_NUMBER;
import static baseball.util.ConsoleUtil.printMsg;
import static baseball.util.ConsoleUtil.printMsg_newLine;

import baseball.game.balls.Balls;
import baseball.input.UserInput;
import java.util.ArrayList;

public class GameManager {

	private final Balls answer = new Balls(new ArrayList<>());
	private final Balls user = new Balls(new ArrayList<>());
	private final UserInput userInput = new UserInput();
	private final GameService gameService = new GameService();

	public void start() {
		printMsg_newLine(GAME_START.getMessage());

		boolean gameEnd = true;
		while (gameEnd) {
			setAnswerNumbers();

			playGameRound();

			gameEnd = userInput.askToPlayAgain();
		}
	}

	private void playGameRound() {
		boolean isAnswer = false;

		while (!isAnswer) {
			printMsg(INPUT_NUMBER.getMessage());

			setUserNumbers();

			printMsg_newLine(gameService.giveHint(user.getBalls(), answer.getBalls()));
			isAnswer = isGameEndedWith3Strikes();
		}

		printMsg_newLine(GAME_OVER.getMessage());
	}

	private boolean isGameEndedWith3Strikes() {
		return gameService.countStrike(user.getBalls(), answer.getBalls()) == 3;
	}

	private void setAnswerNumbers() {
		answer.setBalls(gameService.generateRandomNumber());
	}

	private void setUserNumbers() {
		user.setBalls(userInput.getNumbers());
	}
}
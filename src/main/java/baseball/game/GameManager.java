package baseball.game;

import baseball.game.balls.Balls;
import baseball.input.UserInput;
import baseball.util.ConsoleUtil;
import java.util.ArrayList;

public class GameManager {

	private static final int STRIKE_CONDITION = 3;
	private final Balls answer = new Balls(new ArrayList<>());
	private final Balls user = new Balls(new ArrayList<>());
	private final UserInput userInput = new UserInput();
	private final GameService gameService = new GameService();

	public void start() {
		ConsoleUtil.printMsg_newLine(GameMessages.GAME_START.getMessage());

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
			ConsoleUtil.printMsg(GameMessages.INPUT_NUMBER.getMessage());

			setUserNumbers();

			ConsoleUtil.printMsg_newLine(gameService.giveHint(user.getBalls(), answer.getBalls()));
			isAnswer = isGameEndedWith3Strikes();
		}

		ConsoleUtil.printMsg_newLine(GameMessages.GAME_OVER.getMessage());
	}

	private boolean isGameEndedWith3Strikes() {
		return gameService.countStrike(user.getBalls(), answer.getBalls()) == STRIKE_CONDITION;
	}

	private void setAnswerNumbers() {
		answer.setBalls(gameService.generateRandomNumber());
	}

	private void setUserNumbers() {
		user.setBalls(userInput.getNumbers());
	}
}
package baseball.game;

import static baseball.game.GameMessages.BALL;
import static baseball.game.GameMessages.BALL_STRIKE;
import static baseball.game.GameMessages.INPUT_NUMBER;
import static baseball.game.GameMessages.NOTHING;
import static baseball.game.GameMessages.STRIKE;
import static baseball.game.GameMessages.printEndMsg;
import static baseball.game.GameMessages.printStartMsg;
import static baseball.game.RandomNumberGenerator.generateRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

	private final Balls answer = new Balls(new ArrayList<>());
	private final Balls user = new Balls(new ArrayList<>());
	private final UserInput userInput = new UserInput();

	public void start() {
		printStartMsg();

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
			System.out.print(INPUT_NUMBER.getMessage());
			setUserNumbers();
			System.out.println(giveHint(user.getBalls(), answer.getBalls()));
			isAnswer = isGameEndedWith3Strikes();
		}

		printEndMsg();
	}

	private boolean isGameEndedWith3Strikes() {
		return countStrike(user.getBalls(), answer.getBalls()) == 3;
	}

	private void setAnswerNumbers() {
		answer.setBalls(generateRandomNumber());
	}

	public void setUserNumbers() {
		user.setBalls(userInput.getNumbers());
	}

	public String giveHint(List<Integer> player, List<Integer> answer) {
		int balls = countBall(player, answer);
		int strikes = countStrike(player, answer);

		if (balls > 0 && strikes > 0) {
			return BALL_STRIKE.getMessage().formatted(balls, strikes);
		} else if (balls > 0) {
			return BALL.getMessage().formatted(balls);
		} else if (strikes > 0) {
			return STRIKE.getMessage().formatted(strikes);
		} else {
			return NOTHING.getMessage();
		}
	}

	public int countBall(List<Integer> player, List<Integer> answer) {
		int ball = 0;
		for (int i = 0; i < player.size(); i++) {
			if (answer.contains(player.get(i)) && !answer.get(i).equals(player.get(i))) {
				ball++;
			}
		}

		return ball;
	}

	public int countStrike(List<Integer> player, List<Integer> answer) {
		int strike = 0;
		for (int i = 0; i < player.size(); i++) {
			if (player.get(i).equals(answer.get(i))) {
				strike++;
			}
		}

		return strike;
	}
}
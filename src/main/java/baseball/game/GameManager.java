package baseball.game;

import static baseball.game.GameMessages.BALL;
import static baseball.game.GameMessages.BALL_STRIKE;
import static baseball.game.GameMessages.NOTHING;
import static baseball.game.GameMessages.STRIKE;
import static baseball.game.GameMessages.printEndMsg;
import static baseball.game.GameMessages.printInputMsg;
import static baseball.game.GameMessages.printStartMsg;

import camp.nextstep.edu.missionutils.Randoms;
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
			printInputMsg();

			setUserNumbers();

			printHint(giveHint(user.getBalls(), answer.getBalls()));
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

	private void printHint(String hint) {
		System.out.println(hint);
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

	private List<Integer> generateRandomNumber() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}

		return numbers;
	}
}
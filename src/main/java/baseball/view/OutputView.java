package baseball.view;

import baseball.model.Score;
import baseball.util.Message;

public class OutputView {
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public void printScore(Score userScore) {
		printMessage(makeScoreString(userScore));
	}

	public static void printGameStartMessage() {
		printMessage(Message.GAME_START_MESSAGE);
	}

	public static void printInputNumberMessage() {
		printMessage(Message.INPUT_NUMBER_MESSAGE);
	}

	public static void printGameEndMessage() {
		printMessage(Message.GAME_END_MESSAGE);
	}

	public static void printGameRestartMessage() {
		printMessage(Message.GAME_RESTART_MESSAGE);
	}

	public static void printInputErrorMessage() {
		printMessage(Message.INPUT_ERROR_MESSAGE);
	}

	private String makeScoreString(Score userScore) {
		if (userScore.isNothing()) {
			return Message.NOTHING_MESSAGE;
		} else if (userScore.isOnlyStrike()) {
			return userScore.getStrike()+ Message.STRIKE_MESSAGE;
		} else if (userScore.isOnlyBall()) {
			return userScore.getBall()+ Message.BALL_MESSAGE;
		} else {
			return userScore.getBall()+ Message.BALL_MESSAGE + " " + userScore.getStrike()+ Message.STRIKE_MESSAGE;
		}
	}
}

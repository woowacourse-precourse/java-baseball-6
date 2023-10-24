package baseball.view;

import baseball.util.Message;
public class OutputView {
public static void printMessage(String message) {
		System.out.println(message);
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
	public static void printBallMessage() {
		printMessage(Message.BALL_MESSAGE);
	}
	public static void printStrikeMessage() {
		printMessage(Message.STRIKE_MESSAGE);
	}
	public static void printNothingMessage() {
		printMessage(Message.NOTHING_MESSAGE);
	}
	public static void printInputErrorMessage() {
		printMessage(Message.INPUT_ERROR_MESSAGE);
	}
}

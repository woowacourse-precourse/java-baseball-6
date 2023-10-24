package baseball.util;

import baseball.game.GameMessages;

public class ConsoleUtil {

	public static void printMsg_newLine(String msg) {
		System.out.println(msg);
	}

	public static void printMsg(String msg) {
		System.out.print(msg);
	}

	public static String hintFormatter(int balls, int strikes) {
		if (balls > 0 && strikes > 0) {
			return GameMessages.BALL_STRIKE.getMessage().formatted(balls, strikes);
		} else if (balls > 0) {
			return GameMessages.BALL.getMessage().formatted(balls);
		} else if (strikes > 0) {
			return GameMessages.STRIKE.getMessage().formatted(strikes);
		} else {
			return GameMessages.NOTHING.getMessage();
		}
	}
}
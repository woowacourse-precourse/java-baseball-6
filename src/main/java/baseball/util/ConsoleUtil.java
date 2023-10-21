package baseball.util;

import static baseball.game.GameMessages.BALL;
import static baseball.game.GameMessages.BALL_STRIKE;
import static baseball.game.GameMessages.NOTHING;
import static baseball.game.GameMessages.STRIKE;

public class ConsoleUtil {

	public static void printMsg_newLine(String msg) {
		System.out.println(msg);
	}

	public static void printMsg(String msg) {
		System.out.print(msg);
	}

	public static String hintFormatter(int balls, int strikes) {
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
}
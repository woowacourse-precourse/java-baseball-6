package baseball.global.utils;

import baseball.global.constant.Common;
import baseball.global.constant.Output;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleUtil {

	public static String input() {
		return Console.readLine();
	}

	public static void commonOutput(String output) {
		System.out.println(output);
	}

	public static void ballAndStrikeCountOutput(int ball, int strike) {
		if (isNothing(ball, strike)) {
			System.out.println(Output.NOTHING.getComment());
			return;
		}
		if (isGameEnd(strike)) {
			System.out.println(strike + Output.STRIKE.getComment());
			System.out.println(Output.GAME_END.getComment());
			return;
		}
		outputAnotherCase(ball, strike);
	}

	private static void outputAnotherCase(int ball, int strike) {
		StringBuilder stringBuilder = new StringBuilder();
		ballExistOutput(ball, stringBuilder);
		if (ballAndStrikeExistOutput(ball, strike, stringBuilder)) {
			return;
		}
		strikeExistOutput(strike, stringBuilder);
	}

	private static boolean ballAndStrikeExistOutput(int ball, int strike, StringBuilder stringBuilder) {
		if (existsBall(ball) && existsStrike(strike)) {
			stringBuilder.append(Output.SPACE.getComment()).append(strike).append(Output.STRIKE.getComment())
				.append(Output.NEXT_LINE.getComment());
			System.out.println(stringBuilder);
			return true;
		}
		return false;
	}

	private static void strikeExistOutput(int strike, StringBuilder stringBuilder) {
		if (existsStrike(strike)) {
			stringBuilder.append(strike).append(Output.STRIKE.getComment());
		}
		System.out.println(stringBuilder);
	}

	private static void ballExistOutput(int ball, StringBuilder stringBuilder) {
		if (existsBall(ball)) {
			stringBuilder.append(ball).append(Output.BALL.getComment());
		}
	}

	private static boolean existsStrike(int strike) {
		return strike != Common.ZERO_COUNT.getNumber();
	}

	private static boolean existsBall(int ball) {
		return ball != Common.ZERO_COUNT.getNumber();
	}

	private static boolean isGameEnd(int strike) {
		return strike == Common.MAXIMUM_COUNT.getNumber();
	}

	private static boolean isNothing(int ball, int strike) {
		return strike == Common.ZERO_COUNT.getNumber() && ball == Common.ZERO_COUNT.getNumber();
	}

}

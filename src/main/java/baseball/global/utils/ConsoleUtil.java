package baseball.global.utils;

import baseball.global.constant.CommonNumberType;
import baseball.global.constant.OutputType;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleUtil {

	public static String input() {
		return Console.readLine();
	}

	public static void commonOutputLine(String output) {
		System.out.println(output);
	}

	public static void commonOutput(String output) {
		System.out.print(output);
	}

	public static void ballAndStrikeCountOutput(int ball, int strike) {
		if (isNothing(ball, strike)) {
			System.out.println(OutputType.NOTHING.getComment());
			return;
		}
		if (isGameEnd(strike)) {
			System.out.println(strike + OutputType.STRIKE.getComment());
			System.out.println(OutputType.GAME_END.getComment());
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
			stringBuilder.append(OutputType.SPACE.getComment()).append(strike).append(OutputType.STRIKE.getComment())
					.append(OutputType.NEXT_LINE.getComment());
			System.out.println(stringBuilder);
			return true;
		}
		return false;
	}

	private static void strikeExistOutput(int strike, StringBuilder stringBuilder) {
		if (existsStrike(strike)) {
			stringBuilder.append(strike).append(OutputType.STRIKE.getComment());
		}
		System.out.println(stringBuilder);
	}

	private static void ballExistOutput(int ball, StringBuilder stringBuilder) {
		if (existsBall(ball)) {
			stringBuilder.append(ball).append(OutputType.BALL.getComment());
		}
	}

	private static boolean existsStrike(int strike) {
		return strike != CommonNumberType.ZERO_COUNT.getValue();
	}

	private static boolean existsBall(int ball) {
		return ball != CommonNumberType.ZERO_COUNT.getValue();
	}

	private static boolean isGameEnd(int strike) {
		return strike == CommonNumberType.MAXIMUM_COUNT.getValue();
	}

	private static boolean isNothing(int ball, int strike) {
		return strike == CommonNumberType.ZERO_COUNT.getValue() && ball == CommonNumberType.ZERO_COUNT.getValue();
	}

}

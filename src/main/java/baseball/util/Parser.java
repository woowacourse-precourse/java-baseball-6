package baseball.util;

public class Parser {
	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";

	public static String parseHintToString(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			return NOTHING;
		} else if (strike == 0 || ball == 0) {
			return parseHintToOneResult(strike, ball);
		} else {
			return parseHintToResults(strike, ball);
		}
	}

	private static String parseHintToOneResult(int strike, int ball) {
		if (strike == 0) {
			return ball + BALL;
		}
		return strike + STRIKE;
	}

	private static String parseHintToResults(int strike, int ball) {
		return ball + BALL + " " + strike + STRIKE;
	}
}

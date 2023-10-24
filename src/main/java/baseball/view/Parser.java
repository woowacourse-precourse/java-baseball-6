package baseball.view;

public class Parser {
	private static final String STRIKE = "%d스트라이크";
	private static final String BALL_STRIKE = "%d볼 %d스트라이크";
	private static final String BALL = "%d볼";
	private static final String NOTHING = "낫싱";

	public static String parseHintToString(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			return NOTHING;
		} else if (strike == 0 || ball == 0) {
			return parseHintToOneResult(strike, ball);
		}
		return parseHintToResults(strike, ball);
	}

	private static String parseHintToOneResult(int strike, int ball) {
		if (strike == 0) {
			return String.format(BALL, ball);
		}
		return String.format(STRIKE, strike);
	}

	private static String parseHintToResults(int strike, int ball) {
		return String.format(BALL_STRIKE, ball, strike);
	}
}

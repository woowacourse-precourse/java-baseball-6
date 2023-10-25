package baseball.domain;

public enum GameResultMessage {
	BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

	private final String message;

	GameResultMessage(final String message) {
		this.message = message;
	}

	public static String createMessage(final GameResult gameResult) {
		if (gameResult.isNothing()) {
			return NOTHING.message;
		}
		int ballCount = gameResult.getBallCount();
		int strikeCount = gameResult.getStrikeCount();
		if (gameResult.existOnlyBall()) {
			return createCountMessage(ballCount, BALL);
		}
		if (gameResult.existOnlyStrike()) {
			return createCountMessage(strikeCount, STRIKE);
		}
		return String.join(" ", createCountMessage(ballCount, BALL), createCountMessage(strikeCount, STRIKE));
	}

	private static String createCountMessage(final int count, final GameResultMessage gameResultMessage) {
		return String.join("", count + gameResultMessage.message);
	}

}

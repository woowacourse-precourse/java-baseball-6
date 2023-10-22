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
		if (existOnlyBall(gameResult)) {
			return gameResult.getBallCount() + BALL.message;
		}
		if (existOnlyStrike(gameResult)) {
			return gameResult.getStrikeCount() + STRIKE.message;
		}
		return gameResult.getBallCount() + BALL.message + " " + gameResult.getStrikeCount() + STRIKE.message;
	}

	private static boolean existOnlyBall(final GameResult gameResult) {
		return gameResult.getBallCount() != 0 && gameResult.getStrikeCount() == 0;
	}

	private static boolean existOnlyStrike(final GameResult gameResult) {
		return gameResult.getStrikeCount() != 0 && gameResult.getBallCount() == 0;
	}
}

package baseball.domain.balls;

public enum BallsRule {
	MIN_NUMBER(1), MAX_NUMBER(9), BALLS_SIZE(3), MIN_POSITION(0), MAX_POSITION(2);

	private final int value;

	BallsRule(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

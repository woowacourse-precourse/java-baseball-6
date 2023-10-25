package baseball.domain.balls;

public enum BallsRule {
	MIN_NUMBER(1), MAX_NUMBER(9), BALLS_SIZE(3), MIN_POSITION(0), MAX_POSITION(2);

	private final int value;

	BallsRule(final int value) {
		this.value = value;
	}

	public static boolean isNumberOutOfRange(final int number) {
		return number < MIN_NUMBER.value || number > MAX_NUMBER.value;
	}

	public static boolean isPositionOutOfRange(final int position) {
		return position < MIN_POSITION.value || position > MAX_POSITION.value;
	}

	public static boolean isNotCorrectSize(final int size) {
		return size != BALLS_SIZE.value;
	}

	public int getValue() {
		return value;
	}

}

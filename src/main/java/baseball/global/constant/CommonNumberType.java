package baseball.global.constant;

public enum CommonNumberType {

	LENGTH_OF_NUMBERS(3),
	ZERO_COUNT(0),
	MAXIMUM_COUNT(3);

	private final int value;

	CommonNumberType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

package baseball.controller.constant;

public enum NumberConstant {
	MIN_NUMBER(1),
	MAX_NUMBER(9),
	PICK_COUNT(3);

	private final int value;

	NumberConstant(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

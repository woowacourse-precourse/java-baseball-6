package baseball.service.constant;

public enum NumberConstant {
	MIN_NUMBER(1),
	MAX_NUMBER(9),
	PICK_COUNT(3),
	GAME_INPUT_LENGTH(3),
	END_INPUT_LENGTH(1);

	private final int value;

	NumberConstant(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

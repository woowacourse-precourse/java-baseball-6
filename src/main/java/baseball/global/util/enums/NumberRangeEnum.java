package baseball.global.util.enums;

public enum NumberRangeEnum {
	MIN_NUMBER(1),
	MAX_NUMBER(9),
	NUMBER_LENGTH(3);

	private final int value;

	NumberRangeEnum(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

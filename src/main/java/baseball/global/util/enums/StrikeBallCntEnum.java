package baseball.global.util.enums;

public enum StrikeBallCntEnum {
	ALL_STRIKE(NumberRangeEnum.NUMBER_LENGTH.getValue()),
	NO_STRIKE(0),
	ALL_BALL(NumberRangeEnum.NUMBER_LENGTH.getValue()),
	NO_BALL(0);

	private final int value;

	StrikeBallCntEnum(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

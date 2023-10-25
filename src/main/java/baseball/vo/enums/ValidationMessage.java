package baseball.vo.enums;

public enum ValidationMessage {
	STOP_GAME("잘못된 값을 입력하셨습니다. 게임이 종료됩니다."),
	UNDER_THREE("야구게임에서 사용될 값은 3자리 입니다. 3자리 미만을 입력하셨습니다."),
	OVER_THREE("야구게임에서 사용될 값은 3자리 입니다. 3자리를 넘게 입력하셨습니다."),
	PROPER_TYPE("바르게 입력되었습니다."),
	NULL_TYPE("야구게임에서 입력하신 값은 NULL이 될 수 없습니다."),
	EMPTY_TYPE("야구게임에서 사용될 값이 입력되지 않았습니다."),
	ZERO_TYPE("야구게임에서 사용될 값은 0이 될 수 없습니다."),
	NOT_DUPLICATE_NUMBER("야구게임에서 사용될 숫자값들은 중복될 수 없습니다."),
	NOT_NUMBER("숫자만 입력해주세요.")
	;


	private String value;
	ValidationMessage(String value) {
		this.value = value;
	}

	public String getKey() {
		return name();
	}

	public String getValue() {
		return value;
	}
}

package baseball.vo.enums;

public enum ValidationMessage {
	STOP_GAME("잘못된 값을 입력하셨습니다. 게임이 종료됩니다."),
	UNDER_THREE("야구게임에서 사용될 값은 3자리 입니다. 3자리 미만을 입력하셨습니다."),
	OVER_THREE("야구게임에서 사용될 값은 3자리 입니다. 3자리를 넘게 입력하셨습니다.")
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

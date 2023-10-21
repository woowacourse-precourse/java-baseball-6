package baseball.console.constant;

public enum ErrorMessage {
	GAME_INPUT_ERROR_MSG("1 ~ 9 중 중복되지 않은 세자리 숫자만 입력 가능합니다."),
	END_INPUT_ERROR_MSG("1 또는 2만 입력 가능합니다.");

	private final String value;

	ErrorMessage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

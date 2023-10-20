package baseball.util.message;

public enum ErrorMessage {

	NUMBER_DUPLICATE_ERROR("중복된 숫자가 아니여야 합니다."),
	DIGIT_LENGTH_ERROR("숫자는 3자리수여야 합니다."),
	COMMAND_ERROR("1 또는 2를 입력해야 합니다."),
	INPUT_LETTER_ERROR("문자가 아닌 0을 제외한 숫자를 입력해야합니다."),
	PREFIX("[ERROR] ");

	private String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX.message + message;
	}
}

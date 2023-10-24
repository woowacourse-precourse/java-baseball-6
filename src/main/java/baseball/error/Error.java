package baseball.error;

public enum Error {
	RANGE_ERROR("숫자가 주어진 범위에서 벗어납니다."),
	DUPLICATION_ERROR("중복된 숫자가 존재합니다."),
	SIZE_ERROR("숫자는 %d자리수만 가능합니다.");

	private String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public String getMessage(int size) {
		return String.format(message, size);
	}
}

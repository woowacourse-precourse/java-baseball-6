package baseball.message;

public enum ErrorMessage {
	NOT_AN_INTEGER("입력이 변환가능한 정수가 아님"), EXCEED_MAX_LENGTH("입력이 규정길이를 초과"),NOT_UNIQUE_NUMBER("서로 다른 임의의 수가 아님");
	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

package baseball.message;

public enum Message {
	pleaseInput("숫자를 입력해주세요 : "), congrats("3개의 숫자를 모두 맞히셨습니다! "), gameOver("게임 종료")
	, threeStrikes("3스트라이크"),nothing("낫싱");

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

package baseball;

public enum PrintMessage {
	START("숫자 야구 게임을 시작합니다. \n"),
	REQUESTNUMBER("숫자를 입력해주세요 : \n"),
    SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n"),
    REQUEST_REPLY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. \n"),
	NOTHING("낫싱 \n"),
	BALL("볼"),
	STRIKE("스트라이크"),
	SPACE(" "),
	ENTER("\n");

	private final String message;

	PrintMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
        return message;
    }
}



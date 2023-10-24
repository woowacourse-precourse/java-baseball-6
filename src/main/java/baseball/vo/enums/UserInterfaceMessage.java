package baseball.vo.enums;

public enum UserInterfaceMessage {
	GAME_INFO("야구게임에 오신 것을 환영합니다.\n야구게임은 숫자 3개를 입력받습니다.\n만약 종료를 원하시면 2를 입력하세요 "),
	REQUEST_INPUT("숫자를 입력해주세요 : "),
	GAME_RESULT_BALL("볼"),
	GAME_RESULT_STRIKE("스트라이크"),
	GAME_RESULT_NOTHING("낫싱"),
	GAME_RESULT_SUCCESS("개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	GAME_END_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	private String value;

	UserInterfaceMessage(String value) {
		this.value = value;
	}

	public String getKey() {
		return name();
	}

	public String getValue() {
		return value;
	}
}

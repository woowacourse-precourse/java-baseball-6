package baseball.console;

public enum GameConstant {
	GAME_INIT("숫자 야구 게임을 시작합니다."),
	INPUT_REQ("숫자를 입력해주세요 : "),
	BALL("볼"),
	STRIKE("스트라이크"),
	NONE("낫싱"),
	SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	GAME_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	RESTART("1"),
	FINISH("2");

	private final String value;

	GameConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

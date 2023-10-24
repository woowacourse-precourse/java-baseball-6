package baseball.global.util.enums;

public enum GameMessageEnum {
	GAME_START("숫자 야구 게임을 시작합니다."),
	ENTER_USER_EXPECTED_NUMBER("숫자를 입력해주세요 : "),

	GAME_CLEAR("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),

	RESTART_OR_QUIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	private final String message;

	GameMessageEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

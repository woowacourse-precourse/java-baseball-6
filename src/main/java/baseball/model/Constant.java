package baseball.model;

public enum Constant {
	MESSAGE_GAME_START("숫자 야구 게임을 시작합니다."),
	MESSAGE_INPUT_NUMBER("숫자를 입력해주세요 : "),
	MESSAGE_GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료."),
	MESSAGE_GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	MESSAGE_STRIKE("스트라이크"),
	MESSAGE_BALL("볼"),
	MESSAGE_NOTHING("낫싱");
	public static final String WRONG_INPUT_LENGTH_MESSAGE = "세 자리만 입력 가능합니다.";
	public static final String WRONG_INPUT_RANGE_MESSAGE = "1~9 사이의 숫자만 입력 가능합니다.";
	public static final String WRONG_INPUT_DUPLICATE_MESSAGE = "서로 다른 세자리 숫자만 입력 가능합니다.";
	public static final String WRONG_INPUT_RESTART_MESSAGE = "1 또는 2만 입력 가능합니다.";
	public static final int NUMBER_LENGTH = 3;
	public static final int RANGE_MIN_NUMBER = 1;
	public static final int RANGE_MAX_NUMBER = 9;

	private final String message;

	Constant(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

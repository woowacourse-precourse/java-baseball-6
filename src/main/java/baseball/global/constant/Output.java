package baseball.global.constant;

public enum Output {

	GAME_INITIALIZE("숫자 야구 게임을 시작합니다."),
	INPUT_NUMBER("숫자를 입력해주세요 : "),
	GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	CHOOSE_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	BALL("볼"),
	STRIKE("스트라이크"),
	NOTHING("낫싱"),
	SPACE(" "),
	NEXT_LINE("\n"),
	EXCEPTION("잘못된 입력입니다. 애플리케이션을 종료합니다.");

	private final String comment;

	Output(final String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
}

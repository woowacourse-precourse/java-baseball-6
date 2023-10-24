package baseball.global.util.enums;

public enum GameResultEnum {
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱");

	private final String value;

	GameResultEnum(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

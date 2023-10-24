package baseball.global.util.enums;

public enum GameRestartEnum {
	RESTART("1"),
	QUIT("2");

	private final String value;

	GameRestartEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

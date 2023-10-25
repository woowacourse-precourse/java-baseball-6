package baseball.vo.enums;

public enum GameRule {
	GAME_NUMBER_LEN(3);

	private Integer value;

	GameRule(Integer value) {
		this.value = value;
	}

	public String getKey() {
		return name();
	}

	public Integer getValue() {
		return value;
	}
}

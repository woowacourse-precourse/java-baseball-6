package baseball.vo.enums;

public enum GameNumberInclusive {
	START(1), END(9);

	private Integer value;

	GameNumberInclusive(Integer value) {
		this.value = value;
	}

	public String getKey() {
		return name();
	}

	public Integer getValue() {
		return value;
	}
}

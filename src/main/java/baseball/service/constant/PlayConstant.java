package baseball.service.constant;

public enum PlayConstant {
	RESTART("1"),
	FINISH("2");

	private final String value;

	PlayConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}

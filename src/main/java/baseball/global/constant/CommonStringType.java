package baseball.global.constant;

public enum CommonStringType {

	RESTART("1"),
	FINISH("2");

	private final String content;

	CommonStringType(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}

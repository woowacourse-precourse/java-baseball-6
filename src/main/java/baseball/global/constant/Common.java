package baseball.global.constant;

public enum Common {

	LENGTH_OF_NUMBERS(3),
	MIN_RANGE_OF_DIGITS(1),
	MAX_RANGE_OF_DIGITS(9),
	ZERO_COUNT(0),
	MAXIMUM_COUNT(3),

	ZERO("0"),
	RESTART("1"),
	FINISH("2");

	private int number;
	private String content;

	Common(int number) {
		this.number = number;
	}

	Common(String content) {
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public String getContent() {
		return content;
	}
}

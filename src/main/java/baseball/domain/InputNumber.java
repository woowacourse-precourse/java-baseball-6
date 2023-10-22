package baseball.domain;

public class InputNumber extends Number {
	private InputNumber(String number, int size) {
		super(number, size);
	}

	public static InputNumber create(String number, int size) {
		return new InputNumber(number, size);
	}
}

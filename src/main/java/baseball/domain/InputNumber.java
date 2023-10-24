package baseball.domain;

public class InputNumber extends Number {
	private InputNumber(String number) {
		super(number);
	}

	public static InputNumber create(String number) {
		return new InputNumber(number);
	}
}

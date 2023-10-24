package baseball;

public class ChooseValidator extends IntegerExtractor{
	public int validate(String input) {
		str = input;
		validateNumber();
		validateValue();
		return number;
	}

	private void validateValue() {
		// 1, 2인지 검증한다.
		if (number != 1 && number != 2) {
			throw new IllegalArgumentException();
		}
	}
}

package baseball;

public class InputValidator {

	private InputValidator() {
	}

	public static void validateOption(int input) {
		Option.validate(input);
	}
}

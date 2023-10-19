package baseball.view;

public class IOValidator {
	public static void validateString(String value) {
		if (value.isBlank()) {
			throw new IllegalArgumentException("빈값을 입력하였습니다.");
		}
	}

	public static void validateNumber(String value) {
		if (value.isBlank()) {
			throw new IllegalArgumentException("빈값을 입력하였습니다.");
		}
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) < '0' || value.charAt(i) > '9') {
				throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
			}
		}
	}
}

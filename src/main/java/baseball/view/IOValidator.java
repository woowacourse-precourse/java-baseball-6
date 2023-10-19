package baseball.view;

public class IOValidator {
	public static void validateString(String value) {
		if (value.isBlank()) {
			throw new IllegalArgumentException("빈값을 입력하였습니다.");
		}
	}


}

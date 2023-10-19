package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validator {

	public List<Integer> validateBaseballNumber(String inputValue) {
		validateLength(inputValue, 3);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < inputValue.length(); i++) {
			String substring = inputValue.substring(i, i + 1);
			validateNumber(substring);
			result.add(Integer.parseInt(substring));
		}
		validateSameNumber(result);
		return result;
	}

	public int validatedRestart(String inputValue) {
		validateLength(inputValue, 1);
		validateNumber(inputValue);
		if (!"12".contains(inputValue)) {
			throw new IllegalArgumentException("1과 2만 입력할 수 있습니다.");
		}
		return Integer.parseInt(inputValue);
	}

	private static void validateLength(String value, int size) {
		if (value.length() != size) {
			throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
		}
	}

	private static void validateNumber(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) < '1' || value.charAt(i) > '9') {
				throw new IllegalArgumentException("1에서 9까지 서로 다른 임의의 수 3개를 선택해야합니다.");
			}
		}
	}

	private static void validateSameNumber(List<Integer> value) {
		int count = (int) value.stream()
				.distinct()
				.count();
		if (count != 3) {
			throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
		}
	}

}

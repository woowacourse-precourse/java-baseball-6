package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
	public static List<Integer> readBaseballNumber() {
		System.out.printf("숫자를 입력해주세요 : ");
		String inputValue = Console.readLine();
		validateLength(inputValue);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < inputValue.length(); i++) {
			String substring = inputValue.substring(i, i + 1);
			validateNumber(substring);
			result.add(Integer.parseInt(substring));
		}
		validateSameNumber(result);
		return result;
	}

	private static void validateLength(String value) {
		if (value.length() != 3) {
			throw new IllegalArgumentException("3 자리 숫자를 입력해야 합니다.");
		}
	}

	private static void validateNumber(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) < '0' || value.charAt(i) > '9') {
				throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
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

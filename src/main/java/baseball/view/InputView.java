package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
	public static List<Integer> readBaseballNumber() {
		System.out.printf("숫자를 입력해주세요 : ");
		String inputValue = Console.readLine();
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

	public static int readRestart() {
		System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String inputValue = Console.readLine();
		validateLength(inputValue, 1);
		validateNumber(inputValue);
		if (!"12".contains(inputValue)) {
			throw new IllegalArgumentException("1 과 2만 입력할 수 있습니다.");
		}
		return Integer.parseInt(inputValue);
	}

	private static void validateLength(String value, int size) {
		if (value.length() != size) {
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

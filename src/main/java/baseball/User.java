package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
	public int input3DigitNumber() {
		String input = Console.readLine();

		// 입력받은 숫자가 3자리가 아닐 때 예외 처리
		if (input.length() != 3) {
			throw new IllegalArgumentException();
		}

		// 3자리 중에서 하나라도 1-9까지 수가 아닐 때 예외 처리
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) < 49 || input.charAt(i) > 57) {
				throw new IllegalArgumentException();
			}
		}

		// 3자리 수 중에서 숫자가 중복되면 예외 처리
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					throw new IllegalArgumentException();
				}
			}
		}

		return Integer.parseInt(input);
	}

	public int inputRestartNumber() {
		String input = Console.readLine();

		if (!input.equals("1") && !input.equals("2")) {
			throw new IllegalArgumentException();
		}

		return Integer.parseInt(input);
	}
}

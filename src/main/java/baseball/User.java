package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 객체의 클래스
 * <p>사용자의 3자리 숫자를 입력받는 함수와
 * 사용자의 게임 재시작 여부를 입력받는 함수 구현</p>
 */
public class User {
	/**
	 * 세자리 숫자를 입력받는 함수
	 * @exception IllegalArgumentException 입력 받은 숫자가 3자리가 아니거나 하나라도 1-9 숫자가 아닐 때, 숫자 간의 중복이 있을 때 발생
	 * @return 입력 받은 3자리 숫자
	 */
	public int input3DigitNumber() {
		String input = Console.readLine();

		if (input.length() != 3) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) < 49 || input.charAt(i) > 57) {
				throw new IllegalArgumentException();
			}
		}

		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					throw new IllegalArgumentException();
				}
			}
		}

		return Integer.parseInt(input);
	}

	/**
	 * 게임 재시작 여부 입력받는 함수
	 * @exception IllegalArgumentException 1 또는 2 말고 다른 것을 입력 받을 시 발생
	 * @return 재시작 여부 숫자 (1 또는 2)
	 */
	public int inputRestartNumber() {
		String input = Console.readLine();

		if (!input.equals("1") && !input.equals("2")) {
			throw new IllegalArgumentException();
		}

		return Integer.parseInt(input);
	}
}

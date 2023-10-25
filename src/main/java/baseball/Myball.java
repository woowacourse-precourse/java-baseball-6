package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Myball {
	
	private int[] numbers = new int[3];

	public void input() {

		String input = Console.readLine();

		System.out.print("숫자를 입력해주세요: ");

		// 길이가 3이 아닐 경우
		if (input.length() != 3) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < 3; i++) {
			char c = input.charAt(i);

			// 숫자에 0이 포함된 경우
			if (c < '1' || c > '9') {
				throw new IllegalArgumentException();
			}
			numbers[i] = c - '0';
		}
		// 중복된 숫자가 있는 경우
		if (DuplicateChecker.containsDuplicates(numbers)) {
			throw new IllegalArgumentException();
		}

	}

	public int[] getNumbers() {
		return numbers;
	}
}
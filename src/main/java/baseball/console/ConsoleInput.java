package baseball.console;

import java.util.Scanner;

import baseball.util.InputValidation;

public class ConsoleInput {
	private final InputValidation inputValidation;

	public ConsoleInput() {
		inputValidation = new InputValidation();
	}

	public String getGameInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (inputValidation.isGameInputValid(input)) {
			return input;
		}
		throw new IllegalArgumentException("1 ~ 9 중 중복되지 않은 세자리 숫자만 입력 가능합니다.");
	}

	public String getEndInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (inputValidation.isEndInputValid(input)) {
			return input;
		}
		throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
	}
}


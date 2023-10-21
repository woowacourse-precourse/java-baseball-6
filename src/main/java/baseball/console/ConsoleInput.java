package baseball.console;

import camp.nextstep.edu.missionutils.Console;

import baseball.util.InputValidation;

public class ConsoleInput {
	private final InputValidation inputValidation;

	public ConsoleInput() {
		inputValidation = new InputValidation();
	}

	public String getGameInput() {
		String input = Console.readLine();
		if (inputValidation.isValidGameInput(input)) {
			return input;
		}
		throw new IllegalArgumentException("1 ~ 9 중 중복되지 않은 세자리 숫자만 입력 가능합니다.");
	}

	public String getEndInput() {
		String input = Console.readLine();
		if (inputValidation.isValidEndInput(input)) {
			return input;
		}
		throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
	}
}


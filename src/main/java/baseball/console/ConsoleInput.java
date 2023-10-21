package baseball.console;

import baseball.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

import baseball.console.util.InputValidation;

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
		throw new IllegalArgumentException(ErrorMessage.GAME_INPUT_ERROR_MSG.getValue());
	}

	public String getEndInput() {
		String input = Console.readLine();
		if (inputValidation.isValidEndInput(input)) {
			return input;
		}
		throw new IllegalArgumentException(ErrorMessage.END_INPUT_ERROR_MSG.getValue());
	}
}


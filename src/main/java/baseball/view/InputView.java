package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String BLANK_ERROR_MESSAGE = "값을 입력해 주세요.";

	public static String getInput() {
		String input = Console.readLine();
		validateBlank(input);
		return input;
	}

	private static void validateBlank(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
		}
	}

}

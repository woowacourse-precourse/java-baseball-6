package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static int readInteger(String message) {
		System.out.printf(message);
		String inputValue = Console.readLine();
		IOValidator.validateNumber(inputValue);
		return Integer.parseInt(inputValue);
	}
}

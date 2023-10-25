package baseball.view;

import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public int userInputNumber() {
		OutputView.printInputNumberMessage();
		String userInput = Console.readLine();

		InputValidator inputValidator = new InputValidator();
		inputValidator.isValidInput(userInput);

		return Integer.parseInt(userInput);
	}

	public int gameRestartFlag() {
		OutputView.printGameRestartMessage();
		String userInput = Console.readLine();

		return Integer.parseInt(userInput);
	}
}

package baseball.view;

import baseball.util.validate.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public int inputDigit() {
		String inputValue = Console.readLine();

		inputDigitValidate(inputValue);

		return Integer.parseInt(inputValue);
	}

	public int inputCommand() {
		String inputValue = Console.readLine();

		inputCommandValidate(inputValue);

		return Integer.parseInt(inputValue);
	}

	public void inputDigitValidate(String inputValue) {
		Validator.validateDigitFormat(inputValue);
		Validator.validateOutOfLength(inputValue);
		Validator.validateDuplicatedNumber(inputValue);
	}

	public void inputCommandValidate(String inputValue) {
		Validator.validateDigitFormat(inputValue);
		Validator.validateContinueCommand(inputValue);
	}
}

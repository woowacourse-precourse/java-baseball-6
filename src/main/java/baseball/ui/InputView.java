package baseball.ui;

import java.util.ArrayList;
import java.util.List;

import baseball.global.util.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final OutputView outputView;

	public InputView(OutputView outputView) {
		this.outputView = outputView;
	}

	private final static String SEPARATOR = "";


	public List<Integer> readNumber() {
		outputView.printNumberInputMessage();
		String inputValue = Console.readLine();
		String[] inputNumbers = inputValue.split(SEPARATOR);

		Validator.validateNumbersFormat(inputNumbers);
		Validator.validateNumbersLength(inputNumbers);
		Validator.validateNumbersDuplication(inputNumbers);

		List<Integer> numbers = new ArrayList<>();
		for (String number : inputNumbers) {
			numbers.add(Integer.parseInt(number));
		}

		return numbers;
	}

	public String readRestartOrNot() {
		outputView.printRestartSelectMessage();
		String selectOption = Console.readLine();

		Validator.validateNumberFormat(selectOption);
		Validator.validateSelectOptionType(selectOption);
		return selectOption;

	}
}

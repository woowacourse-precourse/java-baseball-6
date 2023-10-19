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


	public List<Integer> readPlayerNumber() {
		String[] inputNumbers = readNumber();

		List<Integer> numbers = new ArrayList<>();
		for (String number : inputNumbers) {
			numbers.add(Integer.parseInt(number));
		}

		return numbers;
	}

	private String[] readNumber() {
		outputView.printNumberInputMessage();
		String inputValue = Console.readLine();
		String[] inputNumbers = inputValue.split(SEPARATOR);

		validatePlayerNumber(inputNumbers);
		return inputNumbers;
	}

	private static void validatePlayerNumber(String[] inputNumbers) {
		Validator.validateNumbersFormat(inputNumbers);
		Validator.validateNumbersLength(inputNumbers);
		Validator.validateNumbersDuplication(inputNumbers);
	}

	public String readRestartOrNot() {
		outputView.printRestartSelectMessage();
		String selectOption = Console.readLine();

		validateRestartOrNotValue(selectOption);
		return selectOption;

	}

	private static void validateRestartOrNotValue(String selectOption) {
		Validator.validateNumberFormat(selectOption);
		Validator.validateSelectOptionType(selectOption);
	}
}

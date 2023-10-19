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

	public List<Integer> readNumber() {
		outputView.printNumberInputMessage();
		String inputValue = Console.readLine();
		String[] inputNumbers = inputValue.split("");

		Validator.validateNumberLength(inputNumbers);
		Validator.validateNumberDuplication(inputNumbers);
		Validator.validateNumberFormat(inputNumbers);

		List<Integer> numbers = new ArrayList<>();
		for (String number : inputNumbers) {
			numbers.add(Integer.parseInt(number));
		}

		return numbers;
	}
}

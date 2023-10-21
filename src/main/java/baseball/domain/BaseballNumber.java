package baseball.domain;

import static baseball.validator.NumberValidator.validateNumber;

import java.util.List;

public class BaseballNumber {

	private final List<Integer> numbers;

	public BaseballNumber(List<Integer> numbers) {
		validateNumber(numbers);
		this.numbers = numbers;
	}
}

package baseball.domain;

import static baseball.validator.NumberValidator.validateNumber;

import java.util.List;

public class BaseballNumber {

	private final List<Integer> numbers;

	public BaseballNumber(List<Integer> numbers) {
		validateNumber(numbers);
		this.numbers = numbers;
	}

	public int getComputerNumberByIndex(int index) {
		return numbers.get(index);
	}

	public boolean isComputerNumberContainsPlayerNumber(int playerNumber) {
		return numbers.contains(playerNumber);
	}
}

package baseball.domain;

import java.util.List;

import baseball.util.message.ErrorMessage;

public class BaseballNumber {

	private static final int LENGTH = 3;

	private final List<Integer> numbers;

	public BaseballNumber(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		validateOutOfLength(numbers);
		validateDuplicatedNumber(numbers);
	}

	private void validateOutOfLength(List<Integer> numbers) {
		if (isOutOfLength(numbers)) {
			throw new IllegalArgumentException(ErrorMessage.DIGIT_LENGTH_ERROR.getMessage());
		}
	}

	private void validateDuplicatedNumber(List<Integer> numbers) {
		if (isDuplicatedNumber(numbers)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR.getMessage());
		}
	}

	private boolean isOutOfLength(List<Integer> numbers) {
		return numbers.size() != LENGTH;
	}

	private boolean isDuplicatedNumber(List<Integer> numbers) {
		return numbers.stream().distinct().count() != numbers.size();
	}

	public Integer get(int index) {
		return numbers.get(index);
	}

	public Integer size() {
		return numbers.size();
	}

	public boolean contains(int num) {
		return numbers.contains(num);
	}

}

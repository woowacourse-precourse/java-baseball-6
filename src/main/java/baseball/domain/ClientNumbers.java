package baseball.domain;

import baseball.global.constant.CommonNumberType;
import baseball.global.constant.OutputType;
import java.util.Collections;
import java.util.List;

public class ClientNumbers {

	private static final int MIN_RANGE_OF_DIGITS = 1;
	private static final int MAX_RANGE_OF_DIGITS = 9;
	private final List<Integer> numbers;

	public ClientNumbers(List<Integer> numbers) {
		validateNumbers(numbers);
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}

	private void validateNumbers(List<Integer> numbers) {
		if (isWrongInput(numbers)) {
			throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
		}
	}

	private boolean isWrongInput(List<Integer> numbers) {
		return !(isNotDuplication(numbers) && allowsNumberRange(numbers) && shouldInvalidLength(numbers)
				&& allowsPositiveValue(numbers));
	}

	private boolean isNotDuplication(List<Integer> numbers) {
		return numbers.size() == numbers.stream()
				.distinct().count();
	}

	private boolean allowsNumberRange(List<Integer> numbers) {
		return numbers.stream().allMatch(number -> number >= MIN_RANGE_OF_DIGITS && number <= MAX_RANGE_OF_DIGITS);
	}

	private boolean shouldInvalidLength(List<Integer> numbers) {
		return numbers.size() == CommonNumberType.LENGTH_OF_NUMBERS.getValue();
	}

	private boolean allowsPositiveValue(List<Integer> numbers) {
		return numbers.stream()
				.allMatch(number -> number > 0);
	}
}

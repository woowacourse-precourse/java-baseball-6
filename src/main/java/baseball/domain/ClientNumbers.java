package baseball.domain;

import baseball.global.constant.CommonNumberType;
import baseball.global.constant.OutputType;
import java.util.Collections;
import java.util.List;

public class ClientNumbers {

	private static final int NOT_ALLOWED_INPUT = 0;
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
		return !numbers.contains(NOT_ALLOWED_INPUT);
	}

	private boolean shouldInvalidLength(List<Integer> numbers) {
		return numbers.size() == CommonNumberType.LENGTH_OF_NUMBERS.getValue();
	}

	private boolean allowsPositiveValue(List<Integer> numbers) {
		return numbers.stream()
				.allMatch(number -> number > 0);
	}
}

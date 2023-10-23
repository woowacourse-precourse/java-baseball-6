package baseball.domain;

import java.util.List;

public class NumbersValidator {
	private static final int MIN_RANDOM_NUMBER = 1;
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final int NUMBERS_LENGTH = 3;

	public static void validateDuplicateNumber(List<Integer> numbers) {
		if (numbers.size() != numbers.stream().distinct().count()) {
			throw new IllegalArgumentException("숫자는 중복되면 안됩니다.");
		}
	}

	public static void validateNumbersSize(List<Integer> numbers) {
		if (numbers.size() != NUMBERS_LENGTH) {
			throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
		}
	}

}

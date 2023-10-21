package baseball.validator;

import java.util.List;

public class NumberValidator {

	private static final int MAX_NUMBER_SIZE = 3;
	private static final int MIN_NUMBER_RANGE = 1;
	private static final int MAX_NUMBER_RANGE = 9;

	public static void validateNumber(List<Integer> numbers) {
		validateComputerNumberSize(numbers);
		validateDuplicateNumber(numbers);
		validateNumberRange(numbers);
	}

	private static void validateNumberRange(List<Integer> numbers) {
		if (isOverRange(numbers)) {
			throw new IllegalArgumentException("숫자가 범위에 벗어났습니다.");
		}
	}

	private static boolean isOverRange(List<Integer> numbers) {
		return numbers.stream()
			.anyMatch(number -> number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE);
	}

	private static void validateComputerNumberSize(List<Integer> numbers) {
		if (numbers.size() != MAX_NUMBER_SIZE) {
			throw new IllegalArgumentException("숫자 개수의 오류가 발생하였습니다.");
		}
	}

	private static void validateDuplicateNumber(List<Integer> numbers) {
		if (isDuplicateNumber(numbers)) {
			throw new IllegalArgumentException("숫자가 중복되었습니다.");
		}
	}

	private static boolean isDuplicateNumber(List<Integer> numbers) {
		long distinctCount = numbers.stream()
			.distinct()
			.count();
		return distinctCount != numbers.size();
	}
}

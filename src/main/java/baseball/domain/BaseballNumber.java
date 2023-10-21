package baseball.domain;

import java.util.List;

public class BaseballNumber {

	private static final int MAX_NUMBER_SIZE = 3;
	private static final int MIN_NUMBER_RANGE = 1;
	private static final int MAX_NUMBER_RANGE = 9;

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

	private void validateNumber(List<Integer> numbers) {
		validateNumberSize(numbers);
		validateDuplicateNumber(numbers);
		validateNumberRange(numbers);
	}

	private void validateNumberSize(List<Integer> numbers) {
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

	private void validateNumberRange(List<Integer> numbers) {
		if (isOverRange(numbers)) {
			throw new IllegalArgumentException("숫자가 범위에 벗어났습니다.");
		}
	}

	private boolean isOverRange(List<Integer> numbers) {
		return numbers.stream()
			.anyMatch(number -> number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE);
	}
}

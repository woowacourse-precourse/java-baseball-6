package baseball.domain;

import java.util.List;

public class Computer {

	private static final int MAX_NUMBER_SIZE = 3;
	private static final int MIN_NUMBER_RANGE = 1;
	private static final int MAX_NUMBER_RANGE = 9;

	private final List<Integer> computerNumbers;

	public Computer(List<Integer> computerNumbers) {
		validateComputerNumberSize(computerNumbers);
		validateDuplicateNumber(computerNumbers);
		validateNumberRange(computerNumbers);
		this.computerNumbers = computerNumbers;
	}

	private void validateNumberRange(List<Integer> computerNumbers) {
		if (isOverRange(computerNumbers)) {
			throw new IllegalArgumentException("컴퓨터의 숫자가 범위에 벗어났습니다.");
		}
	}

	private boolean isOverRange(List<Integer> computerNumbers) {
		return computerNumbers.stream()
			.anyMatch(computerNumber -> computerNumber < MIN_NUMBER_RANGE || computerNumber > MAX_NUMBER_RANGE);
	}

	private void validateComputerNumberSize(List<Integer> computerNumbers) {
		if (computerNumbers.size() != MAX_NUMBER_SIZE) {
			throw new IllegalArgumentException("컴퓨터가 숫자를 생성할 때 오류가 발생하였습니다.");
		}
	}

	private void validateDuplicateNumber(List<Integer> computerNumbers) {
		if (isDuplicateNumber(computerNumbers)) {
			throw new IllegalArgumentException("사용자가 입력한 숫자가 중복되었습니다.");
		}
	}

	private boolean isDuplicateNumber(List<Integer> computerNumbers) {
		long distinctCount = computerNumbers.stream()
			.distinct()
			.count();
		return distinctCount != computerNumbers.size();
	}
}

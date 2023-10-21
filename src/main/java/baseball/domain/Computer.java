package baseball.domain;

import java.util.List;

public class Computer {

	private static final int MAX_NUMBER_SIZE = 3;

	private final List<Integer> computerNumbers;

	public Computer(List<Integer> computerNumbers) {
		validateComputerNumberSize(computerNumbers);
		validateDuplicateNumber(computerNumbers);
		this.computerNumbers = computerNumbers;
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

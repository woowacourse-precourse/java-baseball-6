package baseball.domain;

import baseball.global.constant.Common;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

	private List<Integer> numbers;

	public Computer() {
		initialize();
	}

	private void initialize() {
		numbers = new ArrayList<>();
		while (numbers.size() < Common.LENGTH_OF_NUMBERS.getNumber()) {
			addRandomNumber(getRandomNumber());
		}
	}

	private void addRandomNumber(int number) {
		if (isNotDuplicateNumber(number)) {
			numbers.add(number);
		}
	}

	private boolean isNotDuplicateNumber(int number) {
		return !numbers.contains(number);
	}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(
			Common.MIN_RANGE_OF_DIGITS.getNumber(),
			Common.MAX_RANGE_OF_DIGITS.getNumber()
		);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}

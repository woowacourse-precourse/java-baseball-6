package baseball.domain;

import static baseball.controller.GameController.NUMBER_SIZE;
import static baseball.error.Error.*;

import java.util.HashSet;
import java.util.Set;

public class Number {
	private String number;

	public Number(String number) {
		validateRange(number);
		validateSize(number);
		validateDuplication(number);
		this.number = number;
	}

	protected String getNumber() {
		return number;
	}

	private void validateRange(String number) {
		for (char c : number.toCharArray()) {
			if (c - '0' < 1 || c - '0' > 9) {
				throw new IllegalArgumentException(RANGE_ERROR.getMessage());
			}
		}
	}

	private void validateSize(String number) {
		if (number.length()!=NUMBER_SIZE) {
			throw new IllegalArgumentException(SIZE_ERROR.getMessage(NUMBER_SIZE));
		}
	}

	private void validateDuplication(String number) {
		Set<Character> checkSet = new HashSet<>();

		initCheckSet(checkSet, number);
		checkDuplication(checkSet);
	}

	private void initCheckSet(Set<Character> checkSet, String number) {
		for (char checkNumber : number.toCharArray()) {
			checkSet.add(checkNumber);
		}
	}

	private void checkDuplication(Set<Character> checkSet) {
		if (isDuplicated(checkSet)) {
			throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
		}
	}

	private boolean isDuplicated(Set<Character> checkSet) {
		return checkSet.size() != NUMBER_SIZE;
	}

}

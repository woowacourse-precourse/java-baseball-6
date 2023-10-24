package baseball.domain;

import static baseball.error.Error.DUPLICATION_ERROR;
import static baseball.error.Error.RANGE_ERROR;
import static baseball.error.Error.SIZE_ERROR;

import java.util.HashSet;
import java.util.Set;

public class Number {
	public static final int NUMBER_SIZE = 3;
	public static final int START_NUMBER = 1;
	public static final int END_NUMBER = 9;
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
			if (c - '0' < START_NUMBER || c - '0' > END_NUMBER) {
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

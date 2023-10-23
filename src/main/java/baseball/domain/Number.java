package baseball.domain;

import static baseball.controller.GameController.NUMBER_SIZE;

import java.util.HashSet;
import java.util.Set;

public class Number {
	private String number;

	public Number(String number) {
		validateRange(number);
		validateSize(number, NUMBER_SIZE);
		validateDuplication(number);
		this.number = number;
	}

	protected String getNumber() {
		return number;
	}

	private void validateRange(String number) {
		for (char c : number.toCharArray()) {
			if (c - '0' < 1 || c - '0' > 9) {
				throw new IllegalArgumentException("숫자가 주어진 범위에서 벗어납니다.");
			}
		}
	}

	private void validateSize(String number, int size) {
		if (number.length()!=size) {
			throw new IllegalArgumentException(size+"자리수의 숫자를 입력해주세요.");
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
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	private boolean isDuplicated(Set<Character> checkSet) {
		return checkSet.size() != NUMBER_SIZE;
	}

}

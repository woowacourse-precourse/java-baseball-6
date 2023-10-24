package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class UserNumberInputException {
	static final int BASEBALL_NUMBER = 3;
	static final String INPUT_NUMBER_REG = "[1-9]+";

	public void checkOnlyThree(String inputNumber) {
		if (inputNumber.length() != BASEBALL_NUMBER)
			throw new IllegalArgumentException("3개의 값만 입력하세요.");
	}

	public void checkIsNumeric(String inputNumber) {
		if (!inputNumber.matches(INPUT_NUMBER_REG))
			throw new IllegalArgumentException("1~9 사이의 숫자만 입력하세요.");
	}

	public void checkDiffNum(String inputNumber) {
		Set<Integer> set = new HashSet<>();
		inputNumToSet(set, inputNumber);

		if (set.size() != BASEBALL_NUMBER)
			throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력하세요.");
	}

	public void inputNumToSet(Set<Integer> set, String inputNumber) {
		for (int i = 0; i < inputNumber.length(); i++) {
			set.add(inputNumber.charAt(i) - '0');
		}
	}

	public void checkException(String inputNumber) {
		checkIsNumeric(inputNumber);
		checkOnlyThree(inputNumber);
		checkDiffNum(inputNumber);
	}
}
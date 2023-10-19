package baseball.utills;

import java.util.List;

public class InputValidation {
	private static final int NUMBER_LENGTH = 3;
	private static final String WRONG_INPUT_LENGTH_MESSAGE = "세 자리만 입력 가능합니다.";
	private static final String WRONG_INPUT_RANGE_MESSAGE = "1~9 사이의 숫자만 입력 가능합니다.";
	public void validate(String inputNumber){
		if(!hasExactLength(inputNumber)){
			throw new IllegalArgumentException(WRONG_INPUT_LENGTH_MESSAGE);
		}
		if(!hasExactRange(inputNumber)){
			throw new IllegalArgumentException(WRONG_INPUT_RANGE_MESSAGE);
		}
	}

	public boolean hasExactLength(String inputNumber) {
		return inputNumber.length() == NUMBER_LENGTH;
	}
	public boolean hasExactRange(String inputNumber) {
		return inputNumber.chars().allMatch(Character::isDigit);
	}
}

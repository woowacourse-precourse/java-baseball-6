package baseball.utills;

import java.util.List;

public class InputValidation {
	private static final int NUMBER_LENGTH = 3;
	private static final String ERROR_MESSAGE = "잘못된 입력입니다.";

	public void validate(String inputNumber){
		if(!hasExactLength(inputNumber)){
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

	public boolean hasExactLength(String inputNumber) {
		return inputNumber.length() == NUMBER_LENGTH;
	}
}

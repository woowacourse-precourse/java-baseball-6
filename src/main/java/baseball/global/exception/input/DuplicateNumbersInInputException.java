package baseball.global.exception.input;

import baseball.global.exception.constants.ExceptionConstantEnum;

public class DuplicateNumbersInInputException extends IllegalArgumentException {
	public DuplicateNumbersInInputException() {
		super(ExceptionConstantEnum.DUPLICATE_NUMBER_IN_INPUT.getMessage());
	}
}

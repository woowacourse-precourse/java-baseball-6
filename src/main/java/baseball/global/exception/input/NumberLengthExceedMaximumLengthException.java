package baseball.global.exception.input;

import baseball.global.exception.constants.ExceptionConstantEnum;

public class NumberLengthExceedMaximumLengthException extends IllegalArgumentException {
	public NumberLengthExceedMaximumLengthException() {
		super(ExceptionConstantEnum.NUMBER_LENGTH_EXCEED_MAXIMUM_LENGTH.getMessage());
	}
}

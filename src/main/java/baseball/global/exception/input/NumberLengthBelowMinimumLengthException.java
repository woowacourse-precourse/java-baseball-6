package baseball.global.exception.input;

import baseball.global.exception.constants.ExceptionConstantEnum;

public class NumberLengthBelowMinimumLengthException extends IllegalArgumentException {
	public NumberLengthBelowMinimumLengthException() {
		super(ExceptionConstantEnum.NUMBER_LENGTH_BELOW_MINIMUM_LENGTH.getMessage());
	}
}

package baseball.global.exception.input;

import baseball.global.exception.constants.ExceptionConstantEnum;

public class NumberNotDigitExcepton extends IllegalArgumentException {
	public NumberNotDigitExcepton() {
		super(ExceptionConstantEnum.NUMBER_NOT_DIGIT.getMessage());
	}
}

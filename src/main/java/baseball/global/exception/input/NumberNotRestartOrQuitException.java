package baseball.global.exception.input;

import baseball.global.exception.constants.ExceptionConstantEnum;

public class NumberNotRestartOrQuitException extends IllegalArgumentException {
	public NumberNotRestartOrQuitException() {
		super(ExceptionConstantEnum.NUMBER_NOT_START_OR_QUIT.getMessage());
	}
}

package baseball.global;

import static baseball.global.constant.BaseballGameConstant.*;

import baseball.global.constant.BaseballGameConstant;

public class Validator {

	public static void validateRestart(String input) {
		if (!input.equals(IS_RESTART) && !input.equals(IS_STOP))
			throw new IllegalArgumentException("옵션 입력을 잘못하였습니다.");
	}

	public static void validateInputLength(String[] input) {
		if (input.length != PLAY_COUNT)
			throw new IllegalArgumentException("숫자 입력을 잘못하였습니다.");
	}

	public static void validateNumbersFormat(String[] numbers) {
		for (String number : numbers) {
			validateNumberFormat(number);
		}
	}

	public static void validateNumberFormat(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}

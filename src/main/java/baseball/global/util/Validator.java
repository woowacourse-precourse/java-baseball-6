package baseball.global.util;

import static baseball.global.constant.BaseballConstant.*;
import static baseball.global.constant.ErrorMessage.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Validator {

	public static void validateNumbersLength(String[] numbers) {
		if (numbers.length != PLAY_AMOUNT) {
			throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
		}
	}

	public static void validateNumbersDuplication(String[] numbers) {
		int noneDuplicateNumber = Arrays.stream(numbers).collect(Collectors.toSet()).size();
		if (noneDuplicateNumber != PLAY_AMOUNT) {
			throw new IllegalArgumentException(NUMBER_DUPLICATION_ERROR_MESSAGE);
		}
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
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
		}
	}

	public static void validateSelectOptionType(String option) {
		if(!option.equals(SIGN_RESTART) && !option.equals(SIGN_STOP)) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
		}
	}
}

package baseball.global.util;

import static baseball.global.constant.ErrorMessage.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Validator {

	public static void validateNumberLength(String[] value) {
		if (value.length != 3) {
			throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
		}
	}

	public static void validateNumberDuplication(String[] value) {
		int noneDuplicateNumber = Arrays.stream(value).collect(Collectors.toSet()).size();
		if (noneDuplicateNumber != 3) {
			throw new IllegalArgumentException(NUMBER_DUPLICATION_ERROR_MESSAGE);
		}
	}

	public static void validateNumberFormat(String[] value) {
		try {
			for (String v : value) {
				Integer.parseInt(v);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
		}
	}
}

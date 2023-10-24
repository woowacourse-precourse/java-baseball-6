package baseball.utils.converter;

import baseball.exception.argument.InputDuplicateException;
import baseball.exception.argument.InputRangeException;
import baseball.exception.state.UtilityClassConstructorException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersConverter {

	private static final int NUMBER_MIN = 1;
	private static final int NUMBER_MAX = 9;

	private NumbersConverter() {
		throw new UtilityClassConstructorException();
	}

	public static List<Long> from(Long source) {
		List<Long> numbers = new ArrayList<>();
		while (source > 0) {
			Long number = source % 10;
			validateRange(number);
			validateDuplication(numbers, number);
			numbers.add(number);
			source /= 10;
		}

		Collections.reverse(numbers);
		return numbers;
	}

	private static void validateRange(Long number) {
		if (number < NUMBER_MIN || number > NUMBER_MAX) {
			throw new InputRangeException();
		}
	}

	private static void validateDuplication(List<Long> numbers, Long number) {
		if (numbers.contains(number)) {
			throw new InputDuplicateException();
		}
	}
}

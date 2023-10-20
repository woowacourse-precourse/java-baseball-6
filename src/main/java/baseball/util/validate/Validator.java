package baseball.util.validate;

import java.util.List;
import java.util.regex.Pattern;

import baseball.domain.command.Continue;
import baseball.service.BaseballCheckAnswerService;
import baseball.util.message.ErrorMessage;

public class Validator {
	private static final Pattern DIGIT_PATTERN = Pattern.compile("^[1-9]*$");
	private static final int LENGTH = 3;

	public static void validateNumberFormat(String inputValue) {
		if (!DIGIT_PATTERN.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_LETTER_ERROR.getMessage());
		}
	}

	public static void validateContinueCommand(String inputValue) {
		int num = Integer.parseInt(inputValue);

		if (!Continue.checkContinueCommand(num)) {
			throw new IllegalArgumentException(ErrorMessage.COMMAND_ERROR.getMessage());
		}
	}

	public static void validateOutOfLength(String inputValue) {
		if (inputValue.length() != LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.DIGIT_LENGTH_ERROR.getMessage());
		}
	}

	public static void validateDuplicatedNumber(String inputValue) {
		if (checkDuplicate(inputValue)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR.getMessage());
		}
	}

	private static boolean checkDuplicate(String inputValue) {
		int number = Integer.parseInt(inputValue);

		List<Integer> listNum = BaseballCheckAnswerService.divideIntoDigit(number);
		return listNum.stream().distinct().count() != listNum.size();
	}
}

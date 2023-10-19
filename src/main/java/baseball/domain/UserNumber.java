package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import baseball.constant.errorMessage.UserNumberError;

public class UserNumber {

	private final List<Integer> userNumber;

	public UserNumber(String input) {
		this.userNumber = createUserNumber(input);
	}

	private List<Integer> createUserNumber(String input) {
		return Arrays.stream(input.split(""))
				.map(UserNumber::validateUserInputNumber)
				.collect(Collectors.toList());
	}

	private static int validateUserInputNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					UserNumberError.USER_NUMBER_WRONG_INPUT_ERROR_MESSAGE);
		}
	}
}

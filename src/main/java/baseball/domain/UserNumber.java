package baseball.domain;

import baseball.constant.Constant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import baseball.constant.errorMessage.UserNumberError;

public class UserNumber {

	private final List<Integer> userNumber;

	public UserNumber(String input) {
		List<Integer> userNumberList = createUserNumber(input);
		validateUserInputLength(userNumberList);
		this.userNumber = userNumberList;
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

	private void validateUserInputLength(List<Integer> userNum) {
		if (userNum.size() != Constant.NUMBER_LENGTH_LIMIT) {
			throw new IllegalArgumentException(
					UserNumberError.USER_NUMBER_WRONG_LENGTH_ERROR_MESSAGE);
		}
	}
}

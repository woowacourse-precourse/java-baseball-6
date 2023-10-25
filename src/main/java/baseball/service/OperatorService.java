package baseball.service;

import baseball.vo.enums.GameRule;
import baseball.vo.enums.ValidationMessage;

import java.util.HashSet;
import java.util.Set;

public class OperatorService {
	private OperatorService() {
	}

	private static class OperatorServiceHolder {
		private static final OperatorService OPERATOR_SERVICE = new OperatorService();
	}

	public static OperatorService getInstance() {
		return OperatorServiceHolder.OPERATOR_SERVICE;
	}

	public void validateGameNumber(String inputGameNumber) {
		ValidationMessage validationMessage = validateUserInputCase(inputGameNumber);
		if (validationMessage != ValidationMessage.PROPER_TYPE) {
			System.out.println(validationMessage.getValue());
			throw new IllegalArgumentException(validationMessage.getValue());
		}
	}

	private ValidationMessage validateUserInputCase(String userInput) {
		if (userInput == null) return ValidationMessage.NULL_TYPE;
		if (userInput.isEmpty()) return ValidationMessage.EMPTY_TYPE;
		if (userInput.equals("0")) return ValidationMessage.ZERO_TYPE;
		if (userInput.length() < GameRule.GAME_NUMBER_LEN.getValue()) return ValidationMessage.UNDER_THREE;
		if (userInput.length() > GameRule.GAME_NUMBER_LEN.getValue()) return ValidationMessage.OVER_THREE;
		if (isDuplicateUserInput(userInput)) return ValidationMessage.NOT_DUPLICATE_NUMBER;
		try {
			Integer.valueOf(userInput);
		} catch (NumberFormatException e) {
			return ValidationMessage.NOT_NUMBER;
		}
		return ValidationMessage.PROPER_TYPE;
	}

	private boolean isDuplicateUserInput(String userInput) {
		String[] arrUserInput = userInput.split("");
		Set<String> userInputSet = new HashSet<>();
		for (String userInputNum : arrUserInput) {
			userInputSet.add(userInputNum);
		}
		return (arrUserInput.length != userInputSet.size());
	}

	// @TODO: 게임운영에 관련된 코드 작성
}

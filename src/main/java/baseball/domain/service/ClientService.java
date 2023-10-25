package baseball.domain.service;

import baseball.global.constant.CommonNumberType;
import baseball.global.constant.CommonStringType;
import baseball.global.constant.OutputType;
import baseball.global.utils.ConsoleUtil;

public class ClientService {

	private static final String NOT_ALLOWED_INPUT = "0";

	public String getCommonInput() {
		String input = ConsoleUtil.input();
		validateCommonInput(input);
		return input;
	}

	public String getRestartInput() {
		String input = ConsoleUtil.input();
		validateRestartInput(input);
		return input;
	}

	private void validateRestartInput(String input) {
		if (!input.equals(CommonStringType.RESTART.getContent()) && !input.equals(CommonStringType.FINISH.getContent())) {
			throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
		}
	}

	private void validateCommonInput(String input) {
		if (isWrongInput(input)) {
			throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
		}
	}

	private boolean isWrongInput(String input) {
		return !(checkDuplication(input) && checkNumberRange(input) && checkDigit(input) && checkInputType(input));
	}

	private boolean checkDuplication(String input) {
		return input.length() == input.chars().distinct().count();
	}

	private boolean checkNumberRange(String input) {
		return !input.contains(NOT_ALLOWED_INPUT);
	}

	private boolean checkDigit(String input) {
		return input.length() == CommonNumberType.LENGTH_OF_NUMBERS.getValue();
	}

	private boolean checkInputType(String input) {
		return input.chars().allMatch(Character::isDigit);
	}

}

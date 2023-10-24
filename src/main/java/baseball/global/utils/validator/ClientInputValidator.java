package baseball.global.utils.validator;

import baseball.global.constant.Common;
import baseball.global.constant.Output;

public class ClientInputValidator implements InputValidator {

	@Override
	public void validate(String input) {
		if (isWrongInput(input)) {
			throw new IllegalArgumentException(Output.EXCEPTION.getComment());
		}
	}

	private boolean isWrongInput(String input) {
		return !(checkDuplication(input) && checkNumberRange(input) && checkDigit(input) && checkInputType(input));
	}

	private boolean checkDuplication(String input) {
		return input.length() == input.chars().distinct().count();
	}

	private boolean checkNumberRange(String input) {
		return !input.contains(Common.ZERO.getContent());
	}

	private boolean checkDigit(String input) {
		return input.length() == Common.LENGTH_OF_NUMBERS.getNumber();
	}

	private boolean checkInputType(String input) {
		return input.chars().allMatch(Character::isDigit);
	}

}

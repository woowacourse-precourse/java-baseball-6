package baseball.domain.baseballplayer.team.validator;

import baseball.exception.BaseBallGameException;

public class UserInputValidator {

    private UserInputValidator() {
    }

    public static UserInputValidator newInstance() {
        return new UserInputValidator();
    }

    public void inputValidNumbers(final String input) {
        isInputValidOnlyNumbers(input);
        isInputValidLength(input);
    }

    private void isInputValidLength(final String input) {
        final int NUMBERS_SIZE = 3;
        if (input.length() != NUMBERS_SIZE) {
            BaseBallGameException.INVALID_INPUT_LENGTH_EXCEPTION.getException();
        }
    }

    private void isInputValidOnlyNumbers(final String input) {
        final String NON_ZERO_DIGITS_PATTERN = "[1-9]+";
        if (!input.matches(NON_ZERO_DIGITS_PATTERN)) {
            BaseBallGameException.INVALID_INPUT_OUT_OF_RANGE_EXCEPTION.getException();
        }
    }

}

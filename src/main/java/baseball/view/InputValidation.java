package baseball.view;

import baseball.constant.ExceptionMessage;

public class InputValidation {

    private static final int THREE_DIGIT_NUMBER = 3;
    private static final int ONE_DIGIT_NUMBER = 1;
    private static final String STRING_REGEX = "^[0-9]+$";
    private static final String ONE_OR_TWO_REGEX = "^[1-2]+$";

    public void checkLengthThree(final String number) {
        if (isNumberLengthThree(number)) {
            String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_DIGITS_RANGE.getMessage(), 3);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void checkLengthOne(final String number) {
        if (isNumberLengthOne(number)) {
            String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_DIGITS_RANGE.getMessage(), 1);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void checkStringRegex(final String number) {
        if (isNumberRegex(number)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_AVAILABLE_STRING.getMessage());
        }
    }

    public void checkOneOrTwoRegex(final String number) {
        if (isOneOrTwoRegex(number)) {
            String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_RANGE.getMessage(), 1, 2);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean isNumberLengthThree(final String number) {
        return number.length() != THREE_DIGIT_NUMBER;
    }

    private boolean isNumberLengthOne(final String number) {
        return number.length() != ONE_DIGIT_NUMBER;
    }

    private boolean isNumberRegex(final String number) {
        return !number.matches(STRING_REGEX);
    }

    private boolean isOneOrTwoRegex(final String number) {
        return !number.matches(ONE_OR_TWO_REGEX);
    }
}

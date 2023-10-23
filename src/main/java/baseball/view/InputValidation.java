package baseball.view;

import baseball.constant.ExceptionMessage;

public class InputValidation {

    private static final int THREE_DIGIT_NUMBER = 3;
    private static final int ONE_DIGIT_NUMBER = 1;
    private static final String STRING_REGEX = "^[0-9]+$";
    private static final String ONE_OR_TWO_REGEX = "^[1-2]+$";

    public void checkLengthThree(String number) {
        if (isNumberLengthThree(number)) {
            String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_DIGITS_RANGE.getMessage(), 3);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void checkLengthOne(String number) {
        if (isNumberLengthOne(number)) {
            String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_DIGITS_RANGE.getMessage(), 1);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void checkStringRegex(String number) {
        if (isNumberRegex(number)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_AVAILABLE_STRING.getMessage());
        }
    }

    public void checkOneOrTwoRegex(String number) {
        if (isOneOrTwoRegex(number)) {
            String errorMessage = String.format(ExceptionMessage.OUT_OF_NUMBER_RANGE.getMessage(), 1, 2);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean isNumberLengthThree(String number) {
        return number.length() != THREE_DIGIT_NUMBER;
    }

    private boolean isNumberLengthOne(String number) {
        return number.length() != ONE_DIGIT_NUMBER;
    }

    private boolean isNumberRegex(String number) {
        return !number.matches(STRING_REGEX);
    }

    private boolean isOneOrTwoRegex(String number) {
        return !number.matches(ONE_OR_TWO_REGEX);
    }
}

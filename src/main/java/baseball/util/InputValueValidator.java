package baseball.util;

import baseball.constant.ContinueFlag;
import baseball.constant.ErrorMessage;

import java.util.HashSet;
import java.util.Set;

public class InputValueValidator {

    private InputValueValidator() {
    }

    public static void checkValidInputAnswer(String inputAnswer, int numberOfDigits) {
        checkBlank(inputAnswer);
        checkIsNumber(inputAnswer);
        checkCorrectNumberOfDigits(inputAnswer, numberOfDigits);
        checkAnyDuplicateNumber(inputAnswer);
    }

    public static void checkValidInputContinueFlag(String inputContinueFlag) {
        checkBlank(inputContinueFlag);
        checkCorrectContinueFlag(inputContinueFlag);
    }

    private static void checkBlank(String inputValue) {
        if (inputValue == null || inputValue.isEmpty() || inputValue.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());
        }
        for (char c : inputValue.toCharArray()) {
            if (Character.isWhitespace(c)) {
                throw new IllegalArgumentException(ErrorMessage.CONTAIN_WHITE_SPACE_IN_INPUT.getMessage());
            }
        }
    }

    private static void checkIsNumber(String inputValue) {

        for (char c : inputValue.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.CONTAIN_NO_NUMBER_IN_INPUT.getMessage());
            }
        }
    }

    private static void checkCorrectNumberOfDigits(String inputValue, int numberOfDigits) {
        if (inputValue.length() != numberOfDigits) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_DIGITS_IN_INPUT.getMessage(),
                    numberOfDigits));
        }
    }

    private static void checkAnyDuplicateNumber(String inputValue) {
        Set<Character> digitSet = new HashSet<>();
        for (char c : inputValue.toCharArray()) {
            if (digitSet.contains(c)) {
                throw new IllegalArgumentException(ErrorMessage.CONTAIN_DUPLICATE_NUMBER_IN_INPUT.getMessage());
            } else {
                digitSet.add(c);
            }
        }
    }

    private static void checkCorrectContinueFlag(String inputValue) {
        if (!inputValue.equals(String.valueOf(ContinueFlag.CONTINUE.getValue())) && !inputValue.equals(
                String.valueOf(ContinueFlag.DONE.getValue()))) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_CONTINUE_FLAG.getMessage(),
                    ContinueFlag.CONTINUE.getValue(), ContinueFlag.DONE.getValue()));
        }
    }
}

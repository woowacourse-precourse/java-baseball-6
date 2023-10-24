package baseball.utils;

import java.util.List;

public class Validator {
    //---Messages---
    private static final String NON_NUMBER_CONTAINED = "입력 중 숫자가 아닌 것이 포함되었습니다.";
    private static final String REDUNDANT_NUMBER_DETECTED = "서로 다른 세자리 수여야 합니다.";
    private static final String INPUT_NOT_THREE_DIGITS = "입력하신 수가 세자리가 아닙니다.";
    private static final String WHITE_SPACE_INCLUDED = "입력에는 공백이 포함되면 안됩니다.";
    private static final String INPUT_OUT_OF_RANGE = "1~9의 수로 이루어져 있어야 합니다.";

    //---Constants---
    private static final String ZERO = "0";
    private static final String WHITE_SPACE = " ";
    private static final int INPUT_DIGITS = 3;
    private static final int MIN_ALLOWED_INTEGER = 1;
    private static final int MAX_ALLOWED_INTEGER = 9;
    //---------

    public static void validateInputString(String inputString) {
        validateInputNoWhiteSpace(inputString);
        validateInputLength(inputString);
        validateInputNoZero(inputString);
    }

    public static void validateInputNumber(List<Integer> inputNumbers, char input) {
        validateInputIsNumber(input);
        validateRedundancy(inputNumbers, Character.getNumericValue(input));
    }

    private static void validateInputIsNumber(char input) {
        int inputNumber = Character.getNumericValue(input);
        if (inputNumber < MIN_ALLOWED_INTEGER || inputNumber > MAX_ALLOWED_INTEGER) {
            throw new IllegalArgumentException(NON_NUMBER_CONTAINED);
        }
    }

    private static void validateRedundancy(List<Integer> inputNumbers, int input) {
        if (inputNumbers.contains(input)) {
            throw new IllegalArgumentException(REDUNDANT_NUMBER_DETECTED);
        }
    }

    private static void validateInputLength(String inputString) {
        if (inputString.length() != INPUT_DIGITS) {
            throw new IllegalArgumentException(INPUT_NOT_THREE_DIGITS);
        }
    }

    private static void validateInputNoWhiteSpace(String inputString) {
        if (inputString.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException(WHITE_SPACE_INCLUDED);
        }
    }

    private static void validateInputNoZero(String inputString) {
        if (inputString.contains(ZERO)) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE);
        }
    }
}

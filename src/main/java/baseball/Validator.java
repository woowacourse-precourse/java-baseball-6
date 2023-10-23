package baseball;

import java.util.List;

public class Validator {
    //---Messages---
    private static final String NON_NUMBER_CONTAINED = "입력 중 숫자가 아닌 것이 포함되었습니다.";
    private static final String REDUNDANT_NUMBER_DETECTED = "서로 다른 세자리 수여야 합니다.";
    private static final String INPUT_NOT_THREE_DIGITS = "입력하신 수가 세자리가 아닙니다.";
    private static final String WHITE_SPACE_INCLUDED = "입력에는 공백이 포함되면 안됩니다.";
    private static final String INPUT_OUT_OF_RANGE = "1~9의 수로 이루어져 있어야 합니다.";
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
        if (inputNumber < 1 || inputNumber > 9) {
            throw new IllegalArgumentException(NON_NUMBER_CONTAINED);
        }
    }

    private static void validateRedundancy(List<Integer> inputNumbers, int input) {
        if (inputNumbers.contains(input)) {
            throw new IllegalArgumentException(REDUNDANT_NUMBER_DETECTED);
        }
    }

    private static void validateInputLength(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException(INPUT_NOT_THREE_DIGITS);
        }
    }

    private static void validateInputNoWhiteSpace(String inputString) {
        if (inputString.contains(" ")) {
            throw new IllegalArgumentException(WHITE_SPACE_INCLUDED);
        }
    }

    private static void validateInputNoZero(String inputString) {
        if (inputString.contains("0")) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE);
        }
    }
}

package baseball;

import java.util.List;

import static baseball.ErrorMessage.*;

public class UserNumber {

    private static final Integer INPUT_SIZE = 3;
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public UserNumber(String inputStr) {
        inputStr = deleteBlank(inputStr);
        validate(inputStr);
        numbers = convertNumbers(inputStr);
    }

    private static String deleteBlank(String inputStr) {
        return inputStr.replace(" ","");
    }

    private void validate(String inputStr) {
        validateNotNumber(inputStr);
        validateOverSize(inputStr);
        validateUnderSize(inputStr);
        validateErrorNumber(inputStr);
        validateDuplicateNumber(inputStr);
    }

    private static void validateNotNumber(String inputStr) {
        if (isNotNumber(inputStr)) {
            throw new IllegalArgumentException(INCLUDE_NOT_NUMBER.getMessage());
        }
    }

    private static boolean isNotNumber(String inputStr) {
        return !inputStr.chars().allMatch(ch -> Character.isDigit(ch));
    }

    private static void validateOverSize(String inputStr) {
        if (inputStr.length() > INPUT_SIZE) {
            throw new IllegalArgumentException(NUMBERS_OVERSIZE.getMessage());
        }
    }

    private static void validateUnderSize(String inputStr) {
        if (inputStr.length() < INPUT_SIZE) {
            throw new IllegalArgumentException(NUMBERS_UNDERSIZE.getMessage());
        }
    }

    private static void validateErrorNumber(String inputStr) {
        if (inputStr.contains("0")) {
            throw new IllegalArgumentException(INCLUDE_INVALID_NUMBER.getMessage());
        }
    }

    private static void validateDuplicateNumber(String inputStr) {
        if (hasDuplicateNumber(inputStr)) {
            throw new IllegalArgumentException(INCLUDE_DUPLICATE_NUMBER.getMessage());
        }
    }

    private static boolean hasDuplicateNumber(String inputStr) {
        return inputStr.chars().distinct().count() != inputStr.length();
    }

    private static List<Integer> convertNumbers(String inputStr) {
        return inputStr.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

}

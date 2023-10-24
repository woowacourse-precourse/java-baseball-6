package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private static final String SAME_NUMBER_EXCEPTION_MESSAGE = "같은 숫자를 입력할 수 없습니다.";
    private static final String NON_NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String NUMBER_OF_NUMBERS_EXCEPTION_MESSAGE = "입력한 숫자는 3자리여야 합니다.";
    private static final String RESTART_OR_END_NUMBER_EXCEPTION_MESSAGE = "1과 2만 입력해야 합니다.";
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "1~9 사이의 숫자만 입력할 수 있습니다.";

    public static void validateInputThreeNumber(String number) {
        validateSameNumber(number);
        validateNumberOfNumbers(number);
        validateThatInputIsNumeric(number);
        validateTheNumberBetweenOneAndNine(number);
    }

    public static void validateRestartOrEnd(String number) {
        if (!(Constants.GAME_RESTART_NUMBER.equals(number) || Constants.GAME_END_NUMBER.equals(number))) {
            throw new IllegalArgumentException(RESTART_OR_END_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validateSameNumber(String numbers) {
        List<Character> checkList = new ArrayList<>();

        for (char singleNumber : numbers.toCharArray()) {
            validateCheckListContainsSingleNumber(checkList, singleNumber);
            checkList.add(singleNumber);
        }
    }

    private static void validateCheckListContainsSingleNumber(List<Character> checkList, char singleNumber) {
        if (checkList.contains(singleNumber)) {
            throw new IllegalArgumentException(SAME_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validateThatInputIsNumeric(String numbers) {
        if (!isNumeric(numbers)) {
            throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNumberOfNumbers(String numbers) {
        if (numbers.length() != Constants.NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(NUMBER_OF_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    private static void validateTheNumberBetweenOneAndNine(String numbers) {
        if (numbers.contains(String.valueOf(Constants.ZERO))) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNumeric(String numbers) {
        try {
            Integer.parseInt(numbers);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

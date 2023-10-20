package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private static final String SAME_NUMBER_EXCEPTION_MESSAGE = "같은 숫자를 입력할 수 없습니다.";
    private static final String NON_NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String NUMBER_OF_NUMBERS_EXCEPTION_MESSAGE = "입력한 숫자는 3자리여야 합니다.";
    private static final String RESTART_OR_END_NUMBER_EXCEPTION_MESSAGE = "1과 2만 입력해야 합니다.";

    public static void validateSameNumber(String numbers) {
        List<Character> checkList = new ArrayList<>();

        for (char singleNumber : numbers.toCharArray()) {
            if (checkList.contains(singleNumber)) {
                throw new IllegalArgumentException(SAME_NUMBER_EXCEPTION_MESSAGE);
            }
            checkList.add(singleNumber);
        }
    }

    public static void validateThatInputIsNumeric(String numbers) {
        if (!isNumeric(numbers)) {
            throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    public static void validateNumberOfNumbers(String numbers) {
        if (numbers.length() != Constants.NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(NUMBER_OF_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    public static void validateRestartOrEnd(String number) {
        if (!(Constants.GAME_RESTART_NUMBER.equals(number) || Constants.GAME_END_NUMBER.equals(number))) {
            throw new IllegalArgumentException(RESTART_OR_END_NUMBER_EXCEPTION_MESSAGE);
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
